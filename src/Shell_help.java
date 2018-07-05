import com.sun.javafx.collections.MappingChange;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shell_help {
    private Map<String, Command> commands = new HashMap<>();

    public void addCommand (Command c) {
        commands.put (c.getName(), c);
            }



    public void runShell () {
        Scanner sca = new Scanner(System.in);
        while (true) {
            System.out.print(">" );
            String commandName = sca.nextLine();
            if (commands.containsKey(commandName))
                commands.get(commandName).execute(new String[]{});
            else
                System.out.println("There is no command " + commandName);
        }
    }


    }

