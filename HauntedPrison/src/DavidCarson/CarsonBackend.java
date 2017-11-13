package DavidCarson;

public class CarsonBackend implements DavidSupport {
	  private CarsonSupport frontend;
	

	public CarsonBackend(CarsonSupport frontend) {
		this.frontend = frontend;
	}

}
