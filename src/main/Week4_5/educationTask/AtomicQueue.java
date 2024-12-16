package src.main.Week4_5.educationTask;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicQueue<T> {
    private final AtomicReference<T> item = new AtomicReference<>(null);

    // Метод для добавления элемента в очередь
    public boolean enqueue(T newItem) {
        // Если текущий элемент null (очередь пуста), ставим новый элемент
        return item.compareAndSet(null, newItem);
    }

    // Метод для извлечения элемента из очереди
    public T dequeue() {
        return item.getAndSet(null); // Возвращаем элемент и сбрасываем ссылку на null
    }

    public static void main(String[] args) {
        AtomicQueue<String> queue = new AtomicQueue<>();

        // Пробуем добавить элемент в очередь
        System.out.println("Добавление элемента: " + queue.enqueue("Hello")); // true
        System.out.println("Извлечение элемента: " + queue.dequeue()); // Hello

        // Пробуем добавить элемент, но очередь пуста
        System.out.println("Попытка добавить новый элемент: " + queue.enqueue("World")); // true
        System.out.println("Извлечение элемента: " + queue.dequeue()); // World
    }
}
