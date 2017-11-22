package DavidCarson;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class minigameStart2 extends CaveRoom {

	private boolean visited;
	private String activeDescription;
	private String inactiveDescription;
	
	public minigameStart2(String description) {
		super(description);
		this.activeDescription = "This is the memory game";
		this.inactiveDescription = "You have already beat the memory game";
	}
	public void enter() {
		super.enter();
		if(!DavidFrontend.getHasWon()) {
			DavidFrontend.main(null);
		}else {
			CaveExplorer.print(inactiveDescription);
		}
		visited = true;
	}
	
	public String getContents() {
		if(!visited) {
			return "K";
		}else {
			return super.getContents();
		}
	}

	public String getDescription() {
		if(visited == false) {
			return super.getDescription() + "\n" + getActiveDescription();
		}else {
			String npcDesc = "";
			npcDesc = getInactiveDescription();
			return super.getDescription() + "\n" + npcDesc;
		}
	}
	
	public String getInactiveDescription() {
		return inactiveDescription;
	}
	
	public String getActiveDescription() {
		return activeDescription;
	}

}
