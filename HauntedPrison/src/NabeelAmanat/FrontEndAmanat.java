package NabeelAmanat;

import caveExplorer.CaveExplorer;

public class FrontEndAmanat implements NabeelSupport{
	private AmanatSupport backend;
	private String newHint;
	private int ships;
	private int chips;
	private int turn;
	private String cheatcode = "Titanic";
	private long counter;
	private boolean playing;
	private boolean isHit;
	private boolean isCHit;
	private int playerScore;
	private int computerScore;
	
	public static final void main(String[] args) {
		FrontEndAmanat demo = new FrontEndAmanat();
		demo.startGame();
	}
	
	private void startGame() {
		//AmanatNabeelPlot[][] plots = backend.getPlots();
		playing = true;
		while(playing) {
		AmanatNabeelPlot[][] plots = backend.getPlots();
		//AmanatNabeelPlot[][] plots = new AmanatNabeelPlot[6][6];
		//for(int i=0;i<plots.length;i++) {
			//for(int x =0; x<plots[i].length;x++) {
				
			//}
		//}
		ships = 15;
		chips = 15;
		setUp();
		while(ships >0 && chips>0) {
			displayAIBoard(plots);
			System.out.println("\n|--------|\n");
			displayBoard(plots);
			updateScore();
			displayScore();
			//time();
			//turnCount();
	        String input = backend.getValidUserInput();
	        respondToInput(input);
	        backend.computerMove();
	        updateScore();
		}
	}
	}
	
	private void updateScore() {
		if(isHit == true) {
			playerScore++;
		}
		if(isCHit == true) {
			computerScore++;
		}
	}

	private void respondToInput(String input) {
		
	}

	private void displayBoard(AmanatNabeelPlot[][] plots) {
		String rows = "0123456789";
		String columns = "  0123456789";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].isRevealed()){
					if(plots[row][col].isShip()){
						System.out.print("☠");
						isHit = true;
						displayScore();
						isHit=false;
						ships--;
					}else{
						System.out.print(" ");	
					}

				}else{
					System.out.print(".");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	
	}
	
		private void displayAIBoard(AmanatNabeelPlot[][] plots) {
		String rows = "0123456789";
		String columns = "  0123456789";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].isRevealed()){
					if(plots[row][col].isShip()){
						System.out.print("☠");
						isCHit = true;
						displayScore();
						isCHit=false;
						chips--;
					}else{
						System.out.print(" ");	
					}

				}else{
					System.out.print(".");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	
	}

	private void displayScore() {
		System.out.println("Player Score:" + playerScore);
		System.out.println("Computer Score:" + computerScore);
	}
	
	private void analyzeBoard() {
		
	}
	
	private void setUp() {
		
	}
	
//	public void turnCount() {
//		boolean onTurn = true;
//		while(onTurn==true) {
//		turn++;
//		System.out.println(turn);
//		onTurn=false;
//		}
//	}
	
//	public void time() {
//		counter = (long) System.nanoTime();
//		System.out.print(counter);
//	}
	public void cheatCode() {
		String s = CaveExplorer.in.nextLine();
		if(s.equalsIgnoreCase(cheatcode)) {
			System.out.println("Suddenly all the ships crash into giant icebergs! \n'I'll never let go Jack'~");
			playing = false;
		}
	}
	public FrontEndAmanat() {
		backend = new BackEndNabeelBattleShip(this);
		newHint = null;
	}
	
}
