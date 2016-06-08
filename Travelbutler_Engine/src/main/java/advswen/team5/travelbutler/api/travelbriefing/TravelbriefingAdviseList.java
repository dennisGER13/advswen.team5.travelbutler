package advswen.team5.travelbutler.api.travelbriefing;

/*
 * Andreas Tauscher
 */

import java.util.ArrayList;
import java.util.List;

public class TravelbriefingAdviseList {
	private TravelbriefingAdvise UA;
	private TravelbriefingAdvise US;
	private TravelbriefingAdvise CA;
	private boolean prepared = false;

	public TravelbriefingAdviseList(TravelbriefingAdvise uA, TravelbriefingAdvise uS, TravelbriefingAdvise cA) {
		super();
		UA = uA;
		US = uS;
		CA = cA;

		pepareData();
	}

	public TravelbriefingAdvise getUA() {
		if (!prepared)
			pepareData();
		return UA;
	}

	public void setUA(TravelbriefingAdvise uA) {
		UA = uA;
		this.prepared = false;
	}

	public TravelbriefingAdvise getUS() {
		if (!prepared)
			pepareData();
		return US;
	}

	public void setUS(TravelbriefingAdvise uS) {
		US = uS;
		this.prepared = false;
	}

	public TravelbriefingAdvise getCA() {
		if (!prepared)
			pepareData();
		return CA;
	}

	public void setCA(TravelbriefingAdvise cA) {
		CA = cA;
		this.prepared = false;
	}

	private void pepareData() {
		if (UA != null)
			UA.setSource("Australian Department of Foreign Affairs and Trade");
		if (US != null)
			US.setSource("U.S. Department of State");
		if (CA != null) {
			CA.setSource("Global Affairs Canada");

			// Workaround to remove HTML comments
			CA.setAdvise(CA.getAdvise().replaceAll("<.*?>", ""));
		}

		prepared = true;
	}

	public List<TravelbriefingAdvise> getAll() {
		List<TravelbriefingAdvise> advises = new ArrayList<TravelbriefingAdvise>();
		if (!prepared)
			pepareData();

		if (UA != null && !UA.getAdvise().toLowerCase().contains("exercise normal safety precautions")) {
			advises.add(UA);
		}
		if (US != null) {
			advises.add(US);
		}
		if (CA != null && !CA.getAdvise().toLowerCase().contains("exercise normal security precautions")) {
			advises.add(CA);
		}

		return advises;
	}

}
