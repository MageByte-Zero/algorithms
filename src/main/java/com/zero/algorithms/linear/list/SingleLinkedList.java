package com.zero.algorithms.linear.list;

import java.util.Objects;

public class SingleLinkedList<E> extends AbstractList<E> {



    transient int size = 0;
    /**
     * pointer to head node
     */
    transient Node<E> head;
    /**
     * pointer to last node
     */
    transient Node<E> last;

    public SingleLinkedList() {
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, index);
        }
    }

    /**
     * Inserts element e before non-null Node of index.
     */
    void linkBefore(E element, int index) {
        final Node<E> newNode = new Node<>(element, node(index));
        if (index == 0) {
            head = newNode;
        } else {
            Node<E> pred = node(index - 1);
            pred.next = newNode;
        }
        size++;
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    Node<E> node(int index) {
        Node<E> x = this.head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    /**
     * Links e as last element
     *
     * @param e data
     */
    private void linkLast(E e) {
        // 先取出原 last node
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e);
        // 修改 last 指针到新添加的 node
        last = newNode;
        // 如果原 last 是 null 则将 newNode 设置为 head，不为空则原 last.next 指针 = newNode
        if (Objects.isNull(l)) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(E e) {
        final Node<E> h = this.head;
        // 构造新节点,next 指向原先的 head
        final Node<E> newNode = new Node<>(e, h);
        head = newNode;
        // 如果原先的 head 节点为空，则 last 指针也指向新节点
        if (Objects.isNull(h)) {
            last = newNode;
        }
        size++;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (Objects.isNull(o)) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        if (Objects.isNull(o)) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        // 无节点可删除
        return false;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    @Override
    public E remove() {
        checkElementIndex(0);
        return remove(0);
    }

    /**
     * Unlinks non-null node x.
     */
    E unlink(Node<E> x) {
        final E item = x.item;
        final Node<E> next = x.next;
        Node<E> cur = head;
        Node<E> prev = null;
        // 寻找被删除 node cur 节点以及 cur 的上一个节点 prev
        while (!cur.item.equals(item)) {
            prev = cur;
            cur = cur.next;
        }
        // 当只有一个节点的时候 prev  = null,next = null
        // 如果删除的是头结点，则 head = x.next，否则 prev.next = next 打断与被删除节点的联系
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        // 如果删除最后一个节点，则 last 指向 prev，否则打断被删除的节点 next = null
        if (next == null) {
            last = prev;
        } else {
            x.next = null;
        }

        size--;
        x.item = null;
        return item;
    }

    /**
     * Node data
     *
     * @param <E>
     */
    private static class Node<E> {
        /**
         * Node of data
         */
        E item;
        /**
         * pointer to next Node
         */
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public Node(E item) {
            this(item, null);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> cur = this.head;
        while (Objects.nonNull(cur)) {
            sb.append(cur.item).append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
