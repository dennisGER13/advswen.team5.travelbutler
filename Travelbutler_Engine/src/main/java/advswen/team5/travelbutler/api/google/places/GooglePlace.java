package advswen.team5.travelbutler.api.google.places;

public class GooglePlace {
	private String icon;
	private String name;
	private double rating;
	private String formatted_address;
	
	public GooglePlace(String icon, String name, double rating, String formatted_address) {
		super();
		this.icon = icon;
		this.name = name;
		this.rating = rating;
		this.formatted_address = formatted_address;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	
	
	
}
