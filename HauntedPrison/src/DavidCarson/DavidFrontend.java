package DavidCarson;

public class DavidFrontend implements CarsonSupport {

	private DavidSupport backend;
	public DavidFrontend() {
		backend = new CarsonBackend(this);
	}

	public static void main(String[] args) {
		DavidFrontend demo = new DavidFrontend();
		

	}

}
