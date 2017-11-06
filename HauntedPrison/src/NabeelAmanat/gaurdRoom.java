package NabeelAmanat;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class gaurdRoom extends CaveRoom {
	
	

	public gaurdRoom(String description) {
		super(description);
	}
	public void startMission() {
		CaveExplorer.print("You have entered the " +super.gaurdNum + " room.");
		if(Inventory.hasWeapon == true) {
			CaveExplorer.print("Looks like your lucky enough to have a gun with " + super.bulletCount+", lets go ahead and shoot the gaurd.");
			CaveExplorer.print("If you want to use a bullet and kil him press 'e'");
			if(super.interpretInput()) {
				CaveExplorer.print("PEW!!! PEW!!!");
				CaveExplorer.print("He is dead, lets go grab the key that he has.");
				
			}
			else {
				noWeapon();
			}
			if(super.gaurdNum ==1) {
				CaveExplorer.print("");
				
			}
			else
				
			
		}
		else
			noWeapon();
	}
	
	/**
	 * override to add more keys, but always include 'wdsa'
	 * @return
	 */
	public String validKeys() {
		return "wdsae";
	}

	/**
	 * override to print a custom string describing what keys do
	 */
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w', 'a', 's' or 'd'.");
	}
	public void performAction(int direction) {
		System.out.println("That key does nothing.");
	}
	
	private void noWeapon() {
		
	}

	

	
}
