package DavidCarson;

import caveExplorer.CaveRoom;

public class DavidCave extends CaveRoom {

	public DavidCave(String description) {
		super(description);
	}
	
	public String validKeys() {
		return "wdsae";
				
	}
	
	

}
