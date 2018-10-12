public class Heizung {
    private String id;
    private double temp;

    public Heizung(String id, double temp) {
        this.id = id;
        this.temp = temp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
