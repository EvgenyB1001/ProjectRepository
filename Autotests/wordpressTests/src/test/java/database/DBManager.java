package database;

import java.sql.*;

/**
 * Class to work with database
 */
public class DBManager {

    /**
     * Lines with queries
     */
    private static final String DELETE_QUERY = "DELETE FROM ? WHERE user_login = ? AND user_email = ?";
    private static final String INSERT_QUERY = "INSERT INTO ? (`user_login`, `user_pass`, " +
            "`user_nicename`, `user_email`, `user_registered`)" +
                    " VALUES (?, MD5(?), ?, ?, ?)" ;
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM ?";
    private static final String DEFINITE_COUNT_QUERY = "SELECT COUNT(*) FROM ? WHERE user_login = ? AND user_email = ?";

    /**
     * Line with data to connect database
     */
    private static final String DRIVER = "jdbc";
    private static final String PASSWORD = "root";
    private static final String DATABASE_URL = "mysql://localhost:8889/wordpress";
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
     * Method execute query to database and returns count of post in definite table of database
     *
     * @return number of entries
     */
    public Integer getAllCount(String database) {
        DBManager.getInstance().openConnection();
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(COUNT_QUERY);
                statement.setString(1, database);
                ResultSet resultSet = statement.executeQuery();
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
