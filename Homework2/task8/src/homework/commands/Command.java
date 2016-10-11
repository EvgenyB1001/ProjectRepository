package homework.commands;

import homework.Product;

import java.util.ArrayList;

/**
 * Base class Command has only one method performCommand
 */
public abstract class Command {

    /**
     * Method verifyAndExecute is overridden by inheritors.
     *
     * @param line line of command
     * @param list list of created command
     */
    public abstract void verifyAndExecute(String line, ArrayList<Product> list);
}
