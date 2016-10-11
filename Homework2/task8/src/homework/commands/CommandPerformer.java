package homework.commands;

import homework.*;

import java.util.*;

/**
 * Class CommandPerformer performs available commands from user.
 */
public class CommandPerformer {

    /**
     * Creates an object of CommandPerformer, gets list of product, list of commands
     * and performs commands, got from user.
     *
     * @param products list of created products.
     * @param commands list of commands.
     */
    public CommandPerformer(ArrayList<Product> products, ArrayList<Command> commands) {
        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            System.out.println("Set command (input 'exit' to exit):");
            line = scanner.nextLine();
            for (Command c : commands) {
                c.verifyAndExecute(line, products);
            }
        } while (!(line.equals("exit")));
        System.out.println("Thanks for using our program");
        scanner.close();
    }
}