import controllers.HTMLController;
import controllers.JSONController;
import controllers.PDFController;
import models.Stockholder;

import java.util.List;

public class StockStatementGenerator {

    public static void main(String[] args) {
        String jsonDirectory = "src/main/java/raw_data/stockholder-trades.json";

        JSONController.loadJSON(jsonDirectory);
        List<Stockholder> stockholders = JSONController.getStockholdersFromJSON();
        HTMLController.generateHTML(stockholders);
        PDFController.generatePDFStatements();
    }
}
