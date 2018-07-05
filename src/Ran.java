import java.util.Random;

public class Ran {
    public static void main(String[] args) {
        Random r = new Random();
        int[] m = new int [10];
        for (int i=0; i < m.length; i++) {
            m[i] = r.nextInt(5);
            System.out.println(m[i]);

        }
    }
}
