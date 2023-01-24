package algorithmsD21;

import java.util.Scanner;

public class PalindromeCheck {
//this method will check if a string is a palindrome
	static boolean palindromeCheck(String str) {
		
		//tracking the letters at the beginning (i) and end of the string (j)
		int i = 0, j = str.length() -1;
		
		//compare
		while(i < j) {
			//increment and decrement
			i++;
			j--;
			//when there is a mismatch...
			if(str.charAt(i) != str.charAt(j)) 
				return false;
		}
		//if the string is a palindrome
		return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		// take in input
		System.out.println("Enter the word/phrase/sentence you would like to check to see if it is a palindrome: ");
		
		String str = scn.nextLine();
		
		//remove whitespace, punctuation, case sensitivity
		str = str.toLowerCase().replaceAll("\\W", "");
		
		if(palindromeCheck(str))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
