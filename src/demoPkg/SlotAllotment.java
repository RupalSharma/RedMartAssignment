package demoPkg;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/*
 * The main class for handling slotallotment
 * members: Hashmap that contains slot timing and delivery Van available(MAX 4)
 */
public class SlotAllotment {

	HashMap<Integer, String> hm;
	DeliveryVan[] vans;

	public SlotAllotment() {
		hm = new HashMap<Integer, String>();
		hm.put(0, "9AM-11AM");
		hm.put(1, "11AM-1PM");
		hm.put(2, "2PM-4PM");
		hm.put(3, "4PM-6PM");

		hm.put(10, "No Slots available today and Tomorrow");
		vans = new DeliveryVan[4];
		for (int i = 0; i < 4; i++) {
			vans[i] = new DeliveryVan();
		}
	}

	/**
	 * returns available delivery Slots in an integer Array for input Item List
	 * for an order Assuming: All delivery Van are available for all slots
	 * 
	 */
	@SuppressWarnings("deprecation")
	public ArrayList<Integer> availableSlotsForOrder(ArrayList<Item> orderList) {
		int i = 0;
		Date dt = new Date();
		ArrayList<Integer> rslt = new ArrayList<Integer>();
		if (dt.getHours() < 9) {
			i = 0;
		} else if (dt.getHours() < 11) {
			i = 1;
		} else if (dt.getHours() < 14) {
			i = 2;
		} else if (dt.getHours() < 16) {
			i = 3;
		} else {
			i = 4;
		}
		// calculate total volume required for order
		int totalVolume = 0;
		for (int j = 0; j < orderList.size(); j++) {

			totalVolume += orderList.get(j).getVolume();
		}
		// calculate num of boxes required
		int numOfBoxReq = totalVolume / (15 * 15 * 30);
		if (numOfBoxReq == 0) {
			numOfBoxReq = 1;
		}
			for (; i < 8; i++) {
				for (int k = 0; k < 4; k++) {
					DeliveryVan curVan = vans[k];
					if (curVan.numOFBoxes() + numOfBoxReq < 20) {
						rslt.add(i);
						break;
					}
				}

			}

		
		if (rslt.isEmpty())
			rslt.add(10);

		return rslt;
	}

}
