package project;



import game.Direction;
import game.Drawable;
import naturesimulator.Action;
import naturesimulator.LocalInformation;
import ui.GridPanel;

/*	Abstract class that allows to create creatures on the game.
 * 
 */

public abstract class Creature implements Drawable{
	
	protected int x;
	protected int y;
	
	
	
	/**
	 * getter for creature's x	 
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * setter for creature's x coordinate
	 * @param y integer keeps creatures's x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * getter for creature's health
	 * @return health
	 */
	public int getY() {
		return y;
	}
	/**
	 * setter for creature's y coordinate
	 * @param y integer keeps creatures's y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
	

	/**
	 * 	The method draw the new creatures on the panel
	 * @param panel GridPanel represent this game panel
	 */
	public abstract void draw(GridPanel panel);
	/**
	 * The method determine which proper action should be chosen by a creature
	 * @param info LocalInformtion that keeps the creature local information.
	 * @return action
	 */
	public abstract Action chooseAction(LocalInformation info);
	/**
	 * The method provides move action condition according to creature
	 * @param direction direction to which creature move
	 */
	public void move(Direction direction) {
		
	}
	/**
	 * The abstract method provides reproduce action condition according to creature
	 * @return Creature
	 */
	public abstract Creature reproduce();
	/**
	 * The method provides attack action condition according to creature
	 * @param attackedCreature the creature will be attacked.
	 */
	public void attack(Creature attackedCreature) {
		
	}
	/**
	 * The method provides stay 
	 */
	public void stay() {
		
	}


	

}
