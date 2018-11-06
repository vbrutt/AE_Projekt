import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Controller {

	private Map<String, Heizung> heizungen = new HashMap<>();
	private View view;

	public Controller(String source) throws NumberFormatException, IOException {
		onStart(source);
		this.view = new View(this, source);
	}

	public void showView() {
		view.setVisible(true);
		view.setSize(650, 320);
	}

	public Map<String, Heizung> getHeizungen() {
		return heizungen;
	}

	public void setHeizungen(Map<String, Heizung> heizungen) {
		this.heizungen = heizungen;
	}

	// Wird von der View aufgerufen
	public void setTemp(String id, double temp) {
		heizungen.get(id).setTemp(temp);
	}

	public void onStart(String source) throws NumberFormatException, IOException {
		setHeizungen(Model.importData(source));
	}

	public void onEnd(String source) throws IOException {
		Model.export(getHeizungen(), source);
	}
}