package advswen.team5.travelbutler.api.travelbriefing;

/*
 * Andreas Tauscher
 */

public class TravelbriefingExchangeRate {
	private String name;
	private double rate;
	
	public TravelbriefingExchangeRate(String name, double rate) {
		super();
		this.name = name;
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	

}
