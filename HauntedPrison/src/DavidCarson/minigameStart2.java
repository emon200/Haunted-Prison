package DavidCarson;

import caveExplorer.CaveRoom;

public class minigameStart2 extends CaveRoom {

	public minigameStart2(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	public void enter() {
		super.enter();
		DavidFrontend.main(null);
	}

}
