package NabeelAmanat;

public class AmanatNabeelPlot {
	
	private int row;//d
	private int col;
	private boolean revealed;
	private boolean isShip;
	private boolean airevealed;
	private boolean isAIShip;
	
	public AmanatNabeelPlot(int row, int col) {
		revealed = false;
		airevealed = false;
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
	
	public void aireveal() {
		airevealed = true;
	}
	
	public boolean isAIRevealed() {
		return airevealed;
	}

	public boolean isShip() {
		return isShip;
	}
	
	public boolean isAIShip() {
		return isAIShip;
	}
	
	public void setisAIShip(boolean isAIShip) {
		this.isAIShip = isAIShip;
	}
	
	public void setisShip(boolean isShip) {
		this.isShip = isShip;
	}
}
