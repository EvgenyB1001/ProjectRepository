package homework;

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
     * Contains body of html code
     */
    private String html = "";

    /**
     * Method getHtml returns full html code of html-table
     */
    public String getHtml() {
        return HEADER + html + FOOTER;
    }

    /**
     * Method addDataLine gets ip address, their request time and count of line, set this data to another
     * line of html-table.
     *
     * @param server ip addresses
     * @param time   time of request
     * @param count  count of line
     * @param max    value of maximal request time
     */
    public void addDataLine(String server, int time, int max, int count) {
        // Creates another line of table
        if (time == max) {
            html += "<tr bgcolor = \"" + COL_MAX_COLOR + "\" width=\"530\"><td>" + server + "</td><td>"
                    + time + "</td></tr>\n";
        } else {
            // Sets color of line depends on their order
            html += "<tr bgcolor = \"";
            html += (count % 2 != 0) ? COL1_COLOR : COL2_COLOR;
            html += "\" width=\"530\"><td>" + server + "</td><td>"
                    + time + "</td></tr>\n";
        }
    }
}