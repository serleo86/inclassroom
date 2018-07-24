package ru.sbrf.collection.generic;

public class Women implements Voter {
    private final AgeCategory ageCategory;

    public Women(int age) {
        ageCategory = AgeCategory.valueOf(age);
    }

    @Override
    public Gender getGender() {
        return Gender.FEMALE;
    }

    @Override
    public AgeCategory getAgeCategory() {
        return ageCategory;
    }
}
