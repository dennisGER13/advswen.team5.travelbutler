package advswen.team5.travelbutler.api.response;

import advswen.team5.travelbutler.api.google.images.GoogleSearchItem;

/*
 * Andreas Tauscher
 */

public class GoogleImagesResponse implements IAPIResponse {
	private boolean missing = false;
	private GoogleSearchItem[] items;
	
	public GoogleImagesResponse(GoogleSearchItem[] items) {
		super();
		this.items = items;
	}

	public boolean isMissing() {
		return missing;
	}

	public void setMissing(boolean missing) {
		this.missing = missing;
	}

	public GoogleSearchItem[] getItems() {
		return items;
	}

	public void setItems(GoogleSearchItem[] items) {
		this.items = items;
	}

	

}
