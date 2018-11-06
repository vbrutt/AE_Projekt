import java.io.IOException;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String source = "C:\\Users\\verab\\Documents\\Schule\\AE\\Thermostat\\Data2.csv";
		Controller c = new Controller(source);
		c.showView();
	}
}