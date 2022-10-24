package controllers;

import models.StockTrade;
import models.Stockholder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HTMLController {

    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
    private static Date dateObject = new Date();

    private static NumberFormat dollarFormatter = NumberFormat.getCurrencyInstance();

    public static void generateHTML(List<Stockholder> stockholders) {
        for (Stockholder stockholder : stockholders) {
            StringBuilder sb = new StringBuilder();

            sb.append("<!DOCTYPE html>");
            sb.append("<html lang=\"en\">");
            sb.append("<body>");
            sb.append(String.format("<p>Generated on %s</p>", dateFormat.format(dateObject)));
            sb.append(String.format("<h2>%s %s (%s)</h2>", stockholder.getFirstName(), stockholder.getLastName(), stockholder.getAccountNumber()));
            sb.append(String.format("<p>Social Security Number: %s</p>", stockholder.getSsn()));
            sb.append(String.format("<p>Email Address: %s</p>", stockholder.getEmail()));
            sb.append(String.format("<p>Phone Number: %s</p>", stockholder.getPhoneNumber()));
            sb.append("<hr />");
            sb.append("<hr />");
            for (StockTrade stockTrade : stockholder.getStockTrades()) {
                sb.append(String.format("<p><b>Transaction Type: %s</b></p>", stockTrade.getType()));
                sb.append(String.format("<p><b>Stock Symbol Traded: %s</b></p>", stockTrade.getStockSymbol()));
                sb.append(String.format("<p>Number of Shares Traded: %s</p>", stockTrade.getShareCount()));
                sb.append(String.format("<p>Share Value: %s</p>", dollarFormatter.format(stockTrade.getPricePerShare())));
                sb.append(String.format("<p>Total Value of Trade: %s</p>", dollarFormatter.format(stockTrade.getTotalAmount())));
                sb.append("<hr />");
            }
            sb.append(String.format("<p>Current Balance: %s</p>", dollarFormatter.format(stockholder.getTotalCashAmount())));
            sb.append(String.format("<p>Total Value of Shares: %s</p>", dollarFormatter.format(stockholder.getTotalStockAmount())));
            sb.append("</body>");
            sb.append("</html>");
            String html = sb.toString();
            writeHTMLToFile(html, stockholder.getAccountNumber());
        }
    }

    private static void writeHTMLToFile(String html, long name) {
        try (OutputStream outputStream = new FileOutputStream(String.format("src/main/java/html/%s.html", name))) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(html);
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
