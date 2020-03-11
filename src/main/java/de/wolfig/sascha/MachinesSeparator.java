package de.wolfig.sascha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class MachinesSeparator
{
    public static void start()
    {
        String datName = "a_ereignis_10.unl";
        System.out.print("Gib die Spaltennummer ein, zur der du die Tabellen erstellt haben möchtest: ");
        int spalte = Integer.parseInt(readString());
        String spaltenName = "";
        File file = new File(datName);
        boolean ersteZeile = true;
        
        if (!file.canRead() || !file.isFile())
            System.exit(0);

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(datName));
            int number = 0;
            String zeile = null;
            while ((zeile = in.readLine()) != null)
            {
                if(ersteZeile)
                {
                    ersteZeile = false;
                } else {
                    char[] charArray = zeile.toCharArray();
                    ArrayList<Character> maschinenbezeichnungChar = new ArrayList<>();
                    for(int i = 0; charArray[i] != '|'; i++)
                    {
                        maschinenbezeichnungChar.add(charArray[i]);
                    }
                    String maschinenbezeichnungString = new String();
                    for(char c : maschinenbezeichnungChar)
                    {
                        maschinenbezeichnungString = maschinenbezeichnungString + c; 
                    }
                    //System.out.print(maschinenbezeichnungString + ": "); //Name der Maschine

                    ArrayList<Character> einzufuegenderChar = new ArrayList<>();
                    int j = 0;
                    for(int i = 0; i < charArray.length; i++)
                    {
                        if(j<spalte && charArray[i] == '|')
                        {
                            j++;
                        }
                        else if(charArray[i] == '|')
                        {
                            break;
                        }
                        else if(j>=spalte)
                        {
                            einzufuegenderChar.add(charArray[i]);
                        }
                    }
                    String einzufuegenderText = new String();
                    for(char c : einzufuegenderChar)
                    {
                        einzufuegenderText = einzufuegenderText + c; 
                    }
                    //System.out.print(einzufuegenderText + "\n"); //Ausgewählte Spalte der Maschine
                    if(ersteZeile)
                    {
                        spaltenName = einzufuegenderText;
                        ersteZeile = false;
                    } else {
                        writeInTxt(maschinenbezeichnungString, einzufuegenderText);
                    }
                }
            }
            System.out.println(number + " Dateien wurden erstellt.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
    }
    
    public static void writeInTxt(String maschinenbezeichnung, String einzufuegenderText)
    {
        final Logger logger = Logger.getLogger("test");
        try {
                File file = new File("EinzelneMaschinen/"+maschinenbezeichnung+".csv");
                try (FileWriter writer = new FileWriter(file, true))
                {
                    writer.write("\n"+einzufuegenderText);
                    writer.flush();
                }
            }
            catch (IOException ex)
            {
                logger.log(Level.WARNING, ex.getLocalizedMessage());
            }
    }
    
    private static String readString()
    {
        Scanner scan = new Scanner( System.in );
        return scan.nextLine();
    }
}