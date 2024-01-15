package jav.assignment.Entities;

import com.fasterxml.jackson.databind.JsonNode;
import jav.assignment.Coins.Coin;
import jav.assignment.globalObjects.GlobalData;

public class UpdatePrice {
    private Coin coin;
    private long quantity;
    private final String walletAddress;
    private final String status;
    private final Double price;

    public UpdatePrice(String walletAddress, String status, JsonNode obj) {
        this.walletAddress = walletAddress;
        this.status = status;
        this.price = obj.get("price").asDouble();
        this.coin = GlobalData.coinSymbolAndCoinObject.get(obj.get("coin").asText());
    }

    public Double getPrice() {
        return price;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

      public void setQuantity(long quantity) {
        this.quantity = quantity;
    }



    @Override
    public String toString() {
        return "UpdatePrice{" +
                "coin=" + coin +
                ", quantity=" + quantity +
                ", walletAddress='" + walletAddress + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
