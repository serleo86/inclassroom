import java.time.LocalTime;

class TimeCommand implements Command{
    @Override
    public String getName () {
        return "time";
    }

    @Override
    public void execute (String[] args) {
        LocalTime t = LocalTime.now();
        System.out.println(t.toString());
    }
}
