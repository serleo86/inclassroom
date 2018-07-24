package ru.sbrf.collection.generic;

public enum AgeCategory {
    KID(18, 29),
    YOUNG,
    MIDDLEAGE,
    PENSIONER;

    private final int from;
    private final int to;

    AgeCategory(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public static AgeCategory valueOf(int age) {
        for (AgeCategory ageCategory : values()) {

        }

    }
}
