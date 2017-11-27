package NabeelAmanat;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class BackEndNabeel implements AmanatSupport{
	private FrontEndAmanat frontend;
	private AmanatNabeelPlot[][] plots;
	private AmanatNabeelPlot[][] AiPlots;
	private int health;
	private int[][] coordinates =new int[5][1];
	private int ships = 0;
	private int AiShips = 0; 
	private int[] AiChoice = new int[10];
	int[] info = new int[2];
	private boolean first = false;
	private int nShips = 5;
	private boolean inPlay = false;
	private boolean gameStatus= false;
	private boolean firstStep= false;
	Scanner in = new Scanner(System.in);
	
	public BackEndNabeel(FrontEndAmanat frontend) {
		this.frontend = frontend;
		plots = new AmanatNabeelPlot[6][6];
		AiPlots = new AmanatNabeelPlot[6][6];
		createPlots();
	}

	private void createPlots() {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				plots[row][col] = new AmanatNabeelPlot(row, col);
				plots[row][col].reveal();
			}
		}
		for(int row = 0; row < AiPlots.length; row++){
			for(int col = 0; col < AiPlots[row].length; col++){
				AiPlots[row][col] = new AmanatNabeelPlot(row, col);
			}
		}
	}
	public void gameStart() {
		for(int i=0; i<5; i++) {
			nShips = 5-ships;
			frontend.promptUser("Where would you like to place your ship?\n" +"You have "+ nShips+" left to pick"+". Put it in this format: x-coordinate, y-coordinate.");
			String input = CaveExplorer.in.nextLine();
			coordinates[i] = getInput(input);
			ships++;
			setFirstLocations();
			frontend.displayAIBoard(plots);
			frontend.displayBoard(plots);
		}
		ships =5;
		inPlay= true;
		while(inPlay == true) {
		frontend.displayAIBoard(plots);
		frontend.displayBoard(plots);
		frontend.displayScore();
		doHumanAction();
		doAiAction();
		isGameFinished();
		}	
		if(gameStatus==false) {
			frontend.promptUser("Looks like you lost.\nBetter luck next time");
		}
		else {
			frontend.promptUser("Looks like you won, good job.\nComputer:'I'll get you next time.");
		}
	}

	public void setFirstLocations() {
		for(int i =0; i<coordinates.length; i++) {
			plots[coordinates[i][0]][coordinates[i][1]] = new AmanatNabeelPlot(coordinates[i][0], coordinates[i][1]);
		}
		AiActions();
		for(int i =0; i<6; i=i+2) {
			AiPlots[i][i+1] = new AmanatNabeelPlot(i, i+1);
		}
	}

	public int[] AiActions() {
		for(int i =0;i<9;i=i+2) {
			int xLocation = 0;
			int yLocation = 0;
			xLocation = (int)(Math.random()*AiPlots.length);
			yLocation = (int)(Math.random()*AiPlots.length);
			AiChoice[i] = xLocation;
			AiChoice[i+1] = yLocation;	
		}
		AiShips =5;
		return AiChoice;
	}
	
	public void doHumanAction() {
		int[] marks= new int[2];
		frontend.promptUser("Where would you like to hit next? Format: x,y");
		String input = CaveExplorer.in.nextLine();
		marks = getInput(input);
		if(isHitHuman(marks, AiChoice)) {
			frontend.promptUser("Good job you got a ship. \nIt's the Ai's turn.");
			AiShips--;
		}
		else
			frontend.promptUser("There isn't anything there try to hit something next turn.");
		
	}
	
	public int[] getInput(String uinput) {
		int loop =0;
		while (loop ==0){
		try{
			Integer.parseInt(uinput.substring(0,1));
			Integer.parseInt(uinput.substring(2,3));
			}
		catch(NumberFormatException ex) {
			frontend.promptUser("This is not a valid input use format: x,y \n x and y must be numbers.");
			String input = CaveExplorer.in.nextLine();
			getInput(input);
		}
		int x = Integer.parseInt(uinput.substring(0,1));
		int y = Integer.parseInt(uinput.substring(2,3));
			if(checkIfInputValid(x) && checkIfInputValid(y)) {
				info[0] = x;
				info[1] = y;
				loop = 1;
				return info;
			}
			else {
				frontend.promptUser("That doesnt work please select a value that is in the graph and put it in format: x,y");
			}
		}
		return info;
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
			ships--;
		}
		else
			frontend.promptUser("Computer: "+"Damn you human, I'll get you next time");
		
	}
		
	public boolean isHitAi(int[] marks, int[][] list) {
		for(int i=0; i<list.length; i++) {
			if(marks[0] == list[i][0] && marks[1] == list[i][1]) {
				return true;
			}
		}
		return false;
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
		return plots;
	}
	
	public AmanatNabeelPlot[][] getAIPlots() {
		return AiPlots;
	}

	@Override
	public boolean checkIfInputValid(int x) {
		boolean amanat = false;
		if(x < 7 && x>-1) 
			amanat =true;
		return amanat;
	}
}
