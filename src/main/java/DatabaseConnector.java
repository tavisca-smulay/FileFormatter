import java.sql.*;

public class DatabaseConnector {
    static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/datasource", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection connect() {
        return connection;
    }
}