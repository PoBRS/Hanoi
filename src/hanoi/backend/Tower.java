package hanoi.backend;


import util.collection.linkedStack.ImplStack;
//import util.collection.arrayStack.ImplStack;

/**
 * Classe g�rant l'�tat d'une tour. Et emp�che l'insertion d'un gros disque sur un petit disque.
 * @author Pierre-Olivier Boulet
 * @author Rapha�l Sylvain
 *
 * @since 26/09/2013
 * 
 * @see util.collection.Stack.Java
 */
public class Tower extends ImplStack
{
	private ImplStack stack;
	
	/**
	 * Constructeur par d�faut de Tower, cr�ant une tour sans disque.
	 */
	public Tower()
	{
		this.stack = new ImplStack();
	}
	
	/**
	 * Constructeur secondaire de Tower, cr�ant une tour avec le nombre de disque sp�cifi�.
	 * @param nbDiscs
	 */
	public Tower(int nbDiscs) 
	{
		this.stack = new ImplStack();
		
		if (nbDiscs > 0 && nbDiscs < 65)
		{
		
			for(int i = nbDiscs; i > 0; i--)
			{
				Disc discToAdd = new Disc(i,i);
				this.Push(discToAdd);
			}
		}

	}
	
	/**
	 * V�rifie si une tour est compl�te
	 * @param nbDiscs Le nombre de disque total dans le jeu
	 * @return true si la tour a tout les disques, false sinon.
	 */
	public boolean IsCompleted(int nbDiscs)
	{
		if (this.stack.Size() == nbDiscs)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Ajoute un disque sur la tour
	 * @param discToAdd le disque a ajouter
	 * @return le disque ajouter si l'ajout a �t� une r�ussite, null si c'est un �chec
	 */
	public Disc Push(Disc discToAdd)
	{
		if (this.stack.Peek() == null || discToAdd.GetSize() < ((Disc)this.stack.Peek()).GetSize())
		{
			this.stack.Push(discToAdd);
			
			return discToAdd;
		}	
		return null;
	}
	
	/**
	 * Getter de la pile de disque
	 * @return la pile de disque
	 */
	public ImplStack GetStack()
	{
		return this.stack;
	}
}
