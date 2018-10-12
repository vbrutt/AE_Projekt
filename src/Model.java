
import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.*;

public class Model {

    public static Map<String, Heizung> importData() throws NumberFormatException, IOException {

        Map<String, Heizung> heizungen = new HashMap<>();
        CSVFormat format = CSVFormat.EXCEL.withHeader().withDelimiter(';');
        FileReader reader = new FileReader("C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\DataOriginal.csv");
        CSVParser parser = new CSVParser(reader, format);
        for (CSVRecord record : parser.getRecords()) {
            String id = record.get("Id");
            double temp = Double.parseDouble(record.get("temp"));
            Heizung heizung = new Heizung(id, temp);
            heizungen.put(id, heizung);
        }
        reader.close();
        parser.close();
        return heizungen;

    }

    public static void export(Map<String, Heizung> heizungen) throws IOException {
        heizungen.get("Livingroom").setTemp(123);
        CSVFormat format = CSVFormat.EXCEL.withHeader("Id", "temp").withDelimiter(';');
        BufferedWriter writer = Files
                .newBufferedWriter(Paths.get("C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\DataOriginal.csv"));
        CSVPrinter printer = new CSVPrinter(writer, format);

        for (Map.Entry<String, Heizung> entry : heizungen.entrySet()) {
            printer.printRecord(entry.getKey(), entry.getValue().getTemp());

        }

        printer.close();
        writer.close();
        // csv soll mit neuen Daten �berschrieben werden!!!
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Map<String, Heizung> heizungen = importData();
        export(heizungen);
    }

}
