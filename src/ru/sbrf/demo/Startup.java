package ru.sbrf.demo;

import ru.sbrf.demo.MiniDog;

public class Startup {

    public static void main(String[] args) {
        MiniDog miniDog = new MiniDog(3, "Туки");
        System.out.println(miniDog.getColor());
    }
}