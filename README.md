Animal-Simulator
================

My simulation is hunting based. There are two classes: Deer and Hunter.
Deer acts by aging, moving, breeding and dying. But the hunter is a little more
complex. A hunter shoots a certain number of times (6 in my case) before it has to reload.
When the hunter shoots it can move afterwards. But if the hunter is reloading, it cannot shoot
and cannot move.
The shots travel a distance given in the SHOT_RANGE (20 in my case) that is how many locations
to travel past when shot. Any deer found in these locations will be killed.

How to start:
    Create a HuntingFactory object.
    Create a simulator object and specify:  the depth of the sim (say 80)
                                            the width of the sim (say 120)
                                            the factory to use [CHOOSE THE HUNTINGFACTORY
                                                                THAT YOU JUST CREATED]
    Then call one of (on the simulator object):
        + simulateOneStep - for a single step.
        + simulate - and supply a number (say 10) for that many steps.
        + runLongSimulation - for a simulation of 500 steps.
		
This does not currently run outside an environment such as BlueJ, since a scanner has not been implemented.