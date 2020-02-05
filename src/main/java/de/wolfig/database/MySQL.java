package de.wolfig.database;

import de.wolfig.Main;

import java.sql.*;

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

    public static void createTable(String table, String[] columns) {
        connection = getInstance();
        if(connection != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CREATE TABLE IF NOT EXISTS ").append(table).append(" (ID int(11) NOT NULL AUTO_INCREMENT, ");
                for(String string : columns) {
                    stringBuilder.append(string).append(" VARCHAR(30) NOT NULL, ");
                }
                stringBuilder.append("PRIMARY KEY (ID));");
                Statement statement = connection.createStatement();
                statement.executeUpdate(stringBuilder.toString());
                System.out.println("Table created with command: " + stringBuilder.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void createData(String sql) {
        connection = getInstance();
        if(connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("DER HIER IST FALSCH >>> " + sql);
                e.printStackTrace();
            }

        }
    }

    public static void createData(String table, String[] columns, String data) {
        connection = getInstance();
        if(connection != null) {
            try {
                StringBuilder columnBuilder = new StringBuilder();
                for(String string : columns) {
                    columnBuilder.append(string).append(", ");
                }
                columnBuilder.deleteCharAt(columnBuilder.length()-1);
                columnBuilder.deleteCharAt(columnBuilder.length()-1);
                StringBuilder insertBuilder = new StringBuilder();
                for(String string : data.split("\\|")) {
                    insertBuilder.append(string).append("', '");
                }
                insertBuilder.deleteCharAt(insertBuilder.length()-1);
                insertBuilder.deleteCharAt(insertBuilder.length()-1);
                insertBuilder.deleteCharAt(insertBuilder.length()-1);
                insertBuilder.deleteCharAt(insertBuilder.length()-1);
                Statement statement = connection.createStatement();
                String sql = "INSERT INTO " + table + " (" + columnBuilder.toString() + ") VALUES ('" + insertBuilder.toString() + "');";
                statement.executeUpdate(sql);
                System.out.println(Main.num++ + " > " + sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
