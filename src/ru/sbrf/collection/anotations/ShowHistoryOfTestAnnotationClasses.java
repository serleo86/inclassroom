package ru.sbrf.collection.anotations;

/**
 * Created by sbt-panichev-sl on 20.07.2018.
 */
public class ShowHistoryOfTestAnnotationClasses {
    public static void main(String[] args) {
        showOutHistory(TestAnnotationedClass3.class);
    }

    private static void showOutHistory(Class<?> clazz) {
        while (clazz != Void.class) {
            Version annotation = clazz.getAnnotation(Version.class);
            showOutAnnotationInfo(annotation);
            clazz = annotation.previous();
        }
    }

    private static void showOutAnnotationInfo(Version annotation) {
        System.out.println("Версия = " + annotation.value());
        System.out.println("Автор: " + annotation.author());
        System.out.println("Дата создания: " + annotation.creationDate());
        System.out.println("Предыдущая версия: " + annotation.previous());
        System.out.println();
    }
}
