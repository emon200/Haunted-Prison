package DavidCarson;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class DavidFrontend implements CarsonSupport {

	private DavidSupport backend;
	private int tries;
	private String cheatcode;
	private boolean playing;
	public DavidFrontend() {
		backend = new CarsonBackend(this);
		tries = 5;
		cheatcode = "pineapples";
	}

	public static final void main(String[] args) {
		CaveExplorer.in = new Scanner(System.in);
		DavidFrontend demo = new DavidFrontend();
		demo.play();
		

	}

	private void play() {
		CaveExplorer.print("Are you ready to get started? If so, enter 'p' to begin or enter'r' to begin  ");
		startPlaying();
		
			
		}


	private void startPlaying() {
		DavidCarsonChart[][] plots = backend.getPlots();
		DavidCarsonChart p = null;
		playing = true;
          while(playing) {
        	  displayField(plots);
      		  displayScoreStatus(p);
        	  System.out.println("What will be your 2 coordinate to choose from?");
      			//int[] coords = backend.getCoordinates();
      			//p = plots[coords[0]][coords[1]];
      			//backend.reveal(p);
        	  int[][] coords = backend.getCoordInput();
        	  boolean match = backend.isMatch(coords[0], coords[1]);
      			if(tries==0) 
      			{
      			System.out.println("You failed to match up all the combinations...");
      			playing = false;
      			}
      			else {
      				if(playerWin(plots)) {
      					System.out.println("You have matched up all the the switches and have done so in within the limited amount of tries you've been given.");
      					playing = false;
      				}
      			}
      		  
          }
      		
        	  
          }

	private boolean playerWin(DavidCarsonChart[][] plots) {
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				if(!plots[row][col].isMatched()){
					return false;
				}
			}
		}
		return true;
	}
	

	private void displayScoreStatus(DavidCarsonChart p) {
		// TODO Auto-generated method stubx
		
	}
	
	private void displayField(DavidCarsonChart[][] plots) {
		String rows = "0123456789";
		String columns = "  0123456789";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				//if(plots[row][col].isRevealed()){
					if(plots[row][col].isMatched()){
						System.out.print(plots[row][col].getValue());
					}else{
						System.out.print("X");	
					}

				//}else{
					//System.out.print("-");
				
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	}
}



