package caveExplorer;

public class Inventory {
	
	public static boolean hasWeapon;
	private String map;
	private int hp;
	private static int keys;
	
	public static boolean isHasWeapon() {
		return hasWeapon;
	}
	public static void setHasWeapon(boolean hasWeapon) {
		Inventory.hasWeapon = hasWeapon;
	}
	public static int getKeys() {
		return keys;
	}
	public void setKeys(int keys) {
		this.keys = keys;
	}
	public Inventory() {
		
	}
	public static void keysWon() {
		keys++;
	}
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void updateMap() {
		map = " ";
		//create line across top
		for(int i=0;i<CaveExplorer.caves[0].length-1;i++) {
			map+="____"; //4 underscores
		}
		map+="___\n"; //3 underscores,makes the corner look symmetrical
		for(CaveRoom[] row:CaveExplorer.caves) {
			//3 rows of text
			for(int i=0;i<3;i++) {
				String text = "";
				for(CaveRoom cr :row) {
					//if door is open,leave open
					if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen()) {
						text+= " ";
					}else {
						text+="|";
					}
					//contents of room depend on what row this is
					if(i==0) {
						text+= "   ";//3 spaces
					}else if(i ==1) {
						text+=" "+cr.getContents()+ " ";
					}else if(i == 2) {
						//draw space if door to south is open
						if(cr.getDoor(CaveRoom.SOUTH) != null && 
						cr.getDoor(CaveRoom.SOUTH).isOpen()){
							text+="   ";//3 spaces
						}else {
							text += "___";
						}
					}
				}//last caveroom in row
				text+="|";
				map += text +"\n";
			}
		}
	 	map+= "Current HP:" + hp +"\n Keys:"+ keys;
		
	}

	public String getDescription() {
		return map;
		//return "You have nothing in your inventory.";
	}


}
