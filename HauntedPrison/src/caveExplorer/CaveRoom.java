package caveExplorer;

import NabeelAmanat.GaurdRoom;
import NabeelAmanat.MiniGameStart;
import NabeelAmanat.gambleAmanat;
import DavidCarson.CarsonCave;
import DavidCarson.DavidCave;
import DavidCarson.minigameStart2;

public class CaveRoom {

	private String description;//tells what the room looks like
	private String directions;//tells what you can do
	private String contents;//a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organize by direction, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	public String gaurdNum;
	public String bulletCount;

	//constantss
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH =2;
	public static final int WEST = 3;


	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becaomes an 'X' when you are
		//inside this room, when you leave, it goes back to defaultContents

		//note: by default, arrays will populate with 'null' meaning there are no connections
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}


	/**
	 * for every door in doors[] appends a String to "directions" describing the access.
	 * For example:
	 *  "There is a door to the north"
	 *  "There is a door to the south"...etc
	 *  
	 * If there are no doors at all, directions should say:
	 *    "There are no doors, you are trapped in here."
	 */
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i =0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "\n   There is a "+doors[i].getDescription() + " to " +
						toDirection(i)+". "+doors[i].getDetails();
			}
		}
		if(!doorFound) {
			directions += "There is no way out. You are trapped in here.";
		}
	}

	/**
	 * converts an int to a direction
	 * 	toDirection(0) -> "the North"
	 * etc
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] direction = {"the North", "the East", "the South","the West"};
		return direction[dir];
	}


	public void enter() {
		contents = "X";
	}

	public void leave() {
		contents = defaultContents;
	}

	/**
	 * Gives this room access to anotherRoom (and vice-versa)
	 * and sets a door between them, updating the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, 
			Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}


	public static int oppositeDirection(int direction) {
		return (direction + 2)%4;
	}


	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}

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
	}
	/**
	 * override to add more keys, but always include 'wdsa'
	 * @return
	 */
	//method has to be public to be able to override
	public String validKeys() {
		return "wdsa";
	}

	/**
	 * override to print a custom string describing what keys do
	 */
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w', 'a', 's' or 'd'.");
	}


	public boolean isValid(String input) {
		String validEntries = validKeys();
		return validEntries.indexOf(input) > -1 && input.length() ==1;
	}


	public void respondToKey(int direction) {
		//first, protect against null pointer exception
		//(user cannot go through non-existent door
		if(direction < 4) {
			if(borderingRooms[direction] != null && 
					doors[direction] != null) {
				CaveExplorer.currentRoom.leave();
				CaveExplorer.currentRoom = borderingRooms[direction];
				CaveExplorer.currentRoom.enter();
				CaveExplorer.inventory.updateMap();
			}
		}else {
			performAction(direction);
		}
	}

	/**
	 * override to give response to keys other than wasd
	 * @param direction
	 */
	public void performAction(int direction) {
		System.out.println("That key does nothing.");
	}


	/**
	 * This will be where your group sets up all the caves 
	 * and all the connections
	 */
	public static void setUpCaves() {
		//ALL OF THIS CODE CAN BE CHANGED
		//1. Decide how big your caves should be
		CaveExplorer.caves = new CaveRoom[5][5];
		//2. Populate with caves and a defualt description: hint: when starting, use coordinates (helps debugging)
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
		CaveRoom customRoom = new NPCRoom("Room 0,1");
		CaveRoom customRoom2 = new CarsonCave("Room 1,2");
		CaveRoom customRoom3 = new DavidCave("Quiet Room");
		CaveRoom customRoom4 = new gambleAmanat("Room 0,2");
		CaveRoom customRoom5 = new GaurdRoom("Room 2,1s"
				+ "");
		MiniGameStart customRoom6 = new MiniGameStart("This is where Amanats and Nabeels game is");
		minigameStart2 customRoom7 = new minigameStart2("Memory Game");

		
		CaveExplorer.caves[0][1] = customRoom;
		CaveExplorer.caves[0][0] = customRoom3;
		CaveExplorer.caves[0][2] = customRoom4;
		CaveExplorer.caves[2][1] = customRoom5;
		CaveExplorer.caves[1][2] = customRoom2;
		CaveExplorer.caves[2][2] = customRoom6;
		CaveExplorer.caves[2][0] = customRoom7;		
		//4. Set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//5. Set up dooors
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[0][1].setConnection(WEST, c[0][0], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
		c[0][1].setConnection(WEST, c[0][0], new Door());
		c[0][1].setConnection(EAST, c[0][2], new Door());
		c[1][1].setConnection(SOUTH, c[2][1], new Door());
		c[2][1].setConnection(EAST, c[2][2], new Door());
		c[2][1].setConnection(WEST, c[2][0], new Door());

		/**
		 * Special requests:
		 * moving objects in caves
		 * what happens when you lose?
		 * can another object move toward you?
		 */

	}


	public String getDescription() {
		return description + "\n"+directions;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}


	public Door getDoor(int direction) {
		if (direction >=0 && direction < doors.length) {
			return doors[direction];
		}else {
			return null;
		}
	}



}
