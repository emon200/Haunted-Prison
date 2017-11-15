package DavidCarson;

import caveExplorer.CaveExplorer;

public class DavidFrontend implements CarsonSupport {

	private DavidSupport backend;
	private int tries;
	private String cheatcode;
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
		CaveExplorer.print("Are you ready to get started? If so, enter 'p' to begin or enter'r' to  ");
		String s = CaveExplorer.in.nextLine();
		if(s.equalsIgnoreCase("r")) {
				CaveExplorer.print("You are looking at a switch board that has been disabled and needs to be reworked on in order to escape this room "
						+"In order to turn back on the switchboard you must sucesfully match 4 pairs of values that make up the board's switchs"
						+"However, be careful with chossing as you only get 5 chances for error "
						+ "After hitting your 5th error the switchboard's safety mechanism will activate and be locked preventing you from doing any more combinations!");
				play();
		}else {
			startPlaying();
		}
		
			
		}


	private void startPlaying() {
          while(tries>0) {
        	  CaveExplorer.print("What will be your 2 coordinate to choose from?");
        	  
          }
	}
	private void checkValue(int[] arr1,int[] arr2) {
		
	}
	private boolean validCoords(int row,int col) {
		return false;
	}

	private void displayField(DavidCarsonChart[][] plots) {
		String rows = "01234";
		String columns = "  01234";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].isRevealed()){
					if(plots[row][col].isMatched() == true){
						System.out.print(plots[row][col].getValue());
					}else{
						System.out.print("+");	
					}
			}
			else{
				System.out.print("-");	
				}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	}
	}
}



