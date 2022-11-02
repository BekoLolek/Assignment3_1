package sdj3.assignment3_1.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String url="jdbc:postgresql://localhost/slaughterhouse";
    private final String user="postgres";
    private final String password="g11nsUhb";
    private static DatabaseConnection databaseConnection;

    public static DatabaseConnection getConnection() throws SQLException {
        databaseConnection = (DatabaseConnection) DriverManager.getConnection(databaseConnection.url, databaseConnection.user,
                databaseConnection.password);
        return databaseConnection;
    }
}
