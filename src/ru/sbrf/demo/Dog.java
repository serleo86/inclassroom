package ru.sbrf.demo;

public class Dog implements Animal {
    private int age;
    private String name;


    public Dog (int age, String name) {
        this.age=age;
        this.name=name;
    }

    @Override
    public int gerAge() {
        return age;
    }

    @Override
    public void setName(int age) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {

    }

    public String say() {
        return "гаф-гаф";
    }

    protected String getColor () {
        return "Red";
    }

}
