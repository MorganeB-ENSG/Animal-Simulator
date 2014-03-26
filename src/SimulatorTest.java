

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SimulatorTest.
 *
 * @author  Jamie Redding
 * @version 20/02/2014
 */
public class SimulatorTest
{
    private HuntingFactory huntFac1;
    private Simulator simul1;

    /**
     * Default constructor for test class SimulatorTest
     */
    public SimulatorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        huntFac1 = new HuntingFactory();
        simul1 = new Simulator(80, 120, huntFac1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Run one step in the simulation
     */
    @Test
    public void oneStep()
    {
        simul1.simulateOneStep();
    }
}
