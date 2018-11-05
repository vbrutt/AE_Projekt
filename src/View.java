
import java.awt.Component;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame 
				  implements ChangeListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel _jPanel = new JPanel();
	private Map<JSlider,String> sliderMap = new HashMap<>()	;
	static int anzahlheizungen;
	static Controller _ctrlr;
    static String sourcePath = "D:\\Downloads\\Data2.csv";
	

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
			

			sliderMap.put(_jSlider, entry.getKey());
		
		_jPanel.add(_jSliderLabel);
		_jPanel.add(_jSlider);

		add(_jPanel);
		}
		validate();
	}
		public void stateChanged(ChangeEvent e) {
        JSlider sourceSlider = (JSlider)e.getSource();
        if (!sourceSlider.getValueIsAdjusting()) {
            
        	//Aus der sliderMap bekommen wir den Namen des Sliders 
        	String roomID = sliderMap.get(sourceSlider);
            
            _ctrlr.setTemp(roomID,(int)sourceSlider.getValue());
            
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
		//String sourcePath = "D:\\Downloads\\Data2.csv";
		_ctrlr = new Controller(sourcePath);
		anzahlheizungen = _ctrlr.getHeizungen().size();
		new View();
	}
}




