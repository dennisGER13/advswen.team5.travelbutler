package advswen.team5.travelbutler.api.response;

public class Response {
	private WikipediaResponse wikipediaResponse = null;
	
	public Response() {

	}

	public WikipediaResponse getWikipediaResponse() {
		if(wikipediaResponse.isMissing()){
			return null;
		}else{
			return wikipediaResponse;
		}
		
	}

	public void setWikipediaResponse(WikipediaResponse wikipediaResponse) {
		this.wikipediaResponse = wikipediaResponse;
	}
	
	

}
