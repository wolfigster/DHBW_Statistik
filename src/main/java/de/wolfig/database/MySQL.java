package de.wolfig.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static de.wolfig.database.Config.*;

public class MySQL {
    private static Connection connection = null;

    private MySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + database + "?autoReconnect=true&user=" + dbUser + "&password=" + dbPassword);

        } catch (ClassNotFoundException e) {
            System.out.println("Treiber nicht gefunden");
        } catch (SQLException e) {
            System.out.println("Connect nicht moeglich");
        }
    }


    private static Connection getInstance() {
        if (connection == null)
            new MySQL();
        return connection;
    }

    public static void createData(String... data) {
        connection = getInstance();
        if(connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sql = "SQL";
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
