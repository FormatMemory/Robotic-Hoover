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
	private int maxX; //biggest value for x coordinator, >0 
	private int maxY; //biggest value for y coordinator, >0
	public ArrayList<Point> dirtyPatchList;
	
	FloorPlan(String filePath) throws Exception{
		ArrayList<String> content = readInputFile(filePath);
		initialMaxXY(content);
		initialDirtyPatchList(content, dirtyPatchList);
	}
/
	private void initialMaxXY(ArrayList<String> content) {
		// TODO Auto-generated method stub
		String firstLine = content.get(0);
		char[] aryFirstLine = firstLine.toCharArray();
		int count = 0;
		for(int i = 0; i < aryFirstLine.length;i++){
			if()
		}
	}
	private void initialDirtyPatchList(ArrayList<String> content, ArrayList<Point> dirtyPatchList) {
		// TODO Auto-generated method stub
		
	}
	
	protected Point getPointFromLine(String s){
		String[] ary = s.split(" ");
		int[] ret = new int[2];
		int count = 0;
		for(int i =0; i< ary.length;i++){
			String s1 = ary[i];
			try{
				 ret[count] = Integer.parseInt(s1);
				 count++;
				 if(count>2) throw new Exception("FloorPlan.getNumberFromLine: Numbers are too many to define a two-number-defined position");
				 if(i==ary.length&&count<2) throw new Exception("FloorPlan.getNumberFromLine: Not enough numbers to define a two-number-defined position");
			}
			catch(NumberFormatException e){
				System.out.println("FloorPlan.getNumberFromLine: position");
			}
			catch(NullPointerException e){
				
			}
			catch(Exception e){
				System.out.println("FloorPlan.getNumberFromLine: Error "+e.getMessage());
				e.printStackTrace();
			}
		}
		Point poi = new Point(ret[0], ret[1]);
		return poi;
	}
	/***
	 * To read contents from a input file and return an ArrayList<String> saves all
	 * information in input file, the format is {firstline, secondline,thirdline...}
	 * @param filePath: a txt file's file path, including file name
	 * @return ArrayList which saves contents in input txt file
	 * @throws Exception: file not found, file cannot be opened, etc.
	 */
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
			if(content == null){
				throw new Exception("FloorPlan.readInputFile: file is empty");
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("FloorPlan.readInputFile: Unable to open file '" + filePath + "'"); 
		}
		catch(IOException ex){
			System.out.println("FloorPlan.readInputFile: Error reading file '" + filePath + "'");                  
			ex.printStackTrace();
		}
		catch(Exception ex){
			System.out.println("FloorPlan.readInputFile: Error "+ex.getMessage());
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
