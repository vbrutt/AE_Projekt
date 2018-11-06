
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Controller {

	private Map<String, Heizung> heizungen = new HashMap<>();

	public Controller(String source) throws NumberFormatException, IOException {
		onStart(source);
	}

	public Map<String, Heizung> getHeizungen() {
		return heizungen;
	}

	public void setHeizungen(Map<String, Heizung> heizungen) {
		this.heizungen = heizungen;
	}

	// Wird von der View aufgerufen
<<<<<<< HEAD
	void setTemp(String id, double temp) {
=======
	public void setTemp(String id, double temp) {
>>>>>>> 6ea1ecb83787ee48a65888331c3b52138dae4c42
		heizungen.get(id).setTemp(temp);
	}

	public void onStart(String source) throws NumberFormatException, IOException {
		setHeizungen(Model.importData(source));
	}

	public void onEnd(String source) throws IOException {
		Model.export(getHeizungen(), source);
	}

	public static void main(String[] args) {
		View view = new View();
	}
}