package NabeelAmanat;

public class FrontEndAmanat implements NabeelSupport{
	private AmanatSupport backend;
	private String newHint;
	
	public static final void main(String[] args) {
		FrontEndAmanat demo = new FrontEndAmanat();
		demo.play();
	}
	
	private void play() {
		
	}

	public FrontEndAmanat() {
		backend = new BackEndNabeelBattleShip(this);
		newHint = null;
	}
	
}
