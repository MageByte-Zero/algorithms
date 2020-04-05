package com.zero.algorithms.linear.list;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 双向链表
 *
 * @param <E>
 */
public class DoubleLinkedList<E> extends AbstractList<E> implements Queue<E> {
    transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     * (first.prev == null && first.item != null)
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     * (last.next == null && last.item != null)
     */
    transient Node<E> last;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * 头结点添加数据
     *
     * @param e 数据
     */
    private void linkFirst(E e) {
        final Node<E> f = this.first;
        Node<E> newNode = new Node<>(null, e, f);
        // first 指向新节点
        first = newNode;
        if (Objects.isNull(f)) {
            // 链表是空的
            last = newNode;
        } else {
            // 将原 first.prev = newNode
            f.prev = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    Node<E> node(int index) {
        // 优化查找，判断 index 在前半部分还是后半部分。
        if (index < (this.size >> 2)) {
            // 前半部分，从头结点开始查找
            Node<E> x = this.first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            // 后半部分，从尾节点开始查找
            Node<E> x = this.last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    /**
     * Inserts element e before non-null Node succ.
     */
    private void linkBefore(E element, Node<E> succ) {
        // assert succ != null
        final Node<E> prev = succ.prev;
        // 构造新节点
        final Node<E> newNode = new Node<>(prev, element, succ);
        succ.prev = newNode;
        if (Objects.isNull(prev)) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    /**
     * Links e as last element.
     */
    void linkLast(E element) {
        addLast(element);
    }

    private void addLast(E e) {
        final Node<E> l = this.last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (Objects.isNull(l)) {
            // 链表为空的情况下，设置 first 指向新节点
            first = newNode;
        } else {
            // 原 last 节点的 next 指向新节点
            l.next = newNode;
        }
        size++;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    /**
     * Unlinks non-null node x.
     */
    private E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;
        // 若 只有一个节点，那么会执行 prev == null 和 next == null 分支代码
        // 若 prev == null 则说明删除的是头结点,主要负责 x 节点跟前驱节点的引用处理
        if (Objects.isNull(prev)) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        // 若 next 为空，说明删除的是尾节点，主要负责 x 与 next 节点 引用的处理
        if (Objects.isNull(next)) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        if (Objects.isNull(o)) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return removeFirst(f);
    }

    /**
     * 删除头结点,节点不能为空 且节点是 first
     *
     * @param f 头结点
     * @return 被删除的节点数据
     */
    private E removeFirst(Node<E> f) {
        // assert f == first && f != null;
        final E item = f.item;
        Node<E> next = f.next;
        // help gc
        f.next = null;
        f.item = null;
        // first 指向 下一个节点
        first = next;
        // 如果只有一个节点，last 也要设置成 null，否则打断 next.prev = null 打断指向被删除的引用
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return item;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (Objects.isNull(o)) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item.equals(o)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> cur = this.first;
        while (Objects.nonNull(cur)) {
            sb.append(cur.item).append("⇌");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
