package c1.peakfinder;

/**
 * Brute force algorithm to find a peak in a Matrix. Important to notice that
 * this algorithm find any peak and stops. It doesn't find the highest peak!
 * 
 * @author rapha
 */
public class A3_2D_TrivialPeakFinder {

	private static final int N = 10, M = 10;

	public static void main(String[] args) {
		int[][] matrix = generateRandomMatrix();
		int iterations = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				iterations++;
				
				int a = matrix[i][j],
					b = matrix[i][Math.max(j-1, 0)],
					c = matrix[Math.max(i-1, 0)][j],
					d = matrix[i][Math.min(j+1, M-1)],
					e = matrix[Math.min(i+1, N-1)][j];
				if (a >= b && a >= c && a >= d && a >= e) {
					System.out.println("Peak at [" + i + ", " + j + "]. value " + a);
					System.out.println("Iterations: " + iterations);
				}
			}
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
