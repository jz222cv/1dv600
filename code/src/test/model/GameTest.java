package test.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.model.Game;

class GameTest {
	
	Game game = new Game("test");

	@Test
	void testGetPlayer() {
		assertSame(game.getPlayer().getName(), "test");
	}
	
	@Test
	void testSetPlayer() {
		game.setPlayer("test2");
		assertEquals(game.getPlayer().getName(), "test2");
	}
	
	@Test
	void testSetWord() {
		game.setWord();
		assertEquals(game.getWord().length(), game.getGuessed().length());
		for(int i=0; i<game.getGuessed().length(); i++) {
			assertEquals(game.getGuessed().substring(i, i+1), "_");
		}
	}
	
	@Test
	void testSetAndGetWord() {
		game.setWord("a");
		assertEquals(game.getWord(), "a");
	}
	
	@Test
	void testGuess() {
		game.setWord("test");
		game.setGuessed("____");
		assertTrue(game.guess("e"));
		assertFalse(game.guess("a"));
	}
	
	@Test
	void testSetGuessed() {
		game.setGuessed("____");
		assertEquals(game.getGuessed(), "____");
	}
	
	@Test
	void testGetGuessed() {
		game.setGuessed("___a_");
		assertEquals(game.getGuessed(), "___a_");
	}
	
	@Test
	void testCheckWin() {
		game.setGuessed("win");
		assertTrue(game.checkWin());
	}
	
	@Test
	void testSaveAndDeleteAndLoad() {
		game.save("test", "pear", "__ar", 3, 2);
		String[] data = {"test", "pear", "__ar", "3", "2"};
		for(int i=0; i<data.length; i++) {
			assertEquals(game.load()[i], data[i]);
		}
		game.delete();
		assertEquals(game.load(), null);
	}
	
}
