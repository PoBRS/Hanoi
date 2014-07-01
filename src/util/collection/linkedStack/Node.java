package util.collection.linkedStack;

	/**
	 * Noeuds contenant de l'information sur un contenu et un autre noeud.
	 * 
	 * @author Raphaël Sylvain
	 * @author Pierre-Olivier Boulet
	 * 
	 * @since 26/09/2013
	 *
	 */
public class Node 
{
	private Object currentElement;
	private Node previousNode;
	
	/**
	 * Constructor of Node
	 * 
	 * @param element
	 * @param previousNode
	 */
	
	public Node(Object element, Node previousNode)
	{
		this.currentElement = element;
		this.previousNode = previousNode;
	}
	/**
	 * 
	 * @return The previousNode
	 */
	public Node GetPrevious()
	{
		return this.previousNode;
	}
	
	/**
	 * 
	 * @return The element
	 */
	public Object GetCurrent()
	{
		return this.currentElement;
	}
	
	public boolean SetCurrent(Object newElement)
	{
		this.currentElement = newElement;
		return true; // How can it be false?
	}
}
