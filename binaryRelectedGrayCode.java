package algorithmsD21;

import java.util.ArrayList;
import java.util.Collections;

public class binaryRelectedGrayCode {

	static ArrayList<String> greyCode(int n){
		ArrayList<String> l = new ArrayList<String>();
		if(n ==1) {
			l.add("0");
			l.add("1");
		} else {
			ArrayList<String> L1 = greyCode(n-1);
			ArrayList<String> L2 = (ArrayList<String>) L1.clone();
			Collections.reverse(L2);


			for(int i = 0; i < L1.size(); i++) {
				L1.set(i, "0" + L1.get(i));
			} 
			for(int i = 0; i < L2.size(); i++) {
				L2.set(i, "1" + L2.get(i));
			}
			//constructing big list
			l = L1;

			for(int i = 0; i < L2.size(); i++) {
				l.add(L2.get(i));
			}
		}
		System.out.println(l);
		return l;

	}
	static ArrayList<String> joinFade(ArrayList<String> l){
		ArrayList<String> mathemusicians = new ArrayList<String>();
		for(int i = 0; i < l.size(); i++) {


			String s = l.get(i);
			int n = Integer.parseInt(s);
			
			if(n != 0) {
				
				//System.out.println("s is " + s);
				if(i > 0) {
					String p = l.get(i -1);
					int m = Integer.parseInt(p);

					int diff = n - m;
					if(diff == 1) {
						mathemusicians.add("Alexiev");
						System.out.println("Alexiev joins");
					}
					if(diff == 10) {
						mathemusicians.add("Barack");
						System.out.println("Barack joins");
					}
					if(diff == 100) {
						mathemusicians.add("Clarice");
						System.out.println("Clarice joins");
					}
					if(diff == 1000 ) {
						mathemusicians.add("Darlene");
						System.out.println("Darlene joins");
					}
					if(diff == 10000) {
						mathemusicians.add("Eduardo");
						System.out.println("Eduardo joins");
					}
					if(diff == -1) {
						mathemusicians.add("Alexiev");
						System.out.println("Alexiev fades");
					}
					if(diff == -10) {
						mathemusicians.add("Barack");
						System.out.println("Barack fades");
					}
					if(diff == -100) {
						mathemusicians.add("Clarice");
						System.out.println("Clarice fades");
					}
					if(diff == -1000) {
						mathemusicians.add("Darlene");
						System.out.println("Darlene fades");
					}
					if(diff == -10000) {
						mathemusicians.add("Eduardo");
						System.out.println("Eduardo fades");
					}

				}

			}
		}
		return mathemusicians;
	}

	public static void main(String[] args) {
		greyCode(5);
		System.out.println(joinFade(greyCode(5)));

	}

}
