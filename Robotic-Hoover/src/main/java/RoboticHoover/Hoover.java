package RoboticHoover;
import java.util.ArrayList;

/***
 * 
 * Hoover starts from a start point(from content) and moves 
 * follows directions (from content), clean dirty patches  
 *
 */
public class Hoover {
	private int dirtyPatchCleaned;
	private char[] movePath;
	private Point startPoint;
	private Point endPoint;
 	
	/**
	 * class constructor
	 * @param content: fileReader initialed ArrayList<String> from input file
	 * @throws Exception if initial start point fails or moving path is empty
	 */
	Hoover(ArrayList<String> content) throws Exception{
		try{
			if(content == null) throw new Exception("Hoover.Hoover: content cannot be empty");
			setDirtyPatchCleaned(0);
			this.startPoint = Point.getPointFromLine(content.get(1));
			this.setEndPoint(this.startPoint);
			movePath = content.get(content.size()-1).toCharArray();
			if(movePath == null) throw new Exception("Hoover.Hoover: move path cannot be empty");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/**
	 * hoover runs from the start point to the end point follows the directions of movePath[] 
	 * @param fp, a FloorPlan object who needs to be clean (run our hoover robot) 
	 * @throws Exception when move path direction not in N(n), S(s), E(e), W(w);
	 */
	public void runClean(FloorPlan fp) throws Exception{
		try{
			for(char c: movePath){
				//clean dirty patches and check point valid(after moving)
				if(fp.checkValidPoint(endPoint)){
					if(!fp.dirtyPatchList.isEmpty()){
						for(Point p: fp.dirtyPatchList){
							//find a dirty patch, clean 
							if(p.equal(endPoint)){
								this.dirtyPatchCleaned++;
								fp.dirtyPatchList.remove(p);
								break;
							}
						}
					}
					
				}
				//move to next place follows  movapath[]
				switch (c){
					case 'N': case 'n':
						endPoint.setY(endPoint.getY()+1); 
						break;
					case 'S': case 's':
						endPoint.setY(endPoint.getY()-1); 
						break;
					case 'W': case 'w':
						endPoint.setX(endPoint.getX()-1); 
						break;
					case 'E': case 'e':
						endPoint.setX(endPoint.getX()+1); 
						break;	
					default:
						throw new Exception("Hoover.runClean: move path direction should be N,S,W,E or n,s,w,e");
				}
				//System.out.println("Hoover's current Position: "+endPoint.getX()+" "+endPoint.getY());

			}
			fp.checkValidPoint(endPoint);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			//ex.printStackTrace();
		}
	}
	
	/**
	 * @return the endPoint
	 */
	public Point getEndPoint() {
		return endPoint;
	}

	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	/**
	 * @return the startPoint
	 */
	public Point getStartPoint() {
		return startPoint;
	}

	/**
	 * @param endPoint the startPoint to set
	 */
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	/**
	 * @return the dirtyPatchCleaned
	 */
	public int getDirtyPatchCleaned() {
		return dirtyPatchCleaned;
	}

	/**
	 * @param dirtyPatchCleaned the dirtyPatchCleaned to set
	 */
	public void setDirtyPatchCleaned(int dirtyPatchCleaned) {
		this.dirtyPatchCleaned = dirtyPatchCleaned;
	}
	
}
