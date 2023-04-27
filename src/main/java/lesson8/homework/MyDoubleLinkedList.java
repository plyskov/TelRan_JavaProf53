package lesson8.homework;

import lesson6.list.MyList;

public class MyDoubleLinkedList implements MyList {

    private int size = 0;
    private Node head;
    private Node tail;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public void set(int index, int value) {

    }

    @Override
    public void add(int value) {

    }

    @Override
    public void add(int index, int value) {

    }

    @Override
    public void remove(int index) {

    }

    public int getFirst() {
        return 0;
    }

    public int getLast() {
        return 0;
    }

    public int removeFirst() {
        return 0;
    }

    public int removeLast() {
        return 0;
    }

    public void addFirst(int value) {

    }

    public void addLast(int value) {

    }


    private static class Node {
        Node prev;
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node prev, Node next, int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;

            if (next != null) // чтобы следующий стал ссылаться на нас
                next.prev = this;

            if (prev != null) // чтобы предыдущий стал ссылаться на нас
                prev.next = this;
        }
    }

}
