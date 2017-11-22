package DavidCarson;

public class Intro {

	public Intro() {
	}
	
	public void play(){
		displayGameScreen();
	}

	private void displayGameScreen() {
		String message = "Memory Game\n";
		for(int i = 0 ; i < message.length(); i++){
			System.out.print(message.substring(i, i+1));
			pause(100);
		}
		System.out.println("\nAre you ready to get started? If so, enter 'p' to begin or enter'r' for info  ");
	}

	public static void pause(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
