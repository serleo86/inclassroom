package ru.sbrf.collection.anotations;

/**
 * Created by sbt-panichev-sl on 20.07.2018.
 */
public class ShowHistoryOfTestAnnotationClasses {
    public static void main(String[] args) {
        showOutHistory(TestAnnotationedClass3.class);
    }

    private static void showOutHistory(Class<?> clazz) {
        if (clazz != Void.class) {
            Version annotation = clazz.getAnnotation(Version.class);
            showOutAnnotationInfo(clazz, annotation);
            showOutHistory(annotation.previous());
        }
    }

    private static void showOutAnnotationInfo(Class<?> clazz, Version version) {
        System.out.println("Класс: " + clazz.getSimpleName());
        System.out.println("Версия: " + version.value());
        System.out.println("Автор: " + version.author());
        System.out.println("Дата создания: " + getFormatedDate(version.creationDate()));
        System.out.println("Предыдущая версия: " + version.previous());
        System.out.println();
    }

    private static String getFormatedDate(Date creationDate) {
        return String.format("%d.%d.%d", creationDate.day(), creationDate.month(), creationDate.year());
    }
}
