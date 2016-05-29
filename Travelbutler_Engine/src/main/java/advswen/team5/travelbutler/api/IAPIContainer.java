package advswen.team5.travelbutler.api;

import advswen.team5.travelbutler.api.response.IAPIResponse;

public interface IAPIContainer {


	IAPIResponse processSearch(String requestedString);
}
