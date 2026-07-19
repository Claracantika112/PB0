package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/db_kasir";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Jika XAMPP Anda diberi password, tulis di sini
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC tidak ditemukan: " + e.getMessage());
            }
        }
        return connection;
    }
}