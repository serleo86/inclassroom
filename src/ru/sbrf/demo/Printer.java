package ru.sbrf.demo;
//ЗАПРЕРИТЬ СОСЗДАВАТЬ р если она уже создана
public class Printer {
    private static Printer p;

    private Printer () {
    }

    public static Printer getInstance () {
        if (p==null)
            p = new Printer();

        return p;
    }

    public void print (String text) {
        System.out.println(text);
    }
}

