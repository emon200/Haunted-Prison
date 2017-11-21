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
		for(int i=0; i<6; i++) {
			nShips = nShips-ships;
			frontend.promptUser("Where would you like to place your ship?\n" +"You have "+ nShips+" left to pick");
			coordinates[i] = frontend.getInput();
			ships++;
		}
		inPlay= true;
		setFirstLocations();
		while(inPlay == true) {
		doHumanAction();
		doAiAction();
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
		if(isHitHuman(marks, AiChoice)) {
			frontend.promptUser("Good job you got a ship. \n It's the Ai's turn.");
		}
		else
			frontend.promptUser("There isn't anything there try to hit something next turn.");
		
	}
	
	public boolean isHitHuman(int[] marks, int[] list) {
			for(int i=0; i<list.length; i++) {
				if(marks[0] == list[i] && marks[1] == list[i+1]) {
					return true;
				}
			}
		return false;
	}

	public void doAiAction() {
		int target[] = new int[2];
		for(int i=0; i<2; i++) {
			target[i] = (int)(Math.random()*AiPlots.length);
		}
		if(isHitAi(target, coordinates)) {
			String result ="Looks like the computer took out one of your ships at location: " +target[0]+", "+target[1]+".";
			frontend.promptUser(result);
		}
		else
			frontend.promptUser("There isn't anything there try to hit something next turn.");
		
	}
		
	public boolean isHitAi(int[] marks, int[][] list) {
		for(int i=0; i<list.length; i++) {
			for(int a=0; a<list[i].length; a++) {
				if(marks[0] == list[i][a+1] && marks[1] == list[i][a+1]) {
					return true;
				}
			}
		}
		return false;
	}
	public int[] AiActions() {
		for(int i =0;i<6;i=i+2) {
			int location = 0;
			location = (int)(Math.random()*AiPlots.length);
			AiChoice[i] = location;
			AiChoice[i+1] = location;	
		}
		return AiChoice;
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
	public boolean checkIfInputValid(int x) {
		boolean amanat = false;
		if(x < 7 && x>-1) 
			amanat =true;
		return amanat;
	}
}
