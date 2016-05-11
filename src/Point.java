/***
 * 
 * Point is a 2 dimensional point on the map
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
}
