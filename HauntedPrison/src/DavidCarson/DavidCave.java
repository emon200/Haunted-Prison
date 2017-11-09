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
		this.activeDescription = "On the corner you see the med-bay where prisoners would be brought for treatment after their usual scuffles...";
		this.inactiveDescription = "This is where the med-bay is located...";
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
		//super.performAction(direction);
		if(direction == 4) {
			if(visited == false) {
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
			CaveExplorer.print("Inside the room, you notice a spare med-kit lying on the ground... It would be a waste not to use it...  ");
			String s = CaveExplorer.in.nextLine();
			chatting = true;
			check = 0;
			while(chatting) {
				if(!s.equalsIgnoreCase("e")) {
				CaveExplorer.print("You tried to do something but fumbled");
				s = CaveExplorer.in.nextLine();
				check++;
				}
				if(check >3) {
				  CaveExplorer.print("You took too long to do something! Zombies have come and chased you out!");
				  visited = true;
				  chatting = false;
				  
				}
				else {
					if(s.equalsIgnoreCase("e")) {
					CaveExplorer.print("You bandaged your wounds with the med kit and feel much better...");
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
			return super.getDescription() + "\n"+getActiveDescription();
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
