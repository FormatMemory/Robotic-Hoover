package sandbox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readInputTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "..\/input.txt";
		ArrayList<String> content;
		String line;
		FileReader fileReader = null;
		try{
			fileReader = new FileReader(filePath);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			content = new ArrayList<String>();
			line = bufferReader.readLine();
			
			System.out.println("Firlst line: ");
			while( line != null){
				line = bufferReader.readLine();
				content.add(line);
				System.out.println(line);
			}
			System.out.println("end");
			bufferReader.close();
			System.out.println(content);
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to open file '" + filePath + "'");           
		}
		catch(IOException ex){
			 System.out.println("Error reading file '" + filePath + "'");                  
		      ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if(fileReader!=null) fileReader.close();
		}
	}

}
