package lesson5.homework;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {

        int [] c = {1,2,3};
        int [] d = {3,5};
        System.out.println(
                Arrays.toString(removeDuplicates(c, d))
        );

        int [] r = {1, 2, 7, 12, 33, 35, 37, 50, 77};
        System.out.println(Arrays.binarySearch(r, 50));
        System.out.println(binarySearch(r, 50));
        System.out.println(Arrays.binarySearch(r, 10));
        System.out.println(binarySearch(r, 10));

    }

    // напишите функцию, возвращающую массив из не повторяющиеся элементов двух массивов
    /*
        [1,2,3]
        [3,5]

        перебор всех элементов O(n^2)
        сортировка O(n*log(n))
     */
    public static int [] removeDuplicates(int [] a, int [] b) {
        int [] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }

        // Arrays.copyOf() - может копировать массив

        for (int i = 0; i < b.length; i++) {
            c[i + a.length] = b[i];
        }
        Arrays.sort(c);

        int [] d = new int[c.length];

        int current = c[0];
        d[0] = c[0];
        int index = 1;
        for (int i = 1; i < c.length; i++) {
            if (current != c[i]) {
                d[index] = c[i];
                index++;
            }
            current = c[i];
        }
        int [] e = new int[index];
        for (int i = 0; i < e.length; i++) {
            e[i] = d[i];
        }
        return e;
    }

    // Функция бинарного поиска для массива целых
    /* ищем 50:
    0 1 2 3   4  5  6  7  8
    1 2 7 12 33 35 37 50 77 // оригинал
                35 37 50 77 // второй проход
                      50 77 // третий проход
     */
    public static int binarySearch(int [] a, int value) {
        int minIndex = 0;
        int maxIndex = a.length - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            if (a[midIndex] < value) {
                minIndex = midIndex + 1;
            } else if (value < a[midIndex]) {
                maxIndex = midIndex - 1;
            } else // a[midIndex] = value
                return midIndex;
        }
        return (-minIndex - 1);
    }

}
