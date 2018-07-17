package ru.sbrf.collection.profi;

public class TestArrayList {
    public static void main(String[] args) {
        List <String> list = new ArrayList<>();
        int size=0;

        list.add("one"); //0
        list.add("two"); //1
        list.add("three"); //2
        list.add("four"); //3
        list.add("five"); //4
        list.add("two"); //5
        list.add("seven"); //6
        list.add("eight"); //7


        System.out.println("Изначальный размер " + list.size());

        System.out.println(list.indexOf(null));
        System.out.println(list.lastIndexOf(null));

    }
}
