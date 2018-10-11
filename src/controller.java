
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.*;
import org.apache.commons.lang3.*;

public class controller {

	private Map<String, Heizung> heizungen = new HashMap<>();

	private void setTemp(String id, int temp) {
		// heizungen.get(id).setTemp(temp);
	}

	public Map<String, Heizung> getHeizungen() {
		// heizungen = Model.import();
		return heizungen;
	}

	public void setHeizungen(Map<String, Heizung> heizungen) {
		this.heizungen = heizungen;
	}

	public void onStart() {
		// heizungen = Model.importData();
		CSVFormat format = CSVFormat.EXCEL.withHeader().withDelimiter(';');
        try (FileReader reader = new FileReader(source)) {
            CSVParser parser = new CSVParser(reader, format);
            for (CSVRecord record : parser.getRecords()) {
            	record.get("id");
            	Float.par
            }
	}
	
	
}
