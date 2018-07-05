import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner sca = new Scanner (System.in);
        //sca.nextLine();
        while (true){
            System.out.print(">" );
            String s = sca.nextLine();
            switch (s) {
                case "time":
                    System.out.println(LocalTime.now());
                    break;
                case "date":
                    System.out.println(LocalDate.now());
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Команда неизвестна");
                }

        }
    }
}
