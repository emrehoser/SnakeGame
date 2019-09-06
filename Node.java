package project;

import java.awt.Color;


import naturesimulator.Action;
import naturesimulator.LocalInformation;
import ui.GridPanel;

/*	Class that allows to create node on the game.
 * 
 */

public class Node extends Creature {
	
    //1 if head
	protected int type;
	/**
	 * Create a new node instance
	 * @param x integer represent node x coordinate on the panel
	 * @param y integer represent node y coordinate on the panel
	 * @param type integer represent node's type
	 */
	public Node(int x , int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	/**
	 * getter for node's x	 
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * setter for node's x coordinate
	 * @param x integer keeps node's x coordinate
	 */

	public void setX(int x) {
		this.x = x;
	}
	/**
	 * getter for node's x	 
	 * @return x
	 */

	public int getY() {
		return y;
	}
	/**
	 * setter for node's y coordinate
	 * @param y integer keeps node's y  coordinate
	 */

	public void setY(int y) {
		this.y = y;
	}
	/**
	 * getter for node's type
	 * @return type
	 */

	public int getType() {
		return type;
	}
	/**
	 * setter for node's type coordinate
	 * @param y integer keeps node's type  coordinate
	 */

	public void setType(int type) {
		this.type = type;
	}


	/**
	 * 	The method draw the new node on the panel
	 * @param panel GridPanel represent this game panel
	 */

	@Override
	public void draw(GridPanel panel) {
		// TODO Auto-generated method stub
		if (type==1) {
			panel.drawSquare(x, y, Color.RED);
		}
		else
			panel.drawSquare(x, y, Color.BLUE);
	}

	/**
	 * The method determine which proper action should be chosen by a node
	 * @param info LocalInformtion that keeps the creature local information.
	 * @return null
	 */

	@Override
	public Action chooseAction(LocalInformation info) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * The abstract method provides reproduce action condition according to node
	 * @return null
	 */
	@Override
	public Creature reproduce() {
		// TODO Auto-generated method stub
		return null;
	}

}
