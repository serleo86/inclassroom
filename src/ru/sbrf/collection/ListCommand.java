package ru.sbrf.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListCommand {
    Scanner scanner = new Scanner(System.in);

    public void handle() {
        List list = new ArrayList();
        while (true) {
            shooutMenuList();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Содержимое списка: " + list);
                    break;

                case 2:
                    System.out.println("Список пустой: " + list.isEmpty());
                    break;

                case 3:
                    containsItem(list);
                    break;

                case 4:
                    addItems(list);
                    break;

                case 5:
                    addByIndex(list);
                    break;

                case 6:
                    getByIndex(list);
                    break;

                case 7:
                    removeItems(list);
                    break;

                case 8:
                    removeByIndex(list);
                    break;

                case 9:
                    return;


            }
        }
    }

    private static void shooutMenuList () {
        System.out.println("Выберите действие");
        System.out.println("1. showItems");
        System.out.println("2. isEmpty");
        System.out.println("3. contains");
        System.out.println("4. add");
        System.out.println("5. addByIndex");
        System.out.println("6. getByIndex");
        System.out.println("7. remove");
        System.out.println("8. remove");
        System.out.println("9. goToMain");
    }

    private void containsItem(List list) {
        System.out.print("Введите значение: ");
        boolean contains = list.contains(scanner.next());
        System.out.println("Есть ли элемент: " + contains);
    }

    private void addItems (List list) {
        System.out.print("Введите значения для ввода: ");
        list.add(scanner.next());
    }

    private void addByIndex (List list) {
        System.out.print("Введите индекс и значения для ввода: ");
        list.add(scanner.nextInt(), scanner.next());
    }

    private void getByIndex (List list) {
        System.out.print("Введите индекс элемента, который хотите вывести: ");
        System.out.println("Элемент " + list.get(scanner.nextInt()));
    }

    private void removeItems (List list) {
        System.out.print("Укажите элемент для удаления: ");
        list.remove(scanner.next());
        System.out.println("Элемент успешно удален");
    }

    private void removeByIndex (List list) {
        System.out.print("Введите индекс элемента для удаления: ");
        list.remove(scanner.nextInt());
        System.out.println("Элемент успешно удален");
    }
}

