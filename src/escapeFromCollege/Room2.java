package escapeFromCollege;

import java.lang.String;

public class Room2 {
	
	private String description, roomID;
	
	/**
	 * 
	 * @param roomIDIn
	 * @param description
	 */
	public Room2(String roomIDIn, String description) {
		this.roomID = roomIDIn;
		this.description = description;
	}
	
	/**
	 * 
	 * @return description of room
	 */
	
	public String getShortDescription(){
		return description;
	}
	
	/**
	 * 
	 * @return long description of room
	 */
	
	public String getLongDescription() {
		return "You Are " + description + ".\n";
	}
	
	/**
	 * 
	 * @return name of room
	 */
	
	public String getRoomID() {
		return roomID;
	}
	

}
