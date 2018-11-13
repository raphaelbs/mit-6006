package c1.peakfinder;

/**
 * Brute force algorithm to find a peak.
 * Important to notice that this algorithm find any peak and stops.
 * It doesn't find the highest peak!
 * @author rapha
 */
public class A1_1D_TrivialPeakFinder {

	private static final int N = 1000;
	
	public static void main(String[] args) {
		int[] list = generateRandomList();
		int iterations = 0;
		
		for (int i=0; i<N; i++) {
			iterations++;
			int prev = Math.max(i-1, 0);
			int next = Math.min(i+1, N-1);
			if (list[i] >= list[prev] && list[i] >= list[next]) {
				System.out.println("Peak at " + i + ", value " + list[i]);
				System.out.println("Iterations: " + iterations);
				break;
			}
		}
	}
	
	// Worst case
	private static int[] generateRandomList() {
		int[] randomList = new int[N];
		for (int i=0; i<N; i++) {
			randomList[i] = i;
		}
		return randomList;
	}

}
