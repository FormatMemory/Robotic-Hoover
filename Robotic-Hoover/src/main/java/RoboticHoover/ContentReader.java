package RoboticHoover;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is in charge of reading the input file
 * save into ArrayList<String> content after checking the input format
 * content first line: FloorPlan boundary
 * content second line: hoover start point
 * content 4th~~last-1 line: dirty patches positions
 * content last line: moving directions
 */
public class ContentReader {
	private ArrayList<String> content;
	
	
	/***
	 * class constructor
	 * To read contents from a input file and return an ArrayList<String> saves all
	 * information in input file, the format is {firstline, secondline,thirdline...}
	 * @param filePath: a txt file's file path, including file name
	 * @return ArrayList which saves contents in input txt file
	 * @throws Exception: file not found, file cannot be opened, etc.
	 */
	public ContentReader(String filePath) throws Exception{
		//String filePath = "";
		ArrayList<String> content = null;
		String line;
		FileReader fileReader = null;
		try{
			if(filePath == null)
				throw new Exception("file path is empty");
			fileReader = new FileReader(filePath);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			content = new ArrayList<String>();
			line = bufferReader.readLine();
			if(line == null)
				throw new Exception("file is empty");
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
			System.out.println("FloorPlan.readInputFile: Error "+ex.getMessage());
			ex.printStackTrace();
		}
		finally{
			if(fileReader!=null) fileReader.close();
		}
		this.setContent(content);
	}
	/**
	 * get method of this.content arrayList
	 * @return content
	 */
	public ArrayList<String> getContent() {
		return content;
	}
	/**
	 * set method of this.content arrayList
	 * @param content
	 */
	public void setContent(ArrayList<String> content) {
		this.content = content;
	}
	
}
