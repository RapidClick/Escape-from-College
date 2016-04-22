package escapeFromCollege;

import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.String;

/**
 * Game Map 2.0 This is a more modular design of the game map
 * 
 * @author Matthew
 * 
 * TODO 
 * error checking for commands, char counter
 * limit movement through map
 * 
 */


public class GameMap2 {
	
	private Room2 currentRoom;
	private HashMap<String, Room2> campus = new HashMap<String, Room2>();
	
	public GameMap2() {
		generateMap();
	}
	
	private void generateMap(){
			
			Room2 courtyard, scienceBuilding, hallwayFloorOne, computerLab, classroom101, classroom102, classroom103, misOffice, stairs,
				hallwayFloorTwo, classroom201, classroom202, classroom203, classroom204;
			
			//initialize rooms
			courtyard = new Room2("Courtyard","in the Courtyard.");
			scienceBuilding = new Room2("Science Building", "in the lobby of the science building.");
			hallwayFloorOne = new Room2("First Floor Hallway","in a hall way, you see a few different rooms...");
			computerLab = new Room2("Computer Lab","in a room full of computers, they seem kind of old...");
			classroom101 = new Room2("Classroom 101","in a classroom.");
			classroom102 = new Room2("Classroom 102","in a classroom.");
			classroom103 = new Room2("Classroom 103","in a classroom?");
			misOffice = new Room2("MIS Office","SHINE BRIGHT LIKE A JORAH!");
			stairs = new Room2("Stairwell","in the stairwell.");
			hallwayFloorTwo = new Room2("Second Floor Hallway","in the second floor hallway. You see some more classrooms...");
			classroom201 = new Room2("Classroom 201","-EXCUSE ME! There's a class in here!!! GTFO!");
			classroom202 = new Room2("Classroom 202","in an empty classroom...maybe...");
			classroom203 = new Room2("Classroom 203","in a science lab, whats that smell?");
			classroom204 = new Room2("Classroom 203","in an empty classroom.");
			
			campus.put(courtyard.getRoomID(), courtyard);
			campus.put(scienceBuilding.getRoomID(), scienceBuilding);
			campus.put(hallwayFloorOne.getRoomID(), hallwayFloorOne);
			campus.put(computerLab.getRoomID(), computerLab);
			campus.put(classroom101.getRoomID(), classroom101);
			campus.put(classroom102.getRoomID(), classroom102);
			campus.put(classroom103.getRoomID(), classroom103);
			campus.put(misOffice.getRoomID(), misOffice);
			campus.put(stairs.getRoomID(), stairs);
			campus.put(hallwayFloorTwo.getRoomID(), hallwayFloorTwo);
			campus.put(classroom201.getRoomID(), classroom201);
			campus.put(classroom202.getRoomID(), classroom202);
			campus.put(classroom203.getRoomID(), classroom203);
			campus.put(classroom204.getRoomID(), classroom204);
			
			//cursor
			currentRoom = courtyard;
	}
	
	public void play(){
		
		Scanner scanner = new Scanner(System.in);
		boolean finished = false;
		
		System.out.println(printWelcome());
		
		while (! finished) {
			System.out.println("Where do you want to go?");
			String command = scanner.nextLine();
			
			if (command.equals("quit")){
				finished = true;
			}
			else if (command.equals("Science Building")){
				goRoom(command);
			}
			else if (command.equals("Courtyard")){
				goRoom(command);
			}
			else if (command.equals("First Floor Hallway")){
				goRoom(command);
			}
			else if (command.equals("Computer Lab")){
				goRoom(command);
			}
			else if (command.equals("Classroom 101")){
				goRoom(command);
			}
			else if (command.equals("Classroom 102")){
				goRoom(command);
			}
			else if (command.equals("Classroom 103")){
				goRoom(command);
			}
			else if (command.equals("MIS Office")){
				goRoom(command);
			}
			else if (command.equals("Stairwell")){
				goRoom(command);
			}
			else if (command.equals("Second Floor Hallway")){
				goRoom(command);
			}
			else if (command.equals("Classroom 201")){
				goRoom(command);
			}
			else if (command.equals("Classroom 202")){
				goRoom(command);
			}
			else if (command.equals("Classroom 203")){
				goRoom(command);
			}
			else if (command.equals("Classroom 204")){
				goRoom(command);
			}
			else {
				System.out.println("Que?");
			}	
		}
		System.out.println("Goodbye!");
		scanner.close();	
		
		
	}
	/**
	 * 
	 * @return the welcome string for a new game.
	 */
	
	public String printWelcome() {
		String welcome = "Welcome to HELL!!!!!!!!!!\nJust kidding! Welcome to College!\n"
				+ "just type where you want to go to get around!\nTo exit the game type 'quit'"
				+ currentRoom.getLongDescription();
		return welcome;
	}
	
	/**
	 * 
	 * @param commandIn
	 */
	
	public void goRoom(String commandIn){
		
		Room2 nextRoom = campus.get(commandIn);
		currentRoom = nextRoom;
		System.out.println(currentRoom.getLongDescription());
	}

}
