package models;

public class StockTrade {
    private String type;
    private String stockSymbol;
    private long shareCount;
    private double pricePerShare;

    private double totalAmount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public long getShareCount() {
        return shareCount;
    }

    public void setShareCount(long shareCount) {
        this.shareCount = shareCount;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public double getTotalAmount() {
        generateTotalAmount();
        return this.totalAmount;
    }

    private void generateTotalAmount() {
        this.totalAmount = shareCount * pricePerShare;
    }
}
