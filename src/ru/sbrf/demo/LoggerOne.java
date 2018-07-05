package ru.sbrf.demo;

public class LoggerOne implements Logger {
    @Override
    public void log(Animal animal) {
        System.out.println(animal.say());
    }
}
