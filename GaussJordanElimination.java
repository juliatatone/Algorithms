package algorithmsD21;



// 1.a) The ForwardElimination algorithm on page 210 is not always correct if A[i,i] =0. This is the case for x1 in the first column and first row. Because of this, we cannot use that row as a pivot row for the ith iteration of the algorithm. It zeroes out A[i + 1, n + 1] in the beginning, but it should do that in the end.
//1. b) The problem in the ForwardElimination algorithm is in the innermost loop, for k ← i to n + 1 do A[j, k]← A[j, k] − A[i, k] ∗ A[j, i] / A[i, i] (forwards). The BetterForwardElimination algorithm fixes this inefficiency by doing for k ← i to n + 1 do A[j, k]← A[j, k] − A[i, k] ∗ temp (backwards). The BetterForwardElimination also incorporates partial pivoting. The betterForwardElimination does the A[i + 1, n + 1] at the end like it should. 

// 2. The third column of the matrix/equations is 1x, 2x, 3x (linear) and this can cause issues trying to find the solution, especially if there are infinite solutions and it can't pick up on this. To remedy this, add something in the algorithm to check for linear combinations in other rows. Also add something to find no solution or infinite solutions.

public class GaussJordanElimination {

	static int N = 11;

	//reducing matrix
	static int GaussJordanElim(float a[][], int n) {
		int i = 0;
		int j = 0;
		int k = 0;

		int c = 0;
		int f = 0;


		for(i = 0; i < n; i++) {
			if(a[i][i] == 0) {
				c = 1;
				while ((i + c) < n && a[i + c][i] == 0) {
					c++;
				}
				if((i + c) == n) {
					f = 1;
					break;
				}
				for(j = i, k = 0; k <= n; k++) {
					float temp = a[j][k];
					a[j][k] = a[j+c][k];
					a[j+c][k] = temp;
				}
			}
			for(j = 0; j < n; j++) {
				if(i != j) {
					float p = a[j][i] / (a[i][i]);

					for(k = 0; k<= n; k++) {
						a[j][k] = a[j][k] - (a[i][k]) * p;
					}

				}
			}

		}
		return f;
	}

	static void PrintResult(float a[][], int n, int f) {
		System.out.print("Result is: ");

		if(f == 2) {
			System.out.print("Infinite Solutions Exists");
		}
		else if(f == 3) {
			System.out.println("NO solution Exists");
		}
		else {
			for(int i = 0; i < n; i++) {
				System.out.print(a[i][n] / a[i][i] + " ");
			}
		}
	}

	static void PrintMatrix(float a[][], int n)
	{
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j <= n; j++) 
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	static int Check(float a[][], int n, int f) {
		int i, j;
		float sum;

		f = 3; //no solution

		for(i = 0; i < n; i++) {
			sum = 0;
			for(j = 0; j< n; j++) {
				sum = sum + a[i][j];
			}
			if(sum == a[i][j]) {
				f = 2; //infinite solutions
			}
		}
		return f;
	}

	public static void main(String[] args) {
		float a[][] = { 
				{1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 0},
				{1, 1, 1, 1, 5, 1, 5, 1, 1, 1, 1, 0},
				{1, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 0},
				{1, 1, 3, 1, 1, 1, 1, 1, 3, 1, 1, 0},
				{1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0},
				{11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
				{1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10},
				{1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 12},
				{1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 10},
				{1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 7},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0} 
		};

		int n = 3;
		int f = 0;

		f = GaussJordanElim(a, n);

		if(f == 1) {
			f = Check(a, n, f);
		}

		System.out.println("Final Augumented Matrix is : ");
		PrintMatrix(a, n);
		System.out.println("");

		//solutions
		PrintResult(a, n, f);

	}

}
