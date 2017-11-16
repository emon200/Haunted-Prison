package DavidCarson;

import caveExplorer.CaveExplorer;

public class CarsonBackend implements DavidSupport {

	private CarsonSupport frontend;
	private DavidCarsonChart[][] chart;
	private int[] values;

	public CarsonBackend(CarsonSupport frontend) {
		int[] values = new int[100];
		this.frontend = frontend;
		shuffle(values);
		CaveExplorer.print(values.toString());
		chart = new DavidCarsonChart[10][10];
		createChart();
	}

	private void createChart() {
		int i = 0;
		for(int row = 0; row < chart.length; row++) {
			for(int col = 0; col < chart[row].length; col++) {
				chart[row][col] = new DavidCarsonChart(row, col, values[i]);
				i++;
			}
		}
	}
	
	public int[] createValues() {
		int len = (int)Math.pow(chart.length, 2);
		for(int i = 0; i < len / 2; i ++) {
			values[i] = i;
		}
		for(int i = len / 2; i < len; i ++) {
			values[i] = i;
		}
		return values;
	} 

	public DavidCarsonChart[][] getChart() {
		return chart;
	}

	public int[][] getCoordInput() {
		CaveExplorer.print("Please enter the 1st coordinate");
		String input1 = CaveExplorer.in.nextLine();
		int[] coord1 = toCoords(input1);
		while(coord1 == null) {
			CaveExplorer.print("Invalid entry, try again");
			input1 = CaveExplorer.in.nextLine();
			coord1 = toCoords(input1);
		}
		CaveExplorer.print("Please enter the 2nd coordinate");
		String input2 = CaveExplorer.in.nextLine();
		int[] coord2 = toCoords(input2);
		while(coord2 == null) {
			CaveExplorer.print("Invalid entry, try again");
			input2 = CaveExplorer.in.nextLine();
			coord2 = toCoords(input1);
		}

		if(input2 != null) {				
			if(isValidInput(coord1, coord2)) {
				int[][] guess = {coord1, coord2};
				return guess;
			} else {
				CaveExplorer.print("Invalid input, make sure to not use the same coordinates");
			}
		}
		return null;
	}


	private boolean isValidInput(int[] coord1, int[] coord2) {
		if(coord1 != coord2) {
			return true;
		}
		return false;
	}

	private int[] toCoords(String input) {
		try{
			int a = Integer.parseInt(input.substring(0,1));
			int b = Integer.parseInt(input.substring(2,3));
			if(input.substring(1,2).equals(",") && input.length() == 3){
				int[] coords = {a,b};
				return coords;
			}else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}

	public int getFailures() {
		return 0;
	}

	public int[] getCoordinates() {
		return null;
	}

	public void reveal(DavidCarsonChart p) {
		p.reveal();
	}

	private void shuffle(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			swap(arr,(int)(Math.random()*arr.length), (int)(Math.random()*arr.length));
		}

	}

	private void swap(int[] arr, int i, int j) {
		int x = arr[j];
		arr[j] = arr[i];
		arr[i] = x;

	}

	public DavidCarsonChart[][] getPlots() {
		return chart;
	}

	@Override
	public boolean isMatch(int[] coord1, int[] coord2) {
		if(chart[coord1[0]][coord1[1]].getValue() == chart[coord2[0]][coord2[1]].getValue()) {
			chart[coord1[0]][coord1[1]].setMatched(true);
			chart[coord2[0]][coord2[1]].setMatched(true);
			CaveExplorer.print("This was a match");
			return true;
		}
		CaveExplorer.print("No match");
		return false;
	}

}
