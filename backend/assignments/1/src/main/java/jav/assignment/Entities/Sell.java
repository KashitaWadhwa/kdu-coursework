package jav.assignment.Entities;

import com.fasterxml.jackson.databind.JsonNode;
import jav.assignment.Coins.Coin;
import jav.assignment.globalObjects.GlobalData;

public class Sell {
    private Coin coin;
    private final Long quantity;
    private final String walletAddress;
    private String transactionStatus;
    public Sell(JsonNode obj, String walletAddress) {
        this.quantity = obj.get("quantity").asLong();
        this.coin = GlobalData.coinSymbolAndCoinObject.get(obj.get("coin").asText());
        this.walletAddress = walletAddress;
    }


    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }




    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public Long getQuantity() {
        return quantity;
    }


    public String getWalletAddress() {
        return walletAddress;
    }



    @Override
    public String toString() {
        String status = "available";
        return "Sell{" +
                "coin=" + coin +
                ", quantity=" + quantity +
                ", walletAddress='" + walletAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}