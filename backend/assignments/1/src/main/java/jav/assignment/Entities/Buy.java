package jav.assignment.Entities;

import com.fasterxml.jackson.databind.JsonNode;
import jav.assignment.Coins.Coin;
import jav.assignment.globalObjects.GlobalData;

public class Buy {
    private Coin coin;
    private final long quantity;
    private final String walletAddress;
    private String status;


    public Buy(JsonNode obj) {
        String coinSymbol = obj.get("coin").asText();
        this.coin = GlobalData.coinSymbolAndCoinObject.get(coinSymbol);
        this.quantity = obj.get("quantity").asLong();
        this.walletAddress = obj.get("wallet_address").asText();
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public long getQuantity() {
        return quantity;
    }


    public String getWalletAddress() {
        return walletAddress;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "coin=" + coin +
                ", quantity=" + quantity +
                ", walletAddress='" + walletAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
