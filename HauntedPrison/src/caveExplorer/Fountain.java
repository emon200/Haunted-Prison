package caveExplorer;

public class Fountain extends CaveRoom {
	
	private int maxHp;
	boolean visited = false;
	public Fountain(String description) {
		super(description);
			maxHp = 100;
	}
	
	public String getContents() {
		if(!visited) {
			visited = true;
			super.setHp(maxHp);
			return "F";
		}else {
			//return what would've been returned otherwise
			return super.getContents();
		}
	}
	public String getDescription() {
		if(!visited) {
			return super.getDescription() + "\n"+ "There is a fountain in the middle of the room";
		}else {
			return super.getDescription() + "\n" + "This was where you gained your strength";
		}
	}

}
