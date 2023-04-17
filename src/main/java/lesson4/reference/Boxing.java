package lesson4.reference;

import lesson4.animals.BigDog;
import lesson4.animals.Cat;
import lesson4.animals.Dog;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Boxing {
    public static void main(String[] args) {

        int i = 10;
        Integer i1 = new Integer(10);

        List<Integer> integers = new ArrayList<>();
        //List<int> abc = new ArrayList<>(); // Так нельзя - контейнеры работают только со ссылочными типами

        Integer i2 = 10; // boxing - превращение примитивного типа в ссылку
        System.out.println(i2);

        if (i2 < 100) { // unboxing - преобразование ссылочного типа к примитивному
            System.out.println("Hello");
        }

        // Сравнение типов

        // Примитивные типы сравниваются по значению
        int a = 10;
        int b = 10;
        System.out.println(a == b);

        // Ссылочные типы по умолчанию оператором "==" сравниваются по адресам в памяти
        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);
        System.out.println("Ссылочные равны: " + (i3 == i4));

        System.out.println("По значению равны: " + i3.equals(i4));

        // Сравним ссылочных объектов
        Cat c1 = new Cat("Trifon");
        Cat c2 = new Cat("Trifon");
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));

        System.out.println(c1.getClass());

        System.out.println(c1);

        Dog d1 = new Dog("Semen");
        BigDog bigD1 = new BigDog("Semen");
        System.out.println("Dogs equals: " + (d1.equals(bigD1)));

        Object o;

    }
}
