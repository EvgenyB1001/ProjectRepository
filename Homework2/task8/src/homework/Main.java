package homework;

import homework.commands.*;

import java.util.*;

/**
 * Class Main has entry point to the program.
 */
public class Main {

    /**
     * Method main calls class Initializer to set products, then it
     * creates list of commands, send list of products and list of commands to
     * class, that performs commands
     */
    public static void main(String[] args) {
        try {
            Initializer initializer = new Initializer();
            // Sets products to the program.
            initializer.setProduct();
            // Creates list of commands
            ArrayList<Command> commands = new ArrayList<>();
            commands.add(new CountAll());
            commands.add(new CountTypes());
            commands.add(new AllAveragePrice());
            commands.add(new AverageTypeCost());
            // Class, that performs commands
            new CommandPerformer(initializer.getList(), commands);
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input format");
        } catch (ArithmeticException e) {
            System.out.println("Error in calculations");
        } catch (Exception e) {
            System.out.println("Error in program");
        }
    }
}