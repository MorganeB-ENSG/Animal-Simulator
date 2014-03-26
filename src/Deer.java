import java.util.List;

/**
 * A simple model of a deer.
 * Deer age, move, breed, and die.
 * 
 * @author Jamie Redding
 * @version 20/02/2014
 */
public class Deer extends Animal
{
    // Characteristics shared by all deer (static fields).

    // The age at which a deer can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a deer can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a deer breeding.
    private static final double BREEDING_PROBABILITY = 0.15;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    
    /**
     * Create a new deer. A deer may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the deer will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Deer(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        if(randomAge) {
            setAge(rand.nextInt(MAX_AGE));
        }
    }
    
    /**
     * This is what the deer does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newDeer A list to add newly born deer to.
     */
    public void act(List<Actor> newDeer)
    {
        incrementAge();
        if(isActive()) {
            giveBirth(newDeer);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    /**
     * Return the young of this animal
     * @return The young of this animal
     */
    protected Animal getYoung(Location loc)
    {
        return new Deer(false, getField(), loc);
    }
        
    /**
     * Return the maximal age of the deer.
     * @return The maximal age of the deer.
     */
    protected int getMaxAge()
    {
        return MAX_AGE;
    }
    
    /**
     * Return the breeding age of the deer.
     * @return The breeding age of the deer.
     */
    protected int getBreedingAge()
    {
        return BREEDING_AGE;
    }

    /**
     * Return the breeding probability of the deer.
     * @return The breeding probability of the deer.
     */
    
    protected double getBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }
    
    /**
     * Return the maximal litter size of the deer.
     * @return The maximal litter size of the deer.
     */
    
    protected int getMaxLitterSize()
    {
        return MAX_LITTER_SIZE;
    }
    
}
