package demoPkg;

import java.util.ArrayList;
/*
 * This class defines Box entity
 * with specific hight, width, breadth
 * curVolume specifies volume left in the box
 */
public class Box {
	int hight;
	int width;
	int breadth;
	int curVolume;
	ArrayList<Item>itemList;
	
	public Box(){
		this.hight=15;
		this.width=30;
		this.breadth=15;
		this.curVolume=hight*width*breadth;
		itemList= new ArrayList<Item>();
	}
	// adds new item it into current box
	public void addNewItem(Item it){
		curVolume-=it.getVolume();
		itemList.add(it);
	}
	// gives total number of item in box
	public int getItemInBox(){
		return itemList.size();
	}
	
}
