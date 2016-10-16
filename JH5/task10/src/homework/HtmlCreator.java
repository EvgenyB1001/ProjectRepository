package homework;

import java.util.HashMap;
import java.util.Map;

/**
 * Class HtnlCreator creates html code and returns string of html code
 */
public class HtmlCreator {

    /**
     * Colors of html-table
     */
    private static final String HEAD_COLOR = "#999999";
    private static final String COL1_COLOR = "#efefef";
    private static final String COL2_COLOR = "#D9D9D9";
    private static final String COL_MAX_COLOR = "FF0000";
    private static final String BORDER_COLOR = "#ffffff";

    /**
     * String HEADER contains header of html code
     */
    private static final String HEADER = "<html>\n " +
            "<head>\n " +
            "<title>Table</title>\n " +
            "<meta charset = \"utf-8\">\n " +
            "</head>\n " +
            "<body>\n" +
            "<table border=1 bordercolor =\"" + BORDER_COLOR + "\"CELLSPACING = 0" +
            "cellpadding=\"1\"  width=\"630\" height=\"230\" align = \"center\">\n " +
            "<tr bgcolor=\"" + HEAD_COLOR + "\"align = center valign = center>\n " +
            "<th width=\"630\">Server</th>\n " +
            "<th width=\"630\">Response, ms</th>\n";

    /**
     * String FOOTER contains finish part of html code
     */
    private static final String FOOTER = "</table>\n </body>\n </html>\n";

    /**
     * Body of the html code
     */
    private String HTML = "";

    /**
     * Method getHtml returns full html code of html-table
     */
    public String getHtml() {
        return HTML;
    }

    /**
     * Constructor HtmlCreator gets collection of ip addresses and creates
     * a full html code of html table.
     *
     * @param addresses collection of ip addresses
     */
    public HtmlCreator (HashMap<String, Integer> addresses) {
        int max = 0;
        // Searching for the maximal time
        for (Map.Entry<String, Integer> ip : addresses.entrySet()) {
            if (ip.getValue() > max) {
                max = ip.getValue();
            }
        }
        // Create another line of table
        setLine(addresses, max);
        // Create full html code
        HTML = HEADER + HTML + FOOTER;
    }

    /**
     * Method setLine gets collection of ip addresses and maximal time,
     * depending on maximal time set color of line, creates another line of table.
     *
     * @param addresses collection of ip addresses
     * @param max maximal time of request
     */
    private void setLine(HashMap<String, Integer> addresses, int max) {
        int count = 0;
        for (Map.Entry<String, Integer> ip : addresses.entrySet()) {
            // if there are maximal request time, color of line is red
            if (ip.getValue() == max) {
                HTML += "<tr bgcolor = \"" + COL_MAX_COLOR + "\" width=\"530\"><td>" + ip.getKey() + "</td><td>"
                        + ip.getValue() + "</td></tr>\n";
            } else {
                count++;
                // Set color of line depends on there order
                if (count % 2 != 0) {
                    HTML += "<tr bgcolor = \"" + COL1_COLOR + "\" width=\"530\"><td>" + ip.getKey() + "</td><td>"
                            + ip.getValue() + "</td></tr>\n";
                } else {
                    HTML += "<tr bgcolor = \"" + COL2_COLOR + "\" width=\"530\"><td>" + ip.getKey() + "</td><td>"
                            + ip.getValue() + "</td></tr>\n";
                }
            }
        }
    }
}
