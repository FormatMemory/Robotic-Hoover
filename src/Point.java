/***
 * 
 * Point is a 2 dimensional point on the map
 * Indicating a position in a map
 *
 */
public class Point {
	private int x;
	private int y;
	
	Point(int x, int y){
		this.setX(x);
		this.setY(y);
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
	public boolean equal(Point a){
		if(this.x == a.getX() && this.y ==a.getY()) 
			return true;
		else
			return false;
	}
}
