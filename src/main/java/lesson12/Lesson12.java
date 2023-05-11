package lesson12;

import java.util.*;

public class Lesson12 {
    public static void main(String[] args) {
        // Нужно смоделировать автобус, люди входят в переднюю,
        // а выходят из задней - Queue

        // emergency room в скорой помощи (больные по приоритету критичности) - PriorityQueue

        // Библиотека - ящик для приема прочитанных книг - Stack

        // Сравнение сетов
        Set<String> s1 = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        Set<String> s2 = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        Set<String> s3 = new HashSet<>(Arrays.asList("Four", "Two", "Three"));

        System.out.println(setsCompare(s1, s2)); // true
        System.out.println(setsCompare(s1, s3)); // false
        System.out.println(setsCompare(s1, null)); // false
        System.out.println(setsCompare(null, null)); // false

        // Написать функцию которая удалить из Set<Integer> все отрицательные элементы
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1,-2, 3, -5, 8, 10, -12));
        System.out.println("before: " + numbers);
        removeNegative(numbers);
        System.out.println("after:  " + numbers);

        // Написать функцию, которая тестирует строку на предмет того, является ли она палиндромом
        // алла
        // а роза упала на лапу азора
        // aла

        System.out.println(checkPalindrom("алла"));
        System.out.println(checkPalindrom("ала"));
        System.out.println(checkPalindrom("а роза упала на лапу азора"));
        System.out.println(checkPalindrom("алан"));

        // Написать фунцию, которая принимает на вход список целых чисел и еще одно целое число
        // Функция вернет true, если среди двух в списке есть пара, произведение которых дает
        // указанное число
        // [1 2 5 12 4 7 100], 60 -> true
        // [1 2 4 5 7 12 100], 60 -> true (в отсортированном легче найти)
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 5, 12, 4, 7));
        System.out.println(checkProduct(nums, 60)); // true
        System.out.println(checkProduct(nums, 3)); // false

        // reverse-polish calculator * / + -
        // (3 + 4 - 2) * 6 = 30
        // 3 4 + 2 - 6 * = 30 // форма записи - операция после операндов
        System.out.println(reversePolishCalculator("3 4 + 2 - 6 *"));

        // Очередь:
        // [10, 20, 30, 40, 50, 60, 70], 5 элементов
        // [10, 20, 30, 40, 50, 60, 70], 5 элементов
        Queue<Integer> q = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        System.out.println(q);
        partyallyReverseQueue(q, 5);
        System.out.println(q);

        // Функция, которая ищет самую длинную последовательность целых чисел
        // напишите функцию которая ищет в списке самую длинную последовательность четных чисел
        // [1,2,5,6,8,7,4] -> [6,8]
        System.out.println(longestEvenSequence(Arrays.asList(1,2,5,6,8,7,4)));
        System.out.println(longestEvenSequence(Arrays.asList(1,2,5,6,8,7,4,12,8,6)));

    }

    // функция сравнения двух сетов
    public static boolean setsCompare(Set<String> s1, Set<String> s2) {

        // не использовать  Set.equals() !!!
        if (s1 == null || s2 == null)
            return false;

        if (s1.size() != s2.size())
            return false;

        // 1 вариант: перебор элементов одного и проверка вхождения во второй методом contains

        // 2 вариант: вычесть один сет из другого

        Set<String> temp = new HashSet<>(s1);
        temp.removeAll(s2);

        return temp.size() == 0;
    }

    public static void removeNegative(Set<Integer> s) {

        if (s == null)
            return;

        Iterator<Integer> iter = s.iterator();
        while (iter.hasNext()) {
            Integer num = iter.next();
            if (num < 0) {
                iter.remove();
            }
        }
    }

    public static boolean checkPalindrom(String s) {

        String tempStr = s.replaceAll(" ", "").toLowerCase();
        System.out.println(tempStr);
        Deque<Character> chars = new LinkedList<>();
        for (int i = 0; i < tempStr.length(); i++) {
            chars.add(tempStr.charAt(i));
        }

        while (chars.size() > 1) {

            char c1 = chars.removeFirst();
            char c2 = chars.removeLast();
            if (c1 != c2) return false;
        }
        return true;
    }

    // Написать фунцию, которая принимает на вход список целых чисел и еще одно целое число
    // Функция вернет true, если среди двух в списке есть пара, произведение которых дает
    // указанное число
    public static boolean checkProduct(List<Integer> ints, int value) {

        Collections.sort(ints);

        Deque<Integer> i = new LinkedList<>(ints);
        int f = i.removeFirst();
        int l = i.removeLast();
        while (i.size() > 0) {
            int s = f * l;
            if (s == value) return true;
            if (s < value) {
                f = i.removeFirst();
            } else {
                l = i.removeLast();
            }
        }

        return false;
    }

    public static int reversePolishCalculator(String s) {
        Queue<String> t = new LinkedList<>(Arrays.asList(s.split(" ")));
//        t.poll();
//        int i = Integer.parseInt();
        System.out.println(t);
        int arg1 = Integer.parseInt(t.poll());
        while (t.size() >= 2) {
            int arg2 = Integer.parseInt(t.poll());
            String action = t.poll();
            arg1 = actNumbers(arg1, arg2, action);
        }
        return arg1;
    }

    private static int actNumbers(int arg1, int arg2, String action) {
        if (action.equals("+")) return arg1 + arg2;
        if (action.equals("-")) return arg1 - arg2;
        if (action.equals("*")) return arg1 * arg2;
        if (action.equals("/")) return arg1 / arg2;
        return 0;
    }

    public static void partyallyReverseQueue(Queue<Integer> q, int number) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= number; i++) {
            stack.push(q.poll());
        }

        for (int i = 1; i <= number; i++) {
            q.offer(stack.pop());
        }

        for (int i = 1; i<= q.size() - number; i++) {
            q.offer(q.poll());
        }
    }

    public static List<Integer> longestEvenSequence(List<Integer> l) {

        List<Integer> maxEvens = new LinkedList<>();
        List<Integer> actualEvens = new LinkedList<>();

        for (int num : l) {
            if (num % 2 == 0) {
                actualEvens.add(num);
            } else {
                if (maxEvens.size() < actualEvens.size()) {
                    maxEvens.clear();
                    maxEvens.addAll(actualEvens);
                }
                actualEvens.clear();
            }
        }

        if ((maxEvens.size() < actualEvens.size()))
            return actualEvens;
        else
            return maxEvens;

    }
}
