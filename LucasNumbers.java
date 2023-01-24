package algorithmsD21;

import java.time.Clock;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LucasNumbers {

	private static Clock clock; 

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the number of terms you want to find in the Lucas Series: ");
		int inputL = scan.nextInt();
		successiveCalcLucas(inputL);
		
		
		System.out.print("Enter the number of terms you want to find in the Julia Series: ");
		int inputJ = scan.nextInt();
		successiveCalcJulia(inputJ);


	}

	public static int lucasNumbers(int n) {

		if(n == 0) {
			return 2;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			return lucasNumbers(n-1) + lucasNumbers(n-2);	
			
		}

	}
	
	public static void successiveCalcLucas(int n) {
		int prevLucas = -1;
		long prevTime = -1;

		for(int i = 0; i < n; i++) {
			long startTime = System.nanoTime();
			int currentLucas = lucasNumbers(i);
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			System.out.println("L(" + i + ")= " + currentLucas + " ");
			System.out.println("The time to compute L(" + i + ") is " + timeElapsed + " nanoseconds");
			


			if(i != 0) {
				float ratioLucas = ((float) currentLucas / (float) prevLucas);
				System.out.println("The ratio of successive calculations = " + ratioLucas);
				float ratioTime = ((float) timeElapsed / (float) prevTime);
				System.out.println("The successive calculation time is " + ratioTime + " nanoseconds");
			}
			System.out.println(" ");
			prevLucas = currentLucas;
			prevTime = timeElapsed;
		}
		



	} 
	
	public static int juliasNumbers(int n) {

		if(n == 0) {
			return 5;
		}
		else if(n == 1) {
			return 13;
		}
		else {
			return juliasNumbers(n-1) + juliasNumbers(n-2);
		}

	}
	//for loops for iterator variables, declare, boolean condition to end loop (while condition), what you do to i at the end of each loop 
	//while loop based on user input or until a certain condition is reached.. forever until

	public static void successiveCalcJulia(int n) {
		int prevJulia = -1;
		long prevTime = -1;

		for(int i = 0; i < n; i++) {
			long startTime = System.nanoTime();
			int currentJulia = juliasNumbers(i);
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			System.out.println("J(" + i + ")= " + currentJulia + " "); 
			System.out.println("The time to compute J(" + i + ") is " + timeElapsed + " nanoseconds");
			
			

			if(i != 0) {
				float ratioJulia = ((float) currentJulia / (float) prevJulia);
				System.out.println("The ratio of successive calculations = " + ratioJulia);
				float ratioTime = ((float) timeElapsed / (float) prevTime);
				System.out.println("The successive calculation time is " + ratioTime + " nanoseconds");
			}
			System.out.println(" ");
			prevJulia = currentJulia;
			prevTime = timeElapsed;
		}
		



	} 



}

