package util.collection;

/**
 * Une pile (Last In, First Out) abstraite permettant de s'assurer de la pl�nitude des Stacks personnelles.
 * 
 * @author Pierre-Olivier Boulet
 * @author Rapha�l Sylvain
 * 
 * @since 26/09/2013
 */
public abstract class Stack 
{
	
	protected int size = 0;
	
	/**
	 * Retourne le nombre d'�l�ments dans la pile
	 * @return le nombre d'�l�ments
	 */
	public int Size()
	{
		return this.size;
	}
	
	/**
	 * Stack constructor
	 */
	public Stack()
	{
	}
	
	
	/**
	 * Ajoute un �l�ment sur le dessus de la pile
	 * @param element : l'�l�ment � ajouter � la pile
	 * @return l'�l�ment que l'on a ajout�, null si on a pas ajout� l'�l�ment
	 */
	public abstract Object Push(Object element);
	
	/**
	 * Enl�ve l'�l�ment sur le dessus de la pile
	 * @return l'�l�ment que l'on a enlev�, null si aucun �l�ment a �t� enlev�.
	 */
	public abstract Object Pop();
	
	/**
	 * V�rifie si la pile est vide
	 * @return Vrai si la pile est vide, Faux s'il y a des �l�ments
	 */
	public abstract boolean IsEmpty();
	
	/**
	 * Enl�ve tout les �l�ments de la pile
	 * @see Pop
	 */
	public abstract void Clear();	
	
	/**
	 * Regardes l'�l�ment sur le dessus de la pile sans la supprimer.
	 * @return L'�l�ment sur le dessus de la pile, null si la pile est vide.
	 */
	public abstract Object Peek();	
	
	/**
	 * Retournes la position o� un objet sp�cifi� est dans la stack.
	 * On consid�re que l'object sur le dessus de la pile est � la position 0.
	 * @param element : L'objet recherch�.
	 * @return La position de l'objet rechercher, -1 s'il n'existe pas.
	 */
	public abstract int Search(Object element);	
	
	/**
	 * Retourne l'�l�ment � une position sp�cifi�e sans le supprim�.
	 * On consif�re que l'objet sur le dessus de la pile est � la position 0.
	 * @param position : la position de l'objet que l'on recherche.
	 * @return L'objet � la position sp�cifi�e, null si la position n'est pas valide.
	 */
	public abstract Object Get(int position);
	
	/**
	 * Retourne la pile sous une forme String.
	 * @return Une pile qui repr�sente l'objet.
	 */
	public abstract String ToString();
}