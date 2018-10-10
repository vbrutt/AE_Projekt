
public class Heizung {

    private String id;
    private double temperature;

    public Heizung(String line) {
        String[] data = line.split(";");

        this.id = data[0];
        this.temperature = Double.parseDouble(data[1]);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
