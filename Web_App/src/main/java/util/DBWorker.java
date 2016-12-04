package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class works with database
 */
public class DBWorker {

	/**
	 * Number of rows, changed by request
	 */
	private Integer affected_rows = 0;

	/**
	 * Value of id of new record
	 */
	private Integer last_insert_id = 0;

	/**
	 * Pointer to object of class
	 */
	private static DBWorker instance = null;

	/**
	 * Method returns object of DBWorker
	 *
	 * @return obkect of DBWorker
	 */
	public static DBWorker getInstance() {
		if (instance == null) {
			instance = new DBWorker();
		}

		return instance;
	}

	private DBWorker() {
	}

	/**
	 * Method performs queries of selecting data
	 *
	 * @param query
	 * @return selecting data
	 */
	public ResultSet getDBData(String query) {
		Statement statement;
		Connection connect;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			return resultSet;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("null on getDBData()!");
		return null;

	}

	/**
	 * Method performs queries of changing data
	 *
	 * @param query
	 * @return number of changed rows
	 */
	public Integer changeDBData(String query) {
		Statement statement;
		Connection connect;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
			statement = connect.createStatement();
			this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

			// Получаем last_insert_id() для операции вставки.
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				this.last_insert_id = rs.getInt(1);
			}

			return this.affected_rows;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("null on changeDBData()!");
		return null;
	}

	/**
	 * Method returns number of changed rows of database
	 *
	 * @return number of rows
	 */
	public Integer getAffectedRowsCount() {
		return this.affected_rows;
	}

	/**
	 * Method returns id of last inserted record
	 *
	 * @return id of record
	 */
	public Integer getLastInsertId() {
		return this.last_insert_id;
	}
}

