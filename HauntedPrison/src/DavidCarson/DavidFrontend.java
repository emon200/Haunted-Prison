package DavidCarson;

import java.util.Scanner;

import caveExplorer.CaveExplorer;


public class DavidFrontend implements CarsonSupport {

	private DavidSupport backend;
	private int tries;
	private String cheatcode;
	private boolean playing;
	private boolean chatting; 
	public DavidFrontend() {
		backend = new CarsonBackend(this);
		tries = 10;
		cheatcode = "pineapples";
	}

	public static final void main(String[] args) {
		CaveExplorer.in = new Scanner(System.in);
		DavidFrontend demo = new DavidFrontend();
		demo.play();
		

	}

	private void play() {
		CaveExplorer.print("Are you ready to get started? If so, enter 'p' to begin or enter'r' for info  ");
		String s = CaveExplorer.in.nextLine();
		if(s.equalsIgnoreCase("r")){
			CaveExplorer.print("In your display you will find a switchboard, with your tasks being to match up all the pairs of switches...\n"
					+ "You will have 10 tries to get all the pairs matched up and for every pair matched, you get an extra attempt...\n"
					+ "When matching up the combinations there will be a few features embedded that may speed your progess in matching the switches...\n"
					+ "Good Luck...\n\n      - - press enter - -");
			CaveExplorer.in.nextLine();
			play();
		}else{
			startPlaying();
		}

		
			
		}


	private void startPlaying() {
		DavidCarsonChart[][] plots = backend.getPlots();
		DavidCarsonChart p = null;
		playing = true;
          while(playing) {
        	  displayField(plots);
      		  displayScoreStatus();
        	  System.out.println("Please pick your 2 coordinates to choose from!");
        	  int[][] coords = backend.getCoordInput();
        	  boolean match = backend.isMatch(coords[0], coords[1]);
        	  if(match) {
        		  addTries();
        	  }else {
        		  removeTries();
        	  }
      			if(tries==0) 
      			{
      			System.out.println("You failed to match up all the combinations within the allotted amount of attempts!...");
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
	

	private void displayScoreStatus() {
		CaveExplorer.print("You currently have "+tries+" attempts left before the switchboard locks down..");
		
	}
	
	private void displayField(DavidCarsonChart[][] plots) {
		String rows = "0123456789";
		String columns = "  0123456789";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
					if(plots[row][col].isMatched()){
						System.out.print(plots[row][col].getValue());
					}else{
						System.out.print("-");
					}

			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(columns.substring(0, plots[0].length+2));
	}
	
	public void checkIfBomb(DavidCarsonChart p) {
		DavidCarsonChart[][] plots = backend.getPlots();
		int r = p.getRow();
		int c = p.getCol();
		int east = p.getCol()+1;
		int west = p.getCol()-1;
		int north = p.getRow()-1;
		int south= p.getRow()+1;
		if(p.isHasBomb()) {
			CaveExplorer.print("You just triggered a bomb mechanic in the system!... \n All adjacent blocks at these directions gets matched!");
			//p.setMatched(true);
			if(valid(r,east)) {
				plots[r][east].setMatched(true);
				matchOther(plots[r][east].getValue(),plots[r][east]);
				CaveExplorer.print("east");
			}
			 if(valid(r,west)) {
				 plots[r][west].setMatched(true);
				 matchOther(plots[r][west].getValue(),plots[r][west]);
				 CaveExplorer.print("west");
			}
			 if(valid(north,c)) {
				 plots[north][c].setMatched(true);
				 matchOther(plots[north][c].getValue(),plots[north][c]);
				 CaveExplorer.print("north");
				}
			 if(valid(south,c)) {
				 plots[south][c].setMatched(true);
				 matchOther(plots[south][c].getValue(),plots[south][c]);
				 CaveExplorer.print("south");
				}
		}
		
	}
	private void matchOther(int i, DavidCarsonChart plots2) {
		String rows = "0123456789";
		String columns = "  0123456789";
		DavidCarsonChart[][] plots = backend.getPlots();
		for(int row = 0; row < plots.length; row++){
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col] != plots2) {
					if(plots[row][col].getValue() == i){
						plots[row][col].setMatched(true);
					}
				}
			}
			
		}
		
	}

	private boolean valid(int row, int col){
		return row >= 0 && row< backend.getPlots().length && col >= 0 && col < backend.getPlots()[row].length;
	}
	public void removeTries() {
		tries--;
	}
	public void addTries() {
		tries++;
	}
	
}



