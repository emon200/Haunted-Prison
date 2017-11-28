package caveExplorer;

public class Door {
	
	private boolean locked;
	private boolean open;
	private String description;
	private String details;

	public Door() {
		locked = false;
		open = true;
		description = "passage";
		details = "";
		
	}

	public Door(String string) {
		if(Inventory.getKeys() ==2) {
			locked =false;
			open =true;
			description ="This is the exit. YOU MADE IT. YAY!!!";
			details = "";
		}
		else {
			locked =true;
			open =false;
			description = "You don't have the two keys needed to exit. Go back and get them by defeating the Gaurds!";
			details = "";
		}
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
