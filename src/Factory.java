
/**
 * An interface to be implemented by any factory-related class
 * for this simulation
 * 
 * @author Jamie Redding
 * @version 17/02/2014
 */
public interface Factory
{
    /**
     * Optionally create an actor.
     * Whether an actor is created will depend upon probabilities
     * of actor creation.
     * @param row The row that the actor could be placed in
     * @param col The column that the actor could be placed in
     * @param field The field that the actor could be placed in
     * @return A newly created Actor, or null if none is created.
     */
    Actor optionallyCreateActor(int row, int col, Field field);
    
    /**
     * Associate colors with the animal classes.
     * @param view The simulatorview to set the colors of
     */
    void setupColors(SimulatorView view);
}
