package homework.commands;

import homework.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Class calculates average price of created products of definite type
 */
public class AverageTypeCost extends Command {

    /**
     * Method getAveragePriceType gets type set by user and list of products.
     * It counts products of set by user type, their prices and outputs average price.
     *
     * @param type set by user type.
     * @param list list of products.
     */
    public void getAveragePriceType(String type, ArrayList<Product> list) {
        double count = 0;
        int negCount = 0;
        BigDecimal cost = new BigDecimal(0);
        // For each type that equals to set by user type it counts products and sum prices.
        for (Product p : list) {
            if (p.getType().equals(type)) {
                count += p.getCount();
                cost = cost.add(p.getCost());
            } else {
                negCount++;
            }
        }
        // If there are no product of such type, the program shows info about it
        if (negCount == list.size()) {
            System.out.println("No products of such type");
            return;
        }
        // Outputs average price
        System.out.println("Average price of " + type + " = " + cost.divide(BigDecimal.valueOf(count)).toString());
    }

    /**
     * Overrides method from superclass Command, verifies input command and perform command
     *
     * @param line     user's command
     * @param products list of created products
     */
    @Override
    public void checkCommand(String line, ArrayList<Product> products) {
        if (line.matches("^average price\\s\\w*$")) {
            String[] params = line.split(" ");
            getAveragePriceType(params[2], products);
        }
    }
}