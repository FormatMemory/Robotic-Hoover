/**
 * Entry file of the whole project
 * Runing a hoover robot in a certain floor-plan follows path direction from the input file
 * Finally returns the final position of the robot and the number of dirty patches it has cleaned
 * Cleaning mode is always on which means the hoover robot will clean all the dirty patches on its routine.
 * Default input file is input.txt in the same folder with the jar file
 * 
 * @author Yusheng Ding
 * @since May.10 2016
 * @Problem Description {@link https://gist.github.com/AustinBGibbons/2200f6a5a924a8bd1f3f69714846a080}
 * @Project source code github {@linkhttps://github.com/FormatMemory/Robotic-Hoover}}
 * @More info can be found in README.md
 */
public class Entry {
	
	public static void main(String[] args) throws Exception{
		final String INPUT_FILEPATH = "input.txt";
		//read input file and initial floorPlan, patch of dirt (check valid)
		ContentReader cReader = new ContentReader(INPUT_FILEPATH);
		FloorPlan fp = new FloorPlan(cReader.getContent());
		
		//run hoover (check valid location), save location and patch of dirty cleaned
		Hoover hBot = new Hoover(cReader.getContent());
		//System.out.println("Hoover's Enrty Position: "+hBot.getStartPoint().getX()+" "+hBot.getStartPoint().getY());
		hBot.runClean(fp);
		//output 
		System.out.println();
		System.out.println("Hoover's Final Position: "+hBot.getEndPoint().getX()+" "+hBot.getEndPoint().getY());
		System.out.println("Hoover cleaned number of patch: "+hBot.getDirtyPatchCleaned());
		System.out.println("Press Enter key to Continue...");
		System.in.read();
	}

}
