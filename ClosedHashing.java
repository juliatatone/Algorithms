package algorithmsD21;

import java.util.*;
import java.io.*;

public class ClosedHashing {

	static String filePath = "/Users/juliatatone/Downloads/PaulReveresRide.txt";
	public static ArrayList<Integer> values = new ArrayList<Integer>(500);
	public static Integer[] hashTable = new Integer[500];
	static int C = 123;
	static int m = 500;
	static int h;
	static File file = new File(filePath);
	static String [] word;
	static Scanner read;

	static ArrayList<String> text = new ArrayList<String>(500);

	public static void main(String[] args)  throws FileNotFoundException {


		read = new Scanner(file); 	//read the file

		while(read.hasNextLine()) {	//while the scanner is still reading the file
			String str = read.nextLine();	//string to represent the file
			word = str.split("\s", 0);	//create an array with the split words 
			
			for(String w : word) {	//for each word in the file
				text.add(w);  //add the word to an array list 
				for(int i = 0; i < w.length() - 1; i++) {
					int ordC = w.charAt(i);
					h = ((h * C) + ordC) % m; //get the hash code value of that word and store it in a variable h	
				}
				values.add(h);  // add the hash code values to an array list

			}
		}
		ArrayList<String> newText = removeDuplicates(text);
		//print every word of text
		for(int i = 0; i < text.size() - 1; i++) {  //for each index in the text
			for(String w : word) {
				System.out.println(i + "     " + newText.get(i) + "      " + values.get(i));
			}
		}
//		hashTable = values.toArray(hashTable);
//		
//		int[] hashAddress = new int[500];
//		for(int i = 0; i < hashAddress.length; i++) {
//			hashAddress[i] = -1;
//		}
//		for(int i = 0; i < hashTable.length; i++) {
//			if(hashAddress[hashTable[i] == -1]) {
//				
//			}
//		}
		
		
		
//		boolean open = false;
//		while(!open) {
//			for(int i = 0; i < text.size() - 1; i++) {  //for each index in the text
//				for(String w : word) {
//					if(text.get(i) == null) {
//						text.add(word);
//					}
//				}
//			}
//		}
	}
	
	static <T>ArrayList<T> removeDuplicates(ArrayList<T> text) {
		 // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();
  
        // Add the elements to set
        set.addAll(text);
  
        // Clear the list
        text.clear();
  
        // add the elements of set
        // with no duplicates to the list
        text.addAll(set);
  
        // return the list
        return text;
    }
		
}


