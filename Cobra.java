package project;
import java.util.LinkedList;
import java.util.List;


import game.Direction;
import naturesimulator.Action;
import naturesimulator.LocalInformation;
import naturesimulator.NatureSimulator;
import ui.GridPanel;
/*	Class that allows to create cobra on the game.
 * 
 */
public class Cobra extends Creature {
		
		LinkedList<Node> cobra = new LinkedList<Node>();
		NatureSimulator natsim;
		/**
		 * Create a new cobra instance
		 * @param LinkedList nodes represent cobra
		 * @param NatureSimulator natsim represent natsim
		 */
		public Cobra(LinkedList<Node> nodes,NatureSimulator natsim) {
		this.natsim = natsim;
		this.cobra = nodes;
		this.x = cobra.getLast().x;
		this.y = cobra.getLast().y;
		
	}
		/**
		 * getter for cobra
		 * @return cobra
		 */
		public LinkedList<Node> getCobra() {
			return cobra;
		}
		/**
		 * setter for cobra
		 * @param cobra
		 */
		public void setCobra(LinkedList<Node> cobra) {
			this.cobra = cobra;
		}
		/**
		 * getter for cobra's head
		 * @return cobra's head
		 */
		public Node getHead() {
			return cobra.getLast();
			
		}
		/**
		 * ýu to enable cobra to go to egg
		 * @param info
		 * @return direction
		 */
		public Direction toEgg(LocalInformation info) {
			List<Direction> freeDirections = info.getFreeDirections();
			
			if(info.getEgg().x > getHead().x && info.getEgg().y > getHead().y) {
					if(freeDirections.contains(Direction.RIGHT)) {
						return Direction.RIGHT;
					}
					else if(freeDirections.contains(Direction.DOWN)) {
						return Direction.DOWN;
					}
					else {
						return LocalInformation.getRandomDirection(freeDirections);
					}	
			}
			else if(info.getEgg().x > getHead().x && info.getEgg().y < getHead().y) {
				if(freeDirections.contains(Direction.UP)) {
					return Direction.UP;
				}
				else if(freeDirections.contains(Direction.RIGHT)) {
					return Direction.RIGHT;
				}
				else {
					return LocalInformation.getRandomDirection(freeDirections);
				}	
			}
			else if(info.getEgg().x > getHead().x && info.getEgg().y == getHead().y) {
				if(freeDirections.contains(Direction.RIGHT)) {
					return Direction.RIGHT;
				}
				else {
					return LocalInformation.getRandomDirection(freeDirections);
				}	
		}
			else if(info.getEgg().x < getHead().x && info.getEgg().y > getHead().y) {
				if(freeDirections.contains(Direction.LEFT)) {
					return Direction.LEFT;
				}
				else if(freeDirections.contains(Direction.DOWN)) {
					return Direction.DOWN;
				}
				else {
					return LocalInformation.getRandomDirection(freeDirections);
				}	
		}
			else if(info.getEgg().x < getHead().x && info.getEgg().y < getHead().y) {
				if(freeDirections.contains(Direction.UP)) {
					return Direction.UP;
				}
				else if(freeDirections.contains(Direction.LEFT)) {
					return Direction.LEFT;
				}
				else {
					return LocalInformation.getRandomDirection(freeDirections);
				}	
		}
			else if(info.getEgg().x < getHead().x && info.getEgg().y == getHead().y) {
				if(freeDirections.contains(Direction.LEFT)) {
					return Direction.LEFT;
				}
				else {
					return LocalInformation.getRandomDirection(freeDirections);
				}	
		}
			else if(info.getEgg().x == getHead().x && info.getEgg().y > getHead().y) {
				if(freeDirections.contains(Direction.DOWN)) {
					return Direction.DOWN;
				}
				else {
					return LocalInformation.getRandomDirection(freeDirections);
				}	
		}
			else {
				if(freeDirections.contains(Direction.UP)) {
					return Direction.UP;
				}
				else {
					return LocalInformation.getRandomDirection(freeDirections);
				}	
		}
			
			
			
		}
		/**
		 * 	The method draw the new cobra on the panel
		 * @param panel GridPanel represent this game panel
		 */
	@Override
	public void draw(GridPanel panel) {
		for(Node nodes : cobra) {
			nodes.draw(panel);
		}
		
	}
	/**
	 * The method determine which proper action should be chosen by a cobra
	 * @param info LocalInformtion that keeps the cobra's local information.
	 * @return action
	 */
	@Override
	public Action chooseAction(LocalInformation info) {
	
		Direction eggDirection = null;
		if(info.getCreatureDown() instanceof Egg) eggDirection = Direction.DOWN;
		if(info.getCreatureUp() instanceof Egg) eggDirection = Direction.UP;
		if(info.getCreatureLeft() instanceof Egg) eggDirection = Direction.LEFT;
		if(info.getCreatureRight() instanceof Egg) eggDirection = Direction.RIGHT;
		if(cobra.size() == 8) {
			return new Action(Action.Type.REPRODUCE);
		}
		else if(eggDirection != null) {
			return new Action(Action.Type.ATTACK,eggDirection);
		}
		
		
		return new Action(Action.Type.MOVE,toEgg(info));
	}
	/**
	 * The abstract method provides reproduce action condition according to cobra
	 * @return Creature
	 */
	@Override
	public Creature reproduce() {
		LinkedList<Node> childNodes = new LinkedList<Node>();
		childNodes.add(cobra.get(3));
		childNodes.add(cobra.get(2));
		childNodes.add(cobra.get(1));
		childNodes.add(cobra.getFirst());
		natsim.removeCreature(cobra.get(3));
		natsim.removeCreature(cobra.get(2));
		natsim.removeCreature(cobra.get(1));
		natsim.removeCreature(cobra.get(0));
		cobra.remove(3);
		cobra.remove(2);
		cobra.remove(1);
		cobra.remove(cobra.getFirst());
		Cobra childCobra = new Cobra(childNodes,natsim);
		
		return childCobra;
	}
	/**
	 * The method provides attack action condition according to cobra.
	 * @param attackedCreature the creature will be attacked.
	 */
	public void attack(Creature attackedCreature) {
		int x = (int) (Math.random() * natsim.getGridWidth());
        int y = (int) (Math.random() * natsim.getGridHeight());
		while(!natsim.isPositionFree(x, y)) {
			x = (int) (Math.random() * natsim.getGridWidth());
	        y = (int) (Math.random() * natsim.getGridHeight());
		}
		
		cobra.addLast(new Node(attackedCreature.x,attackedCreature.y,1));
		cobra.set(cobra.size()-2,new Node(cobra.get(cobra.size()-2).x,cobra.get(cobra.size()-2).y,0));
//		natsim.removeCreature(attackedCreature);
//		natsim.addCreature(new Egg(x,y));
		attackedCreature.setX(x);
		attackedCreature.setY(y);
		
		
		
	}
	/**
	 * The method provides move action condition according to creature
	 * @param direction direction to which creature move
	 */
	public void move(Direction direction) {	
		if(direction == Direction.UP) {
				cobra.add(new Node(getHead().x,getHead().y-1,1));
				cobra.set(cobra.size()-2,new Node(cobra.get(cobra.size()-2).x,cobra.get(cobra.size()-2).y,0));
				natsim.removeCreature(cobra.getFirst());
				cobra.remove(cobra.getFirst());
				this.x = cobra.getLast().x;
				this.y = cobra.getLast().y;
			}
			else if(direction == Direction.DOWN) { 
				cobra.add(new Node(getHead().x,getHead().y+1,1));
				cobra.set(cobra.size()-2,new Node(cobra.get(cobra.size()-2).x,cobra.get(cobra.size()-2).y,0));
				natsim.removeCreature(cobra.getFirst());
				cobra.remove(cobra.getFirst());
				this.x = cobra.getLast().x;
				this.y = cobra.getLast().y;
			}
			else if(direction == Direction.RIGHT) {
				cobra.add(new Node(getHead().x+1,getHead().y,1));
				cobra.set(cobra.size()-2,new Node(cobra.get(cobra.size()-2).x,cobra.get(cobra.size()-2).y,0));
				natsim.removeCreature(cobra.getFirst());
				cobra.remove(cobra.getFirst());
				this.x = cobra.getLast().x;
				this.y = cobra.getLast().y;
				
			}else {
				cobra.add(new Node(getHead().x-1,getHead().y,1));
				cobra.set(cobra.size()-2,new Node(cobra.get(cobra.size()-2).x,cobra.get(cobra.size()-2).y,0));
				natsim.removeCreature(cobra.getFirst());
				cobra.remove(cobra.getFirst());
				this.x = cobra.getLast().x;
				this.y = cobra.getLast().y;
		}
		
	}
}
