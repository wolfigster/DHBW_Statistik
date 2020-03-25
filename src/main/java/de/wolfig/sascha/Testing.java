package de.wolfig.sascha;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Testing
{
    public static void start()
    {
        String fileName = "a_ereignis_10.unl";
        System.out.println("1 KOSTENSTELLE\n" +
                "2 VERWEIS\n" +
                "3 SATZART\n" +
                "4 BEGIN_ZEIT\n" +
                "5 BEGIN_DAT\n" +
                "6 ENDE_ZEIT\n" +
                "7 DAUER\n" +
                "8 SOLLTAKT\n" +
                "9 TEILIGKEIT\n" +
                "10 ALT_STATUS\n" +
                "11 ALT_GRUND\n" +
                "12 NEU_STATUS\n" +
                "13 NEU_GRUND\n" +
                "14 ZFLAG\n" +
                "15 M_STATUS\n" +
                "16 STILLGRUND\n" +
                "17 BMKTONR\n" +
                "18 STOERTXT_NR\n" +
                "19 MSTCK\n" +
                "20 MAUFTR\n" +
                "21 RESERVE1\n" +
                "22 RESERVE2\n" +
                "23 RESERVE3\n" +
                "24 RESERVE4\n" +
                "25 ZAEHLER1\n" +
                "26 ZAEHLER2\n" +
                "27 ZAEHLER3\n" +
                "28 ZAEHLER4\n" +
                "29 ZAEHLER5\n" +
                "30 ZAEHLER6\n" +
                "31 SCHICHTNR\n" +
                "32 SCHICHTANF\n" +
                "33 SCHICHTEND\n" +
                "34 SCHICHTPAUSE\n" +
                "35 SCHICHTDAT\n" +
                "36 RUECKGEMELDET\n" +
                "37 BEARB\n" +
                "38 BEARB_DATE\n" +
                "39 GUT_BAS\n" +
                "40 GUT_PRI\n" +
                "41 GUT_SEK\n" +
                "42 GUT_TER\n" +
                "43 AUS_BAS\n" +
                "44 AUS_PRI\n" +
                "45 AUS_SEK\n" +
                "46 AUS_TER\n" +
                "47 NACHARB_BAS\n" +
                "48 NACHARB_PRI\n" +
                "49 NACHARB_SEK\n" +
                "50 NACHARB_TER\n" +
                "51 PROBLEM_BAS\n" +
                "52 PROBLEM_PRI\n" +
                "53 PROBLEM_SEK\n" +
                "54 PROBLEM_TER\n" +
                "55 MEINHEIT_BAS\n" +
                "56 MEINHEIT_PRI\n" +
                "57 MEINHEIT_SEK\n" +
                "58 MEINHEIT_TER\n" +
                "59 HUB_GESAMT\n" +
                "60 HUB_GUT\n" +
                "61 GUT_GRUND\n" +
                "62 GUT_GRUND_TEXT\n" +
                "63 AUS_GRUND\n" +
                "64 AUS_GRUND_TEXT\n" +
                "65 NACHARB_GRUND\n" +
                "66 NACHARB_GRUND_TEXT\n" +
                "67 PROBLEM_GRUND\n" +
                "68 PROBLEM_GRUND_TEXT\n" +
                "69 IST_LST_01\n" +
                "70 IST_LST_02\n" +
                "71 IST_LST_03\n" +
                "72 IST_LST_04\n" +
                "73 IST_LST_05\n" +
                "74  IST_LST_06\n" +
                "75 IST_LST_07\n" +
                "76 IST_LST_08\n" +
                "77 IST_LST_09\n" +
                "78 IST_LST_10\n" +
                "79 LST_EINH_01\n" +
                "80 LST_EINH_02\n" +
                "81 LST_EINH_03\n" +
                "82 LST_EINH_04\n" +
                "83 LST_EINH_05\n" +
                "84 LST_EINH_06\n" +
                "85 LST_EINH_07\n" +
                "86 LST_EINH_08\n" +
                "87 LST_EINH_09\n" +
                "88 LST_EINH_10\n" +
                "89 BEARB_TIME\n" +
                "90 HERKUNFT\n" +
                "91 ENDE_DAT\n" +
                "92 SCHICHTART\n" +
                "93 SCHICHTMODELL\n" +
                "94 PERSON_NR\n" +
                "95 P_DIVISOR\n" +
                "96 DLG_DATA_VERWEIS\n" +
                "97 BEGIN_TS\n" +
                "98 END_TS\n" +
                "99 USER_CODE\n" +
                "100 USER_D_01\n" +
                "101 USER_D_02\n" +
                "102 USER_D_03\n" +
                "103 USER_D_04\n" +
                "104 USER_D_05\n" +
                "105 USER_D_06\n" +
                "106 USER_N_07\n" +
                "107 USER_N_08\n" +
                "108 USER_N_09\n" +
                "109 USER_N_10\n" +
                "110 USER_N_11\n" +
                "111 USER_N_12\n" +
                "112 USER_N_13\n" +
                "113 USER_N_14\n" +
                "114USER_N_15\n" +
                "115 USER_N_16\n" +
                "116 USER_N_17\n" +
                "117 USER_N_18\n" +
                "118 USER_N_19\n" +
                "119 USER_N_20\n" +
                "120 USER_N_21\n" +
                "121 USER_N_22\n" +
                "122 USER_F_23\n" +
                "123 USER_F_24\n" +
                "124 USER_F_25\n" +
                "125 USER_F_26\n" +
                "126 USER_F_27\n" +
                "127 USER_F_28\n" +
                "128 USER_C_29\n" +
                "129 USER_C_30\n" +
                "130 USER_C_31\n" +
                "131 USER_C_32\n" +
                "132 USER_C_33\n" +
                "133 USER_C_34\n" +
                "134 USER_C_35\n" +
                "135 USER_C_36\n" +
                "136 USER_C_37\n" +
                "137 USER_C_38\n" +
                "138 USER_C_39\n" +
                "139 USER_C_40\n" +
                "140 USER_C_41\n" +
                "141 USER_C_42\n" +
                "142 USER_C_43\n" +
                "143 USER_C_44\n" +
                "144 USER_C_45\n" +
                "145 USER_C_46\n" +
                "146 USER_C_47\n" +
                "147 USER_C_48\n" +
                "148 USER_C_49\n" +
                "149 USER_C_50\n" +
                "150 USER_C_51\n" +
                "151 USER_C_52\n" +
                "152 USER_C_53\n" +
                "153 USER_C_54\n" +
                "154 USER_C_55\n" +
                "155 USER_C_56\n" +
                "156 USER_C_57\n" +
                "157 USER_C_58\n" +
                "158 USER_C_59\n" +
                "159 USER_C_60\n" +
                "160 USER_C_61\n" +
                "161 USER_C_62\n" +
                "162 USER_C_63\n" +
                "163 USER_C_64\n" +
                "164 USER_C_65\n" +
                "165 USER_C_66");
        System.out.print("Enter the row for specified output:");

        int column = Integer.parseInt(readString());
        String columnName = "";
        File file = new File(fileName);

        if (!file.canRead() || !file.isFile()) {
            System.out.println("Can't find file " + fileName);
            System.exit(0);
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String row = in.readLine();
            while ((row = in.readLine()) != null) {
                String[] rowData = row.split("\\|");
                writeToCSV(rowData[0], rowData[column]);
            }
            System.out.println("finished");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void writeToCSV(String machineName, String data)
    {
        final Logger logger = Logger.getLogger("test");
        try {
            File file = new File("machines/"+machineName+".csv");
            try (FileWriter writer = new FileWriter(file, true))
            {
                writer.write("\n"+data);
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


    public static void starTBt() throws IOException
    {
        File f = new File("machines");
        File[] fileArray = f.listFiles();
        String[][] docs = new String[131][119630];
        FileWriter fw = new FileWriter("table.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        int i = 0;
        for(File oneFile : fileArray) {
            File file = new File(fileArray[i].toString());

            if (!file.canRead() || !file.isFile())
                System.exit(0);

            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(fileArray[i].toString()));
                String row = null;
                docs[i][0] = fileArray[i].toString().replaceAll(".csv","").replaceAll("machines\\\\", "") + ";";
                for(int a = 1; a <= 119629; a++) {
                    if((row = in.readLine()) != null) {
                        docs[i][a] = row + ";";
                    } else {
                        docs[i][a] = ";";
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null)
                    try {
                        in.close();
                    } catch (IOException e) {
                    }
            }
            docs[i][1] = String.valueOf(i) + ";";
            i++;
            System.out.println("Document " + i + " was added to the docs");
        }

        for(int y = 0; y <= 119629; y++) {
            for(int x = 0; x <= 130; x++) {
                bw.write(docs[x][y]);
            }
            bw.newLine();
        }

        bw.close();
    }
}