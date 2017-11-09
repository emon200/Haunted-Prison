package DavidCarson;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class CarsonCave extends CaveRoom{
	
	private boolean visited;
	private boolean chatting;
	
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
			if(!visited) {
				interact();
			}else {
				CaveExplorer.print("This is the room where you killed the zombie");
			}
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	private void interact() {
		CaveExplorer.print("In this room you find a handgun and a zombie slowly aproaching you." + "\n" + "Press e to pick up the gun");
		String s = CaveExplorer.in.nextLine();
		visited = false;
		chatting = true;
		while(chatting) {
			if(s.equals("e")) {
				CaveExplorer.print("You picked up the gun and shot the zombie");
				visited = true;
			}else {
				CaveExplorer.print("You fumbled the gun and the zombie hurt you");
				CaveExplorer.inventory.setHp(CaveExplorer.inventory.getHp() - 20);
				CaveExplorer.print("\nTry shooting the zombie again.");
			}
			chatting = false;
		}
	}
	
	public String getContents() {
		return "Z";
	}
	
	public String getDescription() {
		return super.getDescription();
	}//
	
}