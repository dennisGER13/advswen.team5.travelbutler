package advswen.team5.travelbutler.api.travelbriefing;

/*
 * Andreas Tauscher
 */

public class TravelbriefingLanguage {
	private String language;
	private String official;
	
	public TravelbriefingLanguage(String language, String official) {
		super();
		this.language = language;
		this.official = official;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOfficial() {
		return official;
	}
	public void setOfficial(String official) {
		this.official = official;
	}
	
	
}
