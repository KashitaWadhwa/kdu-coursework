package jav.assignment;

import jav.assignment.globalObjects.GlobalData;
import jav.assignment.readFiles.ReadJSON;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            String csvCoin = "src/main/resources/coins.csv";
            String csvTrader = "src/main/resources/traders.csv";
            GlobalData.readData(csvCoin, csvTrader);
            MenuDriven md = new MenuDriven();
            md.start();

            com.fasterxml.jackson.databind.JsonNode transaction = null;
            transaction = ReadJSON.JSONFileReader("src/main/resources/small_transaction.json");

            CountDownLatch latch = new CountDownLatch(transaction.size());
            executeTransactions(transaction, latch);

            latch.await();
        } catch (Exception e) {
            Logging.logInfo(e.getMessage());
        }
    }

    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch) {
        ExecutorService executorService = Executors.newFixedThreadPool((int)latch.getCount());
        try {
            for (JsonNode obj : jsonTransactions) {
                ExecuteTransaction executeTransaction = new ExecuteTransaction(obj, latch);
                executorService.submit(executeTransaction);

            }
            executorService.shutdown();
        } catch (Exception e) {
            Logging.logInfo(e.getMessage());
        }
    }
}
