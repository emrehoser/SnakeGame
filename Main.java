package main;

import naturesimulator.NatureSimulator;
import project.Cobra;
import project.Egg;
import project.Node;
import ui.ApplicationWindow;

import java.awt.*;
import java.util.LinkedList;


/**
 * The main class that can be used as a playground to test your project.
 * This class will be discarded and replaced with our own grading class.
 *
 * IMPORTANT: All the classes that you create should be put under the package named "project".
 * All the other packages will be reset when grading your project.
 */
public class Main {

    /**
     * Main entry point for the application.
     *
     * IMPORTANT: You can change anything in this method to test your game,
     * but your changes will be discarded when grading your project.
     *
     * @param args application arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // Create game
                // You can change the world width and height, size of each grid square in pixels or the game speed
                NatureSimulator game = new NatureSimulator(25, 25, 10, 10);
                
                int x = (int) (Math.random() * game.getGridWidth());
                int y = (int) (Math.random() * game.getGridHeight());
                //create new egg
                game.addCreature(new Egg(x, y));
                //create new cobra
                LinkedList<Node> firstCobra = new LinkedList<Node>();
                firstCobra.add(new Node(1,1,0));
                firstCobra.add(new Node(2,1,0));
                firstCobra.add(new Node(3,1,0));
                firstCobra.add(new Node(4,1,1));
                game.addCreature(new Cobra(firstCobra,game));
                
                
                // Create application window that contains the game panel
                ApplicationWindow window = new ApplicationWindow(game.getGamePanel());
                window.getFrame().setVisible(true);

                // Start game
                game.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
