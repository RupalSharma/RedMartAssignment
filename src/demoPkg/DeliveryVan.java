package demoPkg;

import java.util.ArrayList;
/*
 * Class defination for deliveryVan
 * which has list of boxes
 * MAX number of boxes allowed in 20
 */
public class DeliveryVan {
	final int MAX_BOXES_PER_VAN=20;
	ArrayList<Box> boxes;
	
	public DeliveryVan(){
		boxes= new ArrayList<Box>();
	}
	//adds new box to this van
	public void addNewBox(Box box){
		if(boxes.size()< MAX_BOXES_PER_VAN)
			boxes.add(box);
		
	}
	 //returns total number of boxes in the Van
	public int numOFBoxes(){
		return boxes.size();
	}
	

}
