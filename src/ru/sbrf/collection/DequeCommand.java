package ru.sbrf.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeCommand {
    private final Scanner scanner = new Scanner(System.in);

    public void handle () {
        Deque<String> deque = new ArrayDeque<String>();
        while (true) {
            showoutMenuDeque();
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    System.out.println("Список элементов " + deque);
                    break;

                case 2:
                    System.out.println("Пусто ли список: " + deque.isEmpty());
                    break;

                case 3:
                    containsItem(deque);
                    break;

                case 4:
                    addFirstItems(deque);
                    break;

                case 5:
                    addLastItems(deque);
                    break;

                case 6:
                    getFirstItems(deque);
                    break;
                case 7:
                    getLastItems(deque);
                    break;

                case 8:
                    pollFirstItems(deque);
                    break;

                case 9:
                    pollLastItems(deque);
                    break;

                case 10:
                    removeFirstItems(deque);
                    break;

                case 11:
                    removeLastItems(deque);
                    break;

                case 12:
                    return;
            }
        }
    }

    private static void showoutMenuDeque () {
        System.out.println("Выберите действие");
        System.out.println("1. showItems");
        System.out.println("2. isEmpty");
        System.out.println("3. contains");
        System.out.println("4. addFirst");
        System.out.println("5. addLast");
        System.out.println("6. getFirst");
        System.out.println("7. getLast");
        System.out.println("8. poolFirst");
        System.out.println("9. poolLast");
        System.out.println("10. removeFirst");
        System.out.println("11. removeLast");
        System.out.println("12. goToMainMenu");
    }

    private void containsItem (Deque deque) {
        System.out.println("Введите элемент для проверки");
        System.out.println(deque.contains(scanner.next()));
    }

    private void addFirstItems (Deque deque) {
        System.out.println("Введите элемент для ввода в начало: ");
        deque.addFirst(scanner.next());
    }

    private void addLastItems (Deque deque) {
        System.out.println("Введите элемент для ввода в конец: ");
        deque.addLast(scanner.next());
    }

    private void getFirstItems (Deque deque) {
        System.out.println("Первый элемент списка: " + deque.getFirst());
    }

    private void getLastItems (Deque deque) {
        System.out.println("Последний элемент списка: " + deque.getLast());
    }

    private void pollFirstItems (Deque deque) {
        System.out.println("Первый элемент списка, который удаляется после вывода: " + deque.pollFirst());
    }

    private void pollLastItems (Deque deque) {
        System.out.println("Последний элемент списка, который удаляется после вывода: " + deque.pollLast());
    }

    private void removeFirstItems (Deque deque) {
        System.out.println("Отображается удаленный элемент, который был первым: " + deque.removeFirst());
    }

    private void removeLastItems (Deque deque) {
        System.out.println("Отображается удаленный элемент, который был последним: " + deque.removeLast());
    }
}
