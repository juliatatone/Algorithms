package algorithmsD21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.max;

public class PreciousPath {

	public static int[][] getRedNumbers(int[][] blackNumbers) {
		int[][] redNumbers = new int[blackNumbers.length][blackNumbers[0].length];
		//special case for row 1 elements, their red numbers are the starting black numbers
		redNumbers[0] = blackNumbers[0];
		for(int i = 1; i < redNumbers.length; i++) {
			for(int j = 0; j < redNumbers[0].length; j++) {
				int downMiddle = Integer.MIN_VALUE;
				int downRight = Integer.MIN_VALUE;
				int downLeft = Integer.MIN_VALUE;
				
				downMiddle = redNumbers[i-1][j];
				
				//special case for right most column
				if(j != redNumbers[0].length - 1) {
					downRight = redNumbers[i-1][j+1];
				}
				//special case for left most column
				if(j != 0) {
					downLeft = redNumbers[i-1][j-1];	
				}
				
				//find max of downMiddle, downRight, downLeft
				int max = Integer.MIN_VALUE;
				if(downMiddle > max) {
					max = downMiddle;
				}
				if(downLeft > max) {
					max = downLeft;
				}
				if(downRight > max) {
					max = downRight;
				}
				redNumbers[i][j] = max + blackNumbers[i][j];			
				
			} 
		}
		
		
		
		return redNumbers;
		
		
		}
	
	
	
	
	  public static ArrayList<Integer> findPreciousPath(int[][] redNumbers){
		//find max gems in 8th row (final square)
			 ArrayList<Integer> lastRow = new ArrayList<Integer>();
			 for(int i = 0; i < 8; i++) {
				 lastRow.add(redNumbers[7][i]);		 
			 }
			 int redNumbersMax = Collections.max(lastRow);
			 System.out.println("The total number of gems collected on the way is " + redNumbersMax + " gems");
			 
			 int maxPositionLastRow = -1;
			 for(int i = 0; i < 8; i++) {
				 if(redNumbersMax == redNumbers[7][i]) {
					maxPositionLastRow = i;
					break;
				 }
			 }
			 
			 ArrayList<Integer> path = new ArrayList<Integer>(8);
			 //find max of downLeft, downRight, downMiddle of max value through 7-1 rows
			 for(int i = 7; i >= 0; i--) {
				 
				 int downMiddle = Integer.MIN_VALUE;
				 int downRight = Integer.MIN_VALUE;
				 int downLeft = Integer.MIN_VALUE; 
				 
				 downMiddle = redNumbers[i][maxPositionLastRow];
				 
				 	//special case for right most column
					if(maxPositionLastRow != redNumbers[0].length - 1) {
						downRight = redNumbers[i][maxPositionLastRow + 1];
					}
					//special case for left most column
					if(maxPositionLastRow != 0) {
						downLeft = redNumbers[i][maxPositionLastRow - 1];	
					}
					
					//find max of downMiddle, downRight, downLeft
					int max = Integer.MIN_VALUE;
					if(downMiddle > max) {
						max = downMiddle;
					}
					if(downLeft > max) {
						max = downLeft;
					}
					if(downRight > max) {
						max = downRight;
					}
					
					//remember which column the max number (out of the three possible moves) is in
					int maxIndex = -1;
					for(int j = 0; j < 8; j++) {
						 if(max == redNumbers[i][j]) {
							maxIndex = j; 
							continue;
							} 
						 
							
							
						 }
					
					
					//make array to contain the indices of the steps on the path to get from the max gem stones to the starting square
					
					
					
				 //update maxPositionLastRow
					maxPositionLastRow = maxIndex;
					path.add(maxIndex + 1);
			 }
			 int start = path.get(0);
			 int end = path.get(7);
			 System.out.println("the precious path is: start " + path + " end");
			 System.out.println("Bilbo's starting square is in row 1, vault  " + start);
			 System.out.println("The Arkenstone was in vault " + end);
			 
		  	  
		  return lastRow; 
		  }
	 
	
	public static void main(String[] args) {
		
		int blackNumbers[][] = { 
				{84, 96, 33, 44, 99, 98, 70, 74},
				{76, 10, 42, 1, 53, 46, 24, 90},
				{7, 91, 94, 83, 30, 65, 51, 27},
				{12, 56, 63, 47, 67, 22, 92, 68},
				{15, 78, 11, 89, 95, 13, 71, 48},
				{25, 32, 41, 17, 16, 31, 4, 64},
				{50, 14, 5, 39, 73, 78, 37, 23},
				{21, 35, 52, 94, 66, 82, 97, 20}
		};
		
		int [][] redNumbers = getRedNumbers(blackNumbers);
		findPreciousPath(redNumbers);
				
		}

	}


