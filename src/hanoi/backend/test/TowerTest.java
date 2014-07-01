package hanoi.backend.test;

import org.junit.Assert;
import org.junit.Test;
import hanoi.backend.*;

public class TowerTest 
{

	@Test
	public void ConstructorTest() 
	{
		// Constructor with zero element
		Tower towerZero = new Tower(0);
		Assert.assertEquals(0, towerZero.GetStack().Size());
		
		// Constructor with three elements
		Tower towerThree = new Tower(3);
		Assert.assertEquals(3, towerThree.GetStack().Size());
		
		// Constructor with sixty-four elements
		Tower towerSixtyFour = new Tower(64);
		Assert.assertEquals(towerSixtyFour.GetStack().Size(), 64);

		// Constructor with minus one element
		Tower towerMinusOne = new Tower(-1);
		Assert.assertNull(towerMinusOne.GetStack().Peek());
		
		// Constructor with sixty-five elements
		Tower towerSixtyFive = new Tower(65);
		Assert.assertNull(towerSixtyFive.GetStack().Peek());

	}
	
	@Test 
	public void IsCompletedTest()
	{
		
		// Yes
		Tower completeTower = new Tower(5);
		Assert.assertTrue(completeTower.IsCompleted(5));
		
		// No
		Tower incompleteTower = new Tower(3);
		Assert.assertFalse(incompleteTower.IsCompleted(5));
		
	}
	
	@Test
	public void PushTest()
	{
		Disc smallDisc = new Disc(1, 1);
		Disc bigDisc = new Disc(5,5);
		Tower firstTower = new Tower(0);
		Tower secondTower = new Tower(0);
		
		// Push on empty tower
		Assert.assertEquals(smallDisc, firstTower.Push(smallDisc));
		
		// Impossibility to push a bigger disc
		Assert.assertNull(firstTower.Push(bigDisc));
		
		// Can push a smaller disc
		secondTower.Push(bigDisc);
		Assert.assertEquals(smallDisc, secondTower.Push(smallDisc));
	
	}
	
	
}

