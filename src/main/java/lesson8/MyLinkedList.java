package lesson8;

import lesson6.list.MyList;

public class MyLinkedList implements MyList {

    // добавление элемента в конец
    @Override
    public void add(int value) {
        size++; // вставляем новый элемент - размер увеличили
        if (head == null) {
            head = new Node(value, null);
            return;
        }
        Node n = head;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        n.setNext(new Node(value, null));
    }

    // получение значения элемента по индексу
    @Override
    public int get(int index) {
        return getNodeByIndex(index).getValue();
    }

    @Override
    public void add(int index, int value) {
        // Случай: index == 0 - вставка в начало
        // Создать новый узел, сделать его следующим узлом head, а в head засунуть новый узел
        if (index == 0) {
            head = new Node(value, head);
        } else {
            Node prevNode = getNodeByIndex(index - 1);
            Node nextNode = prevNode.getNext();
            prevNode.setNext(new Node(value, nextNode));
        }
        // Случай, когда узел добавляем в середину
        // 1. Создадим новый узел со ссылкой next = Node(index)
        // 2. Присвоим узлу Node(index - 1) ссылку next на наш новый узел
        size++;
    }

    @Override
    public void remove(int index) {
        // 1 случай - index == 0
        if (index == 0) {
            if (head == null)
                return;
            head = head.getNext();
            size--;
        } else {
            // 2 случай = index > 0
            // Мое:
            /*Node prev = getNodeByIndex(index - 1);
            Node del = getNodeByIndex(index);
            prev.setNext(del.getNext());
             */

            // От преподавателя:
            Node prev = getNodeByIndex(index - 1);
            if(prev != null)
            {
                Node current = prev.getNext();
                if(current != null)
                {
                    prev.setNext(current.getNext());
                    size--;
                }

            }

        }
    }


    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("[");
        Node n = head;
        while (n != null) {
            b.append(n.getValue());
            n = n.getNext();
            if (n != null)
                b.append(", "); // разделитель
        }
        b.append("]");
        return b.toString();
    }

    // получение узла по индексу
    private Node getNodeByIndex(int index) {

        /* Моя реализация
        // Проверим валидность индекса
        if (index < 0) throw new IndexOutOfBoundsException();
        // Нужно index раз сделать getNext()
        // важно проверить, что полученный узел не null
        Node n = head;
        for (int i = 0; i <= index; i++) {
            if (n == null) throw new IndexOutOfBoundsException();
            if (i == index){
                return n;
            } else {
                n = n.getNext();
            }
        }
         */

        // От преподавателя
        Node n = head;
        // нужно index раз сделать getNext()
        for(int i=0; i < index; i++)
        {
            // важно проверить что полученный узел не null
            if(n != null)
                n = n.getNext();
            else
                // если в процессе определится что текущий узел null нужно
                throw new IndexOutOfBoundsException();
        }
        return n;
    }

    // изменение значения элемента по порядковому номеру
    @Override
    public void set(int index, int value) {
        Node n = getNodeByIndex(index);
        if (n != null)
            n.setValue(value);
    }

    // Проверка, что элемент с нужным значением содержится в LinkedList
    @Override
    public boolean contains(int value) {
        Node n = head; // текущий узел
        while (n != null) {
            // проверяем значение
            if (n.getValue() == value) // если элемент с нужным значением найден
                return true;
            n = n.getNext();           // если нет, проверяем следующий узел
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    // Удаляет первый элемент и возвращает старое значение из удаленного первого элемента
    public int removeFirst() {
        int value = getFirst();
        remove(0);
        return value;

    }

    // Вернуть самый первый элемент
    public int getFirst() {
        return get(0);
    }

    public void addFirst (int value) {
        head = new Node(value, head);
        size++;
        // альтернатива:
        //add(0, value);
    }

    // Структура для хранения данных в LinkedList
    private static class Node {
        private int value; // значение
        private Node next; // ссылка на следующий узел

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head; // Ссылка на первый узел Linked List'а

    private int size = 0; // Количество элементов в LinkedList

}
