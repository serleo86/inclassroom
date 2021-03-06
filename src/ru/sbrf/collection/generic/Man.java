package ru.sbrf.collection.generic;

public class Man implements Voter {
    private final AgeCategory ageCategory;

    public Man(int age) {
        ageCategory = AgeCategory.valueOf(age);
    }

    @Override
    public Gender getGender() {
        return Gender.MALE;
    }

    @Override
    public AgeCategory getAgeCategory() {
        return ageCategory;
    }
}
