import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	FloorPlan(String filePath) throws Exception{
		ArrayList<String> content = readInputFile(filePath);
		
	}
	
	private ArrayList<String> readInputFile(String filePath) throws Exception{
		//String filePath = "";
		ArrayList<String> content = null;
		String line;
		FileReader fileReader = null;
		try{
			fileReader = new FileReader(filePath);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			content = new ArrayList<String>();
			line = bufferReader.readLine();
			while( line != null){
				content.add(line);
				line = bufferReader.readLine();
			}
			bufferReader.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("FloorPlan.readInputFile: Unable to open file '" + filePath + "'"); 
		}
		catch(IOException ex){
			System.out.println("FloorPlan.readInputFile: Error reading file '" + filePath + "'");                  
			ex.printStackTrace();
		}
		catch(Exception ex){
			System.out.println("FloorPlan.readInputFile: Error ");
			ex.printStackTrace();
		}
		finally{
			if(fileReader!=null) fileReader.close();
		}
		return content;
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
