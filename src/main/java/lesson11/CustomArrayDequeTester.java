package lesson11;

public class CustomArrayDequeTester {
    public static void main(String[] args) {
        CustomArrayDeque c = new CustomArrayDeque();

        c.addLast(10);
        c.addLast(20);
        c.addLast(30);
        c.addLast(40);
        c.addLast(50);
        System.out.println(c);

        System.out.println(c.getLast());
        System.out.println(c.removeLast());
        System.out.println(c);
    }
}
