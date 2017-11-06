package DavidCarson;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class CarsonCave extends CaveRoom{
	
	private boolean power;

	public CarsonCave(String description) {
		super(description);
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w','a','s', or'd' to move or" + " you can type 'e' to interact ");
	}
	
	public String validKeys() {
		return "wdsae";
	}
	
	public String getContents() {
		return super.getContents();
	}
	
	public String getDescription() {
		return super.getDescription();
	}
}
