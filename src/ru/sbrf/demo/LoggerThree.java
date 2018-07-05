package ru.sbrf.demo;

public class LoggerThree implements Logger {
    @Override
    public void log(Animal animal) {
        System.out.println(animal.getName() + ": " + animal.gerAge() + ": " + animal.say());
    }
}
