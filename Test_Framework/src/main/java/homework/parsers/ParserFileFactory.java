package homework.parsers;

/**
 * Class creates objects of parsers depending of input data
 */
public class ParserFileFactory {

    /**
     * Names of supported file formats
     */
    private final String JSON = "json";
    private final String XML = "xml";
    private final String TXT = "txt";

    /**
     * Method creates and returns object of parser, depending on
     * the first argument, got as parameter
     *
     * @param args input argument
     * @return object of parser
     */
    public ParserFile createParser(String[] args) throws Exception {
        String[] parts = args[0].split("\\.");
        if (parts.length == 1) {
            return new CommandLineParser(args);
        }
        switch (parts[parts.length - 1]) {
            case JSON:
                return new ParserJSON(args[0]);
            case TXT:
                return new ParserTXT(args[0]);
            case XML:
                return new ParserXML(args[0]);
            default:
                throw new Exception("No parser for such file");
        }
    }
}
