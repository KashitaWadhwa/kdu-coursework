package jav.assignment.Coins;

public class Coin {
    private int srNo;
    private int rank;
    private String name;
    private String symbol;
    private Double price;
    private long circulatingSupply;
    private String status = "available";


    public Coin(){

    }
    public Coin(int rank, String name, String symbol, Double price,long circulatingSupply) {
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.circulatingSupply  =circulatingSupply;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "srNo=" + srNo +
                ", rank=" + rank +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", circulatingSupply=" + circulatingSupply +
                ", status='" + status + '\'' +
                '}';
    }

}