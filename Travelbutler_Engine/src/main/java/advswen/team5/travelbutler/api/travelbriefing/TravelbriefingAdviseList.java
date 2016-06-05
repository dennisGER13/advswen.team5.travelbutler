package advswen.team5.travelbutler.api.travelbriefing;

public class TravelbriefingAdviseList {
	private TravelbriefingAdvise UA;
	private TravelbriefingAdvise US;
	private TravelbriefingAdvise CA;
	
	public TravelbriefingAdviseList(TravelbriefingAdvise uA, TravelbriefingAdvise uS, TravelbriefingAdvise cA) {
		super();
		UA = uA;
		US = uS;
		CA = cA;
	}

	public TravelbriefingAdvise getUA() {
		return UA;
	}

	public void setUA(TravelbriefingAdvise uA) {
		UA = uA;
	}

	public TravelbriefingAdvise getUS() {
		return US;
	}

	public void setUS(TravelbriefingAdvise uS) {
		US = uS;
	}

	public TravelbriefingAdvise getCA() {
		return CA;
	}

	public void setCA(TravelbriefingAdvise cA) {
		CA = cA;
	}
	
	
	
}
