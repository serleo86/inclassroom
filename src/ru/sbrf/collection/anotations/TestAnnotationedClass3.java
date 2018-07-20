package ru.sbrf.collection.anotations;


@Version(value = 3,
        creationDate = @Date(year = 1, month = 1, day = 3),
        author = "PSL",
        previous = TestAnnotationedClass2.class)
public class TestAnnotationedClass3 {

        public int showMaxDigit3 (int digit1, int digit2, int digit3){
                if ((digit1>=digit2) && (digit1>=digit3))
                        return digit1;
                else if ((digit1<digit2) && (digit1>=digit3))
                        return digit2;
                else
                        return 666;
        }
}
