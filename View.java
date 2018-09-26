import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class View extends JFrame{
	
	JPanel panel_1 = new JPanel();
	JButton button_1 = new JButton();
	
	public static void main (String[] args) {
		new View();
	}
	
	public View() {
		super("Thermonitor");
		setSize(800,600);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
