import java.io.*;
import java.util.*;

public class Model {

    public static Map<String, Heizung> importData() throws IOException {
        File file = new File("C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\Data.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(fileReader);
        Map<String, Heizung> heizungen = new HashMap<>();

        String line = buffer.readLine();

        while ((line = buffer.readLine()) != null) {
            Heizung h = new Heizung(line);
            heizungen.put(h.getId(), h);
        }
        buffer.close();
        
        return heizungen;

    }

    public static void main(String[] args) throws IOException {
        importData();
    }
}
