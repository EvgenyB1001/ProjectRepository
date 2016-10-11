package homework.commands;

import homework.Product;

import java.util.ArrayList;

/**
 * Class CountTypes counts types of created products.
 */
public class CountTypes extends Command {

    /**
     * Command to perform action of this class
     */
    private static final String COMMAND_COUNT_TYPES = "count types";

    /**
     * Method getCountTypes gets list of products and calculate
     * the count of types.
     *
     * @param products list of products.
     */
    public static void getCountTypes(ArrayList<Product> products) {
        int currCount = 0;
        Product[] curProducts = new Product[products.size()];
        for (int i = 0; i < curProducts.length; i++) {
            curProducts[i] = products.get(i);
        }
        // Looks for equal types of product
        for (int i = 0; i < curProducts.length; i++) {
            for (int j = i + 1; j < curProducts.length; j++) {
                if (curProducts[i].getType().equals(curProducts[j].getType())) {
                    currCount++;
                }
            }
        }
        System.out.println("Count of types is " + (curProducts.length - currCount));
    }

    /**
     * Overrides method from superclass Command, verifies input command and perform command
     *
     * @param line     user's command
     * @param products list of created products
     */
    @Override
    public void verifyAndExecute(String line, ArrayList<Product> products) {
        if (line.equals(COMMAND_COUNT_TYPES)) {
            getCountTypes(products);
        }
    }
}