import java.awt.Color;
import java.util.Random;

/**
 * A class responsible for creating the initial population
 * of animals in the simulation.
 * 
 * @author Jamie Redding 
 * @version 20/02/2014
 */
public class AnimalFactory implements Factory
{
    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given grid position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;    
    
    /**
     * Constructor for objects of class AnimalFactory
     */
    public AnimalFactory()
    {
    }
    
    /**
     * Optionally create an animal.
     * Whether an actor is created will depend upon probabilities
     * of actor creation.
     * @param row The row that the actor could be placed in
     * @param col The column that the actor could be placed in
     * @param field The field that the actor could be placed in
     * @return A newly created Actor, or null if none is created.
     */
    public Actor optionallyCreateActor(int row, int col, Field field)
    {
        Random rand = Randomizer.getRandom();
        if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
            Location location = new Location(row, col);
            Fox fox = new Fox(true, field, location);
            return fox;
        }
        else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
            Location location = new Location(row, col);
            Rabbit rabbit = new Rabbit(true, field, location);
            return rabbit;
        }
        return null;
    }
    
    /**
     * Associate colors with the animal classes.
     * @param view The simulatorview to set the colors of
     */
    public void setupColors(SimulatorView view)
    {
        view.setColor(Rabbit.class, Color.orange);
        view.setColor(Fox.class, Color.blue);
    }
}
