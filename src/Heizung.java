package deinemutterheizen;

public class Heizung {

	
	private String id;
	private Float temp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getTemp() {
		return temp;
	}
	public void setTemp(Float temp) {
		this.temp = temp;
	}
	
	public Heizung (String id, Float temp) {
		this.id = id;
		this.temp = temp;
	}
	
}
