import junit.framework.*;
import FloorPlan.java;
public class TestFloorPlan extends TestCase {

	public void testReadFile(){
		String validFild = "test//validInput1.txt";
		fp = new FloorPlan(validFild);
	}
	
}
