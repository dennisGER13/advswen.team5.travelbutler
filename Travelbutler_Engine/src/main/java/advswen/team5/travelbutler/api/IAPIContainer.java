package advswen.team5.travelbutler.api;

/*
 * Andreas Tauscher
 */

import advswen.team5.travelbutler.api.response.IAPIResponse;

public interface IAPIContainer {


	IAPIResponse processSearch(String requestString);
}
