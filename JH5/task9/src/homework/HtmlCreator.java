package homework;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.io.*;

/**
 * Class HtmlCreator creates html-table
 */
public class HtmlCreator {

    /**
     * Colors of html-table
     */
    private static final String HEAD_COLOR = "#cecfce";
    private static final String COL1_COLOR = "#efefef";
    private static final String COL2_COLOR = "#f7f7f7";
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
            "<style type=\"text/css\">\n" +
            "table {\n" +
            "border-collapse: collapse;\n" +
            "}\n" +
            "table thead {\n" +
            "border-bottom: 4px solid " + BORDER_COLOR + ";\n" +
            "}\n" +
            "table td {\n" +
            "padding-left: 9px;\n" +
            "}\n" +
            "</style>\n" +
            "<table border=1 bordercolor =\"" + BORDER_COLOR + "\"CELLSPACING = 0" +
            "cellpadding=\"1\"  width=\"530\" height=\"130\" align = center>\n " +
            "<thead>\n" +
            "<tr valign=\"top\" bgcolor =\"" + HEAD_COLOR + "\" align = center height = \"30\"> \n" +
            "<th>ИМЯ</th>\n" +
            "<th>ТИП</th>\n" +
            "<th>ДАТА<br>СОЗДАНИЯ</th>\n" +
            "<th>РАЗМЕР (в Kb)</th>\n" +
            "</tr>\n" +
            "</thead>\n" +
            "<tbody>\n";

    /**
     * String FOOTER contains finish part of html code
     */
    private static final String FOOTER = "</tbody>\n </table>\n </body>\n </html>\n";

    /**
     * Contains full html code
     */
    private String HTML = "";

    /**
     * Method getHtml returns full html code of html-table
     */
    public String getHtml() {
        return HTML;
    }

    /**
     * Method setInfo gets path of the working directory, observe information
     * about files, that exist in this directory, and set this info to the html-table
     *
     * @param address path to the working directory
     */
    public HtmlCreator(String address) throws Exception {
        File folder = new File(address);
        // Array of files, that exist in directory
        File[] listOfFiles = folder.listFiles();
        int count = 0;
        // Variable of attributes of the file
        BasicFileAttributes attributes;
        for (File file : listOfFiles) {
            attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            count++;
            setLineOfFile(file, attributes, count);
        }
        HTML = HEADER + HTML + FOOTER;
    }

    /**
     * Method convertDate convert date format to format dd.mm.yyyy
     *
     * @param line line of date
     * @return line of date in format dd.mm.yyyy
     */
    private String convertDate(String line) {
        // Cuts redundant text from date
        line = line.substring(0, line.indexOf("T"));
        // Splits line to separate values of day, month and year
        String[] array = line.split("-");
        return array[2] + "." + array[1] + "." + array[0];
    }

    /**
     * Method get file and calculate size in Kb in cases of file or directory
     *
     * @param file file, that should be observed
     * @return size of this file in bytes
     */
    private long getSize(File file) {
        long size = 0;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File newFile : files) {
                    if (newFile.isFile()) {
                        size += newFile.length();
                    }
                    // Observes every inserted directory
                    if (newFile.isDirectory()) {
                        size += getSize(newFile);
                    }
                }
            }
        }
        if (file.isFile() && file.length() != 0) {
            size = file.length();
        }
        return size;
    }

    /**
     * Method convertToKb convert size in bytes to Kb
     * If size less the 1 Kb, it returns 1.
     * If remainder of the division is more than half of 1024
     * it rounds result to the nearest bigger integer value.
     *
     * @param size value in bytes of size of the file
     * @return size in Kb
     */
    private static long convertToKb(long size) {
        if (size != 0 && size < 1024) {
            return 1;
        } else if ((size % 1024) > (1024 / 2)) {
            return (size / 1024) + 1;
        } else {
            return size / 1024;
        }
    }

    /**
     * Method adds to html table another line, that contains information
     * (name, type, creation date, size) about files,
     * that exist in directory.
     *
     * @param file       file, that should be observed
     * @param attributes attributes of file
     * @param count      number to detect background color
     */
    private void setLineOfFile(File file, BasicFileAttributes attributes, int count) {
        String type = new String();
        // Detect is it file or directory
        if (file.isFile()) {
            type = "FILE";
        }
        if (file.isDirectory()) {
            type = "DIR";
        }
        // Verify, what background color should be
        if (count % 2 != 0) {
            HTML += "<tr bgcolor = \"" + COL1_COLOR + "\"><td>" + file.getName() + "</td><td>"
                    + type + "</td><td>"
                    + convertDate(attributes.creationTime().toString()) + "</td><td>"
                    + convertToKb(getSize(file)) + "</td></tr>\n";
        } else {
            HTML += "<tr bgcolor = \"" + COL2_COLOR + "\"><td>" + file.getName() + "</td><td>"
                    + type + "</td><td>"
                    + convertDate(attributes.creationTime().toString()) + "</td><td>"
                    + convertToKb(getSize(file)) + "</td></tr>\n";
        }
    }
}