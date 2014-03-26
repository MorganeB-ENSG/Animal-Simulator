import java.awt.Color;
import java.util.Random;

/**
 * A class responsible for creating the initial population
 * of actors in the simulation.
 * 
 * @author Jamie Redding
 * @version 20/02/2014
 */
public class HuntingFactory implements Factory
{
    // The probability that a hunter will be created in any given grid position.
    private static final double HUNTER_CREATION_PROBABILITY = 0.01;
    // The probability that a deer will be created in any given grid position.
    private static final double DEER_CREATION_PROBABILITY = 0.08;    
    
    /**
     * Constructor for objects of class HuntingFactory
     */
    public HuntingFactory()
    {
    }
    
    /**
     * Optionally create an actor.
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
        if(rand.nextDouble() <= HUNTER_CREATION_PROBABILITY) {
            Location location = new Location(row, col);
            Hunter hunter = new Hunter(field, location);
            return hunter;
        }
        else if(rand.nextDouble() <= DEER_CREATION_PROBABILITY) {
            Location location = new Location(row, col);
            Deer deer = new Deer(true, field, location);
            return deer;
        }
        return null;
    }
    
    /**
     * Associate colors with the animal classes.
     * @param view The simulatorview to set the colors of
     */
    public void setupColors(SimulatorView view)
    {
        view.setColor(Deer.class, Color.green);
        view.setColor(Hunter.class, Color.red);
    }
}
