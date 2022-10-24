package models;

import java.util.List;

public class Stockholder {
    private long accountNumber;
    private String ssn;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private double beginningBalance;
    private List<StockTrade> stockTrades;

    private double totalCashAmount;
    private double totalStockAmount;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(double beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public List<StockTrade> getStockTrades() {
        return stockTrades;
    }

    public void setStockTrades(List<StockTrade> stockTrades) {
        this.stockTrades = stockTrades;
    }

    public void addStockTrade(StockTrade stockTrade) {
        this.stockTrades.add(stockTrade);
    }

    public void removeStockTrade(StockTrade stockTrade) {
        this.stockTrades.remove(stockTrade);
    }

    public double getTotalCashAmount() {
        calculateTotalAmounts();
        return totalCashAmount;
    }

    public double getTotalStockAmount() {
        calculateTotalAmounts();
        return totalStockAmount;
    }

    private void calculateTotalAmounts() {
        this.totalCashAmount = this.beginningBalance;
        this.totalStockAmount = 0;

        for (StockTrade stockTrade : this.stockTrades) {
            if (stockTrade.getType().equals("Buy")) {
                this.totalCashAmount -= stockTrade.getTotalAmount();
                this.totalStockAmount += stockTrade.getTotalAmount();
            } else if (stockTrade.getType().equals("Sell")) {
                this.totalCashAmount += stockTrade.getTotalAmount();
                this.totalStockAmount -= stockTrade.getTotalAmount();
            }
        }
    }
}
