import javax.swing.*;
import java.awt.*;






public class View extends JFrame
{
	private JPanel jp = new JPanel();
	private JLabel jl = new JLabel();

	
	public View() 
	{
		setTitle("Thermonitor");
		setVisible(true);
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		jl.setIcon(new ImageIcon("D:\\Projects\\AE_Projekt\\knob.png"));
		jp.add(jl);
		
		add(jp);
		
		validate();
	}
	
	
	
	public static void main (String[] args)
	{
		View v = new View();
	}
	
}
