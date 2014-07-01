package hanoi;

import javafx.scene.effect.Light.Distant;
import javafx.scene.Parent;
import javafx.scene.effect.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import hanoi.backend.Tower;
import hanoi.backend.Disc;

/**
 * Classe gérant l'affichage d'un poteau.
 * 
 * @author Raphaël Sylvain
 * @authoer Pierre-Olivier Boulet
 * 
 * @since 26/09/2013
 *
 * @see hanoi.backend.Tower
 */

public class Pole extends Parent
{
	
	final int[] POSITION_X = {100,400,700};
	final int POSITION_Y = 40;
	final int RECTANGLE_POLE_WIDTH= 20;
	final int RECTANGLE_POLE_HEIGHT = 200;
	final int RECTANGLE_BASE_WIDTH = 200;
	final int RECTANGLE_BASE_HEIGHT = 20;
	
	final int DISC_FIRST_WIDTH = 60;
	final int DISC_HEIGHT = 20;
	
	private Rectangle rectanglePole = new Rectangle();
	private Rectangle rectangleBase = new Rectangle();
	
	/**
	 * Constructeur de Pole, créant un pole pour l'affichage.
	 * @param numberPole	Le numéro de la pole, de gauche à droite.
	 * @param towerToAdd	La Tower à reproduire.
	 */
	Pole(int numberPole, Tower towerToAdd)
	{
		this.rectanglePole.setWidth(this.RECTANGLE_POLE_WIDTH);
		this.rectanglePole.setHeight(this.RECTANGLE_POLE_HEIGHT);
		
		this.rectangleBase.setWidth(this.RECTANGLE_BASE_WIDTH);
		this.rectangleBase.setHeight(this.RECTANGLE_BASE_HEIGHT);
		
		this.rectanglePole.setTranslateX(this.POSITION_X[numberPole - 1] + 90);
		this.rectangleBase.setTranslateX(this.POSITION_X[numberPole - 1]);
		
		this.rectangleBase.setTranslateY(this.POSITION_Y + this.rectanglePole.getHeight());
		this.rectanglePole.setTranslateY(this.POSITION_Y);
		
		this.rectanglePole.setFill(Color.SANDYBROWN);
		this.rectangleBase.setFill(Color.CHOCOLATE);
		
		this.rectanglePole.setStroke(Color.CHOCOLATE);
		this.rectanglePole.setStrokeWidth(1);
		this.rectangleBase.setStroke(Color.BROWN);
		this.rectangleBase.setStrokeWidth(1);

		this.rectangleBase.setArcHeight(7);
		this.rectangleBase.setArcWidth(10);
		
		DropShadow shadow = new DropShadow();
		shadow.setRadius(5.0);
		shadow.setOffsetX(3.0);
		shadow.setOffsetY(3.0);
		shadow.setColor(Color.color(0.4, 0.6, 0.5));  
		this.rectangleBase.setEffect(shadow);
		this.rectanglePole.setEffect(shadow);
        
		this.getChildren().add(this.rectanglePole);
		this.getChildren().add(this.rectangleBase);
		
		this.AddDisc(towerToAdd);
		
	}
	/**
	 * Fonction qui crée les disques pour l'affichage
	 * @param tower	La tower à reproduire les disques.
	 */
	public void AddDisc(Tower tower)
	{
		int nbDiscs = tower.GetStack().Size();
		int counter = 0;
		
		for (int i = nbDiscs; i > 0; i--)
		{
			int width = 0;
			Rectangle disc = new Rectangle();
			disc.setWidth(this.findWidth(tower,i));
			width = (this.findWidth(tower,i));
			disc.setHeight(DISC_HEIGHT);
			disc.setTranslateX(this.getPositionX(width));
			disc.setTranslateY(this.getPositionY(counter));
			
			disc.setFill((Color)((Disc)tower.GetStack().Get(i - 1 )).GetColor());
	        disc.setStroke(Color.WHITESMOKE);
			disc.setStrokeWidth(1);
			disc.setArcHeight(35);
			disc.setArcWidth(15);
			
			Distant light = new Distant();
		    light.setAzimuth(-45.0f);
			Lighting lightning = new Lighting();
			lightning.setLight(light);
	        lightning.setSurfaceScale(3.0f);
	        
	        disc.setEffect(lightning);
	        
			this.getChildren().add(disc);
			counter++;
		}
	}
	
	/**
	 * Fonction qui trouve la largeur, en pixel, d'un disque.
	 * @param tower		La tower à trouver le disque
	 * @param discToAdd	La position du disque.
	 * @return	La largeur en pixel du disque.
	 */
	private int findWidth(Tower tower, int discToAdd)
	{
		return (((Disc)tower.GetStack().Get(discToAdd - 1)).GetSize() -1) * 20 + this.RECTANGLE_POLE_WIDTH + 20;
	}
	
	
	/**
	 * Fonction qui donne la position Y où il faut ajouter le disque.
	 * @param nbDiscs	Le numéro du disque.
	 * @return			La position en Pixel de la hauteur du disque.
	 */
	private int getPositionY(int nbDiscs)
	{
		int positionBase = (int) this.rectangleBase.getTranslateY();
		int positionModifier = (DISC_HEIGHT * (nbDiscs)) + this.RECTANGLE_BASE_HEIGHT;
		
		return positionBase - positionModifier;
	}
	
	/**
	 * Fonction qui donne la position X où il faut ajouter le disque.
	 * @param width		La largeur du disque
	 * @return			La position, en pixel, du disque à ajouter.
	 */
	private int getPositionX(int width)
	{
		
		int positionPole = (int) this.rectanglePole.getTranslateX();
		int poleWidth = (int) this.rectanglePole.getWidth();
		int middleOfThePole = positionPole + (poleWidth / 2);
		int discWidth = width;
		int positionDisc = middleOfThePole - (discWidth / 2);
		
		return positionDisc;
		
		
	}
}
