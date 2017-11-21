package NabeelAmanat;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class gambleAmanat extends CaveRoom {


	boolean visited;
	private String activeDescription;
	private String inactiveDescription;

	public gambleAmanat(String description) {
		super(description);
		this.activeDescription = "You remember the days you wold come here to gamble, how about one last shot?";
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
		int hp = CaveExplorer.inventory.getHp();
		CaveExplorer.print("Tarot cards start to form around you, do you dare take one and read your fortune?");
		double x = 0;
		if(visited == false) {
			CaveExplorer.print("On a table you see poker cards forming, will you pick a card?");
			String s = CaveExplorer.in.nextLine();
			if(s.equalsIgnoreCase("e")) {
				x = (double)(Math.random()*5);
				System.out.print(x);
				CaveExplorer.print("As fate has it you...");
				if(x <= 1) {
					CaveExplorer.print("...have been gravely injured.");
					CaveExplorer.inventory.setHp(hp-50);
					visited = true;
					//chatting = false;
				}
				else if(x > 1 && x <= 2) {
					CaveExplorer.print("...are completely rejuvenated.");
					CaveExplorer.inventory.setHp(100);
					visited = true;
				}
				else if(x > 2 && x <= 3) {
					CaveExplorer.print("...are not to be fought with.");
					caveExplorer.Inventory.hasWeapon = true;
					visited = true;
				}
				else if(x > 3 && x <= 4) {
					CaveExplorer.print("...are dead.");
					CaveExplorer.inventory.setHp(0);
					visited = true;
				}
				else if(x > 4 && x <= 5) {
					CaveExplorer.print("...get nothing.");
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


}

