package deinemutterheizen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class model {

	public Map<String, Heizung> importData() throws NumberFormatException, IOException {

		Map<String, Heizung> heizungen = new HashMap<>();
		CSVFormat format = CSVFormat.EXCEL.withHeader().withDelimiter(';');
		FileReader reader = new FileReader("H:\\AE\\JavaProjekt\\Data.csv");
		CSVParser parser = new CSVParser(reader, format);
		for (CSVRecord record : parser.getRecords()) {
			String id = record.get("Id");
			Float temp = Float.parseFloat(record.get("temp"));
			Heizung heizung = new Heizung(id, temp);
			heizungen.put(id, heizung);
		}
		reader.close();
		parser.close();
		return heizungen;

	}

	public void export() {
		
		// csv soll mit neuen Daten überschrieben werden!!!
	}
		
	}
