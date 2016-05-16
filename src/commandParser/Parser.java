package commandParser;

import commandParser.Command.Commands;

public class Parser {
	
	//TODO add a place where commands should be sent as a parameter?
	public Parser() {
	}
	
	public Command Parse(String toParse) {
		Command toReturn = null;
		toParse.trim();
		toParse.toLowerCase();
		if (toParse.contains("enter")) {
			int start = toParse.indexOf("enter");
			String subStr = toParse.substring(start, toParse.length());
			//TODO change door to a list of available things to enter
			if (subStr.contains("door")) {
				 toReturn = new Command(Commands.ENTER);
			} else {
				toReturn = new Command(Commands.UNCLEAR);
			}
		} else if (toParse.contains("use")) {
			int start = toParse.indexOf("use");
			String subStr = toParse.substring(start, toParse.length());
			//TODO change to be more generic
			if (subStr.contains("switch")) {
				toReturn = new Command(Commands.USE);
			} else {
				toReturn = new Command(Commands.UNCLEAR);
			}
		} else if (toParse.contains("grab")) {
			int start = toParse.indexOf("grab");
			String subStr = toParse.substring(start, toParse.length());
			//TODO change to be more generic
			if (subStr.contains("item")) {
				toReturn = new Command(Commands.GRAB);
			} else {
				toReturn = new Command(Commands.UNCLEAR);
			}
		}
		return toReturn;
	}

}
