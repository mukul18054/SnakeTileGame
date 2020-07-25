package assignment5;

import static org.junit.Assert.*;

import org.junit.Test;

//import assignment5.Game.SnakeBiteException;
//import assignment5.Game.tiles;
import assignment5.Game.*;

public class ver1GameTest {
	Game g=new Game();
	@Test(expected = SnakeBiteException.class)
	public void testSBE() throws Exception {
	tiles t= g.new snake();
	t.shakeMe();
	}
	@Test(expected = VultureBiteException.class)
	public void testVBE() throws Exception {
	tiles t= g.new vulture();
	t.shakeMe();
	}
	@Test(expected = CricketBiteException.class)
	public void testCBE() throws Exception {
	tiles t= g.new cricket();
	t.shakeMe();
	}
	@Test(expected = TrampolineException.class)
	public void testTE() throws Exception {
	tiles t= g.new trampoline();
	t.shakeMe();
	}
	@Test(expected = gameWinnerException.class)
	public void testGWE() throws Exception {
	gamePlay t= g.new gamePlay(100);
//	t.shakeMe();
	t.printWin(10);
	}
}

