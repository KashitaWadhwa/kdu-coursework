package jav.assignment.globalObjects;


import jav.assignment.Coins.Coin;
import jav.assignment.traders.Trader;
import jav.assignment.readFiles.ReadTraders;
import jav.assignment.readFiles.ReadCoins;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GlobalData {

    public static HashMap<String, Trader> tradersData = new HashMap<>();
    public static HashMap<String, Coin> coinNameAndCoinObject = new HashMap<>();
    public static HashMap<String, Coin> coinSymbolAndCoinObject = new HashMap<>();
    public static List<Trader> allTraderList = new ArrayList<>();

    private static final ArrayList<String[]> arr = new ArrayList<>();

    public static void readData(String coinsCsvFilePath, String tradersCsvFilePath) throws IOException {

        ReadCoins.readDataFromCoins(coinsCsvFilePath,arr);
        ReadTraders.readDataFromTraders(tradersCsvFilePath,arr);
    }
}