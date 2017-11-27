package caveExplorer;

public class EscapeRoom extends CaveRoom {
	boolean win;
	private String activeDescription;
	private String inactiveDescription;
	private boolean chatting;

	public EscapeRoom(String description) {
		super(description);
		this.activeDescription = "You see a sign labled 'EXIT'...";
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
			if(win == false) {
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
			CaveExplorer.print("You see a large door with two keyholes... This must be the escape door...");
			String s = CaveExplorer.in.nextLine();
			chatting = true;
			while(chatting) {
				    if(s.equalsIgnoreCase("e")) {
				    	if(CaveExplorer.inventory.getKeys()==2) {
				    		CaveExplorer.print("You put each key into the sockets and unlock the door...");
				    		chatting = false;
				    		CaveExplorer.playing = false;
				    	}
				    	else {
				    		CaveExplorer.print("You don't have all the keys to open the door...");
				    		chatting = false;
				    	}
				    }
				    else {
				    	CaveExplorer.print("You tried doing something but fumbled...");
				    	s = CaveExplorer.in.nextLine();
				    }
			}
				
			
	}

		    
	
	public String getContents() {
		if(!win) {
			return "A";
		}else {
			//return what would've been returned otherwise
			return super.getContents();
		}
	}

	public String getDescription() {
		if(win == false) {
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
