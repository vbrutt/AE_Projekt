
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private Map<String, Heizung> heizungen = new HashMap<>();

    public Map<String, Heizung> getHeizungen() {
        return heizungen;
    }

    public void setHeizungen(Map<String, Heizung> heizungen) {
        this.heizungen = heizungen;
    }

    // Wird von der View aufgerufen
    private void setTemp(String id, double temp) {
        heizungen.get(id).setTemp(temp);
    }

    public void onStart() throws NumberFormatException, IOException {
        setHeizungen(Model.importData());

    }

    public void onEnd() throws IOException {
        Model.export(getHeizungen());
    }

}
