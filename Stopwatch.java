package selection_sort;

import java.util.Scanner;
/**
 * Stop watch that accumulates time when running
 * Measures elapsed time
 * Can be used to measure run-time of methods/program/etc.
 */

public class Stopwatch {
	
	private long elapsedTime;
	private long startTime;
	private boolean isRunning;
	
	// Constructor - build stop watch that is in a stopped state/has no elapsed time
	public Stopwatch() {
		reset();
	}
	
	// Helper method - starts stop watch, time starts accumulating
	public void start() {
		if (isRunning) {
			return;
		}
		isRunning = true;
		startTime = System.currentTimeMillis();
	}
	
	// Helper method - stops stop watch, time stops accumulating and is added to elapsed time
	public void stop() {
		if (!isRunning) {
			return;
		}
		isRunning = false;
		long endTime = System.currentTimeMillis();
		elapsedTime = elapsedTime + endTime - startTime;
	}
	
	// Helper method - returns elapsed time
	public long getElapsedTime() {
		if (isRunning) {
			long endTime = System.currentTimeMillis();
			return elapsedTime + endTime - startTime;
		}
		else {
			return elapsedTime;
		}
	}
	
	// Stops the stop watch and resets elapsed time to 0.0
	public void reset() {
		elapsedTime = 0;
		isRunning = false;
	}
	
	// Driver
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter array size: ");
		int n = in.nextInt();
		
		// Construct random array
		int[] a = SelectionSorter.randomIntArray(n,  100);
		
		// Use stop watch to time selection sort
		Stopwatch timer = new Stopwatch();
		
		timer.start();
		SelectionSorter.sort(a);
		timer.stop();
		
		System.out.println("Elapsed time with selection sort: " + timer.getElapsedTime() + " milliseconds");
		
		timer.start();
		InsertionSort.sort(a);
		timer.stop();
		
		System.out.println("Elapsed time with insertion sort: " + timer.getElapsedTime() + " milliseconds");
	}
}
