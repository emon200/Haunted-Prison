package NabeelAmanat;

public class FrontEndAmanat implements NabeelSupport{
	private AmanatSupport backend;
	private String newHint;
	private int ships;
	private int turn;
	
	public static final void main(String[] args) {
		FrontEndAmanat demo = new FrontEndAmanat();
		demo.play();
	}
	
	private void play() {
		
	}

	private void startGame() {
		AmanatNabeelPlot[][] plots = backend.getPlots();
		AmanatNabeelPlot s = null;
		ships = 5;
		setUp();
		while(ships >0) {
			displayBoard(plots);
			displayScore();
	        String input = backend.getValidUserInput();
	        respondToInput(input);
	        backend.computerMove();
	        updateScore();
		}
	}
	
	private void updateScore() {
		
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
						System.out.print("X");
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
	
	private void displayAIBoard() {
		
	}

	private void displayScore() {
		
	}
	
	private void analyzeBoard() {
		
	}
	
	private void setUp() {
		
	}
	
	public void turnCount() {
		turn++;
	}
	
	public void time() {
		
	}

	public FrontEndAmanat() {
		backend = new BackEndNabeelBattleShip(this);
		newHint = null;
	}
	
}
