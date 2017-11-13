package NabeelAmanat;

public class BackEndNabeelBattleShip implements AmanatSupport{
	private NabeelSupport frontend;
	private AmanatNabeelPlot[][] plots;
	private int health;
	private String cheatcode = "Titanic";
	
	public BackEndNabeelBattleShip(NabeelSupport frontend) {
		this.frontend = frontend;
		
	}
}
