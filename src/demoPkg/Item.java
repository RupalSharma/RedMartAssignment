package demoPkg;

import javax.xml.bind.annotation.XmlRootElement;
/*
 * This class defines entity item
 * that has some hight width breadth and an ID for identification
 */
@XmlRootElement
public class Item {
	
	private int ID;
	private int hight;
	private int width;
	private int breadth;
	
	public Item(){
		
	}
	public Item( int id, int h,int w,int b){
		this.ID=id;
		this.hight=h;
		this.width=w;
		this.breadth=b;
	}
	public int getID(){
		return this.ID;
	}
	public int getHight(){
		return this.hight;
	}
	public int getWidth(){
		return this.width;
	}
	public int getbreadth(){
		return this.breadth;
	}
	public void setID(int a){
		this.ID=a;
	}
	public void setHight(int h){
		this.hight=h;
	}
	public void setWidth(int w){
		this.width=w;
	}
	public void setBreadth(int b){
		this.breadth=b;
	}
	
	public int getVolume(){
		return hight*width*breadth;
	}
	
	public String toString() {
		        return new StringBuffer(" ID : ").append(this.ID)
		                .append(" hight : ").append(this.hight)
		                .append(" width : ").append(this.width).
		                append(" breadth ").append(this.breadth).toString();
		    }

	
}
