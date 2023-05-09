package lesson11;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTester {
    public static void main(String[] args) {
        // Queue - интерфейс (в отличие от стека, который реализован классом)
        // Позволяет добавлять элементы в конец и получать из начала

        // Поскольку это интерфейс, нужно использовать один из классов, имплементирующих данный интерфейс
        // Например, тот же LinkedList

        Queue<String> bankingQueue = new LinkedList<>();
        bankingQueue.offer("Max Kotkov");
        bankingQueue.offer("Sveta Petrova");
        bankingQueue.offer("Semen Deznev");
        String element = null;
        while ((element = bankingQueue.poll()) != null)
        {
            System.out.println("element: " + element);
        }

        // PriorityQueue (очередь с приоритетом)
        // Пример - очередь на регистрацию в самолет и пассажиры с разным статусом (бизнес, эконом, PriorityPass ...)
        // Приоритет определяется на основе компаратора
        Queue<String> priorityCustomers = new PriorityQueue<>();
        priorityCustomers.add("One");
        priorityCustomers.add("Two");
        priorityCustomers.add("Three");
        priorityCustomers.add("Four");
        priorityCustomers.add("Five");

        // В очередь нельзя поместить null

        while (!priorityCustomers.isEmpty()) {
            String e = priorityCustomers.poll();
            System.out.println("priority: " + e);
        }

    }
}
