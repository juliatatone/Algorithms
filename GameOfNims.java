package algorithmsD21;
import java.util.Random;
import java.util.Scanner;


public class Homework1 {

	//Double trouble is a version of the combinatorial game of nims. It was said to originate in China with roots in a game of "picking stones", but it was
	// Charles Leonard Bouton who solved the theory of the game. The game of Nim was the subject of Martin Gardner's February 1958
	//Mathematical Games column in Scientific American. A version of Nim is played—and has symbolic importance—in the French New Wave film 
	//Last Year at Marienbad (1961). This game appears in Pop culture in the GBA version of Tales of Phantasia.

	@SuppressWarnings("null")
	public static void main (String [] args) {

		//setup
		int greenMarkers = 3;
		int yellowMarkers = 7;
		int orangeMarkers = 5;

		//players
		Scanner user;
		Random computer;


		//objects
		Scanner userInput = new Scanner (System.in);
		Scanner compInput = new Scanner (System.in);

		//play
		Scanner sc = new Scanner (System.in);
		System.out.println("Welcome to Double Trouble. You have 3 green markers, 7  yellow markers, and 5 orange markers. "
				+ "You may choose who goes first now.");

		//choose user or computer to go first
		String start = sc.next();


		System.out.println(start + " will make the first move");


		String winner = start;

		//first move user

		System.out.println("Enter number of markers to take from the pile and number (example; G2 would take 2 markers from the green pile): "); 
		while(greenMarkers + yellowMarkers + orangeMarkers > 0) {

			if (start.equals("user")) {
				int numMarkers = 0;
				winner = "user";

				System.out.println("User's turn");
				
				String input = userInput.nextLine();
				String pile = Character.toString(input.charAt(0));
				numMarkers = Integer.parseInt(Character.toString(input.charAt(1)));
				if (pile.equals("G")) {

					if (greenMarkers - numMarkers >= 0) {
						greenMarkers = greenMarkers - numMarkers;
						System.out.println("Green Markers Left: " + greenMarkers);
						System.out.println("Yellow Markers Left: " + yellowMarkers);
						System.out.println("Orange Markers Left: " + orangeMarkers);
					}
					else System.out.println("That's not a valid move");
				}
				if (pile.equals("Y")) {
					if (yellowMarkers - numMarkers >= 0) {
						yellowMarkers = yellowMarkers - numMarkers;
						System.out.println("Green Markers Left: " + greenMarkers);
						System.out.println("Yellow Markers Left: " + yellowMarkers);
						System.out.println("Orange Markers Left: " + orangeMarkers);
					}
					else System.out.println("That's not a valid move");
				}
				if (pile.equals("O")) {
					if (orangeMarkers - numMarkers >= 0) {
						orangeMarkers = orangeMarkers - numMarkers;
						System.out.println("Green Markers Left: " + greenMarkers);
						System.out.println("Yellow Markers Left: " + yellowMarkers);
						System.out.println("Orange Markers Left: " + orangeMarkers);
					}
					else System.out.println("That's not a valid move");
				} 
				start = "computer";

				//computer moves
			} else if (start.equals("computer")) {
				winner = "computer"; 

				System.out.println("Computer's turn");
				Random rand = new Random(); 
				int upperbound = 3;
				int int_random = rand.nextInt(upperbound) + 1;
				//check int random for empty pile pick new one
				int[] piles = new int[]{greenMarkers, yellowMarkers, orangeMarkers};

				while (piles[int_random - 1] < 0) {
					int_random = rand.nextInt(upperbound) + 1;
				}
				if ( int_random == 1) {
					upperbound = greenMarkers;
					int markersToTake = rand.nextInt(upperbound) + 1;

					while (greenMarkers - markersToTake < 0) {
						System.out.println("That's not a valid move");
						upperbound = greenMarkers;
						markersToTake = rand.nextInt(upperbound) + 1;	
					}

					greenMarkers = greenMarkers - markersToTake;
					System.out.println("Green Markers Left: " + greenMarkers);
					System.out.println("Yellow Markers Left: " + yellowMarkers);
					System.out.println("Orange Markers Left: " + orangeMarkers);
				}



				else if (int_random == 2) {
					upperbound = yellowMarkers;
					int markersToTake = rand.nextInt(upperbound) + 1;

					while (yellowMarkers - markersToTake < 0) {
						System.out.println("That's not a valid move");
						upperbound = yellowMarkers;
						markersToTake = rand.nextInt(upperbound) + 1;	
					}

					yellowMarkers = yellowMarkers - markersToTake;
					System.out.println("Green Markers Left: " + greenMarkers);
					System.out.println("Yellow Markers Left: " + yellowMarkers);
					System.out.println("Orange Markers Left: " + orangeMarkers);
				}


				else if (int_random == 3) {
					upperbound = orangeMarkers;
					int markersToTake = rand.nextInt(upperbound) + 1;

					while (orangeMarkers - markersToTake < 0) {
						System.out.println("That's not a valid move");
						upperbound = orangeMarkers;
						markersToTake = rand.nextInt(upperbound) + 1;	
					}

					orangeMarkers = orangeMarkers - markersToTake;
					System.out.println("Green Markers Left: " + greenMarkers);
					System.out.println("Yellow Markers Left: " + yellowMarkers);
					System.out.println("Orange Markers Left: " + orangeMarkers);

				}
				else {
					System.out.println("That's not a valid move");
				}
				start = "user";
			}

		} 
		System.out.println("Game over. " + winner + " won!");

	}
}








