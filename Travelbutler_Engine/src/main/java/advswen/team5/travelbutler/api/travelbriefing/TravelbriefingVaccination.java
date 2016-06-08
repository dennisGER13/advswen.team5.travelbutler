package advswen.team5.travelbutler.api.travelbriefing;

/*
 * Andreas Tauscher
 */

public class TravelbriefingVaccination {
	private String name;
	private String message;
	
	public TravelbriefingVaccination(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
