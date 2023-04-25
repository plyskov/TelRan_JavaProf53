package lesson6.list;

public class MyArrayList implements MyList {

    // Внутри физически это будет массив из целых, и у него будет начальная емкость.
    // далее она будет увеличиваться

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
