package lesson11;

import java.util.Arrays;

public class CustomArrayDeque implements CustomDeque {

    private int [] source = new int[INITIAL_CAPACITY]; // массив с элементами дека
    private int size = 0; // Сколько сейчас элементов в деке
    private int firstElementIndex = 0; // индекс первого элемента дека внутри массива

    private static final int INITIAL_CAPACITY = 4;

    @Override
    public String toString() {
       StringBuilder b = new StringBuilder("[");

       for (int i = 0; i < size; i++) {
           // Для получения реального индекса элемента (с  учетом смещения первого элемента)
           // делим "по модулю" (то есть получаем остаток деления) длины массива.
           int v = source[ (firstElementIndex + i) % source.length ];
           b.append(v);
           if (i < (size - 1))
               b.append(", ");
       }
       b.append("]");
       return b.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(int value) {
        if (size() == source.length) { // если в массиве source больше нет свободных ячеек
            increaseCapacity(); // сделает массив в 2 раза большей длины и скопирует в него имеющиеся элементы
        }

        // Уменьшить firstElementIndex на 1 с учетом размера source
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
        source[firstElementIndex] = value;
        size++;

    }

    private void increaseCapacity() {
        int [] newSource = new int[source.length * 2];
        int j = 0; // Начальный индекс в новом массиве newSource
        for (int i = firstElementIndex; i < source.length; i++) {
            newSource[j++] = source[i];
        } // копируем с позиции firstElementIndex до конца исходного массива
        for (int i = 0; i < firstElementIndex; i++) {
            newSource[j++] = source[i];
        } // копируем с начала исходного массива до позиции firstElementIndex
        source = newSource;
    }

    @Override
    public int getFirst() {
        if (size() == 0)
            throw new IndexOutOfBoundsException();

        return source[firstElementIndex];
    }

    @Override
    public int removeFirst() {
        if (size() == 0)
            throw new IndexOutOfBoundsException();

        int deleted = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        return deleted;
    }

    @Override
    public void addLast(int value) {

    }

    @Override
    public int getLast() {
        return 0;
    }

    @Override
    public int removeLast() {
        return 0;
    }
}
