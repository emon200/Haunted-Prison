package caveExplorer;

public class InventoryRoom extends CaveRoom {
	 private boolean visited = false;
	 private boolean chatting = false;

	public InventoryRoom(String description) {
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
		CaveExplorer.print("Seems like the close is clear in this room, I should check to see what I have so far...");
		String s = CaveExplorer.in.nextLine();
		visited = false;
		chatting = true;
		while(chatting) {
			CaveExplorer.print("Keys:"+Inventory.getKeys()+" Has a gun: "+Inventory.isHasWeapon());
			chatting = false;
		}		
	}
	
	public String getContents() {
		return "I";
	}
	
	public String getDescription() {
		return super.getDescription();
	}

}
