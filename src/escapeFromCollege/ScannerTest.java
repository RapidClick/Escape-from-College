package escapeFromCollege;

import java.util.Scanner;


public class ScannerTest {
	
	private Scanner scanner = new Scanner(System.in);

	public void play() {
		
		boolean finished = false;
		
		while (! finished){
			System.out.println("Type a command:");
			String command = scanner.next();
			
			if (command.equals("quit")) {
				finished = true;
			}
		}
		System.out.println("Goodbye.");
	}
	
	public static void main (String[] args){
		
		ScannerTest g;
		g = new ScannerTest();
		g.play();
		
	}

}
