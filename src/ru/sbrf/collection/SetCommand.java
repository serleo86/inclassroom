package ru.sbrf.collection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetCommand {
    private final Scanner scanner = new Scanner(System.in);

    public void handle() {
        Set<String> set = new HashSet<>();
        while (true) {
            showoutMenuSet();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Список элементов: " + set);
                    break;

                case 2:
                    System.out.println("Список содержит элементы: " + set.isEmpty());
                    break;

                case 3:
                    containsItem(set);
                    break;

                case 4:
                    addItems(set);
                    break;

                case 5:
                    removeItems(set);
                    break;

                case 6:
                    return;
            }
        }
    }

    private static void showoutMenuSet() {
        System.out.println("Выберите действие");
        System.out.println("1. showItems");
        System.out.println("2. isEmpty");
        System.out.println("3. contains");
        System.out.println("4. add");
        System.out.println("5. remove");
        System.out.println("6. goToMain");
    }

    private void containsItem(Set set) {
        System.out.print("Введите элемент: ");
        String next = scanner.next();
        System.out.println("Содержится ли элемент: " + set.contains(next));
    }

    private void addItems(Set set) {
        System.out.print("Введите значение для ввода: ");
        set.add(scanner.next());
    }

    private void removeItems(Set set) {
        System.out.println("Введите элемент для удаления: ");
        set.remove(scanner.next());
    }
}
