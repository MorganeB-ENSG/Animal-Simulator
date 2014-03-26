import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * A simple model of a hunter.
 * Hunters shoot deer, move, and reload
 * 
 * @author Jamie Redding 
 * @version 20/02/2014
 */
public class Hunter implements Actor
{
    // Characteristics shared by all hunters
    
    // The number of shots the hunter can make before reloading
    private static final int MAX_SHELLS = 6;
    // The range of each shot
    private static final int SHOT_RANGE = 20;
    
    // Individual characteristics
    // Number of shots remaining
    private int shotsRemaining = MAX_SHELLS;
    // Number of steps left on reload
    private int reloadStep = 0;
    // The field that the hunter is in
    private Field field;
    // The location in the field
    private Location location;
    // Whether the hunter is hunting or not
    private boolean hunting = true;
    
    /**
     * Create a hunter.
     * They will always start with the same state
     * 
     * @param field The field currently occupied
     * @param location The location within the field
     */
    public Hunter(Field field, Location location)
    {
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Check if the hunter is still active
     * @return True or false, depending if still active or not.
     */
    public boolean isActive()
    {
        return hunting;
    }
    
    /**
     * This is what the hunter does most of the time
     * It shoots deer, but it must reload if out of ammo
     * @param notUsed This hunter class does not make use of this list
     */
    public void act(List<Actor> notUsed)
    {
        if(isActive()) {
            //If not reloading
            if(reloadStep == 0) {
                shoot();
                // Try to move
                Location newLocation = field.freeAdjacentLocation(location);
                if(newLocation != null) {
                    setLocation(newLocation);
                }
            }
            else {
                reloadStep--;
                shotsRemaining++;
            }
        }
    }
    
    /**
     * This is what happens when the hunter shoots
     */
    private void shoot()
    {
        if(shotsRemaining > 0) {
            shotsRemaining--;
            // Find all locations to be hit by bullet
            List<Location> adjacent = field.adjacentLocations(location);
            List<Location> locationsHit = new LinkedList<Location>();
            locationsHit.add(adjacent.get(0));
            Location startLoc = locationsHit.get(0);
            int roffset = (location.getRow() - startLoc.getRow());
            int coffset = (location.getCol() - startLoc.getCol());
            for(int i = 1; i < SHOT_RANGE; i++) {
               int nextRow = startLoc.getRow() + roffset;
               int nextCol = startLoc.getCol() + coffset;
               if ((nextRow >= 0 && nextRow < field.getDepth()) && (nextCol >= 0 && nextCol < field.getWidth())) {
                   locationsHit.add(new Location(nextRow, nextCol));
                   startLoc = locationsHit.get(i);
               }
               else {
                   break;
               }
            }
            
            // Shoot all deer in the locations to be hit
            Iterator<Location> it = locationsHit.iterator();
            while(it.hasNext()) {
                Location where = it.next();
                Object animal = field.getObjectAt(where);
                if(animal instanceof Deer) {
                    Deer deer = (Deer) animal;
                    if(deer.isActive()) {
                        deer.setDead();
                    }
                }
            }
        }
        else {
            // Start reloading
            reloadStep = MAX_SHELLS;
        }
    }
    
    /**
     * Place the hunter at the new location in the given field.
     * @param newLocation The hunter's new location.
     */
    public void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
}
