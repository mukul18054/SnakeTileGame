package assignment5;

import static org.junit.Assert.*;

import java.io.IOException;
import assignment5.Game.*;
import org.junit.Test;

//import assignment5.Game.SnakeBiteException;
//import assignment5.Game.tiles;
import assignment5.Game.*;

public class ver2GameTest {
	Game g=new Game();
	@Test(expected = IOException.class)
	public void testSBE() throws Exception, IOException {
	gamePlay gp=g.new gamePlay(0);
	gp.setName("abc.txt");
//	gp.startGame();
	
	gp.serialize();
	}
	
}

