package ru.sbrf.collection.anotations;

/**
 * Created by sbt-panichev-sl on 20.07.2018.
 */
public class TestAnnotationClassForGetHistory {
    public static void main(String[] args) {

        Version annotation = TestAnnotationedClass3.class.getAnnotation(Version.class);

        while (annotation.previous()!=Void.class){

            System.out.println("Версия = " + annotation.value());
            System.out.println("Автор: " + annotation.author());
            System.out.println("Дата создания: " + annotation.creationDate());
            System.out.println("Предыдущая версия: " + annotation.previous());
            System.out.println();

            annotation=annotation.previous().getAnnotation(Version.class);

        }
    }
}
