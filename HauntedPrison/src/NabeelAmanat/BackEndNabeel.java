package NabeelAmanat;

public class BackEndNabeel implements AmanatSupport{
	private NabeelSupport frontend;
	private AmanatNabeelPlot[][] plots;
	private AmanatNabeelPlot[][] AiPlots;
	private int health;
	private String[] coordinates;
	private int ships = 0;
	private int AiShips = 0; 
	private String[] AiChoice;
	private int nShips = 5;
	private boolean inPlay = false;
	private boolean gameStatus= false;
	private boolean firstStep= false;
	
	public BackEndNabeel(NabeelSupport frontend) {
		this.frontend = frontend;
		plots = new AmanatNabeelPlot[6][6];
		AiPlots = new AmanatNabeelPlot[6][6];
		createPlots();
	}

	private void createPlots() {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				plots[row][col] = new AmanatNabeelPlot(row, col, false);
			}
		}
		for(int row = 0; row < AiPlots.length; row++){
			for(int col = 0; col < AiPlots[row].length; col++){
				AiPlots[row][col] = new AmanatNabeelPlot(row, col, false);
			}
		}
	}
	public void gameStart() {
		while(ships != 5) {
		nShips = nShips-ships;
		frontend.promptUser("Where would you like to place your ship?\n" +"You have "+ nShips+" left to pick");
		coordinates = frontend.getInput();
		ships++;
		}
		inPlay= true;
		while(inPlay == true) {
		setUpHumanBourd();
		setUpAiBourd();
		frontend.promptUser("So where would you like to hit?");
		humanAction();
		AiAction();
		isGameFinished();
		}	
		
	}

	public void setUpHumanBourd() {
		for(int i =0; i<coordinates.length-1; i=i+2) {
			plots[i][i+1] = new AmanatNabeelPlot(i, i+1, true);
		}
		
	}
	
	public void setUpAiBourd() {
		AiActions();
		
	}
	private String[] AiActions() {
		while(firstStep = false) {
			int location =0;
			location = (int)(Math.random()*AiPlots.length);
			
		}
		return AiChoice;
		
	}

	public void humanAction() {
		
	}

	public void AiAction() {
		
		
	}
	
	
	public void isGameFinished() {
		if(ships ==0) {
			gameStatus = false;
			inPlay = false;
		}
		if(AiShips == 0) {
			gameStatus = true;
			inPlay= false;
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
