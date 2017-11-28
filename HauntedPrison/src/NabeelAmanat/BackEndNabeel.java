package NabeelAmanat;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.Inventory;

public class BackEndNabeel implements AmanatSupport{
	private FrontEndAmanat frontend;
	private AmanatNabeelPlot[][] plots;
	private AmanatNabeelPlot[][] AiPlots;
	private int health;
	private int[][] coordinates =new int[5][2];
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
	private String answer;
	private boolean finishGame =false;
	private int[] breakpoint = new int[10]; 
	
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
			}
		}
		for(int row = 0; row < AiPlots.length; row++){
			for(int col = 0; col < AiPlots[row].length; col++){
				AiPlots[row][col] = new AmanatNabeelPlot(row, col);
			}
		}
	}
	public void gameStart() {
		int[] first = new int[2]; 
		for(int i=0; i<5; i++) {
			nShips = 5-ships;
			frontend.promptUser("Where would you like to place your ship?\n" +"You have "+ nShips+" left to pick"+". Put it in this format: x-coordinate, y-coordinate.");
			String input = CaveExplorer.in.nextLine();
			if(input.toLowerCase().equals("quit")) {
				finishGame = true;
				gameStatus =true;
				break;
			}
			first = getInput(input);
			coordinates[i][0] = first[0];
			coordinates[i][1] = first[1];
			ships++;
		}
		if(finishGame == true){
			if(gameStatus==false) {
				frontend.promptUser("Looks like you lost.\nBetter luck next time");
			}
			else {
				frontend.promptUser("Looks like you won, good job.\nGaurd:'I'll get you next time.");
				frontend.promptUser("You get a key, you can use this to escape.");
				Inventory.keysWon();
				Inventory.keysWon();
			}
		}
		else {
		ships =5;
		AiShips = 5;
		inPlay= true;
		AiActions();
		frontend.promptUser("You can exit with the super secret cheat code or press 'enter' to keep playing");
		while(inPlay == true) {
		String input = CaveExplorer.in.nextLine();
		if(input.toLowerCase().equals("quit")) {
			//frontend.promptUser("WHatthe ");
			finishGame =true;
			AiShips =0;
			gameStatus =true; 
			break;
		}
		frontend.displayAIBoard(plots);
		frontend.displayBoard(plots);
		frontend.displayScore();
		doHumanAction();
		if(breakpoint[0] ==10) {
			gameStatus =true;
			break;
		}
		doAiAction();
		isGameFinished();
		
		}	
		if(gameStatus==false) {
			frontend.promptUser("Looks like you lost.\nBetter luck next time");
		}
		else {
			frontend.promptUser("Looks like you won, good job.\nGaurd:'I'll get you next time.");
			frontend.promptUser("You get a key, you can use this to escape.");
			Inventory.keysWon();
		}
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
		if(marks[0] ==10) {
			return;
		}
		if(isHitHuman(marks, AiChoice)) {
			frontend.promptUser("Good job you got a ship. \nIt's the Ai's turn.");
			AiShips--;
			frontend.updateHumanScore();
		}
		else {
			frontend.promptUser("There isn't anything there try to hit something next turn.");
		}
		AmanatNabeelPlot.reveal(marks[0], marks [1]);
	}
	
	public int[] getInput(String uinput) {
		if(uinput.toLowerCase().equals("quit")) {
			//frontend.promptUser("WHatthe ");
			breakpoint[0] = 10;
			return breakpoint;
		}
		int loop =0;
		int loop2 =0;
		int loop3 =0;
		int part =0;
		int part1 =0; 
		while(loop2== 0) {
			if(uinput.length() <3 && part ==0) { 
			frontend.promptUser("These coordinate's don't work. Please input numbers in format: x,y");
			inputTime();
			part++;
			}
			else if(part>0 && answer.length() <3){
				frontend.promptUser("These coordinates don't work. Please input numbers in format: x,y");
				inputTime();
			}
			else {
				loop2=1;
		}
		}
		while(loop3== 0) {
			if(part ==0 && isNumber(uinput)&& part1 ==0 ) {
			frontend.promptUser("These coordinates don't work. Please input numbers in format: x,y");
			inputTime();
			part1++;
			}
			else if(part1>0 && isNumber(answer)){
				frontend.promptUser("These coordinates don't work. Please input numbers in format: x,y");
				inputTime();
			}
			else {
				loop3=1;
		}
		}
		while (loop ==0){	
		if(part>0 || part1>0) {
		int x = Integer.parseInt(answer.substring(0,1));
		int y = Integer.parseInt(answer.substring(2,3));
			if(checkIfInputValid(x) && checkIfInputValid(y)) {
				info[0] = x;
				info[1] = y;
				loop = 1;
				return info;
			}
		}
		else if(part==0 && part1==0) {
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
					nextStep();
					loop =1; 
			}
		}
		}
		return info;

	}
	public void nextStep() {
		inputTime();
		getInput(answer);
		
	}

	public void inputTime() {
		answer = CaveExplorer.in.nextLine();
		
	}

	public boolean isNumber(String ainput) {
		try{
			Integer.parseInt(ainput.substring(0,1));
			Integer.parseInt(ainput.substring(2,3));
			}
		catch(NumberFormatException ex) {
			return true; 
		}
		return false;
	}

	public boolean isHitHuman(int[] marks, int[] list) {
			for(int i=0; i<list.length-1; i++) {
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
			String result ="Looks like the Gaurd took out one of your ships at location: " +target[0]+", "+target[1]+".";
			frontend.promptUser(result);
			ships--;
			frontend.updateAIScore();
		}
		else
			frontend.promptUser("Gaurd: "+"Damn you human, I'll get you next time");
		AmanatNabeelPlot.Aireveal(target[0], target[1]);
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
		if(x < 6 && x>-1) 
			amanat =true;
		return amanat;
	}

	@Override
	public boolean isThereShip(int row, int col) {
		for(int i=0; i<5;i++) {
			if(coordinates[i][0] == row && coordinates[i][1] == col) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isThereAIShip(int row, int col) {
		for(int i=0; i<9;i++) {
			if(AiChoice[i] == row && AiChoice[i+1] == col) {
				return true;
			}
		}
		return false;
	}
}
