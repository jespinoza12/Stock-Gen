package models;

import controllers.JSONController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTradeTest {

    StockTrade stockTrade;

    @BeforeEach
    void SetupStockTrade() {
        JSONController.loadJSON("src/test/java/raw_data/test.json");
        stockTrade = (StockTrade) ((Stockholder) JSONController.getStockholdersFromJSON().toArray()[0]).getStockTrades().toArray()[0];
    }

    @Test
    void testGetType() {
        String expected = "Buy";
        String actual = stockTrade.getType();
        assertEquals(expected, actual);
    }

    @Test
    void testSetType() {
        String expected = "Sell";
        stockTrade.setType(expected);
        String actual = stockTrade.getType();
        assertEquals(expected, actual);
    }

    @Test
    void testGetStockSymbol() {
        String expected = "AAPL";
        String actual = stockTrade.getStockSymbol();
        assertEquals(expected, actual);
    }

    @Test
    void testSetStockSymbol() {
        String expected = "TSLA";
        stockTrade.setStockSymbol(expected);
        String actual = stockTrade.getStockSymbol();
        assertEquals(expected, actual);
    }

    @Test
    void testGetShareCount() {
        long expected = 6L;
        long actual = stockTrade.getShareCount();
        assertEquals(expected, actual);
    }

    @Test
    void testSetShareCount() {
        long expected = 8L;
        stockTrade.setShareCount(expected);
        long actual = stockTrade.getShareCount();
        assertEquals(expected, actual);
    }

    @Test
    void testGetPricePerShare() {
        double expected = 2.0d;
        double actual = stockTrade.getPricePerShare();
        assertEquals(expected, actual);
    }

    @Test
    void testSetPricePerShare() {
        double expected = 5.0d;
        stockTrade.setPricePerShare(expected);
        double actual = stockTrade.getPricePerShare();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmount() {
        double expected = 12.0d;
        double actual = stockTrade.getTotalAmount();
        assertEquals(expected, actual);
    }
}