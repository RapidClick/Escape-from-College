package escapeFromCollege;

import java.util.Set;
import java.util.HashMap;
import java.lang.String;

/**
 * This is the room/node object that will populate the map.
 * 
 * @author: Matthew Lavranchuk
 * 
 * TODO attatch getLongDescription to Look command
 */

public class Room {
	
	private String description, roomID;
	private HashMap<String, Room> campus;
	
	/**
	 * @param description: gives current room's description
	 */
	
	public Room(String roomIDIn, String description) {
		this.roomID = roomIDIn;
		this.description = description;
		campus = new HashMap<String, Room>();
		
	}
	
	/**
	 * define exits from this room
	 * @param direction: direction of the the exits 
	 * @param neigbor: the room to which that exit leads 
	 */
	
	public void setExit (String roomID , Room neigbor){
		campus.put(roomID , neigbor);
	}
	
	/**
	 * @return short description of room when first entering
	 */
	
	public String getShortDescription(){
		return description;
	}
	
	/**
	 * @return long description of room after player searches
	 */
	
	public String getLongDescription(){
		return "You Are " + description + ".\n" + getExitString();
	}
	
	/**
	 * @return name of Room
	 */
	public String getRoomID() {
		return roomID;
	}
	
	/**
	 * @return a string that lists room exits
	 */
	
	private String getExitString(){
		String returnString = "Exits:";
		Set<String> keys = campus.keySet();
		for (String exit : keys){
			returnString += " " + exit;
		}
		
		return returnString;
	}
	
	/**
	 * return the room that is reached from this room if we go in direction "direction" 
	 * if there is no room in this direction return null
	 * @param direction The exit's direction
	 * @return The room in the given direction
	 */
	public Room getExit(String roomID) {
		return campus.get(roomID);
	}
}
