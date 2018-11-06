import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame implements ChangeListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel dataPanel = new JPanel();
	private Map<JSlider, String> sliderMap = new HashMap<>();
	private Controller ctrlr;
	private JButton doneButton = new JButton("Done!");
	private JPanel buttonPanel = new JPanel();

	private String sourcePath;

	public View(Controller ctrlr, String sourcePath) {
		super("Thermonitor");
		this.ctrlr = ctrlr;
		this.sourcePath = sourcePath;

		for (Map.Entry<String, Heizung> entry : ctrlr.getHeizungen().entrySet()) {

			// Create a text label for the slider
			JLabel jSliderLabel = new JLabel(entry.getKey(), JLabel.CENTER);
			jSliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

			int currentTemp = (int) entry.getValue().getTemp();
			// Create a Slider for the Temperature
			JSlider jSlider = new JSlider(JSlider.VERTICAL, 0, 30, currentTemp);
			setSlider(jSlider);

			sliderMap.put(jSlider, entry.getKey());

			dataPanel.add(jSliderLabel);
			dataPanel.add(jSlider);

			add(dataPanel);

		}
		setButton();

		add(buttonPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setButton() {
		doneButton.setActionCommand(doneButton.getName());
		doneButton.addActionListener(this);
		buttonPanel.add(doneButton);
	}

	private void setSlider(JSlider jSlider) {
		jSlider.addChangeListener(this);
		jSlider.setMajorTickSpacing(5);
		jSlider.setMinorTickSpacing(1);
		jSlider.setPaintTicks(true);
		jSlider.setPaintLabels(true);
		jSlider.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 20));
	}

	public void stateChanged(ChangeEvent e) {
		JSlider sourceSlider = (JSlider) e.getSource();
		if (!sourceSlider.getValueIsAdjusting()) {

			// Aus der sliderMap bekommen wir den Namen des Sliders
			String roomID = sliderMap.get(sourceSlider);

			ctrlr.setTemp(roomID, (double) sourceSlider.getValue());

			try {
				ctrlr.onEnd(sourcePath);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Done!")) {
			System.exit(0);
		}
	}
}
