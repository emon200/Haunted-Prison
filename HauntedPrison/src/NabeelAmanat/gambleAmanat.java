package NabeelAmanat;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Door;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class gambleAmanat extends CaveRoom {


	boolean visited;
	private String activeDescription;
	private String inactiveDescription;
	private boolean chatting;
	
	public gambleAmanat(String description) {
		super(description);
		this.activeDescription = "You feel a powerful aura, as if fate itself is calling you.";
		this.inactiveDescription = "This is where you took your chances.";
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
			interact();
	}
	
	private void interact() {
		int x = 0;
		int hp = CaveExplorer.inventory.getHp();
			CaveExplorer.print("Tarot cards start to form around you, do you dare take one and read your fortune?");
			String s = CaveExplorer.in.nextLine();
					if(s.equalsIgnoreCase("e")) {
					CaveExplorer.print("As fate has it you...");
					x = (int)((Math.random())*5);
					if(x < 1) {
						CaveExplorer.print("...have been gravely injured.");
						CaveExplorer.inventory.setHp(hp-50);
						visited = true;
						//chatting = false;
					}
					else if(x > 1 && x < 2) {
						CaveExplorer.print("...are completely rejuvenated.");
						CaveExplorer.inventory.setHp(100);
						visited = true;
					}
					else if(x > 2 && x < 3) {
						CaveExplorer.print("...are not to be fought with.");
						caveExplorer.Inventory.hasWeapon = true;
						visited = true;
					}
					else if(x > 3 && x < 4) {
						CaveExplorer.print("...are dead.");
						CaveExplorer.inventory.setHp(0);
						visited = true;
					}
					else if(x > 4 && x < 5) {
						CaveExplorer.print("...are unlucky.");
						visited = true;
					}
					}
				}
			

		    
	
	public String getContents() {
		if(!visited) {
			return "?";
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

