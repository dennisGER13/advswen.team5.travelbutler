package advswen.team5.travelbutler.api.response;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

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

	public Image getBannerImage() {
		for (GoogleSearchItem item : items) {
			if (item.getImage().getWidth() >= 1000 && item.getImage().getWidth() <= 8000
					&& (item.getImage().getWidth() / item.getImage().getHeight()) >= 1
					&& (item.getImage().getWidth() / item.getImage().getHeight()) <= 4){
				
				try {
					return Image.getInstance(item.getLink());
				} catch (Exception e) {
					// Image can't be loaded, try the next one
					break;
				}
			}
		}

		return null;
	}

	public Image getSquareImage() {
		for (GoogleSearchItem item : items) {
			if (item.getImage().getWidth() >= 100 && item.getImage().getWidth() <= 2000
					&& (item.getImage().getWidth() / item.getImage().getHeight()) >= 0.7
					&& (item.getImage().getWidth() / item.getImage().getHeight()) <= 1.8){
				
				try {
					return Image.getInstance(item.getLink());
				} catch (Exception e) {
					// Image can't be loaded, try the next one
					break;
				}
			}
		}

		return null;
	}
}
