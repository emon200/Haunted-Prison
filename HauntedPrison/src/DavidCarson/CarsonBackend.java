package DavidCarson;

public class CarsonBackend implements DavidSupport {
	
	private CarsonSupport frontend;
	
	public CarsonBackend(CarsonSupport frontend) {
		this.frontend = frontend;
	}

	public int getFailures() {
		return 0;
	}

	public int[] getCoordinates() {
		return null;
	}

	public void reveal(DavidCarsonChart p) {
		
	}

}
