package advswen.team5.travelbutler.api.travelbriefing;

import com.google.gson.annotations.SerializedName;

public class TravelbriefingWater {
	@SerializedName("short")
	private String shortDescription;

	public TravelbriefingWater(String shortDescription) {
		super();
		this.shortDescription = shortDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	
}
