package escapeFromCollege;
import java.io.File;

public class TestDriverGMap {
	
	public static void main(String[] args){
		File save = new File("Save1");
		GameMap2 g = new GameMap2();
		//GUI gooey = new GUI(save, g);
		g.play();
		
	}
}