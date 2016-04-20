package escapeFromCollege;
/**
 * This is a class to test the creation of a game map using HashMap
 * @author Matthew
 */
import java.util.Scanner;


public class GameMap {
	
	private Room currentRoom;
	
	/**
	 * TODO able to traverse map...
	 * utilize getShortDescription
	 * link to parser
	 * 
	 */
	public GameMap() {
		generateMap();
	}
	
	private void generateMap(){
		
		Room courtyard, scienceBuilding, hallway, computerLab, classroom101, classroom102, classroom103, misOffice, stairs,
			hallwayFloorTwo, classroom201, classroom202, classroom203, classroom204;
		
		//initialize rooms
		courtyard = new Room("in the Courtyard.");
		scienceBuilding = new Room("in the lobby of the science building.");
		hallway = new Room("in a hall way, you see a few different rooms...");
		computerLab = new Room("in a room full of computers, they seem kind of old...");
		classroom101 = new Room("in a classroom.");
		classroom102 = new Room("in a classroom.");
		classroom103 = new Room("in a classroom?");
		misOffice = new Room("SHINE BRIGHT LIKE A JORAH!");
		stairs = new Room("in the stairwell.");
		hallwayFloorTwo = new Room("in the second floor hallway. You see some more classrooms...");
		classroom201 = new Room("-EXCUSE ME! There's a class in here!!! GTFO!");
		classroom202 = new Room("in an empty classroom...maybe...");
		classroom203 = new Room("in a science lab, whats that smell?");
		classroom204 = new Room("in an empty classroom.");
		
		/**
		 * set exits for objects, connects map.
		 */
		courtyard.setExit("frontDoor", scienceBuilding);
		scienceBuilding.setExit("frontDoor", courtyard);
		scienceBuilding.setExit("hallwayFloor1", hallway);
		
		hallway.setExit("101", classroom101);
		hallway.setExit("102", classroom102);
		hallway.setExit("103", classroom103);
		hallway.setExit("computerLab", computerLab);
		hallway.setExit("MIS", misOffice);
		hallway.setExit("Stairwell", stairs);
		
		classroom101.setExit("Door", hallway);
		
		classroom102.setExit("Door", hallway);
		
		classroom103.setExit("Door", hallway);
		
		computerLab.setExit("Door", hallway);
		
		misOffice.setExit("Door", hallway);
		
		stairs.setExit("hallwayFloor1", hallway);
		stairs.setExit("hallwayFloor2", hallwayFloorTwo);
		
		hallwayFloorTwo.setExit("Stairwell", stairs);
		hallwayFloorTwo.setExit("201", classroom201);
		hallwayFloorTwo.setExit("202", classroom202);
		hallwayFloorTwo.setExit("203", classroom203);
		hallwayFloorTwo.setExit("204", classroom204);
		
		classroom201.setExit("Door", hallwayFloorTwo);
		
		classroom202.setExit("Door", hallwayFloorTwo);
		
		classroom203.setExit("Door", hallwayFloorTwo);
		
		classroom204.setExit("Door", hallwayFloorTwo);
		
		//cursor
		currentRoom = courtyard;
	}
	
	/**
	 * the ugly play loop for now
	 * contains all commands currently
	 */
	
	public void play(){
		printWelcome();
		
		boolean finished = false;
		Scanner scanner = new Scanner(System.in);
		
		while (! finished){
			System.out.println("Type an Exit:");
			String direction = scanner.next();
			
			if (direction.equals("quit")) {
				finished = true;
			}
			else if (direction.equals("Door")){
				goRoom(direction);
			}
			else if (direction.equals("frontDoor")){
				goRoom(direction);
			}
			else if (direction.equals("hallwayFloor1")){
				goRoom(direction);
			}
			else if (direction.equals("101")){
				goRoom(direction);
			}
			else if (direction.equals("102")){
				goRoom(direction);
			}
			else if (direction.equals("103")){
				goRoom(direction);
			}
			else if (direction.equals("MIS")){
				goRoom(direction);
			}
			else if (direction.equals("Stairwell")){
				goRoom(direction);
			}
			else if (direction.equals("hallwayFloor2")){
				goRoom(direction);
			}
			else if (direction.equals("201")){
				goRoom(direction);
			}
			else if (direction.equals("202")){
				goRoom(direction);
			}
			else if (direction.equals("203")){
				goRoom(direction);
			}
			else if (direction.equals("204")){
				goRoom(direction);
			}
			else {
				goRoom(direction);
				System.out.println("...dumbass.");
			}
		}
		System.out.println("Goodbye.");
		scanner.close();
			
	}
	
	
	public String printWelcome() {
		String welcome = "Welcome to HELL!!!!!!!!!!\nJust kidding! Welcome to College!\n"
				+ "just type where you want to go to get around!\nTo exit the game type 'quit'"
				+ currentRoom.getLongDescription();
		return welcome;
	}
	
	/*private void getCommands(){
		//Parser will be used here eventually...
		
	}*/
	
	public void goRoom(String direction){
		
		//will replace with command parsing eventually
		
		Room nextRoom = currentRoom.getExit(direction);
		
		if (nextRoom == null){
			System.out.println("You can't go that way");
		}
		
		else {
			currentRoom = nextRoom;
			System.out.println(currentRoom.getLongDescription());
		}
	}

}
