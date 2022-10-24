package models;

import controllers.JSONController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockholderTest {

    Stockholder stockholder;

    @BeforeEach
    void SetupStockholder() {
        JSONController.loadJSON("src/test/java/raw_data/test.json");
        stockholder = (Stockholder) JSONController.getStockholdersFromJSON().toArray()[0];
    }

    @Test
    void testGetAccountNumber() {
        long expected = 1L;
        long actual = stockholder.getAccountNumber();
        assertEquals(expected, actual);
    }

    @Test
    void testSetAccountNumber() {
        long expected = 2L;
        stockholder.setAccountNumber(expected);
        long actual = stockholder.getAccountNumber();
        assertEquals(expected, actual);
    }

    @Test
    void testGetSsn() {
        String expected = "123-45-6789";
        String actual = stockholder.getSsn();
        assertEquals(expected, actual);
    }

    @Test
    void testSetSsn() {
        String expected = "987-65-4321";
        stockholder.setSsn(expected);
        String actual = stockholder.getSsn();
        assertEquals(expected, actual);
    }

    @Test
    void testGetFirstName() {
        String expected = "Jeffrey";
        String actual = stockholder.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    void testSetFirstName() {
        String expected = "Gregor";
        stockholder.setFirstName(expected);
        String actual = stockholder.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    void testGetLastName() {
        String expected = "Jay";
        String actual = stockholder.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    void testSetLastName() {
        String expected = "Espinoza";
        stockholder.setLastName(expected);
        String actual = stockholder.getLastName();
        assertEquals(expected, actual);
    }

    @Test
    void testGetEmail() {
        String expected = "je688433@gmail.com";
        String actual = stockholder.getEmail();
        assertEquals(expected, actual);
    }

    @Test
    void testSetEmail() {
        String expected = "bruh@neumont.edu";
        stockholder.setEmail(expected);
        String actual = stockholder.getEmail();
        assertEquals(expected, actual);
    }

    @Test
    void testGetPhoneNumber() {
        String expected = "801-123-4567";
        String actual = stockholder.getPhoneNumber();
        assertEquals(expected, actual);
    }

    @Test
    void testSetPhoneNumber() {
        String expected = "801-765-4321";
        stockholder.setPhoneNumber(expected);
        String actual = stockholder.getPhoneNumber();
        assertEquals(expected, actual);
    }

    @Test
    void testGetBeginningBalance() {
        double expected = 100.0d;
        double actual = stockholder.getBeginningBalance();
        assertEquals(expected, actual);
    }

    @Test
    void testSetBeginningBalance() {
        double expected = 50.0d;
        stockholder.setBeginningBalance(expected);
        double actual = stockholder.getBeginningBalance();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalCashAmount() {
        double expected = 97.0d;
        double actual = stockholder.getTotalCashAmount();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalStockAmount() {
        double expected = 3.0d;
        double actual = stockholder.getTotalStockAmount();
        assertEquals(expected, actual);
    }
}