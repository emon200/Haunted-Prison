package DavidCarson;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DavidCave extends CaveRoom {


	boolean visited;
	private String activeDescription;
	private String inactiveDescription;
	private int check;
	private boolean chatting;
	public DavidCave(String description) {
		super(description);
		this.activeDescription = "You see something in the distance";
		this.inactiveDescription = "This was where you found the med kit";
		this.visited = false;
	}
	public String validKeys() {
		return "wdsae";
				
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w','a','s', or'd' to move or"
				+ "you can type 'e' to interact ");
	}
	
	public void performAction(int direction) {
		super.performAction(direction);
		if(direction == 4) {
			if(!visited) {
				interact();
			}
			else {
				CaveExplorer.print("There is nothing to interact with right now");
			}
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	private void interact() {
			CaveExplorer.print("At the corner of the room you see a small med kit. You should try applying it!");
			String s = CaveExplorer.in.nextLine();
			chatting = true;
			check = 0;
			while(chatting) {
				if(!s.equalsIgnoreCase("e")) {
				CaveExplorer.print("You tried to do something but fumbled");
				s = CaveExplorer.in.nextLine();
				check++;
				}
				if(check >4) {
				  CaveExplorer.print("You took too long to do something! Zombies have come and chased you out!");
				  visited = true;
				  chatting = false;
				  
				}
				else {
					if(s.equalsIgnoreCase("e")) {
					CaveExplorer.print("You applied the med kit onto yourself and suddenly feel revitalized!");
				    CaveExplorer.inventory.setHp(100);
				    visited = true;
				    chatting = false;
					}
				}
			}

		    
	}
	public String getContents() {
		if(!visited) {
			return "F";
		}else {
			//return what would've been returned otherwise
			return super.getContents();
		}
	}

	public String getDescription() {
		if(visited == false) {
			return super.getDescription() + "\n"+getInactiveDescription();
		}else {
			String npcDesc = "";
				npcDesc = getActiveDescription();
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
