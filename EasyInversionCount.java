package algorithmsD21;

public class EasyInversionCount {
static int A[] = new int[] {2, 30, 7, 8, 10};
	
	static int easyInversionCount(int n) {
		int inversionCount = 0;
		for(int i = 0; i < n - 1; i++)
			for(int j = i + 1; j < n; j++)
				if(A[i] > A[j])
					inversionCount++;
		
		return inversionCount;
		
	}

	public static void main(String[] args) {
		System.out.println("Number of inversions for the array A are " + easyInversionCount(A.length));
	}
}
