package hanoi.backend.test;

import hanoi.backend.*;
import org.junit.Assert;
import org.junit.Test;

public class GameTest 
{

	@Test
	public void ConstructorTest() 
	{
		// Game without enough discs
		Game notEnoughDiscs = new Game(1);
		Assert.assertEquals(notEnoughDiscs.GetNbDiscs(), 0);
		
		// Game with smallest disc number possible
		Game smallestGame = new Game(3);
		Assert.assertEquals(smallestGame.GetNbDiscs(), 3);
		
		// Game with biggest disc number possible
		Game biggestGame = new Game(64);
		Assert.assertEquals(biggestGame.GetNbDiscs(), 64);
		
		// Game with too many discs
		Game tooManyDiscs = new Game(69);
		Assert.assertEquals(tooManyDiscs.GetNbDiscs(), 0);
	}
	
	@Test
	public void MoveTest()
	{
		Game game = new Game(3);
		
		// Valid move
		Assert.assertTrue(game.Move(0, 2));
		
		// Invalid tower - inexistant tower
		Assert.assertFalse(game.Move(0, -1));
		
		// Invalid tower - same tower
		Assert.assertFalse(game.Move(0, 0));
		
		// Invalid move - bigger disc on smaller disc 
		Assert.assertFalse(game.Move(0, 2));
		
	}

	@Test
	public void IsCompletedTest()
	{
		Game game = new Game(3);
		
		// Incomplete tower
		Assert.assertFalse(game.IsCompleted());
		
		// Resolving the game...
		game.Move(0, 2);
		game.Move(0, 1);
		game.Move(2, 1);
		game.Move(0, 2);
		game.Move(1, 0);
		game.Move(1, 2);
		game.Move(0, 2);
		
		// Complete tower
		Assert.assertTrue(game.IsCompleted());

	}
	
	@Test
	public void GetNbDiscs()
	{
		Game game = new Game(5);
		Assert.assertEquals(5, game.GetNbDiscs());
		
	}
	
}
