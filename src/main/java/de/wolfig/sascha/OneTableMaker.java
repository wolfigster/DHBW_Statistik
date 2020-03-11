package de.wolfig.sascha;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;

public class OneTableMaker
{
    public static void start() throws IOException
    {
        File f = new File("EinzelneMaschinen");
        File[] fileArray = f.listFiles();
        boolean newDoc = true;
        String[] documente = new String[131];
        FileWriter fw = new FileWriter("tabelle.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        int i = 0;
            for(File oneFile : fileArray)
            {
                i++;
                File file = new File(oneFile.toString());

                if (!file.canRead() || !file.isFile())
                    System.exit(0);

                    BufferedReader in = null;
                try {
                    in = new BufferedReader(new FileReader(oneFile.toString()));
                    String zeile = null;
                    String maschinenName = oneFile.toString().replaceAll(".csv","");
                    bw.write(maschinenName.replaceAll("EinzelneMaschinen\\\\", ""));
                    while ((zeile = in.readLine()) != null)
                    {
                        bw.write(zeile + ";");
                    }
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (in != null)
                        try {
                            in.close();
                        } catch (IOException e) {
                        }
            }
            System.out.println("Dokument " + i + " wurde in Tabelle geschrieben");
        }
        bw.close();
    }
}