package lesson8;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedListTester {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.size()); // 3
        list.set(2, 30);
        System.out.println(list);

        System.out.println(list.contains(2));  // true
        System.out.println(list.contains(20)); // false

        System.out.println(list.get(1));

        list.add(0, -3);
        System.out.println(list);

        list.add(3, 25);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());

        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());

        list.addFirst(-100);
        System.out.println(list);

        MyLinkedList newList = new MyLinkedList();
        System.out.println(newList);
        newList.addFirst(13);
        System.out.println(newList);

        newList.removeFirst();
        System.out.println(newList);

        System.out.println(list.getFirst()); // 1
        list.addFirst(-10);
        System.out.println(list);

        System.out.println(list.removeFirst()); // -10
        System.out.println(list);

    }
}
