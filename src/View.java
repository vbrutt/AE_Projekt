<<<<<<< HEAD
=======

import java.awt.Component;
>>>>>>> 6ea1ecb83787ee48a65888331c3b52138dae4c42
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
<<<<<<< HEAD

public class View extends JFrame implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel _jPnl = new JPanel();
	private JLabel _jLbl = new JLabel();
	private JSlider _jSldr = new JSlider();
	static int anzahlheizungen;
	static Controller _ctrlr;
	static String sourcePath = "C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\Data.csv";
=======

public class View extends JFrame 
				  implements ChangeListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel _jPanel = new JPanel();
	private Map<JSlider,String> sliderMap = new HashMap<>()	;
	static int anzahlheizungen;
	static Controller _ctrlr;
    static String sourcePath = "D:\\Downloads\\Data2.csv";
	
>>>>>>> 6ea1ecb83787ee48a65888331c3b52138dae4c42

	public View() {
		setTitle("Thermonitor");
		setVisible(true);
		setSize(800, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(Map.Entry<String, Heizung> entry : _ctrlr.getHeizungen().entrySet() ) {
			
			//Create a text label for the slider
			JLabel _jSliderLabel = new JLabel(entry.getKey(),JLabel.CENTER);
			_jSliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			//Create a Slider for the Temperature
			JSlider _jSlider = new JSlider(JSlider.VERTICAL,0,30,20);
			_jSlider.addChangeListener(this);
			_jSlider.setMajorTickSpacing(5);
			_jSlider.setMinorTickSpacing(1);
			_jSlider.setPaintTicks(true);
			_jSlider.setPaintLabels(true);
			_jSlider.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 20));
			

<<<<<<< HEAD
		// _jLbl.setIcon(new
		// ImageIcon("C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\knob.png"));
		_jSldr.addChangeListener(this);
		_jPnl.add(_jLbl);
		_jPnl.add(_jSldr);

		add(_jPnl);
=======
			sliderMap.put(_jSlider, entry.getKey());
		
		_jPanel.add(_jSliderLabel);
		_jPanel.add(_jSlider);
>>>>>>> 6ea1ecb83787ee48a65888331c3b52138dae4c42

		add(_jPanel);
		}
		validate();
	}
<<<<<<< HEAD

	public void stateChanged(ChangeEvent e) {
		JSlider sourceSlider = (JSlider) e.getSource();
		if (!sourceSlider.getValueIsAdjusting()) {
			double temp = (int) sourceSlider.getValue();
			// hab noch keine HeizungsID, daher der platzhalter "Bedroom"
			_ctrlr.setTemp("Bedroom", temp);

			try {
=======
		public void stateChanged(ChangeEvent e) {
        JSlider sourceSlider = (JSlider)e.getSource();
        if (!sourceSlider.getValueIsAdjusting()) {
            
        	//Aus der sliderMap bekommen wir den Namen des Sliders 
        	String roomID = sliderMap.get(sourceSlider);
            
            _ctrlr.setTemp(roomID,(int)sourceSlider.getValue());
            
            try {
>>>>>>> 6ea1ecb83787ee48a65888331c3b52138dae4c42
				Export();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
<<<<<<< HEAD
		}
	}

	private void Export() throws IOException {
		_ctrlr.onEnd(sourcePath);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// String sourcePath = "D:\\Downloads\\Data2.csv";
=======
        }    
    }
		    
	    private void Export() throws IOException {
	    	_ctrlr.onEnd(sourcePath);
	    }
	    
	public static void main(String[] args) throws NumberFormatException, IOException {	
		//String sourcePath = "D:\\Downloads\\Data2.csv";
>>>>>>> 6ea1ecb83787ee48a65888331c3b52138dae4c42
		_ctrlr = new Controller(sourcePath);
		anzahlheizungen = _ctrlr.getHeizungen().size();
		new View();
	}
}




