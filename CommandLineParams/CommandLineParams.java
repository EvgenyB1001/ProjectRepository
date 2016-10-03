/* The program outputs parameters from the command line in reverse order */
public class CommandLineParams {
    /**
     * Method main get parameters from the command line and outputs
     * them in reverse order
     */
    public static void main(String[] args) {
        for(int i = args.length-1; i >= 0; i--) {
            System.out.println("Argument " + i + " = " + args[i]);
        }
    }
}
