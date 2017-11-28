package caveExplorer;

import NabeelAmanat.FrontEndAmanat;

public class GaurdRoom extends CaveRoom {
	private String activeDescription;
	private String inactiveDescription;
	public static final int wait= 1000;
	
	//MINI GAME START FOR BATTLESHIP

	public GaurdRoom(String description) {
		super(description);
		this.activeDescription = "You see a guard apprach you...";
		this.inactiveDescription = "This is where you fought the guard and beat him in the battleship game...";

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
		FrontEndAmanat.main(null);
	
	}
	
	public String getContents() {
		return "G";
	}

	public String getDescription() {
			return super.getDescription() + "\n" + getActiveDescription();
	
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
