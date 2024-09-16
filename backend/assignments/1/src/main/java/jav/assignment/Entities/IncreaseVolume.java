
package jav.assignment.Entities;
import com.fasterxml.jackson.databind.JsonNode;
import jav.assignment.Coins.Coin;
import jav.assignment.globalObjects.GlobalData;

public class IncreaseVolume {
    private final long volume;
    private Coin coin;
    private String status;
    private String transactionStatus;

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public IncreaseVolume(JsonNode obj) {
        this.volume = obj.get("volume").asLong();
        this.coin = GlobalData.coinSymbolAndCoinObject.get(obj.get("coin").asText());
    }

    public long getVolume() {
        return volume;
    }



    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }





    @Override
    public String toString() {
        return "AddVolume{" +
                "volume=" + volume +
                ", coin=" + coin +
                ", status='" + status + '\'' +
                '}';
    }
}