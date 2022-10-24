package controllers;

import models.Stockholder;
import models.StockTrade;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JSONController {

    private static JSONArray jsonData;

    @SuppressWarnings("Unchecked")
    public static void loadJSON(String path) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(path)) {
            jsonData = (JSONArray) parser.parse(reader);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Stockholder> getStockholdersFromJSON() {
        List<Stockholder> stockholders = new ArrayList<>();
        for (Object o : jsonData) {
            Stockholder stockholder = parseStockholderJSON((JSONObject) o);
            stockholders.add(stockholder);
        }
        return stockholders;
    }

    private static Stockholder parseStockholderJSON(JSONObject stockholderJSON) {
        Stockholder stockholder = new Stockholder();
        stockholder.setAccountNumber((long) stockholderJSON.get("account_number"));
        stockholder.setSsn((String) stockholderJSON.get("ssn"));
        stockholder.setFirstName((String) stockholderJSON.get("first_name"));
        stockholder.setLastName((String) stockholderJSON.get("last_name"));
        stockholder.setEmail((String) stockholderJSON.get("email"));
        stockholder.setPhoneNumber((String) stockholderJSON.get("phone"));
        stockholder.setBeginningBalance(Double.parseDouble(((String)stockholderJSON.get("beginning_balance")).replaceAll("^\\$", "")));
        stockholder.setStockTrades(parseStockTradesJSON((JSONArray) stockholderJSON.get("stock_trades")));
        return stockholder;
    }

    private static List<StockTrade> parseStockTradesJSON(JSONArray stockTradesJSON) {
        List<StockTrade> stockTrades = new ArrayList<>();
        for (Object o : stockTradesJSON) {
            JSONObject stockTradeJSON = (JSONObject) o;
            StockTrade stockTrade = new StockTrade();
            stockTrade.setType((String) stockTradeJSON.get("type"));
            stockTrade.setStockSymbol((String) stockTradeJSON.get("stock_symbol"));
            stockTrade.setShareCount((long) stockTradeJSON.get("count_shares"));
            stockTrade.setPricePerShare(Double.parseDouble(((String)stockTradeJSON.get("price_per_share")).replaceAll("^\\$", "")));
            stockTrades.add(stockTrade);
        }
        return stockTrades;
    }
}
