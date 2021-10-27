package demo;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.jose4j.json.internal.json_simple.JSONArray;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.parser.JSONParser;

public class Calculator {
	static Scanner myObj = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter starting point:");
		String start = myObj.nextLine(); // QEW
		System.out.println("Enter exit point:");
		String exit = myObj.nextLine();// Highway 400
		Calculator c = new Calculator();
		List<String> distCost = Arrays.asList(c.costofTrip(start, exit).split("-"));
		System.out.println("distance: " + distCost.get(0));
		System.out.println("cost: " + distCost.get(1));

	}

	@SuppressWarnings("unchecked")
	public String costofTrip(String start, String exit) {
		JSONParser parser = new JSONParser();
		Double distance = 0.0;
		Double cost = 0.0;
		int startId = 0;
		int exitId = 0;
		Map<Integer, JSONArray> Location = new HashMap<>();
		DecimalFormat df = new DecimalFormat("#.######");

		try {
			Object obj = parser.parse(new FileReader("./src/demo/interchanges.json"));
			JSONObject jsonObject = (JSONObject) obj;
			ResponseData responseData = new ResponseData();
			responseData.setLocations((JSONObject) jsonObject.get("locations"));
			LocationID locationID = new LocationID();
			Iterator<Entry<String, Map<String, LocationID>>> itr = responseData.getLocations().entrySet().iterator();

			while (itr.hasNext()) {
				Entry<String, Map<String, LocationID>> entry = itr.next();
				JSONObject locationId = (JSONObject) entry.getValue();
				String name = (String) locationId.get("name");
				JSONArray routes = (JSONArray) locationId.get("routes");
				locationID.setId(entry.getKey());
				locationID.setName(name);
				if (locationID.getName().equalsIgnoreCase(start)) {
					startId = Integer.parseInt(locationID.getId());
				}
				if (locationID.getName().equalsIgnoreCase(exit)) {
					exitId = Integer.parseInt(locationID.getId());
				}
				Location.put(Integer.parseInt(locationID.getId()), routes);
			}

			if (startId == 0 || exitId == 0) {
				System.out.println("Data not available with in the given points :" + start + "  and  " + exit);
			} else if (startId < exitId) {
				for (int i = startId; i < exitId; i++) {
					JSONArray val = Location.get(i);
					if (val != null) {
						for (int j = 0; j < val.size(); j++) {
							JSONObject startExit = (JSONObject) val.get(j);
							if ((Long) startExit.get("toId") >= i
									&& !startExit.get("distance").toString().contentEquals("0")) {
								distance += (Double) startExit.get("distance");
							}
						}

					}
				}
			} else {
				for (int i = startId; i > exitId; i--) {
					JSONArray val = Location.get(i);
					if (val != null) {
						for (int j = 0; j < val.size(); j++) {
							JSONObject exitStart = (JSONObject) val.get(j);
							if ((Long) exitStart.get("toId") <= i
									&& !exitStart.get("distance").toString().contentEquals("0")) {
								distance += (Double) exitStart.get("distance");
							}
						}

					}

				}

			}
			cost = distance * 0.25;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return df.format(distance) + "-" + df.format(cost);
	}
}
