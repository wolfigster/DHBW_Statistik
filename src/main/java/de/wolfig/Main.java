package de.wolfig;

import de.wolfig.database.MySQL;
import de.wolfig.sascha.MachinesSeparator;
import de.wolfig.sascha.OneTableMaker;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static String table;
    public static String[] columns;
    public static int num = 0;
    static String pattern = "dd.MM.yyyy HH:mm:ss.SSS";
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public static void main(String[] args) {
        if(args.length == 1) {
            //createDatabaseFromFile(args[0]);
            if(args[0].equals("ms")) {
                MachinesSeparator.start();
                System.out.println();
            } else if(args[0].equals("otm")) {
                try {
                    OneTableMaker.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if(args.length == 2) {
            test(args[0], Integer.parseInt(args[1]));
        }
    }

    static void test(String file, int start) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + file));
            String cols = bufferedReader.readLine().replace("|", ", ").replace("$COLUMNS$", "");
            table = file.split("\\.")[0];
            MySQL.createTable(table, cols);
            cols = cols.substring(0, cols.length()-2);
            int i = 1;
            String line = bufferedReader.readLine();
            while(line != null) {
                line = line.replace("|", "', '");
                line = line.substring(0, line.length()-4);
                String sql = "INSERT INTO " + table + " (" + cols + ") VALUES ('" + line + "');";
                line = bufferedReader.readLine();
                if(i >= start) {
                    MySQL.createData(sql);
                }
                i++;
                if(i % 10000 == 0) {
                    System.out.println("Count: " + i + " Time: " +  simpleDateFormat.format(new Date()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
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
            StringBuilder columnBuilder = new StringBuilder();
            for(String string : columns) {
                columnBuilder.append(string).append(", ");
            }
            columnBuilder.deleteCharAt(columnBuilder.length()-1);
            columnBuilder.deleteCharAt(columnBuilder.length()-1);
            table = file.split("\\.")[0];
            MySQL.createTable(table, columns);
            int i = 0;
            while(line != null) {
                line = bufferedReader.readLine();
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
