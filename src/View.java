import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel _jPnl = new JPanel();
	private JLabel _jLbl = new JLabel();
	private JSlider _jSldr = new JSlider();
	static int anzahlheizungen;
	static Controller _ctrlr;
	static String sourcePath = "C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\Data.csv";

	public View() {
		setTitle("Thermonitor");
		setVisible(true);
		setSize(800, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// _jLbl.setIcon(new
		// ImageIcon("C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\knob.png"));
		_jSldr.addChangeListener(this);
		_jPnl.add(_jLbl);
		_jPnl.add(_jSldr);

		add(_jPnl);

		validate();
	}

	public void stateChanged(ChangeEvent e) {
		JSlider sourceSlider = (JSlider) e.getSource();
		if (!sourceSlider.getValueIsAdjusting()) {
			double temp = (int) sourceSlider.getValue();
			// hab noch keine HeizungsID, daher der platzhalter "Bedroom"
			_ctrlr.setTemp("Bedroom", temp);

			try {
				Export();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void Export() throws IOException {
		_ctrlr.onEnd(sourcePath);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// String sourcePath = "D:\\Downloads\\Data2.csv";
		_ctrlr = new Controller(sourcePath);
		anzahlheizungen = _ctrlr.getHeizungen().size();
		new View();
	}
}