package algorithmsD21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubirachsMagicSquare {


	//first method
	void findFourElements(ArrayList<Integer> magicSquare, int n) {
		System.out.println("The 4-element combinations that have the same sum as the rows/columns are:");
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				for (int k = j + 1; k < n - 1; k++) {
					for (int l = k + 1; l < n; l++) {
						if (magicSquare.get(i) + magicSquare.get(j) + magicSquare.get(k) + magicSquare.get(l) == 33) {
							System.out.println("{" + magicSquare.get(i) + ", " + magicSquare.get(j) + ", " + magicSquare.get(k) + ", " + magicSquare.get(l) + "}");
						}
					}
				}
			}
		}
	}

	//second method
	static void findAllElements(ArrayList<Integer> magicSquare, int k) {
		//sort
		Collections.sort(magicSquare);
		//store all elements that sum
		ArrayList<Integer> currentSums = new ArrayList<Integer>();
		System.out.println("All combinations that have the same sum as the rows/columns are:");
		//call helper method
		sumAll(0, 0, k, currentSums, magicSquare);

	}

	//recursive call helper method for second method
	public static void sumAll(int l, int sum, int k, ArrayList<Integer> currentSums, ArrayList<Integer> magicSquare) {
		
		for(int i = l; i < magicSquare.size(); i++) {
			if(sum + magicSquare.get(i) > k) {
				continue;
			}
			if(i > l && magicSquare.get(i) == magicSquare.get(i-1)) {
				continue;
			}
			currentSums.add(magicSquare.get(i));

			sumAll(i + 1, sum + magicSquare.get(i), k, currentSums, magicSquare);

			currentSums.remove(currentSums.size() - 1);
		}

		//print found combinations of elements
		if(sum == k) {
			System.out.print("{");
			for(int i = 0; i < currentSums.size(); i++) {
				if(i != 0)
					System.out.print(" ");

				System.out.print(currentSums.get(i));
				if(i != currentSums.size() - 1) 
					System.out.print(", ");
			}
			System.out.println("}");

			return;
		}
	}


	//third method
	public static void combinationSums(ArrayList<Integer> magicSquare) {
		//16 yes or no questions for including the sum

		ArrayList<Integer> finalSums = new ArrayList<Integer>(65536);
		for(int i = 0; i < 65536; i++) {
			int yesNo[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			for(int j = 0, copy = i; copy != 0; j++) {
				//J just keeps track of what index the y/n goes in.
				yesNo[j] = copy%2; // check for yes/no (1 or 0) 
				copy = copy/2; //Final digit binary representation
			}
			//calculate the sum from the yes/no questions, then add it to a list
			int sum = 0;
			for(int j =0; j < yesNo.length; j++) {
				if (yesNo[j] == 1) { //
					sum =  sum + magicSquare.get(j);
				}
			} finalSums.add(sum);
			//check that it doesn't get stuck
			if(i % 1000 == 0) {
				System.out.println(i);
			}
		}


		//sort all sums
		Collections.sort(finalSums);

		//System.out.println(finalSums.get(finalSums.size() - 1));
		
		int count = 0;
		int value = finalSums.get(0);
		int prevValue = finalSums.get(0);
		List<Integer> uniqueSums = new ArrayList<Integer>();
		List<Integer> countOfEachSum = new ArrayList<Integer>();
		int maxCount = -1;
		int maxCountValue = 0;

		//System.out.println(finalSums.size());
		for(int i = 0; i < finalSums.size(); i++) {
			value = finalSums.get(i);
			if(i != 0) {
				prevValue = finalSums.get(i -1);
			}
			if(value != prevValue) {
				System.out.println("The number of occurrences is " + count + " for the sum " + prevValue);
				uniqueSums.add(prevValue);
				countOfEachSum.add(count);
				
				//reset count
				count = 1;
			}  else {
				count++;
			}
		}
		System.out.println("The number of occurrences is " + count + " for the sum " + value);
		uniqueSums.add(value);
		countOfEachSum.add(count);
		
		for (int i = 0; i < countOfEachSum.size(); i++) {
			if(countOfEachSum.get(i) > maxCount) {
				maxCount = countOfEachSum.get(i);
				maxCountValue = uniqueSums.get(i);
			}
		}
		System.out.println("The most frequent sum was " + maxCountValue + " which occured " + maxCount + " times");
	}



	public static void main(String[] args) {

		SubirachsMagicSquare fourElements = new SubirachsMagicSquare();
		//make magic square
		ArrayList<Integer> magicSquare = new ArrayList<Integer>(Arrays.asList(
				1, 14, 14, 4,
				11, 7, 6, 9,
				8, 10, 10, 5,
				13, 2, 3, 15));	
		//store size of array
		int n = magicSquare.size();
		//call first method
		fourElements.findFourElements(magicSquare, n);

		int k = 33;

		findAllElements(magicSquare, k);
		combinationSums(magicSquare);

	}
}
