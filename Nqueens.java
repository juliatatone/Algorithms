package algorithmsD21;

import java.util.Arrays;

public class Nqueens {

	static boolean isLegalPosition(int[] board, int n) {
		
		for(int a = 0; a < n; a++) { 
			if(board[a] != 0) {
				for(int b = a + 1; b < n; b++) {
					if(board[a] == board[b]) {
						//System.out.println("false1");
						return false;
					}
				}

			}

		}

		//diagonals
		for(int i = 0; i < n; i++) {
			int currentQ = board[i];
			if(currentQ != 0) {
				for(int j = 1; j <= n - 1; j++) {
					if(i - j >= 0) {

						if(currentQ - j== board[i - j] || currentQ + j == board[i - j]) { //checks for upper diagonals
							
							return false;
						}
					}
					//					else if(i + j < n) {
					//						if(currentQ + j < n && currentQ > 1) {
					//							if((currentQ + j) == board[i + j] || (currentQ - j) == board[i + j]) { //checks lower diagonals
					//								System.out.println(currentQ + " " + board[i + j] + " " + i + " " + j);
					//								System.out.println("false3");
					//								return false;
					//							}
					//						}
					//					}
				}
			}
		}


		return true; //for legal position 
	}

	public static int[] successor(int [] board, int n) {


		if(isLegalPosition(board, n) && (board[board.length - 1] == 0)) { //is legal not full
			for(int i = 0; i < n; i++) {
				if(board[i] == 0) { //find first 0
					board[i] = 1; //set to 1
					return board; //found successor
				}
			}
		}



		if(!(isLegalPosition(board, n) && (board[board.length - 1] == 0))) { //is legal not full
			int lastQ = -1;
			for(int i = n - 1; i >= 0; i--){ //find last non zero
				if(board[i] != 0) {
					lastQ = i; //save position
					break;
				}
			}


			while(lastQ >= 0) { //while there are still queens on the board
				if(board[lastQ] != n) { //if queen isn't in right most column
					board[lastQ]++; //move queen forward one
					return board; //once any queen is moved (successor found), stop the method
				}
				board[lastQ] = 0; //remove queen
				lastQ--; //lastQ on previous row
			} return board; //we have removed all queens on the board

		}
		return board;
	}


	public static int[] nextLegalPosition(int[] board, int n) {
		int[] nextPosition = successor(board, n);		


		while(!(isLegalPosition(nextPosition, n))) {
			nextPosition = successor(nextPosition, n);

		}
		return nextPosition; //legal position found
	}

	public static int[] firstSolution(int[] solution, int n) {
		
		solution = new int[n]; //build a blank array
		
		while(solution[solution.length - 1] == 0) {

			nextLegalPosition(solution, n); //call next legal
			
		}
		
		return solution;
	}
	
//	public static int[] firstSolution2(int[] solution, int n) {
//	//	solution = new int[n]; //build a blank array
//		for(int i = 0; i < n; i++) {
//			if(solution[i] != 0) {
//				while(solution[i] == 0) {
//
//					nextLegalPosition(solution, n); //call next legal
//					
//				}
////			}
////		}
//	return solution;
//	}
//		
		
	public static int[] firstSolution2(int[] solution, int n) {
		
//		solution = new int[n]; //build a blank array
		
		while(solution[solution.length - 1] == 0) {

			nextLegalPosition(solution, n); //call next legal
			
		}
		
		return solution;
	}		
		
		
		
	
	
	
	
	
	public static int[] allSolutions(int[] solution, int n) {
		solution = nextLegalPosition(solution, n);  //build an array with previous solution
		//System.out.println(Arrays.toString(solution)); 
		boolean solutionFound = true;
		int counter = 0;
		while(solution[solution.length - 1] == 0) {

			nextLegalPosition(solution, n); //call next legal

			if(solution[solution.length - 1] == 0) {
				counter++;
				solutionFound = false;
			}
		}
		for(int i = 4; i <= 4; i++){
			System.out.println("There are " + counter + " solutions to the " + i + "-Queens problem");
		}
		return solution;
	}

	
	
	
//	public static int[] xyz(int[] newSolution, int n) {
//		newSolution = firstSolution(newSolution,n);//build a blank array
//		int counter = 0;
//		for(n = 4; n <= 4; n++) {
//			
//			
//
//				firstSolution(newSolution, n); //call next legal
//				counter++;
//				System.out.println("There are " + counter + " solutions to the " + n + "-Queens problem");
//				while(newSolution[newSolution.length - 1] != 0) {
//					
//				}
// 
////			}
//		}
//		
////		
//		
//		return newSolution;
//	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int board[] = {2, 4, 1, 0};
		int n = 4;
		int solution[] = {2,4,1,3};

		System.out.println(isLegalPosition(board, n));
		System.out.println(Arrays.toString(nextLegalPosition(board, n)));
//		for(int i = 4; i <= 4; i++){ //loop from 4 to 100
//			System.out.println(Arrays.toString(allSolutions(solution, i)));
//		}
//
		for(int i = 4; i <= 4; i++){ //loop from 4 to 12
			allSolutions(solution, i);
		}
	}
}
