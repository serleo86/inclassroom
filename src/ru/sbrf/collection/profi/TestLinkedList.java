package ru.sbrf.collection.profi;

/**
 * Created by sbt-panichev-sl on 11.07.2018.
 */
public class TestLinkedList {
    public static void main(String[] args) {

        LinkedList <String> list = new LinkedList<>();
        int size=0;



        list.add("one"); //0
        list.add("two"); //1
        list.add("three"); //2
        list.add("four"); //3
        list.add("five"); //4
        list.add("two"); //5
        list.add("seven"); //6
        list.add("eight"); //7

        //list.add("three");
        //list.addLast("two");
        //list.add(1,"three");
//        list.addLast("three");

        System.out.println("Изначальный размер " + list.size());
        //System.out.println(list.get(0));
        //System.out.println(list.indexOf("one"));
        //System.out.println(list.indexOf("two"));
        System.out.println("Все содержимое (ищем по индексам):");
        //System.out.println(list.get(2));
        System.out.println(list.lastIndexOf("five"));
        //System.out.println(list.indexOf("four"));
        //System.out.println(list.indexOf("five"));
        //System.out.println(list.indexOf("six"));
        //System.out.println(list.indexOf("seven"));
        //System.out.println(list.indexOf("eight"));
        /* System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println(list.get(7));
        System.out.println();   */

        /*System.out.println("Индекс первого вхождения two " + list.indexOf("two"));
        System.out.println("Индекс последнего вхождения two " + list.lastIndexOf("two"));
        System.out.println();
        System.out.println("Удаляем сейчас " + list.removeFirst());
        System.out.println("Теперь первый " + list.getFirst());
        System.out.println("А размер теперь " + list.size());
        System.out.println();
        System.out.println("Потом удаляем " + list.removeLast());
        System.out.println("Теперь последний " + list.getLast());
        System.out.println("А размер теперь " + list.size());*/


        /*//проверка remove по индексу
        list.remove(list.indexOf(list.getFirst()));
        System.out.println(list.getFirst());
        System.out.println(list.size());

        //проверка remove по item
        System.out.println(list.remove(list.getFirst()));
        System.out.println(list.getFirst());
        System.out.println(list.size());

        //проверка subList
        System.out.println(list.subList(1, 5).get(0));
        System.out.println(list.subList(1, 5).get(1));
        System.out.println(list.subList(1, 5).get(2));
        System.out.println(list.subList(1, 5).get(3));  */


        //System.out.println(list.get(1));

        //System.out.println(list.get(5));
        //System.out.println(list.get(2));
        //System.out.println(list.size());

        //System.out.println(list.get(0));
        /*System.out.println("А размер теперь " + list.size());
        System.out.println(list.get(2));

        System.out.println(list.get(4));*/
        //System.out.println("Удалили 0. Сейчас первый " + list.getFirst());


    }
}
