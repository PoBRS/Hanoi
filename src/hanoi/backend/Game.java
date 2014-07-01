package hanoi.backend;

/**
 * Classe assurant le bon état général du jeu en vérifiant ses tours.
 * 
 * @author Pierre-Olivier Boulet
 * @author Raphaël Sylvain
 * 
 * @since 26/09/2013
 */
public class Game 
{
	int nbDiscs = 0;
	Tower towers[];
	
	/**
	 * Constructeur de game
	 * @param nbDiscs le nombre de disque que l'on veut dans la partie
	 */

	public Game(int nbDiscs) 
	{
		if (nbDiscs > 2 && nbDiscs < 65)
		{
			this.towers =  new Tower[nbDiscs];
			
			this.nbDiscs = nbDiscs;
			
			Tower tower1 = new Tower(nbDiscs);	
			Tower tower2 = new Tower(0);
			Tower tower3 = new Tower(0);
			
			this.towers[0] = tower1;
			this.towers[1] = tower2;
			this.towers[2] = tower3;
		}
	}
	
	/**
	 * Getter de Tower
	 * @param towerNumber la position de la tour dans le jeu, commençant par 0
	 * @return la tour à cette position
	 */
	public Tower GetTower(int towerNumber)
	{
		return this.towers[towerNumber];
	}
	
	/**
	 * Fonction déplançant le disque sur le dessus d'une tour vers une autre tour.
	 * @param startingTower la tour où l'on veut retirer le disque
	 * @param destinationTower la tour où l'on veut ajouter le disque
	 * @return true si le move a pu être réussi, false sinon.
	 */
	public boolean Move(int startingTower, int destinationTower)
	{
		// Verify if the towers are valid.
		if ((startingTower != destinationTower) && VerifyTower(startingTower) && VerifyTower(destinationTower))
		{
			if (this.towers[startingTower].GetStack().Size() > 0)
			{
			//We get the disc that will be removed from the starting tower in order to store it later.
			Disc discToMove;
			discToMove = (Disc) this.towers[startingTower].GetStack().Peek();
			
				if (this.towers[destinationTower].Push(discToMove) != null)
				{
					this.towers[startingTower].GetStack().Pop();
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Vérifie si le numéro de la tour est valide.
	 * @param tower le numéro de la tour à vérifier.
	 * @return true si valide, false sinon.
	 */
	private boolean VerifyTower(int tower)
	{
		if (tower < 0)
		{
			return false;
		}
		if (tower > 2)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Vérifie si le jeu est fini.
	 * @return true si la dernière tour est complète, false sinon.
	 */
	
	public boolean IsCompleted()
	{
		if (this.towers[2].IsCompleted(nbDiscs))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Getter du nombre de disque.
	 * @return le nombre de disque.
	 */
	public int GetNbDiscs()
	{
		return this.nbDiscs;
	}
}
