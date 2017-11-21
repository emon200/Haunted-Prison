package NabeelAmanat;

import caveExplorer.CaveRoom;

public class MiniGameStart extends CaveRoom {

	public MiniGameStart(String description) {
		super(description);
	}

	public void enter() {
		super.enter();
		FrontEndAmanat.main(null);
	}
}
