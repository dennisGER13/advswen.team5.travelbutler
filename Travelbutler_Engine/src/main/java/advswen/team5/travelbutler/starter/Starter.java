package advswen.team5.travelbutler.starter;

import advswen.team5.travelbutler.api.APIContainerOWM;
import advswen.team5.travelbutler.dialogue.InputDialogue;

public class Starter {
	
	public static void main(String[] args){
		
//		InputDialogue in = new InputDialogue();
//		in.run();

		APIContainerOWM owm = new APIContainerOWM();
		owm.processSearch("Paris");
	}
}