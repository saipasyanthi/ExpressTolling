package demo;

import java.util.Map;

public class ResponseData {
	  private Map<String, Map<String, LocationID>> locations;

	public Map<String, Map<String, LocationID>> getLocations() {
		return locations;
	}

	public void setLocations(Map<String, Map<String, LocationID>> locations) {
		this.locations = locations;
	}    

	  
}
