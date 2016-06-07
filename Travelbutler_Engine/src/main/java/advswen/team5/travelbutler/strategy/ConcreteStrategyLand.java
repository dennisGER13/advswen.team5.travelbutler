package advswen.team5.travelbutler.strategy;

import advswen.team5.travelbutler.api.APIContainerWikipedia;
import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.response.WikipediaResponse;

public class ConcreteStrategyLand implements ISearchStrategy {

	@Override
	public Response executeSearch(String requestString) {
		Response response = new Response(requestString);
		WikipediaResponse wiki = new APIContainerWikipedia().processSearch(response.getDestination());
		response.setWikipediaResponse(wiki);
		System.out.println("Suche wurde durchgeführt");
		return response;
	}

}
