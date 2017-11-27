package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;//every room in the cave
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;//changes based on how the user navigated
	public static Inventory inventory = new Inventory();//where all objects found in cave are kept
	public static boolean playing = true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
	
		inventory.setHp(10);
		inventory.updateMap();
		startExploring();
	}


	private static void startExploring() {
		while(playing && inventory.getHp() >0) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		if(inventory.getHp()==0) {
			CaveExplorer.print("GAME OVER");
		}
		else {
			CaveExplorer.print("ESCAPE SUCESSFUL!");
		}
	}
	
	private static void npcActions() {
		for(NPC n: npcs) {
			n.act();
		}
		inventory.updateMap();
	}


	public static void print(String s) {
		//NOTE: later, you can replace this line with the more sophistocated "multiLinePrint" from Chatbot
		System.out.println(s);
	}

}
