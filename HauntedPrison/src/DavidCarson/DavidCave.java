package DavidCarson;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DavidCave extends CaveRoom {


	boolean visited;
	private String activeDescription;
	private String inactiveDescription;
	private int check;
	private boolean chatting;
	int min =0;
	int max = 999;
	private String [] numbers = {"0","1","2","3","4","5","6","7","8","9"};
	int rand = (int) (Math.random()*999);
	public DavidCave(String description) {
		super(description);
		this.activeDescription = "On the corner you see the med-bay where prisoners would be brought for treatment after their usual scuffles...";
		this.inactiveDescription = "This is where the med-bay is located...";
		this.visited = false;
	}
	public String validKeys() {
		return "wdsae";
				
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w','a','s', or'd' to move or"
				+ "you can type 'e' to interact ");
	}
	
	public void performAction(int direction) {
		//super.performAction(direction);
		if(direction == 4) {
			if(visited == false) {
				interact();
			}
			else {
				CaveExplorer.print("There is nothing to interact with right now");
			}
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	private void interact() {
			CaveExplorer.print("Inside the room, you notice a spare med-kit locked inside a small safe. The safe is a 3 digit lock. Won't hurt to try and guess the combination ");
			String s = CaveExplorer.in.nextLine();
			while(!checkNumber(s)) {
				CaveExplorer.print("Invalid Input!!!!");
				s= CaveExplorer.in.nextLine();
			}
				chatting = true;
				check = 0;
			while(chatting) {
				int x = Integer.parseInt(s);
				if(checkNumber(s)) {
					//System.out.println(rand);
					if(x>rand) {
						CaveExplorer.print("Too high");
						if(x<max) {
							setMax(x);
						}
						CaveExplorer.print("The safe code is between "+min+" and "+max);
						check++;
						s = CaveExplorer.in.nextLine();
					}else {
						if(x<rand) {
						CaveExplorer.print("Too low");
						if(x>min) {
							setMin(x);
						}
						CaveExplorer.print("The safe code is between "+min+" and "+max);
						check++;
						s = CaveExplorer.in.nextLine();
						}
						else {
							if(x==rand) {
							CaveExplorer.print("You hear a click and the safe cracks open...");
							CaveExplorer.print("You bandaged your wounds with the med kit and feel much better...");
						    CaveExplorer.inventory.setHp(100);
						    visited = true;
						    chatting = false;
							}
						}
					}
					}
				if(check >10) {
				  CaveExplorer.print("You hear beeping and notice the lock has enter a fail-safe mode. Guess it won't take anymore entries.");
				  visited = true;
				  chatting = false;
				  
				}
			
			}

		    
	}
	public String getContents() {
		if(!visited) {
			return "F";
		}else {
			//return what would've been returned otherwise
			return super.getContents();
		}
	}

	public String getDescription() {
		if(visited == false) {
			return super.getDescription() + "\n"+getActiveDescription();
		}else {
			String npcDesc = "";
				npcDesc = getInactiveDescription();
				return super.getDescription() + "\n" + npcDesc;
			
		}
	}
	public String getInactiveDescription() {
		return inactiveDescription;
	}
	public String getActiveDescription() {
		return activeDescription;
	}
    public boolean checkNumber(String response)
    {
      
	  for(int i =0;i<numbers.length;i++) 
		  {
			  if(response.contains(numbers[i])) {
			  return true;
			  }   
      
		  
		 }
		  return false;
    }
	public void setMin(int min) {
		this.min = min;
	}
	public void setMax(int max) {
		this.max = max;
	}

}
