package test.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.model.Player;

class PlayerTest {
	
	Player player = new Player("test");

	@Test
	void testGetName() {
		assertEquals(player.getName(), "test");
	}
	
	@Test
	void testSetName() {
		player.setName("test2");
		assertEquals(player.getName(), "test2");
	}

}
