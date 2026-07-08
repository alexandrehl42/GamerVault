package gamervault.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/gamer_vault";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private ConnectionFactory() {
    }

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {

            throw new RuntimeException("Erro ao conectar ao banco de dados.", e);

        }

    }

}