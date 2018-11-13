package c1.peakfinder;

/**
 * Optimized algorithm to find a peak in a Matrix. Important to notice that this
 * algorithm find any peak and stops. It doesn't find the highest peak!
 *  _ _ _
 * |_|c|_|
 * |b|a|d|
 * |_|e|_|
 * 
 * @author rapha
 */
public class A4_2D_OptimizedPeakFinder {
	
	private static final int N = 10, M = 10;

	public static void main(String[] args) {

		System.out.println("Iterative:");
		Iterative();
		
		System.out.println("Recursive:");
		Recursive(null, 0, 0, 0, 0);
		
	}
	
	private static void Iterative() {
		int[][] matrix = generateRandomMatrix();
		int iterationsJ = 0, iterationsI = 0;
		
		int jmin = 0, jmax = M, j;
		do {
			iterationsJ++;
			j = (jmax + jmin)/2;
			
			int vbig = Integer.MIN_VALUE, ibig = 0;
			for (int i=0; i<N; i++) 
				if (matrix[i][j] > vbig) {
					vbig = matrix[i][j];
					ibig = i;
					iterationsI++;
				}
					
			int a = matrix[ibig][j],
					b = matrix[ibig][Math.max(j-1, 0)],
					d = matrix[ibig][Math.min(j+1, M-1)];
			
			if (a < b)
				jmax = j;
			else if (a < d)
				jmin = j;
			else {
				System.out.println("Peak at [" + ibig + ", " + j + "]. value " + a);
				System.out.println("Iterations: " + iterationsI + "i + " + iterationsJ + "j = " + (iterationsI + iterationsJ));
				break;
			}						
		} while(j > 1);
	}
	
	private static void Recursive(int[][] matrix, int jmin, int jmax, int iterationsJ, int iterationsI) {
		if (matrix == null) {
			matrix = generateRandomMatrix();
			iterationsI = 0;
			iterationsJ = 0;
			jmin = 0;
			jmax = M;
		}
		
		iterationsJ++;
		int j = (jmax + jmin)/2;
		int vbig = Integer.MIN_VALUE, ibig = 0;
		
		for (int i=0; i<N; i++)
			if (matrix[i][j] > vbig) {
				vbig = matrix[i][j];
				ibig = i;
				iterationsI++;
			}
		
		int a = matrix[ibig][j],
			b = matrix[ibig][Math.max(0, j-1)],
			d = matrix[ibig][Math.min(j+1, M-1)];
		
		if (a < b)
			Recursive(matrix, jmin, j, iterationsJ, iterationsI);
		else if (a < d)
			Recursive(matrix, j, jmax, iterationsJ, iterationsI);
		else {			
			System.out.println("Iterations: " + iterationsI + "i + " + iterationsJ + "j = " + (iterationsI + iterationsJ));
			System.out.println("Peak at [" + ibig + ", " + j + "]. value " + a);
		}
	}

	// Worst case
	private static int[][] generateRandomMatrix() {
		int[][] matrix = new int[N][M];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				matrix[i][j] = i + j;

		return matrix;
	}

}
