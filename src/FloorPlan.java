import java.util.ArrayList;

/**
 * 
 */

/**
 * save floor plan information
 *
 */
public class FloorPlan {
	private int maxX;
	private int maxY;
	public ArrayList<Point> dirtyPatchList;
	
	FloorPlan(){
		
	}
	
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
}
