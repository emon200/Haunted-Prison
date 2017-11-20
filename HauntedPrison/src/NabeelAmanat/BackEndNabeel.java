package NabeelAmanat;

public class BackEndNabeel implements AmanatSupport{
	private NabeelSupport frontend;
	private AmanatNabeelPlot[][] plots;
	private AmanatNabeelPlot[][] AiPlots;
	private int health;
	private int[][] coordinates;
	private int ships = 0;
	private int AiShips = 0; 
	private int[] AiChoice;
	private boolean first = false;
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
				plots[row][col] = new AmanatNabeelPlot(row, col);
			}
		}
		for(int row = 0; row < AiPlots.length; row++){
			for(int col = 0; col < AiPlots[row].length; col++){
				AiPlots[row][col] = new AmanatNabeelPlot(row, col);
			}
		}
	}
	public void gameStart() {
		int i =0;
		while(ships != 5) {
		nShips = nShips-ships;
		frontend.promptUser("Where would you like to place your ship?\n" +"You have "+ nShips+" left to pick");
		coordinates[i] = frontend.getInput();
		ships++;
		i++;
		}
		inPlay= true;
		setFirstLocations();
		while(inPlay == true) {
		doHumanAction();
		setUpAiBourd();
		frontend.promptUser("So where would you like to hit?");
		humanAction();
		AiAction();
		isGameFinished();
		}	
		
	}

	public void setFirstLocations() {
		
		for(int i =0; i<coordinates.length-1; i=i+2) {
			plots[coordinates[i][0]][coordinates[i][1]] = new AmanatNabeelPlot(coordinates[i][0], coordinates[i][1]);
		}
		AiActions();
		for(int i =0; i<AiChoice.length-1; i=i+2) {
			AiPlots[i][i+1] = new AmanatNabeelPlot(i, i+1);
		}
	}

	public void doHumanAction() {
		int[] marks;
		frontend.promptUser("Where would you like to hit next?");
		marks = frontend.getInput();
		if(AiPlots[marks[0][marks[1]) {
			
		}
		
	}
	
	public void setUpAiBourd() {
		AiActions();
		
	}
	private int[] AiActions() {
		int times=0;
		int i=0;
		while(times != 5) {
		int location = 0;
		location = (int)(Math.random()*AiPlots.length);
		AiChoice[i] = location;
		AiChoice[i+1] = location;
		times++;
		i=i+2;
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
		// TODO Auto-genedrated method stub
		return null;
	}

	@Override
	public void computerMove() {
		// TODO Auto-generated method stub
		
	}
}
