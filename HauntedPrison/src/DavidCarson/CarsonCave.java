package DavidCarson;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class CarsonCave extends CaveRoom{
	
	public CarsonCave(String description) {
		super(description);
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w','a','s', or'd' to move or" + " you can type 'e' to interact ");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			CaveExplorer.print("You have found a guard room.");
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}//
	
	public String getContents() {
		return "G";
	}
	
	public String getDescription() {
		return super.getDescription();
	}
}