package util.collection.test;

import util.collection.arrayStack.ImplStack;
//import util.collection.linkedStack.ImplStack;

import org.junit.Assert;
import org.junit.Test;

public class StackTest{	
	
	@Test
	// Check if the constructor has correctly initialize the stack
	public void testImplStack() 
	{
		ImplStack myStack = new ImplStack();
		Assert.assertNotNull(myStack);
		Assert.assertTrue(myStack.IsEmpty());
		Assert.assertEquals(0, myStack.Size());
	}
	
	@Test
	// Adding an element to the stack.
	public void testPush() 
	{	
		//Create a new stack of objects
		ImplStack stackTest = new ImplStack();
		
		//Create two instances of object		
		Object item1 = new Object();
		Object item2 = new Object();
		
		//Check if the first element of the stack is my new pushed object
		Assert.assertEquals(item1, stackTest.Push(item1));
				
		// Check if my stack has now the second instance on top	
		Assert.assertEquals(item2, stackTest.Push(item2));
		
		// If the paramter to push is null, the pushed element will not be pushed and the return value is null.
		Assert.assertNull(stackTest.Push(null));
	}
	
	@Test
	// Removing an element from the stack.
	public void testPop() 
	{
		ImplStack stackTest = new ImplStack();
		Object item1 = new Object();
		Object item2 = new Object();
		Object item3 = new Object();
		
		//Empty stack -> Cannot pop.
		Assert.assertNull(stackTest.Pop());
		
		//One element -> First element should be removed.
		stackTest.Push(item1);
		Assert.assertEquals(item1, stackTest.Pop());	
		
		//Multiple elements -> First element should be removed.
		stackTest.Push(item1);
		stackTest.Push(item2);
		stackTest.Push(item3);
		Assert.assertEquals(item3, stackTest.Pop());
	}

	@Test
	// Comparing the size of the stack.
	public void testSize() 
	{
		ImplStack stackTest = new ImplStack();
		Object item1 = new Object();
		
		//Empty stack
		Assert.assertEquals(0, stackTest.Size());
		
		//One element
		stackTest.Push(item1);
		Assert.assertEquals(1, stackTest.Size());
	}

	@Test
	// Checking if the stack is empty.
	public void testIsEmpty() 
	{
		ImplStack stackTest = new ImplStack();
		Object item1 = new Object();
		
		//Empty stack
		Assert.assertTrue(stackTest.IsEmpty());
		
		//One element
		stackTest.Push(item1);
		Assert.assertFalse(stackTest.IsEmpty());
	}

	@Test
	// Removing every element from the stack.
	public void testClear() 
	{

		ImplStack stackTest = new ImplStack();		
		Object item1 = new Object();
		Object item2 = new Object();
		
		stackTest.Push(item1);
		stackTest.Push(item2);
		stackTest.Clear();
		
		Assert.assertEquals(0, stackTest.Size());
		
	}

	@Test
	// Checking if the first element of the stack matches the last item added.
	public void testPeek() 
	{
		ImplStack stackTest = new ImplStack();		
		Object item1 = new Object();
		Object item2 = new Object();
		
		Assert.assertNull(stackTest.Peek());
		
		stackTest.Push(item1);
		stackTest.Push(item2);
		
		Assert.assertEquals(item2, stackTest.Peek());
	}

	@Test
	// Checking if the element is located on the correct position.
	public void testSearch() 
	{
		ImplStack stackTest = new ImplStack();		
		Object item1 = new Object();
		Object item2 = new Object();
		Object item3 = new Object();
		
		stackTest.Push(item1);
		stackTest.Push(item2);
		
		Assert.assertEquals(1, stackTest.Search(item1));
		Assert.assertEquals(-1, stackTest.Search(item3));
	}
	@Test
	// Checking if the position is what it's supposed to be.
	public void testGet() 
	{
		ImplStack stackTest = new ImplStack();		
		Object item1 = new Object();
		Object item2 = new Object();
		
		stackTest.Push(item1);
		stackTest.Push(item2);
		
		Assert.assertEquals(item1, stackTest.Get(1));
		Assert.assertEquals(item2 , stackTest.Get(0));
		Assert.assertNull(stackTest.Get(-1));
		Assert.assertNull(stackTest.Get(3));
	}
	

	@Test
	// Checking if the string created represents the object added.
	public void testToString() 
	{
		ImplStack stackTest = new ImplStack();		
		Object item1 = new Object();
		Object item2 = new Object();
		
		Assert.assertEquals("", stackTest.ToString());
		
		stackTest.Push(item1);
		stackTest.Push(item2);
		
		Assert.assertEquals("", stackTest.ToString());
	}
}
