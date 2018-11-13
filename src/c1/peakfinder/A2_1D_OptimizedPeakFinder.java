package c1.peakfinder;

/**
 * Optimized algorithm to find a peak.
 * Important to notice that this algorithm find any peak and stops.
 * It doesn't find the highest peak!
 * @author rapha
 */
public class A2_1D_OptimizedPeakFinder {
	
	private static final int N = 1000;

	public static void main(String[] args) {
		
		System.out.println("Iterative:");
		Iterative();
		System.out.println("Recursive:");
		Recursive(null, 0, 0, 0);
	}
	
	private static void Iterative() {
		int[] list = generateRandomList();
		int iterations = 0;
		int min = 0, max = N, i;
		
		do {
			i = (max + min)/2;
			iterations++;
			int prev = Math.max(i-1, 0);
			int next = Math.min(i+1, N-1);
			if (list[i] < list[prev]) {				
				max = i;
			}
			else if (list[i] < list[next]) {				
				min = i;
			}
			else {
				System.out.println("Peak at " + i + ", value " + list[i]);
				System.out.println("Iterations: " + iterations);
				break;
			}
			
		} while (i > 0);
	}

	private static void Recursive(int[] list, int min, int max, int iterations) {
		if (list == null) {
			list = generateRandomList();
			min = 0;
			max = list.length;
			iterations = 0;
		}
		
		int i = (max + min)/2;
		int prev = Math.max(i-1, 0);
		int next = Math.min(i+i, N-1);
		iterations++;
		
		if (list[i] < list[prev])
			Recursive(list, min, i, iterations);
		else if (list[i] < list[next])
			Recursive(list, i, max, iterations);
		else {
			System.out.println("Peak at " + i + ", value " + list[i]);
			System.out.println("Iterations: " + iterations);
		}
	}
	
	// Worst case for trivial logic
	private static int[] generateRandomList() {
		int[] randomList = new int[N];
		for (int i = 0; i < N; i++) {
			randomList[i] = i;
		}
		return randomList;
	}

}
