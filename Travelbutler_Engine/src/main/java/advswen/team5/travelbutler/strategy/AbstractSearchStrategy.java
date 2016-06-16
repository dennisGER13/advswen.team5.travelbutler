package advswen.team5.travelbutler.strategy;

import java.util.ArrayList;
import java.util.List;

import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.search.Listener;

public abstract class AbstractSearchStrategy {
	
	private int progress = 0;
	protected List<Listener> listeners = new ArrayList<Listener>();
	
	public abstract Response executeSearch(String requestString);
		
	public void registerListener(Listener listener) {
		if(!listeners.contains(listener))
			listeners.add(listener);
	}
	
	public void removeListener(Listener listener) {
		if(listeners.contains(listener))
			listeners.remove(listeners.indexOf(listener));
	}

	public void notifyListeners() {
		for(Listener listener : listeners){
			listener.update();
		}
	}

	public int getProgress() {
		return progress;
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
		notifyListeners();
	}

}
