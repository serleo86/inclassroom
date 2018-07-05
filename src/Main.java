public class Main {
    public static void main(String[] args) {
        Shell_help s = new Shell_help();
        s.addCommand (new TimeCommand());
        s.addCommand (new DateCommand());
        s.addCommand (new ExitCommand());
        s.runShell();
    }
}
