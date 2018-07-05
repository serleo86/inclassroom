import java.time.LocalDate;

public class DateCommand implements Command{
    @Override
    public String getName() {
        return "date";
    }

    @Override
    public void execute(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(d.toString());
    }
}
