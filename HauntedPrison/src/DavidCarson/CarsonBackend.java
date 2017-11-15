package DavidCarson;

import caveExplorer.CaveExplorer;

public class CarsonBackend implements DavidSupport {
	
	private CarsonSupport frontend;
	private DavidCarsonChart[][] chart;
	private int[] values = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8};
	
	public CarsonBackend(CarsonSupport frontend) {
		this.frontend = frontend;
		shuffle(values);
		CaveExplorer.print(values.toString());
		chart = new DavidCarsonChart[4][4];
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
	
	public DavidCarsonChart[][] getChart() {
		return chart;
	}
	
	public int[] getCoordInput() {
		String input = CaveExplorer.in.nextLine();
		int[] coords = toCoords(input);
		while(coords == null){
			System.out.println("You must enter cordinates of the form:\n <row>,<col>" + "\n<row> and <col> should be integers.");
			input = CaveExplorer.in.nextLine();
			coords = toCoords(input);
		}
		return coords;
	}
	
	public int[] getSecondCoordInput() {
		String input2 = CaveExplorer.in.nextLine();
		int[] coords2 = toCoords(input2);
		while(coords2 == null){
			System.out.println("You must enter cordinates of the form:\n <row>,<col>" + "\n<row> and <col> should be integers.");
			input2 = CaveExplorer.in.nextLine();
			coords2 = toCoords(input2);
		}
		return coords2;
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
		for(int i = 0;i<arr.length;i++) {
			swap(arr,(int)(Math.random()*arr.length), (int)(Math.random()*arr.length));
		}

	}
	
	private void swap(int[] arr, int i, int j) {
		int x = arr[j];
		arr[j] = arr[i];
		arr[i] = x;

	}

}
