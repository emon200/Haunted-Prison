package DavidCarson;

public interface DavidSupport {
	/**
	 * returns the amount of times the user gets the wrong match
	 * @return
	 */
	int getFailures();
	
	int[] getCoordinates();
	
	
	/**
	 * reveals the value of the coordinate inputsx
	 * @param p
	 */
	void reveal(DavidCarsonChart p);

	DavidCarsonChart[][] getPlots();

	int[][] getCoordInput();

	boolean isMatch(int[] coords, int[] coords2);
}
