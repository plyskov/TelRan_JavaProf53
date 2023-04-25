package lesson5.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortTester {

    public static void main(String[] args) {
        String[] countries = new String[]
                {
                        "Zambia",
                        "Germany",
                        "France",
                        "Cyprus",
                        "Burkina-Faso",
                        "Switzerland"
                };

        Arrays.sort(countries);
        System.out.println(Arrays.toString(countries));

        int [] a = new int[] {1,-10, 2, 5, 3}; // O(n) - сложность поиска в несортированном массиве
        Arrays.sort(a);
        System.out.println(
                Arrays.toString(a)
        );

        // Сортировка массива по собственным критериям
        Arrays.sort(countries, new StringLengthComparator());
        System.out.println(Arrays.toString(countries));

        // {-10, 1, 2, 5, 3}; // O(log(n)) - сложность двоичного поиска в отсортированном массиве

        System.out.println(
                Arrays.binarySearch(a, 5)
        );
        System.out.println(
                Arrays.binarySearch(a, 4)
        );
        System.out.println(
                Arrays.binarySearch(a, -20)
        );
        System.out.println(
                Arrays.binarySearch(a, -4)
        );

        // Что возвращает binarySearch при отсутствии элемента:
        // возвращает место элемента М при его вставке в массив,
        // которое не нарушило бы порядок сортировки -(M + 1)
        // binarySearch вотзвращает отрицательное число, если элемента нет
        // либо порядковый номер найденного элемента

        int [] a1 = {1,2,3};
        int [] b1 = {1,2,3};
        System.out.println(compare(a1, b1));

        Object [] o = {3.14, true, "Abap", a1, 'q'};
        System.out.println(Arrays.toString(o));

        Arrays.sort(a1);   // для массивов

        // Для сортировки НЕ массивов
        //Collections.sort(...);

    }

    // Функция, получающая на вход 2 массива одинаковой длины, а возвращает
    // true если элеементы массивов совпадают

    public static boolean compare(int [] a, int [] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    // ДОМАШКА
    // 1. Написать функцию вычисляющую сумму элементов двухмерного массива целых
    // 2. Написать функцию распечатывающую двухмерный массив
    // 3*. Напишите функцию возвращающуюся неповторяющиеся элементы двух массивов
    // 4**. Написать функцию бинарного поиска

}

// Минимально возможная сложность сортировки:
// O(n*log(n))


class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        // если 01 < 02 вернуть отрицательное
        // если 01 > 02 вернуть положительное
        // если 01 == 02 вернуть 0
        if (o1.length() < o2.length()) {
            return -1;
        }
        if (o1.length() > o2.length()) {
            return 1;
        }
        return 0;
        // ОТ ПРЕПОДАВАТЕЛЯ простой алгоритм:
        //return o1.length() - o2.length();
    }
}
