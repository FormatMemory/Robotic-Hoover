import java.util.ArrayList;

/***
 * 
 * Hoover starts from a start point(from content) and moves 
 * follows directions (from content), clean dirty patches  
 *
 */
public class Hoover {
	int dirtyPatchCleaned;
	char[] movePath;
	Point startPoint;
	Point endPoint;
 	
	/**
	 * class constructor
	 * @param content: fileReader initialed ArrayList<String> from input file
	 * @throws Exception if initial start point fails or content is empty
	 */
	Hoover(ArrayList<String> content) throws Exception{
		try{
			if(content == null) throw new Exception("Hoover.Hoover: content cannot be empty");
			dirtyPatchCleaned = 0;
			startPoint = Point.getPointFromLine(content.get(1));
			movePath = content.get(content.size()-1).toCharArray();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
}
