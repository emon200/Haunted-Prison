package NabeelAmanat;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class gaurdRoom extends CaveRoom {
	
	private String finalAnswer ="";

	public gaurdRoom(String description) {
		super(description);
	}
	public void startMission() {
		CaveExplorer.print("You have entered the " +super.gaurdNum + " room.");
		if(Inventory.hasWeapon == true) {
			CaveExplorer.print("Looks like your lucky enough to have a gun with " + super.bulletCount+", lets go ahead and shoot the gaurd.");
			CaveExplorer.print("If you want to use a bullet and kil him press 'e'or 'n' to battle him");
			String input = CaveExplorer.in.nextLine();
			interpretInput(input);
			if(finalAnswer.equals("e")) {
				CaveExplorer.print("PEW!!! PEW!!!");
				CaveExplorer.print("He is dead, lets go grab the key that he has.");
				
			}
			else {
				noWeapon();
			}
		}
		else
			noWeapon();
	}
	
	/**
	 * override to add more keys, but always include 'wdsa'
	 * @return
	 */
	
	public void interpretInput(String input) {
		System.err.println("interpretting input "+input);
		while(!isValid(input)) {
			printAllowedEntry();
			input = CaveExplorer.in.nextLine();
		}
		System.err.println("marked as valid: "+input);
		//task: convert user input into a direction
		//DO NOT USE AN IF STATEMENT
		//(or, if you must, don't use more than 1)
		String dirs = validKeys();
		respondToKey(dirs.indexOf(input));
		finalAnswer= input;
	}
	public String validKeys() {
		return "en";
	}

	/**
	 * override to print a custom string describing what keys do
	 */
	public void printAllowedEntry() {
		System.out.println("You can only enter 'e' or 'n'.");
	}
	public void performAction(int direction) {
		System.out.println("That key does nothing.");
	}
	
	private void noWeapon() {
		System.out.println("Looks like you cant't/ won't use the gun, time to die.");
		System.out.println("oooff, looks like your dead");
	}

	

	
}
