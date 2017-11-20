package NabeelAmanat;

public class AmanatNabeelPlot {
	
	private int row;//d
	private int col;
	private boolean revealed;
	private boolean isShip;
	
	public AmanatNabeelPlot(int row, int col) {
		revealed = false;
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void reveal() {
		revealed = true;
	}
	
	public boolean isRevealed() {
		return revealed;
	}
	
	public boolean isShip() {
		return isShip;
	}
	
	public void setisShip(boolean isShip) {
		this.isShip = isShip;
	}
}
