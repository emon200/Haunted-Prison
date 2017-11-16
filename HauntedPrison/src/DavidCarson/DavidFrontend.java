package DavidCarson;

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
        	  backend.getCoordInput();

      			if(tries==0) {
      				playing = false;
      		}
          }
      		displayScoreStatus(p);
        	  
          }
	private void displayScoreStatus(DavidCarsonChart p) {
		// TODO Auto-generated method stubx
		
	}
	
	private void checkValue(int[] arr1,int[] arr2) {
		
	}
	private boolean validCoords(int row,int col) {
		return false;
	}


	private void displayField(DavidCarsonChart[][] plots) {
		String rows = "0123456789";
		String columns = "  0123456789";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].isRevealed()){
					if(plots[row][col].isMatched()){
						System.out.print(plots[row][col].getValue());
					}else{
						System.out.print("X");	
					}

				}else{
					System.out.print("-");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	}
}



