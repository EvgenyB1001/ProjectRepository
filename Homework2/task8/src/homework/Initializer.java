package homework;

import java.math.BigDecimal;
import java.util.*;

/**
 * Class Initializer has 2 methods setProduct and getList. This class gets input
 * parameters and depending on them sets new product. The method getList returns
 * list of created products.
 */
public class Initializer {

    /**
     * List of created products
     */
    private ArrayList<Product> list = new ArrayList<>();

    /**
     * Method setProduct asks user to input parameters for the new product,
     * creates new product. Then asks, does user want to set another product.
     * If the answer 'yes' it repeats actions to create another product. Otherwise, method
     * stops.
     */
    public void setProduct() {
        String type, name;
        int count = 0;
        BigDecimal cost = new BigDecimal(0);
        Scanner scanner = new Scanner(System.in);
        String solution, current;
        boolean apply = false;
        do {
            System.out.println("Set product's type");
            type = scanner.next();
            System.out.println("Set product's name");
            name = scanner.next();
            // If there are invalid input, user sets parameters again
            do {
                try {
                    System.out.println("Set product's count");
                    count = scanner.nextInt();
                    System.out.println("Set product's cost");
                    cost = scanner.nextBigDecimal();
                    apply = true;
                } catch (InputMismatchException e) {
                    current = scanner.next();
                    System.out.println("Line '" + current + "' is not valid. Try again");
                }
            } while (!apply);
            System.out.println("Do you want to set another product? (Input 'yes' to repeat input, any key to continue)");
            solution = scanner.next();
            list.add(new Product(type, name, count, cost));
        } while (solution.equals("yes"));
    }

    /**
     * Method getList returns list of created products.
     *
     * @return list of products.
     */
    public ArrayList<Product> getList() {
        return list;
    }
}