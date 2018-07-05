import java.util.Random;

public class Veschest {
    public static void main(String[] args) {
        double s=0;
        double sred = 0;
        double [] m = {1.5,2.9,3.1,4.6,5.2};
        //Random r = new Random ();
        //double [] m = new double[10];
        for (int i=0; i<m.length; i++) {
            s +=m[i];
        }
        sred = s / m.length;
        System.out.println("Среднее равно " + sred);
    }
}
