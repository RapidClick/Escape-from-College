package commandParser;

public class Command {
	
	private Commands type;
	
	public enum Commands {
		ENTER, USE, GRAB, DROP, LOOK, UNCLEAR
	}
	
	public Command(Commands setType) {
		type = setType;
	}

}
