package advswen.team5.travelbutler.api.response;

/*
 * Andreas Tauscher
 */

public interface IAPIResponse {

	// Used to indicate that the response does not contain the expected result,
	// e.g. because the API coudn't find a result for the search term
	boolean missing = false;

	void setMissing(boolean missing);

	boolean isMissing();

}
