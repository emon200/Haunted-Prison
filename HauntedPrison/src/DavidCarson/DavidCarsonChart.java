package DavidCarson;

public class DavidCarsonChart {

	private boolean revealed;
	private int row;
	private int col;
	private int value;
	private boolean matched;
	private boolean hasBomb;
	
	public boolean isHasBomb() {
		return hasBomb;
	}

	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}

	public DavidCarsonChart(int row, int col, int value) {
		revealed = false;
		matched = false;
		this.row = row;
		this.col = col;
		this.value = value;
	}
	
	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
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
