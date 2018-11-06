import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.*;

public class Model {

	public static Map<String, Heizung> importData(String source) throws NumberFormatException, IOException {
		Map<String, Heizung> heizungen = new HashMap<>();
		CSVFormat format = CSVFormat.EXCEL.withHeader().withDelimiter(';');
		FileReader reader = new FileReader(source);
		CSVParser parser = new CSVParser(reader, format);
		for (CSVRecord record : parser.getRecords()) {
			String id = record.get("id");
			double temp = Double.parseDouble(record.get("temperature"));
			Heizung heizung = new Heizung(id, temp);
			heizungen.put(id, heizung);
		}
		reader.close();
		parser.close();
		return heizungen;
	}

	public static void export(Map<String, Heizung> heizungen, String source) throws IOException {
		CSVFormat format = CSVFormat.EXCEL.withHeader("id", "temperature").withDelimiter(';');
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(source));
		CSVPrinter printer = new CSVPrinter(writer, format);

		for (Map.Entry<String, Heizung> entry : heizungen.entrySet()) {
			printer.printRecord(entry.getKey(), entry.getValue().getTemp());
		}

		printer.close();
		writer.close();
	}
}