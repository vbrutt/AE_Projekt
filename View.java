import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
	
	private ImageIcon image1;
	private JLabel label1;
	private JPanel panel_1 = new JPanel();
	private JButton button_1 = new JButton();
	
	public static void main (String[] args){
		View gui =	new View();
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		
	}
	
	public View() {
		super("Thermonitor");
		setSize(800,600);
		setResizable(true);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		image1 = new ImageIcon(getClass().getResource("knob.png"));
		label1.setIcon(image1);
		
		add(label1);
	}
}
