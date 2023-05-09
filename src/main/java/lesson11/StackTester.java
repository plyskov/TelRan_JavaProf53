package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackTester {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        List<String> names = new ArrayList<>(
                Arrays.asList("Max", "Lena", "Alex", "Katerina", "Valeria")
        );

        //  Стек. Приниципы работы:
        // LIFO контейнер - последний пришел, первым вышел Last in, first out
        // T push(T) - добавляет элемент на вершину стэка
        // T pop() - снимает верхний элемент из стэка и возвращает его
        // T peek() - возвращает верхний элемент из стэка, но не удаляет его
        // boolean isEmpty() - есть ли еще элемент на вершине стэка


        // Нужно сделать список имен в обратном порядке от исходного,
        // не используя перебор по индексу исходного списка.

        List<String> reversedNames = new ArrayList<>();

        for (String name: names) {
            stack.push(name);
            System.out.println(stack);
        }

        while (!stack.isEmpty()) {
            reversedNames.add(stack.pop());
        }

        System.out.println(reversedNames);

    }

}
