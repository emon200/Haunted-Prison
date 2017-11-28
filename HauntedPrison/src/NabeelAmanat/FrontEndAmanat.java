package NabeelAmanat;

import caveExplorer.CaveExplorer;

public class FrontEndAmanat implements NabeelSupport{
	private AmanatSupport backend;
	private String newHint;
	private int turn;
	private long counter;
	private boolean playing;
	private boolean isHit=false;;
	private boolean isCHit=false;
	private int playerScore;
	private int computerScore;
	
	public static final void main(String[] args) {
		
		FrontEndAmanat demo = new FrontEndAmanat();
		CaveExplorer.initScanner();
		demo.startGame();
	}
	
	
	public void startGame() {
		promptUser("Welcome to Battleship!" + "\n");
		//add in some text with instructions or stuff
		((BackEndNabeel)backend).gameStart();
		
	}
	
	public void updateHumanScore() {
		playerScore++;
	}
	public void displayBoard(AmanatNabeelPlot[][] plots) {
		String rows = "0123456789";
		String columns = "  0123456789";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(AmanatNabeelPlot.isAiRevealed(row, col)){
					if(backend.isThereShip(row, col)){
						System.out.print("☠");						
					}else{
						System.out.print(" ");	
					}
				}
				else if(backend.isThereShip(row, col)) {
					System.out.print("⛵");
				
			}
				else {
					System.out.print(" ");
				}
			}
			System.out.println(" ");
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	
	}
	
	
	public void displayAIBoard(AmanatNabeelPlot[][] plots) {
		String rows = "0123456789";
		String columns = "  0123456789";
		promptUser("~Battleship~");
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(AmanatNabeelPlot.isRevealed(row, col)){
					if(backend.isThereAIShip(row, col)){
						System.out.print("☠");
					}else{
						System.out.print(" ");	
					}

				}else{
					System.out.print(".");
				}
			}
			System.out.println(" ");
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	
	}

	public void displayScore() {
		System.out.println("Player Score:" + playerScore);
		System.out.println("Computer Score:" + computerScore);
	}
	public FrontEndAmanat() {
		backend = new BackEndNabeel(this);
		newHint = null;
	}

	@Override
	public void promptUser(String question) {
		System.out.println(question);
	}


	public void updateAIScore() {
		computerScore++;
		
	}
}
