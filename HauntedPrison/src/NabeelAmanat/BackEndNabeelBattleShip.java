package NabeelAmanat;

public class BackEndNabeelBattleShip implements AmanatSupport{
	private NabeelSupport frontend;
	private AmanatNabeelPlot[][] plots;
	private int health;
	
	public BackEndNabeelBattleShip(NabeelSupport frontend) {
		this.frontend = frontend;
		plots = new AmanatNabeelPlot[6][6];
		createPlots();
	}

	private void createPlots() {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				plots[row][col] = new AmanatNabeelPlot(row, col);
			}
		}
	}

	@Override
	public AmanatNabeelPlot[][] getPlots() {
		// TODO Auto-generated method stub
		return plots;
	}

	@Override
	public String getValidUserInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void computerMove() {
		// TODO Auto-generated method stub
		
	}
}
