package homework.commands;

import homework.Product;

import java.math.BigDecimal;
import java.util.*;

/**
 * Class calculates average price of all created products.
 */
public class AllAveragePrice extends Command {

    /**
     * Command to perform action of this class
     */
    private static final String COMMAND_AVERAGE_PRICE = "average price";

    /**
     * Method averagePrice gets list of products, counts products
     * and sum their prices. It outputs average price of all products.
     *
     * @param list list of products.
     */
    public void averagePrice(ArrayList<Product> list) {
        BigDecimal cost = new BigDecimal(0);
        double count = 0;
        // For each type it counts products and sum prices.
        for (Product p : list) {
            cost = cost.add(p.getCost());
            count += p.getCount();
        }
        System.out.println("Average cost is " + cost.divide(BigDecimal.valueOf(count)).toString());
    }

    /**
     * Overrides method from superclass Command, verifies input command and perform command
     *
     * @param line     user's command
     * @param products list of created products
     */
    @Override
    public void verifyAndExecute(String line, ArrayList<Product> products) {
        if (line.equals(COMMAND_AVERAGE_PRICE)) {
            averagePrice(products);
        }
    }
}