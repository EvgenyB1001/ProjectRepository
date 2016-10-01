// This program outputs a line: "Hello, (parameter from the command line)". If there
// are several parameters, it outputs lines to each of the
// parameters. If the program didn't get any parameters, it outputs:
// "Hello, unnamed"
public class HelloName {
    public static void main(String[] args) {
        // Check number of parameters, which program got from the command line.
        if (args.length == 0) {
            System.out.println("Hello, unnamed");
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.println("Hello, " + args[i]);
            }
          }
        }
    }


