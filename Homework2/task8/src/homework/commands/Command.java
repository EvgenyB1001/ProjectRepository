package homework.commands;

import homework.Product;

import java.util.ArrayList;

/**
 * Base class Command has only one method performCommand
 */
public abstract class Command {

    /**
     * Method performCommand will be overridden
     */
    public abstract void checkCommand(String line, ArrayList<Product> list);
}
