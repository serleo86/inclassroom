package ru.sbrf.demo;

public class LoggerTwo implements Logger {
    @Override
    public void log(Animal animal) {
        System.out.println(animal.getName() + ": " + animal.say());
    }
}
