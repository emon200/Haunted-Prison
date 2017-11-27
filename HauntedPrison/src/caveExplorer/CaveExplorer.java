package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;//every room in the cave
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;//changes based on how the user navigated
	public static Inventory inventory;//where all objects found in cave are kept
	public static boolean playing = true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		initScanner();
		CaveRoom.setUpCaves();
		
		inventory = new Inventory();
		inventory.setHp(10);
		inventory.setKeys(0);
		inventory.updateMap();
		startExploring();
	}
	public static void initScanner(){
		in = new Scanner(System.in);
	}

	private static void startExploring() {
		while(playing & inventory.getHp()>0) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		if(inventory.getHp()<=0) {
			CaveExplorer.print("Game Over");
		}
		if(inventory.getKeys()==2) {
			CaveExplorer.print("You have escaped");
		}
		
	}
	
	private static void npcActions() {
		for(NPC n: npcs) {
			n.act();
		}
		inventory.updateMap();
	}


	public static void print(String s) {
		//NOTE: later, you can replace this line with the more sophistocated "multiLinePrint" from Chatbott
		System.out.println(s);
	}

}
