package lesson4.reference;

public class ReferenceTester {
    public static void main(String[] args) {

        int a[] = new int[1];
        a[0] = 10;
        changeArray(a);
        System.out.println(a[0]);

        a[0] = 5;
        changeNumber(a[0]);
        System.out.println(a[0]);

    }

    public static void changeArray(int[] array) {
        array[0] = 1000;
    }

    public static void changeNumber(int num) {
        num = 1000;
    }
}
