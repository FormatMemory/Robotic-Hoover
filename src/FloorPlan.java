import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * To save floor plan information, 
 * including the boundary of the rectangle map, list of location of dirty patches
 */
public class FloorPlan {
	private int maxX; //biggest value for x coordinator, >0 
	private int maxY; //biggest value for y coordinator, >0
	public ArrayList<Point> dirtyPatchList;//save all dirty patches' positions
	
	/**
	 * FloorPlan constructor
	 * Initial the FloorPlan, the List of dirty patches
	 * @param filePath
	 * @throws Exception
	 */
	FloorPlan(ArrayList<String> content) throws Exception{
		initialMaxXY(content);
		initialDirtyPatchList(content, dirtyPatchList);
	}
	
	
	/***
	 * Use first String in $content$ to set MaxX and MaxY 
	 * @param content, ArrayList<String> 
	 * @throws Exception when content is null, MaxX!=MaxY (not rectangle)
	 ***/
	private void initialMaxXY(ArrayList<String> content) throws Exception {
		if(content==null) throw new Exception("FloorPlan.initialMaxXY: Content is null");
		Point poi = Point.getPointFromLine(content.get(0));
		if(poi.getX() == poi.getY()){
			this.setMaxX(poi.getX());
			this.setMaxY(poi.getY());
		}
		else{
			throw new Exception("FloorPlan.initialMaxXY: FloorPlan should be rectangle (Max X == Max Y)");
		}
		return;
	}
	
	/***
	 * Initial dirtyPathchList, read values from $content$
	 * @param content
	 * @param dirtyPatchList
	 * @throws Exception when point is not valid, out of boundry.
	 */
	private void initialDirtyPatchList(ArrayList<String> content,ArrayList<Point> dirtyPatchList) throws Exception {
		//if(content.size()<=3) return;//no dirty patches
		int index = 2;
		while(index<content.size()){
			Point point = Point.getPointFromLine(content.get(index));
			checkValidPoint(point);
			dirtyPatchList.add(point);
			index++;
		}
		return;
	}
	
	/***
	 * Check point location is not out of boundary,
	 * @param point
	 * @return
	 * @throws Exception when point location is not out of boundary
	 * @return true if valid.
	 */
	private boolean checkValidPoint(Point point) throws Exception{
		if(point.getX() <= this.maxX && point.getY()<=this.maxY)
			return true;
		else{
			throw new Exception("FloorPlan.checkValidPoint: point location out of boundary.");
		}
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
