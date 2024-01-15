package jav.assignment.readFiles;


import jav.assignment.Logging;
import jav.assignment.traders.Trader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadTraders {
    private static final String CSV_SEPARATOR = ",";
    private static final HashMap<String, Trader> tradersData = new HashMap<>();
    private static final List<Trader> allTradersList = new ArrayList<>();

    public static void readDataFromTraders(String path, ArrayList<String[]> temp) throws IOException {

        String tradersCSV = path;

        BufferedReader br = null;
        try {
            File file = new File(tradersCSV);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            String[] headerLine = br.readLine().split(CSV_SEPARATOR);
            String[] individualField;

            while ((line = br.readLine()) != null) {
                individualField = line.split(CSV_SEPARATOR);
                Trader trader = new Trader();
                trader.setSrNo(Integer.parseInt(individualField[0]));
                trader.setFirstName(individualField[1]);
                trader.setLastName(individualField[2]);
                trader.setPhone(individualField[3]);
                trader.setWalletAddress(individualField[4]);

                tradersData.put(trader.getWalletAddress(), trader);
                allTradersList.add(trader);
                temp.add(individualField);
            }
            Logging.logInfo("Traders data read");

        } catch(NumberFormatException numberFormatException) {
            throw new NumberFormatException("Problem occurred while parsing data, check whether correct typecasting is being used for data type");
        } catch(FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException("The file you are looking doesn't exist at location, Please check its file path or name");
        } catch (IOException ioException) {
            throw new IOException("Problem occurred while reading file, check for file security, permission or your network ");
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    Logging.logInfo("Couldn't close the reader resource, check for its availability");
                }
            }
        }
    }
}