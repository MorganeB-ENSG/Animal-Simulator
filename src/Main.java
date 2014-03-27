import java.util.Scanner;
/**
 * Main class
 * @author Jamie Redding
 * @version 27/03/2014
 *
 */
public class Main {

	/**
	 * Start the simulation
	 * @param args
	 */
	public static void main(String[] args) {
		HuntingFactory huntF1 = new HuntingFactory();
		Simulator sim1 = new Simulator(80, 120, huntF1);
		
		System.out.println("Please enter a command.");
		
		Scanner reader = new Scanner(System.in);
		boolean finished = false;
		String word1 = null;
		int numSteps = 0;
		
		while(!finished) {
			System.out.print("> ");
			Scanner tokenizer = new Scanner(reader.nextLine());
			
			if(tokenizer.hasNext()) {
				word1 = tokenizer.next().toLowerCase();
				if(tokenizer.hasNextInt()) {
					numSteps = tokenizer.nextInt();
				}
			}
			
			if(word1 != null) {
				switch (word1) {
				case "runlongsim": 
					sim1.runLongSimulation(); break;
					
				case "simulate": 
					if(numSteps > 0) {
						sim1.simulate(numSteps);
					}
					else {
						System.out.println("Please enter a valid number of steps to simulate.");
					}
					break;
				
				case "simulateonestep":
					sim1.simulateOneStep();
					break;
					
				case "reset":
					sim1.reset();
					break;
					
				case "quit":
					finished = true;
					break;
					
				default: System.out.println("Please enter a command from the README."); break;
				}
			}
			tokenizer.close();
		}

		reader.close();
		System.out.println("The simulation has ended");
		System.exit(0);
	}
	
	/**
	 * stuff
	 */
	//private 
}
