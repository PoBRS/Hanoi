package hanoi.backend;

import javafx.scene.paint.Color;

/**
 * Classe gérant l'état d'un disque.
 * 
 * @author Raphaël Sylvain
 * @author Pierre-Olivier Boulet
 * 
 * @since 26/09/2013
 * 
 * @ToDo Utiliser un enum pour les couleurs
 * @ToDo Ne pas gérer de couleurs dans le disque, seulement des Integers.
 */
public class Disc 
{
	private Color color;
	private int size;

	
	/**
	 * Constructeur de disque
	 * @param size	La largeur du disque
	 * @param color	Le numéro représentant une couleur.
	 */
	public Disc(int size, int color)
	{
		this.SetSize(size);
		this.SetColor(color);
	}

	/**
	 * Getter de couleur
	 * @return La couleur du disque.
	 */
	public Color GetColor()
	{
		return this.color;
	}
	
	/**
	 * Setter de couleur
	 * @param color Le numéro de la couleur.
	 */
	public void SetColor(int color)
	{
		switch (color) {
        case 1:
            this.color = Color.BLUE;
            break;
                
        case 2:
            this.color = Color.RED;
            break;
                     
        case 3:
            this.color = Color.LIMEGREEN;
            break;
                   
        case 4:
            this.color = Color.YELLOW;
            break;
                   
        case 5:
            this.color = Color.ORANGE;
            break;
                    
        default:
        	this.color = Color.WHITE;
            break;
		}
	}
	
	/**
	 * Getter de size
	 * @return La taille du disque
	 */
	public int GetSize()
	{
		return this.size;
	}
	
	/**
	 * Setter de size
	 * @param size La taille voulu du disque.
	 */
	public void SetSize(int size)
	{
		this.size = size;
	}
}
