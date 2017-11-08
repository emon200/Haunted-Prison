package DavidCarson;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class CarsonCave extends CaveRoom{
	
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
			CaveExplorer.print("You have found a guard room.");
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	private void interact() {
		CaveExplorer.print("In this room you find a handgun and a zombie slowly aproaching you." + "\n" + "Press e to pick up the gun");
		String s = CaveExplorer.in.nextLine();
		chatting = true;
		while(chatting) {
			if(!s.equals("e")) {
				CaveExplorer.print("You picked up the gun and shot the zombie");
			}else {
				CaveExplorer.print("You fumbled the gun and the zombie killed you");
				CaveExplorer.inventory.setHp(0);
			}
		}		
	}
	
	public String getContents() {
		return "G";
	}
	
	public String getDescription() {
		return super.getDescription();
	}
	
}