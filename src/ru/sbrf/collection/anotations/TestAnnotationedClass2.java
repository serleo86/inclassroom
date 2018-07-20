package ru.sbrf.collection.anotations;


@Version(value = 2,
        creationDate = @Date(year = 1, month = 1, day = 2),
        author = "PSL",
        previous = TestAnnotationedClass1.class)
public class TestAnnotationedClass2 {

        public int showMaxDigit2 (int digit1, int digit2){
            if (digit1>=digit2)
                return digit1;
            else
                return digit2;
        }

}
