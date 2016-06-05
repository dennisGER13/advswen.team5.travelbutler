package advswen.team5.travelbutler.api.travelbriefing;

public class TravelbriefingCurrency {
	private String name;
	private String symbol;
	private TravelbriefingExchangeRate[] compare;

	public TravelbriefingCurrency(String name, String symbol, TravelbriefingExchangeRate[] compare) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.compare = compare;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public TravelbriefingExchangeRate[] getCompare() {
		return compare;
	}
	public void setCompare(TravelbriefingExchangeRate[] compare) {
		this.compare = compare;
	}
	
	


}
