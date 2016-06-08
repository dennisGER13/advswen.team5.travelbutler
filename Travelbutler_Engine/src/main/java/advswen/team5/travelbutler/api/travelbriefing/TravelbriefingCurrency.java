package advswen.team5.travelbutler.api.travelbriefing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Andreas Tauscher
 */

public class TravelbriefingCurrency {
	private String name;
	private String symbol;
	private TravelbriefingExchangeRate[] compare;
	private Map<String, TravelbriefingExchangeRate> exchangeRates;
	private boolean prepared = false;

	public TravelbriefingCurrency(String name, String symbol, TravelbriefingExchangeRate[] compare) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.compare = compare;

		pepareData();
	}

	public String getName() {
		if (!prepared)
			pepareData();
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.prepared = false;
	}

	public String getSymbol() {
		if (!prepared)
			pepareData();
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
		this.prepared = false;
	}

	protected TravelbriefingExchangeRate[] getCompare() {
		if (!prepared)
			pepareData();
		return compare;
	}

	protected void setCompare(TravelbriefingExchangeRate[] compare) {
		this.compare = compare;
		this.prepared = false;
	}

	public Map<String, TravelbriefingExchangeRate> getExchangeRates() {
		if (!prepared)
			pepareData();
		return exchangeRates;
	}

	public void setExchangeRates(Map<String, TravelbriefingExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
		this.prepared = false;
	}

	private void pepareData() {
		exchangeRates = new HashMap<String, TravelbriefingExchangeRate>();
		for (TravelbriefingExchangeRate rate : compare) {
			exchangeRates.put(rate.getName(), rate);
		}
	}

	public double getExchangeRate(String currency) {
		if (!prepared)
			pepareData();

		if (!exchangeRates.containsKey(name) || !exchangeRates.containsKey(currency))
			return -1;
		
		return exchangeRates.get(currency).getRate() / exchangeRates.get(name).getRate();
	}

}
