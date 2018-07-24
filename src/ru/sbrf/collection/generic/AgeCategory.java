package ru.sbrf.collection.generic;

public enum AgeCategory {
    KID(18, 29),
    YOUNG(30, 49),
    MIDDLEAGE(50, 64),
    PENSIONER(65, 65);

    private final int from;
    private final int to;

    AgeCategory(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public static AgeCategory valueOf(int age) {
        for (AgeCategory ageCategory : values()) {
            if ((ageCategory.from <= age) && (age <= ageCategory.to)) {
                return ageCategory;
            }
        }
        throw new IllegalArgumentException();
    }
}
