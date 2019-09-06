package project;

import java.awt.Color;


import naturesimulator.Action;
import naturesimulator.LocalInformation;
import ui.GridPanel;

/*	 Class that allows to create egg on the game.
 * 
 */
public class Egg extends Creature{
	/**
	 * Create a new egg instance
	 * @param x integer represent egg x coordinate on the panel
	 * @param y integer represent egg y coordinate on the panel
	 */
	public Egg(int x,int y) {
		this.x = x;
		this.y = y;
		
	}
	/**
	 * 	The method draw the new egg on the panel
	 * @param panel GridPanel represent this game panel
	 */
	@Override
	public void draw(GridPanel panel) {
		panel.drawSquare(x, y, Color.YELLOW);
		
	}
	/**
	 * The method determine which proper action should be chosen by a egg
	 * @param info LocalInformtion that keeps the creature local information.
	 * @return null
	 */
	@Override
	public Action chooseAction(LocalInformation info) {
		return null;
	}
	/**
	 * The abstract method provides reproduce action condition according to egg
	 * @return null
	 */
	@Override
	public Creature reproduce() {
		return null;
	}
	
}
