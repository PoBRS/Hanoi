package util.collection;

/**
 * Une pile (Last In, First Out) abstraite permettant de s'assurer de la plénitude des Stacks personnelles.
 * 
 * @author Pierre-Olivier Boulet
 * @author Raphaël Sylvain
 * 
 * @since 26/09/2013
 */
public abstract class Stack 
{
	
	protected int size = 0;
	
	/**
	 * Retourne le nombre d'éléments dans la pile
	 * @return le nombre d'éléments
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
	 * Ajoute un élément sur le dessus de la pile
	 * @param element : l'élément à ajouter à la pile
	 * @return l'élément que l'on a ajouté, null si on a pas ajouté l'élément
	 */
	public abstract Object Push(Object element);
	
	/**
	 * Enlève l'élément sur le dessus de la pile
	 * @return l'élément que l'on a enlevé, null si aucun élément a été enlevé.
	 */
	public abstract Object Pop();
	
	/**
	 * Vérifie si la pile est vide
	 * @return Vrai si la pile est vide, Faux s'il y a des éléments
	 */
	public abstract boolean IsEmpty();
	
	/**
	 * Enlève tout les éléments de la pile
	 * @see Pop
	 */
	public abstract void Clear();	
	
	/**
	 * Regardes l'élément sur le dessus de la pile sans la supprimer.
	 * @return L'élément sur le dessus de la pile, null si la pile est vide.
	 */
	public abstract Object Peek();	
	
	/**
	 * Retournes la position où un objet spécifié est dans la stack.
	 * On considére que l'object sur le dessus de la pile est à la position 0.
	 * @param element : L'objet recherché.
	 * @return La position de l'objet rechercher, -1 s'il n'existe pas.
	 */
	public abstract int Search(Object element);	
	
	/**
	 * Retourne l'élément à une position spécifiée sans le supprimé.
	 * On consifère que l'objet sur le dessus de la pile est à la position 0.
	 * @param position : la position de l'objet que l'on recherche.
	 * @return L'objet à la position spécifiée, null si la position n'est pas valide.
	 */
	public abstract Object Get(int position);
	
	/**
	 * Retourne la pile sous une forme String.
	 * @return Une pile qui représente l'objet.
	 */
	public abstract String ToString();
}