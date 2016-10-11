package homework;

import java.math.BigDecimal;

/**
 * Class Product has structure of products. It describes all attributes of products
 */
public class Product {

    /**
     * The type of the product
     */
    private String type = new String();

    /**
     * The name of the product
     */
    private String name = new String();

    /**
     * The count of the products
     */
    private int count = 0;

    /**
     * The cost of the one product
     */
    private BigDecimal cost = new BigDecimal(0);

    /**
     * Constructor Product create object of product, gets input parameters
     * of product and adds information about input types of product.
     *
     * @param type  type of product
     * @param name  name of product
     * @param count count of products
     * @param cost  cost of one of the product
     */
    public Product(String type, String name, int count, BigDecimal cost) {

        this.type = type;
        this.name = name;
        this.count = count;
        this.cost = cost;
    }

    /**
     * Method getType returns type of the product
     *
     * @return type of the product
     */
    public String getType() {
        return type;
    }

    /**
     * Method getCost returns cost of one product
     *
     * @return cost of the product
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Method getCount returns the count of the products
     *
     * @return count of the product
     */
    public int getCount() {
        return count;
    }
}