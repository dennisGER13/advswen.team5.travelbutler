package advswen.team5.travelbutler.api.response;

/*
 * Andreas Tauscher
 */

import advswen.team5.travelbutler.api.travelbriefing.*;

public class TravelbriefingResponse implements IAPIResponse {
	private TravelbriefingAdviseList advise;
	private TravelbriefingCurrency currency;
	private TravelbriefingElectricity electricity;
	private TravelbriefingLanguage[] language;
	private TravelbriefingTimezone timezone;
	private TravelbriefingVaccination[] vaccinations;
	private TravelbriefingWater water;
	
	private boolean missing = false;

	public TravelbriefingResponse(TravelbriefingAdviseList advise, TravelbriefingCurrency currency,
			TravelbriefingElectricity electricity, TravelbriefingLanguage[] language, TravelbriefingTimezone timezone,
			TravelbriefingVaccination[] vaccinations, TravelbriefingWater water) {
		super();
		this.advise = advise;
		this.currency = currency;
		this.electricity = electricity;
		this.language = language;
		this.timezone = timezone;
		this.vaccinations = vaccinations;
		this.water = water;
	}

	public TravelbriefingAdviseList getAdvise() {
		return advise;
	}

	public void setAdvise(TravelbriefingAdviseList advise) {
		this.advise = advise;
	}

	public TravelbriefingCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(TravelbriefingCurrency currency) {
		this.currency = currency;
	}

	public TravelbriefingElectricity getElectricity() {
		return electricity;
	}

	public void setElectricity(TravelbriefingElectricity electricity) {
		this.electricity = electricity;
	}

	public TravelbriefingLanguage[] getLanguage() {
		return language;
	}

	public void setLanguage(TravelbriefingLanguage[] language) {
		this.language = language;
	}

	public TravelbriefingTimezone getTimezone() {
		return timezone;
	}

	public void setTimezone(TravelbriefingTimezone timezone) {
		this.timezone = timezone;
	}

	public TravelbriefingVaccination[] getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(TravelbriefingVaccination[] vaccinations) {
		this.vaccinations = vaccinations;
	}

	public TravelbriefingWater getWater() {
		return water;
	}

	public void setWater(TravelbriefingWater water) {
		this.water = water;
	}

	public boolean isMissing() {
		return missing;
	}

	public void setMissing(boolean missing) {
		this.missing = missing;
	}

	
	
}
