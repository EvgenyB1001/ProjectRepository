package homework;

import homework.commands.*;

import java.util.*;

/**
 * Class Main has entry point to the program.
 */
public class Main {

    /**
     * Method main calls class Initializer to set products, then it asks user
     * to input commands and depending on the input command method calls various classes
     * to perform the action. If user's command is 'exit', program exits.
     */
    public static void main(String[] args) {
        try {
            Initializer initializer = new Initializer();
            // Sets products to the program.
            initializer.setProduct();
            ArrayList<Command> commands = new ArrayList<>();
            commands.add(new CountAll());
            commands.add(new CountTypes());
            commands.add(new AllAveragePrice());
            commands.add(new AverageTypeCost());
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