package demoPkg;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/redmart")
public class DemoClass {

	SlotAllotment sa;

	public DemoClass() {
		// TODO Auto-generated constructor stub
		sa = new SlotAllotment();
	}

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Welcome to RedMart!!!";
	}

	//posts orderList in json format
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getSlot")
	public String getSlot(String inputString) {
		JSONArray inputArr = null;
		try {
			inputArr = new JSONArray(inputString);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Item> iList = new ArrayList<Item>();
		if (inputArr != null) {
			for (int i = 0; i < inputArr.length(); i++) {
				try {
					iList.add(new Item(Integer.parseInt(inputArr
							.getJSONObject(i).get("ID").toString()), Integer
							.parseInt(inputArr.getJSONObject(i).get("hight")
									.toString()), Integer.parseInt(inputArr
							.getJSONObject(i).get("width").toString()), Integer
							.parseInt(inputArr.getJSONObject(i).get("breadth")
									.toString())));
				} catch (NumberFormatException | JSONException e) {
					
					e.printStackTrace();
				}
			}
		}

		ArrayList<Integer> rslt = new ArrayList<Integer>();
		rslt = sa.availableSlotsForOrder(iList);
		JSONArray resJArr = new JSONArray();
		JSONObject[] localjs = new JSONObject[rslt.size()];
		for (int i = 0; i < rslt.size(); i++) {
			try {
				localjs[i] = new JSONObject();
				if (rslt.get(i) / 4 == 0)
					localjs[i].put("Today", i);
				else if (rslt.get(i) / 4 == 1)
					localjs[i].put("Tomorrow", i);
				else
					localjs[i].put("Slot", 0);

				localjs[i].put("Time", sa.hm.get((rslt.get(i) % 4)));
				resJArr.put(localjs[i]);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String res=null;
		try {
			res = resJArr.toString(1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	}

	/*
	 * Posts order list string into sever
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/getSlotString")
	public String provideSlotInfoString(String inputString) {
		JSONArray inputArr = null;
		try {
			inputArr = new JSONArray(inputString);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (inputArr != null) {
			ArrayList<Item> iList = new ArrayList<Item>();
			for (int i = 0; i < inputArr.length(); i++) {
				try {
					iList.add(new Item(Integer.parseInt(inputArr
							.getJSONObject(i).get("ID").toString()), Integer
							.parseInt(inputArr.getJSONObject(i).get("hight")
									.toString()), Integer.parseInt(inputArr
							.getJSONObject(i).get("width").toString()), Integer
							.parseInt(inputArr.getJSONObject(i).get("breadth")
									.toString())));
				} catch (NumberFormatException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			ArrayList<Integer> rslt = new ArrayList<Integer>();
			rslt = sa.availableSlotsForOrder(iList);
			JSONArray resJArr = new JSONArray();
			JSONObject[] localjs = new JSONObject[rslt.size()];
			for (int i = 0; i < rslt.size(); i++) {
				try {
					localjs[i] = new JSONObject();
					if (rslt.get(i) / 4 == 0)
						localjs[i].put("Today", i);
					else if (rslt.get(i) / 4 == 1)
						localjs[i].put("Tomorrow", i);
					else
						localjs[i].put("Slot", 0);

					localjs[i].put("Time", sa.hm.get((rslt.get(i) % 4)));
					resJArr.put(localjs[i]);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			localjs = null;
			String res = null;
			try {
				res = resJArr.toString(1);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;
		} else {
			return "Something went wrong";
		}
	}


}
