package lesson6.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList implements MyList, Iterable<Integer> {

    // Домашняя работа
    // 2. Написать функцию в MyArrayList, возвращающую итератор, обходящий контейнер по возрастанию значений элементов
    //    порядок элементов в контейнере меняться не должен
    public Iterator<Integer> smallToBigIterator()
    {
        return new SmallToBigIterator();
    }

    public class SmallToBigIterator implements Iterator<Integer> {

        // массив с данными для итератора
        private  int [] source = new int[size];
        // позиция итератора
        private int position = -1;

        public SmallToBigIterator () {
            // Скопировать данные из массива data в массив source
            // и отсортировать данные в source
            System.arraycopy(data, 0, source, 0, size); // Работает быстрее копирования в цикде
            Arrays.sort(source);
        }

        @Override
        public boolean hasNext() {
            return ++position < size;
        }

        @Override
        public Integer next() {
            if(position < 0 || position >= size)
                throw new NoSuchElementException();
            return source[position];
        }

    }


    // Домашняя работа - от преподавателя. Обратный итератор.
    // 1. Написать функцию в MyArrayList, возвращающую итератор, обходящий контейнер в обратном порядке
    public Iterator<Integer> backwardIterator() {

        // Это анонимный внутренний класс. Мы создаем экземпляр класса прямо в момент его объявления
        return new Iterator<Integer> () {

            private int position = size; // Начальная позиция - в конце листа

            @Override
            public boolean hasNext() {
                return --position >= 0; // Уменьшаем позицию и проверяем, не дошли ли до нуля
            }

            @Override
            public Integer next() {
                return get(position);
            }
        };
    }

    // Внутри физически это будет массив из целых, и у него будет начальная емкость.
    // далее она будет увеличиваться

    // Итератор - делаем свой
    @Override
    public Iterator<Integer> iterator() {
        // если hasNext() == true, то можно вызвать next()
        // реализация итератора через анонимный внутренний класс
        return new Iterator<Integer>() {
             // позиция итератора по умолчанию
            private int position = -1;
            @Override
            public boolean hasNext() {
                return ++position < size; // инкрементируем позицию итератора и провряем, что не дошли до конца контейнера
            }

            @Override
            public Integer next() {
                return get(position);
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(position--); // удаляем элемент и смещаем позицию итератора назад на 1

            }
        };
    }

    private static final int INITIAL_SIZE = 8; // начальная емкость
    private int size = 0; // длина контейнера

    private int [] data; // именно тут будут храниться элементы

    public MyArrayList() {
        data = new int[INITIAL_SIZE];
    }

    @Override
    public int size() { // количество элементов в списке
        return size;
    }

    @Override
    public int get(int index) { // получение элемента по индексу
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(); // Если входной индекс невалидный, генерим исключение
        return data[index];
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value)
                return true;
        }
        return false;
    }

    // Заменить значение элемента по index на value
    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(); // Если входной индекс невалидный, генерим исключение
        data[index] = value;
    }

    // Добавление нового элемента в конец контейнера
    @Override
    public void add(int value) {
        if (size == data.length) {
            // увеличить размер массива data, поскольку превысил предельно зарезервированный
            increaseCapascity();
        }
        // Основные действия - добавление элемента и увеличение "публичного" размера списка
        data[size] = value;
        size++;
    }

    @Override
    public void add(int index, int value) {

        // Если входной индекс невалидный, генерим исключение
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        // увеличить размер массива data, поскольку превысил предельно зарезервированный
        if (size == data.length) {
            increaseCapascity();
        }

        // переместим элементы начиная с index на 1 позицию вперед
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        // наконец, поместим в позицию index переданное значение
        data[index] = value;
        size++;
    }

    private void increaseCapascity() {
        int [] newData = new int[size * 2]; // заготовка для нового контейнера в 2 раза больше
        for (int i = 0; i < size; i++) {
            newData[i] = data[i]; // заливаем в новый контейнер элементы старого
        }
        data = newData; // присваиваем полю контейнера адрес нового контейнера - заменяем контейнер
    }

    // удалить элемент с порядковым номером index из контейнера
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(); // Если входной индекс невалидный, генерим исключение
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                b.append(", ");
            }
            b.append(data[i]);
        }
        b.append(']');
        return b.toString();
    }
}
