package RoboticHoover;
/***
 * Point is a 2 dimensional point on the map
 * Indicating a position in a map
 */
public class Point {
	private int x;
	private int y;
	
	Point(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	/***
	 * Compare Point object, if x and y value are equal, return true otherwise return false
	 * @param a, a Point object
	 * @return
	 */
	public boolean equal(Point a){
		if(this.x == a.getX() && this.y ==a.getY()) 
			return true;
		else
			return false;
	}
	
	/***
	 * To initial(create) a point object from a string
	 * @param s: a string, format should be %d %d
	 * @return a Point
	 * @exception if input number and the dimension do not fit 
	 */
	public static Point getPointFromLine(String s) throws Exception{
		String[] ary = s.split(" ");
		int[] ret = new int[2];
		int count = 0;
		for(int i =0; i< ary.length;i++){
			String s1 = ary[i];
			try{
				 ret[count] = Integer.parseInt(s1);
				 count++;
				 if(count>2) throw new Exception("Point.getNumberFromLine: Numbers are too many to define a two-number-defined position");
				 if(i==ary.length&&count<2) throw new Exception("FloorPlan.getNumberFromLine: Not enough numbers to define a two-number-defined position");
			}
			catch(NumberFormatException e){
				System.out.println("Point.getNumberFromLine: Point should be define in numbers");
				//e.printStackTrace();
			}
			catch(NullPointerException e){
				System.out.println("Point.getNumberFromLine: Error "+e.getMessage());
				//e.printStackTrace();
			}
			catch(Exception e){
				System.out.println("Point.getNumberFromLine: Error "+e.getMessage());
				//e.printStackTrace();
			}
		}
		Point poi = new Point(ret[0], ret[1]);
		return poi;
	}

	public int getX(){
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
