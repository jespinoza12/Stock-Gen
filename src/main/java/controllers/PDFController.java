package controllers;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;

public class PDFController {
    public static void generatePDFStatements() {
        File dir = new File("src/main/java/html");
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                String htmlPath = file.getAbsolutePath();
                Path filepath = Path.of(htmlPath);

                try (OutputStream os = new FileOutputStream(String.format("src/main/java/pdf/%s.pdf", filepath.getFileName().toString().replaceFirst("(\\.[\\w\\- ]*)$", "")))) {
                    PdfRendererBuilder builder = new PdfRendererBuilder();
                    builder.useFastMode();
                    builder.withUri(filepath.toUri().toString());
                    builder.toStream(os);
                    builder.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
