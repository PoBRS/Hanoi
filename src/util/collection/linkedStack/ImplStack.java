package util.collection.linkedStack;

import util.collection.Stack;

/**
 * Stack fait à l'aide de noeuds.
 * 
 * @author Raphaël Sylvain
 * @author Pierre-Olivier Boulet
 * 
 * @since 26/09/2013
 * 
 * @see util.collection.Stack.Java
 * 
 */

public class ImplStack extends Stack
{
	Node firstNode;
	
	public ImplStack()
	{
		this.firstNode = null;
	}
	
	@Override
	public Object Push(Object element)
	{
		Node newNode = new Node(element, this.firstNode);
		this.firstNode = newNode;
		this.size++;
		return element;

	}
	
	@Override 
	public Object Pop()
	{
		Object returnedObject = null;
		
		// The stack is empty if firstNode == null.
		if (this.firstNode != null)
		{
			returnedObject = this.firstNode.GetCurrent();
			this.firstNode = this.firstNode.GetPrevious();
			this.size--;
		}
		
		return returnedObject;
	}
	
	@Override
	public boolean IsEmpty()
	{
		if (this.firstNode == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public void Clear()
	{
		this.firstNode = null;
		this.size = 0;
	}
	
	@Override
	public Object Peek()
	{
		if (this.firstNode == null)
		{
			return null;
		}
		else
		{
			return this.firstNode.GetCurrent(); 
		}
	}
	
	@Override
	public int Search(Object element)
	{
		int counter = 0;
		
		Node checkerNode = this.firstNode;
		
		while (checkerNode != null && checkerNode.GetCurrent() != element)
		{
			checkerNode = checkerNode.GetPrevious();
			counter++;	
		}
		
		if (checkerNode == null)
		{
			counter = -1;
		}
		return counter;
		
		
		
		
	}
	
	@Override
	public Object Get(int position)
	{
		if (position < 0)
		{
			return null;
		}
		else
		{
			Node checkerNode = this.firstNode;
			
			for (int i = 0; i < position && checkerNode != null; i++)
			{
				checkerNode = checkerNode.GetPrevious();
			}
			
			if (checkerNode == null)
			{
				return null;
			}
			else
			{
				return checkerNode.GetCurrent();
			}
		}
	}
	
	@Override
	public String ToString()
	{
		return "";
	}
}
