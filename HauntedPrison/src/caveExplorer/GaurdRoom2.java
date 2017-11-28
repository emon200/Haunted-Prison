package caveExplorer;

import DavidCarson.DavidFrontend;

public class GaurdRoom2 extends CaveRoom {

	private String activeDescription;
	private String inactiveDescription;
	public static final int wait= 1000;
	public GaurdRoom2(String description) {
		super(description);
		this.activeDescription = "This is the memory game";
		this.inactiveDescription = "This is where you played the memory matching game..."; 
	}
	public void enter() {
		super.enter();
		System.out.println("Gaurd: YOU!!! HOW DID YOU ESCAPE YOUR CELL??");
		delay();
		System.out.println(MissionRoom.getInput()+": Some mysterious voice in my head let me out");
		delay();
		System.out.println("Gaurd: No matter, I won't let you escape.");
		delay();
		System.out.println("Chill I'm bored of this place already, plus I got a mysterious voice in my head \n Really wanna mess with me?");
		delay();
		System.out.println("Gaurd: Fair point. Fine, win the Matching game and you can get past me!");
		delay();
		System.out.println("\n Get ready to fight");
		respondToKey(3); 
		delay();
		if(!DavidFrontend.getHasWon()) {
			DavidFrontend.main(null);
		}else {
			
			CaveExplorer.print(inactiveDescription);
		}
	
	}
	
	public String getContents() {
		if(!DavidFrontend.getHasWon()) {
			return "G";
		}else {
			return super.getContents();
		}
	}

	public String getDescription() {
		if(DavidFrontend.getHasWon() == false) {
			return super.getDescription() + "\n" + getActiveDescription();
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
	
	private void delay() {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}

