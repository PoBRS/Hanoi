package util.collection.test;

import org.junit.Assert;
import org.junit.Test;
import util.collection.linkedStack.Node;

public class NodeTest 
{
	
	@Test
	public void ConstructorTest()
	{
		
		Object emptyObject = new Object();	
		
		// Null Node
		Node nullNode =  new Node(null, null);
		Assert.assertNotNull(nullNode);
				
		// First Node 
		Node nodeEmptyObject = new Node(emptyObject, null);
		Assert.assertNotNull(nodeEmptyObject);
		
		// Node valid previous
		Node nodeValidPrevious = new Node(emptyObject, nodeEmptyObject);
		Assert.assertNotNull(nodeValidPrevious);
		
		// Node invalid previous
		//Node nodeInvalidPrevious = new Node(emptyObject, "Feu à volonté, bande de trou du cul!!");
		//Assert.assertNull(nodeInvalidPrevious);
	}
	
	@Test
	public void GetPreviousTest()
	{
		
		Object emptyObject = new Object();
		
		// Node Previous Null
		Node firstNode = new Node(emptyObject, null);
		Assert.assertNull(firstNode.GetPrevious());;
		
		// Node Previous Node
		Node secondNode = new Node(emptyObject, firstNode);
		Assert.assertEquals(firstNode, secondNode.GetPrevious());;
		
	}
	
	@Test
	public void GetCurrentTest()
	{
		Object emptyObject = new Object();
		Node node = new Node(emptyObject, null);
		Assert.assertEquals(emptyObject, node.GetCurrent());
	}
	
	@Test
	public void SetCurrentTest()
	{
		Object emptyObject = new Object();
		Node node = new Node(null, null);
		Assert.assertTrue(node.SetCurrent(emptyObject));
	}
}
