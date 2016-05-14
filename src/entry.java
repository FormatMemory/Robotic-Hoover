/**
 * entry file
 * @author Yusheng Ding
 * @since May.10 2016
 * @Problem Description {@link https://gist.github.com/AustinBGibbons/2200f6a5a924a8bd1f3f69714846a080}
 *
 */
public class Entry {

	
	public static void main(String[] args) throws Exception {
		final String INPUT_FILEPATH = "input.txt";
		//read input file and initial floorPlan, patch of dirt (check valid)
		ContentReader cReader = new ContentReader(INPUT_FILEPATH);
		FloorPlan fp = new FloorPlan(cReader.getContent());
		
		//run hoover (check valid location), save location and patch of dirty cleaned
		Hoover hBot = new Hoover(cReader.getContent());
		//System.out.println("Hoover's Enrty Position: "+hBot.getStartPoint().getX()+" "+hBot.getStartPoint().getY());
		hBot.runClean(fp);
		//output 
		System.out.println("Hoover's Final Position: "+hBot.getEndPoint().getX()+" "+hBot.getEndPoint().getY());
		System.out.println("Hoover cleaned number of patch: "+hBot.getDirtyPatchCleaned());
	}

}
