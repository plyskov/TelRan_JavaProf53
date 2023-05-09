package lesson11;

public interface CustomDeque {
     int size(); // сколько всего элементов

    // API для работы с началом
    void addFirst(int value); // добавление элемента в начало
    int getFirst(); // получить значение первого элемента без удаления
    int removeFirst(); // получить первый элемент и удалить его из контейнера

    // API для работы с последними
    void addLast(int value); // добавление элемента в rjytw
    int getLast(); // получить значение последнего элемента без удаления
    int removeLast(); // получить последний элемент и удалить его из контейнера

}
