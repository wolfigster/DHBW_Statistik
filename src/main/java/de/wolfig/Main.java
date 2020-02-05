package de.wolfig;

import de.wolfig.database.MySQL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static String table;
    public static String[] columns;
    public static int num = 0;

    public static void main(String[] args) {
        if(args.length == 1) {
            createDatabaseFromFile(args[0]);
        }
    }

    static void createDatabaseFromFile(String file) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + file));
            String data = "";
            StringBuilder dataBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            columns = line.split("\\|");
            for(int c = 0; c < columns.length; c++) {
                if(columns[c].startsWith("$COLUMNS$")) columns[c] = columns[c].substring(9);
            }
            table = file.split("\\.")[0];
            MySQL.createTable(table, columns);
            int i = 0;
            while(line != null) {
                line = bufferedReader.readLine();
                StringBuilder columnBuilder = new StringBuilder();
                for(String string : columns) {
                    columnBuilder.append(string).append(", ");
                }
                columnBuilder.deleteCharAt(columnBuilder.length()-1);
                columnBuilder.deleteCharAt(columnBuilder.length()-1);
                line = line.replace("|", "', '");
                line = line.substring(0, line.length()-4);
                String sql = "INSERT INTO " + table + " (" + columnBuilder.toString() + ") VALUES ('" + line + "');";
                dataBuilder.append(sql);
                i++;

                //routine

                data = dataBuilder.toString();
                MySQL.createData(data);
                dataBuilder.delete(0, dataBuilder.length());
                data = "";

                if(i % 10000 == 0) {
                    System.out.println(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
