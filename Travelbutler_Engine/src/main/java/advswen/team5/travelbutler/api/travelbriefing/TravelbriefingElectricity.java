package advswen.team5.travelbutler.api.travelbriefing;

public class TravelbriefingElectricity {
	private String voltage;
	private String frequency;
	private String[] plugs;
	
	public TravelbriefingElectricity(String voltage, String frequency, String[] plugs) {
		super();
		this.voltage = voltage;
		this.frequency = frequency;
		this.plugs = plugs;
	}
	public String getVoltage() {
		return voltage;
	}
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String[] getPlugs() {
		return plugs;
	}
	public void setPlugs(String[] plugs) {
		this.plugs = plugs;
	}
	
}
