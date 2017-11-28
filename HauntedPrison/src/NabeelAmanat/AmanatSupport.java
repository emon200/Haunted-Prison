package NabeelAmanat;

public interface AmanatSupport {

	AmanatNabeelPlot[][] getPlots();

	boolean checkIfInputValid(int x);

	AmanatNabeelPlot[][] getAIPlots();

	void gameStart();

	boolean isThereShip(int row, int col);

	boolean isThereAIShip(int row, int col);

}
