
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame 
				  implements ChangeListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel _jPnl = new JPanel();
	private JLabel _jLbl = new JLabel();
	private JSlider _jSldr = new JSlider();
	static int anzahlheizungen;
	static Controller _ctrlr;

	public View() {
		setTitle("Thermonitor");
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		_jLbl.setIcon(new ImageIcon("C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\knob.png"));
		_jSldr.addChangeListener(this);
		_jPnl.add(_jLbl);
		_jPnl.add(_jSldr);

		add(_jPnl);

		validate();
	}
	    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            double temp = (int)source.getValue();
            //hab noch keine HeizungsID, daher der platzhalter "heizungID"
            _ctrlr.setTemp("heizungID",temp);
        }    
    }
	    
	public static void main(String[] args) throws NumberFormatException, IOException {	
		String source = "";
		_ctrlr = new Controller(source);
		anzahlheizungen = _ctrlr.getHeizungen().size();
		new View();
	}
}




