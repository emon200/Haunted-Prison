package NabeelAmanat;

import java.util.Scanner;

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
		promptUser("Welcome to Battleship!" + "\n")
		backend.setFirst
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
	
	public void cheatCode() {
		String s = CaveExplorer.in.nextLine();
		if(s.equalsIgnoreCase(cheatcode)) {
			System.out.println("Suddenly all the ships crash into giant icebergs! \n'I'll never let go Jack'~");
			playing = false;
		}
	}
	public FrontEndAmanat() {
		backend = new BackEndNabeel(this);
		newHint = null;
	}

	@Override
	public void promptUser(String question) {
		System.out.println(question);
	}

	@Override
	public int[] getInput() {
		int loop =0;
		int[] info = new int[1];
		while (loop ==0){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int x = Integer.parseInt(input);
		if(backend.checkIfInputValid(x)) {
			info[0] = x;
			return info;
		}
		promptUser("That doesnt work please select a value that is in the graph.");
		}
		return info;
	}
}
