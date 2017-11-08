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
		int hp = caveExplorer.Inventory.hp;
			CaveExplorer.print("Tarot cards start to form around you, do you dare take one and read your fortune?");
			String s = CaveExplorer.in.nextLine();
			chatting = true;
			while(chatting) {
					if(s.equalsIgnoreCase("e")) {
					CaveExplorer.print("As fate has it you...");
					x = (int)((Math.random())*5);
					if(x < 1) {
						CaveExplorer.print("...have been gravely injured.");
						CaveExplorer.inventory.setHp(hp-50);
						visited = true;
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
	
	public static void setUpCaves() {
		//ALL OF THIS CODE CAN BE CHANGED
		//1. Decide how big your caves should be
		CaveExplorer.caves = new NPCRoom[5][5];
		//2. Populate with caves and a default description: hint: when starting, use coordinates (helps debugging)
		for(int row = 0; row < CaveExplorer.caves.length; row++) {
			//PLEASE PAY ATTENTION TO THE DIFFERENCE:
			for(int col = 0; col < CaveExplorer.caves[row].length; col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col] = 
						new NPCRoom("This cave has coords ("+row+","+col+")");
			}
		}
		//3. Replace default rooms with custom rooms
		//--- WE WILL DO LATER
		CaveExplorer.npcs = new NPC[1];
		CaveExplorer.npcs[0] = new NPC();
		CaveExplorer.npcs[0].setposition(1, 1);
		//ADD EACH PERSON's ROOM LIKE THIS:
		CaveRoom customRoom = new NPCRoom("Room");
		CaveExplorer.caves[4][3] = customRoom;
		//4. Set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//5. Set up doors
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		/**
		 * Special requests:
		 * moving objects in caves
		 * what happens when you lose?
		 * can another object move toward you?
		 */

	}

}

