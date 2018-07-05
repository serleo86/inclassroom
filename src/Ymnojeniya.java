public class Ymnojeniya {
    public static void main(String[] args) {
        int[][] m = new int[10][10];
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                m[i][j] = (i+1) * (j+1);
            }
        }
        for (int i=0; i<=9; i++){
            for (int j=0; j<=9; j++){
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
