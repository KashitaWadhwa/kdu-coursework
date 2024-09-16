package jav.assignment.traders;

import jav.assignment.Coins.Coin;
import java.util.HashMap;
import java.util.Map;

public class Trader {
    private int srNo;
    private String firstName;
    private String lastName;
    private String phone;
    private String walletAddress;
    public HashMap<String, Coin> tradersCoin = new HashMap<>();
    private Double spending = 0.0;
    private Double releasedRevenue;
    private Double profit;

    public Double getProfit() {
        double revenue = 0.0;
        for(Map.Entry<String, Coin> coinSymbol : tradersCoin.entrySet()) {
            revenue += coinSymbol.getValue().getPrice() * coinSymbol.getValue().getCirculatingSupply();
        }
        return revenue - spending;
    }


    public Double getReleasedRevenue() {
        return releasedRevenue;
    }

    public void setReleasedRevenue(Double releasedRevenue) {
        this.releasedRevenue = releasedRevenue;
    }

    public Double getSpending() {
        return spending;
    }

    public void setSpending(Double spending) {
        this.spending = spending;
    }



    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "srNo=" + srNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", walletAddress='" + walletAddress + '\'' +
                ", tradersCoin=" + tradersCoin.get(this.getFirstName()) +
                ", spending=" + this.getSpending() +
                ", releasedRevenue=" + this.getReleasedRevenue() +
                ", profit=" + this.getProfit() +
                '}';
    }
}