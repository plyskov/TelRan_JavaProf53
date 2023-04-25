package lesson6.list;

public class MyArrayListTester {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.add(0, 0);
        System.out.println(list);

        list.add(0, -1);
        list.add(4);
        System.out.println(list);

        System.out.println(list.size());
        System.out.println(list.contains(4));
        System.out.println(list.contains(-4));

        list.remove(2);
        list.remove(1);
        list.remove(0);
        System.out.println(list);

    }
}
