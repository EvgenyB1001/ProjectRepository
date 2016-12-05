package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class to work with database
 */
public class DBManager {

    /**
     * Line with data to connect database
     */
    private static final String DRIVER = "jdbc";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "mysql://localhost:3306/wordpress_default";
    private static final String USERNAME = "root";

    /**
     * Instance of class object
     */
    private static DBManager instance;
    private Connection connection;

    /**
     * Implementation of singleton pattern of DBManager
     */
    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    /**
     * Method open connection to database
     */
    private void openConnection() {
        try {
            connection = DriverManager.getConnection(DRIVER + ":" + DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method close connection to database
     */
    private void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method execute query to databse and returns count of post in definite table of database
     *
     * @return number of entries
     */
    public Integer getCountOfPosts() {
        openConnection();
        if (connection != null) {
            try {
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT COUNT(*)" +
                        " FROM `wp_posts`");
                return resultSet.getInt(1);
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            } finally {
                closeConnection();
            }
        }
        return null;
    }
}
