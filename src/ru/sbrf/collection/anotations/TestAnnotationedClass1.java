package ru.sbrf.collection.anotations;


import ru.sbrf.collection.profi.ArrayList;
import ru.sbrf.collection.profi.List;

@Version(value = 1,
        creationDate = @Date(year = 1, month = 1, day = 1),
        author = "PSL")

public class TestAnnotationedClass1 {
    List<String> list = new ArrayList<>();
    int size=0;

}



    Version annotation = TestAnnotationedClass1.class.getAnnotation(Version.class);