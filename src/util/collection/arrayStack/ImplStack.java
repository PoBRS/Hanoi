package util.collection.arrayStack;

import util.collection.Stack;

/**
 * Stack fait à l'aide de tableau dynamique.
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
	private Object[] arrayStack = new Object[0];
	
	@Override
	public Object Push(Object element)
	{
		// We create a temporary array with a superior size of one.
		Object[] tempArrayStack = new Object[this.arrayStack.length + 1];
		
		// We copy the array to the temporary array, leaving the first place empty.
		System.arraycopy(this.arrayStack, 0, tempArrayStack, 1, this.arrayStack.length);
		// We add the element at the first place.
		tempArrayStack[0] = element;
		
		// We replace the old array with the new array.
		this.arrayStack = tempArrayStack;
		
		this.size++;
		
		return element;
	}
	
	@Override 
	public Object Pop()
	{
		Object returnedObject = null;
		
		if (this.arrayStack.length > 0)
		{
			// Since we can pop an object, we store the popped element.
			returnedObject = this.arrayStack[0];
			
			// We create a temporary array with an inferior size of one.
			Object[] tempArrayStack = new Object[this.arrayStack.length - 1];
			
			
			// We copy the array to the temporary array, starting at the second element.
			if (this.arrayStack.length > 1)
			{
				System.arraycopy(this.arrayStack, 1, tempArrayStack, 0, this.arrayStack.length - 1);
			}
		
			// We replace the old array with the new array.
			this.arrayStack = tempArrayStack;
			
			this.size--;
		}
		
		return returnedObject;
	}
	
	@Override
	public boolean IsEmpty()
	{
		if (this.arrayStack.length > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	@Override
	public void Clear()
	{
		// We overwrite the old array with a new empty array.
		this.arrayStack = new Object[0];
		
		this.size = 0;
	}
	
	@Override
	public Object Peek()
	{
		if (this.Size() > 0)
		{
			return this.arrayStack[0]; 
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public int Search(Object element)
	{
		
		for (int i = 0; i < this.arrayStack.length; i++)
		{
			if (Get(i) == element)
			{
				return i;
			}
		}
		
		// Object not found.
		return -1;
	}
	
	@Override
	public Object Get(int position)
	{
		Object returnedObject = null;
		
		if (this.arrayStack.length > 0 && this.arrayStack.length - 1 >= position && position >= 0)
		{
			returnedObject = this.arrayStack[position];
		}
		
		return returnedObject;
	}
	
	@Override
	public String ToString()
	{
		return "";
	}
}
