package lesson6;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Lesson5Repeat {

    public static void main(String[] args) {
        int [][] d = {
                {1,3,5},
                {10,20},
                {-1}
        };

        System.out.println(
                Arrays.toString(flattening(d))
        );

        // O(1) - сложность доступа к любому элементу массива
    }

    // напишите функцию уплощения двухмерного массива
    // задача в том чтобы возвратить одномерный массив
    // со всеми элементами двухмерного
    public static int @NotNull [] flattening(int [][] a) {
        // Решение:
        // пробежаться по двухмерному массиву и узнать общее количество элементов
        // создать одномерный массив с этим количеством
        // в еще одном ? цикле добавить в него элементы из двухмерного

        int elementsAmount = 0;
        for (int i = 0; i < a.length; i++) {
            elementsAmount += a[i].length;
        }

        System.out.println("Result array length = " + elementsAmount);

        int [] result = new int[elementsAmount];
        int counter = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[counter++] = a[i][j]; // Сначала считываем counter, а затем он инкрементируется
            }
        }

        return result;
    }
}
