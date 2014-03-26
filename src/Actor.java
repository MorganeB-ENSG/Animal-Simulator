import java.util.List;

/**
 * The interface to be implemented by any class wishing to
 * participate in the simulation
 * 
 * @author Jamie Redding 
 * @version 17/02/2014
 */
public interface Actor
{
    /**
     * Perform usual behaviour 
     * @param newActors A list to recieve newly created actors
     */
    void act(List<Actor> newActors);
    
    /**
     * Check if actor is still active
     * @return True or false, depending if still active or not.
     */
    boolean isActive();
}
