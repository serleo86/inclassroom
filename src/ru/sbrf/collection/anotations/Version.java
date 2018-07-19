package ru.sbrf.collection.anotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Version {
    int value() default 1;
    Date creationDate();
    String author() default "Unknown";
    Class<?> previous() default Void.class;
}
