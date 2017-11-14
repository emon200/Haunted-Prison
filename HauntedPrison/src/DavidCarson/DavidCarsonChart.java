package DavidCarson;

public class DavidCarsonChart {

	private boolean revealed;
	private int row;
	private int col;
	private int value;
	
	public DavidCarsonChart(int row, int col, int value) {
		revealed = false;
		this.row = row;
		this.col = col;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void reveal(){
		revealed = true;
	}

	public boolean isRevealed() {
		return revealed;
	}

}
