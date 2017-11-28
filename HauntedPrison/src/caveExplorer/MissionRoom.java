package caveExplorer;

public class MissionRoom extends CaveRoom {
	private static String input;
	public MissionRoom(String description) {
		super(description);
		System.out.println("PRISON ESCAPE");
		System.out.println("Objective: Escape the Prison.");
		System.out.println("Who: You play as the latest Prisoner");
		System.out.println("How: You need to beat the two gaurds and get their keys \n then make it the location marked A on the map");
		System.out.println("What will you name yourself?");
		input = CaveExplorer.in.nextLine();
		//For Mr.Nockles, required to raise Nabeels grade for Chatbot project
		System.out.println("Good to meet you "+ input);
		nextSteps();
	}
	public void nextSteps() {
		System.out.println("Which way do you want to go, South(s) or West(d)?");
		String dir = CaveExplorer.in.nextLine();
		interpretInput(dir);
	}
	public static String getInput() {
		return input; 
	}

}
