package homework.commands;

import homework.Product;

import java.util.ArrayList;

/**
 * Class CountAll counts all products that are set by user.
 */
public class CountAll extends Command {

    /**
     * Command to perform action of this class
     */
    private static final String COMMAND_COUNT_ALL = "count all";

    /**
     * Method countAllProducts gets list of products, counts their
     * general count and outputs it to user.
     *
     * @param list list of created products
     */
    public void countAllProducts(ArrayList<Product> list) {
        int count = 0;
        for (Product p : list) {
            count += p.getCount();
        }
        System.out.println("Count of all products is " + count);
    }

    /**
     * Overrides method from superclass Command, verifies input command and perform command
     *
     * @param line     user's command
     * @param products list of created products
     */
    @Override
    public void verifyAndExecute(String line, ArrayList<Product> products) {
        if (line.equals(COMMAND_COUNT_ALL)) {
            countAllProducts(products);
        }
    }
}