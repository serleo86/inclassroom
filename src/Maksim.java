import java.util.Random;

public class Maksim {
    public static void main(String[] args) {
        int[] a = new int [10];
        Random r = new Random();
        for (int i=0; i<a.length; i++) {
            a[i] = r.nextInt(100);
            System.out.print(a[i] + " ");
            }
        int bol = a[0];
        int men = a[0];
        for (int i=0; i<a.length; i++){
            if (a[i]>=bol)
                bol = a[i];
            if (a[i]<=men)
                men = a[i];
        }
        System.out.println();
        System.out.println("MAX=" + bol);
        System.out.println("MIN=" + men);
    }
}
