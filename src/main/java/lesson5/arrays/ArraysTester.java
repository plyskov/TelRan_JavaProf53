package lesson5.arrays;

import java.util.Arrays;

public class ArraysTester {
    public static void main(String[] args) {
        // Массив - это отдельный класс в Java
        int[] a= new int[]{1, 7, 5, -20};
        int[] b = new int[2]; // Значения инициализируются значениями по умолчанию (указаннного при объявлении типа)

        String [] movies = new String[]{"Apocalipse now", "Taxi driver", "Tango and cache"};

        String [] songs = {"Rasputin", "Never let me down again"}; // краткая инициализация

        test(new String[] {"abc", "xyz"}); // так можно
        test(songs);
        //test({"abc"}); // Так нельзя

        System.out.println(a.length);
        System.out.println(songs);
        System.out.println(
                Arrays.toString(songs)
        );

        songs[1] = "November rain";
        System.out.println(
                Arrays.toString(songs)
        );

        System.out.println(format(movies));

        System.out.println(format(movies, "<", ">", "|"));

        // У массивов нельзя изменять размер, заданный при объявлении.

        // ДВУМЕРНЫЕ МАССИВЫ:

        int [] [] c = new int[][] {
                {1, 3, 5},        // 0
                {4},              // 1
                {-10, 20, -40, 5} // 2
        };

        System.out.println(c[2][2]);

        System.out.println(c.length); // 3
        System.out.println(c[2].length); // 4

        String [][] names = new String[2][3];
        String [][] countries = new String[2][];

        int [] x = {1, 3, 5, 6};
        int [] y = {8, 10, 12};

        int [] result = concatenate(x, y);

        System.out.println(Arrays.toString(result));


    }

    public static String format(String[] s) {
        // строку в формате [Rasputin, Never let me down again]

        String resultString;
        boolean firstElem = true;

        resultString = "[";
        for (String strElem : s) {
            if (!firstElem)
                resultString += ", ";
            resultString += strElem;
            firstElem = false;
        }
        resultString += "]";
        return resultString;
    }

    public static String format(String[] s, String prefix, String suffix, String delimiter) {
        // строку в формате [Rasputin, Never let me down again]

        StringBuilder result = new StringBuilder(prefix);

        for (int i = 0; i < s.length; i++) {
            if (i != 0) {
                result.append(delimiter);
            }
            result.append(s[i]);
        }

        result.append(suffix);
        return result.toString();

    }

    // напишите функцию которая принимает на вход два массива целых любой длины и
    // возвращает новый массив целых суммарной длины с элементами
    // взодных массивов [1,2,3], [4,5,6] -> [1,2,3,4,5,6]
    public static int [] concatenate(int [] a, int [] b) {
        int [] result = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }

        for (int i = a.length; i < (a.length + b.length); i++) {
            result[i] = b[i - a.length];
        }
        return result;

        // ОТ преподавателя:
        /*
        int  [] c = new int[a.length + b.length];
        int counter = 0;
        for (int j : a) {
            c[counter++] = j;
        }
        for (int j : b) {
            c[counter++] = j;
        }
        return c;
         */

    }

    public static void test(String[] s) {

    }
}
