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

    /**
     * Unlinks non-null node x.
     */
    E unlink(Node<E> x) {
        final E item = x.item;
        Node<E> l = this.last;
        final Node<E> next = x.next;
        Node<E> cur = this.head;
        Node<E> prev = this.head;
        // 寻找被删除node cur 指针以及 cur 的上一个节点指针 prev
        while (!cur.item.equals(item)) {
            prev = cur;
            cur = cur.next;
        }
        // 只有一个节点
        if (head == last && item.equals(head.item)) {
            head = null;
            last = null;
            x.item = null;// help gc
            x.next = null;
            size--;
            return item;
        }

        // 如果被删除的元素在尾结点
        if (item.equals(l.item)) {
            last = prev;
            prev.next = null;
        } else if (item.equals(head.item)) {
            // 在头结点
            head = next;
            cur.next = null;
            prev.next = null;
        } else {
            // 被删除的元素不在头结点也不在尾节点，则把前驱节点的next 指向 被删除元素的 next 指针
            prev.next = next;
            cur.next = null;
        }
        size--;
        x.item = null;// help gc
        x.next = null;
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
