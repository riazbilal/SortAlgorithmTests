// Bilal Riaz
// Assig4 Main Program
import java.util.*;
import java.io.*;
import java.lang.*;

public class Assig4
{
	public Random R = new Random();
	private ArrayList<Sorter<Integer>> sorts;
	private Integer [] A;	
	private int size;
	private int runs;
	private boolean dataSorted;


	public void fillArrayRandom()
	{
		for (int i = 0; i < A.length; i++)
		{
			A[i] = new Integer(R.nextInt(1000000000)); // fill array with random numbers
		}
	}

	public void fillArraySorted()
	{
		for (int i = 0; i < A.length; i++)
		{
			A[i] = new Integer(i); // fill array with sorted numbers 
		}
	}

	public void showArray() // method creating for debugging 
	{
		for (int i = 0; i < A.length; i++)
		{
			System.out.print(A[i] + " ");
		}
		System.out.println("\n");
	}

	public void showTime(double time) // method created for debugging 
	{
		double timeSeconds = time / 1000000000; 
		System.out.printf("Time: " + timeSeconds + " " + "\n");
	}


	public Assig4(String sz, String run, String bool)
	{
		size = Integer.parseInt(sz);
		runs = Integer.parseInt(run);
		dataSorted = Boolean.parseBoolean(bool);
		double averageSortTime = 0; 
		double bestCase = 0;
		double worstCase = 0; 
		double startSortingTime = 0; // initialize start sorting time 
		double endSortingTime = 0; // initialize end sorting time 
		double totalSortingTime = 0; // how long it took for sorting to complete 
		int runCounter = 0; // count how many runs 
		int runCounter1 = 0; 
		int runCounter2 = 0;
		int runCounter3 = 0;
		int runCounter4 = 0;
		int setMin = 3; // setMin counter (increments by 5)

		sorts = new ArrayList<Sorter<Integer>>();
		sorts.add(new QuickSort<Integer>(new SimplePivot<Integer>()));
		sorts.add(new QuickSort<Integer>(new MedOfThree<Integer>()));
		sorts.add(new QuickSort<Integer>(new RandomPivot<Integer>()));
		sorts.add(new MergeSort<Integer>());
		sorts.add(new RiazSort<Integer>());

		A = new Integer[size];

		// initalization information
		if (dataSorted == true)
		{
			System.out.println("Initialization Information:");
			System.out.println("\tArray Size: " + size);
			System.out.println("\tNumber of runs per test: " + runs);
			System.out.println("\tInitial Data: Sorted" + "\n");
		}
		else
		{
			System.out.println("Initialization Information:");
			System.out.println("\t Array Size: " + size);
			System.out.println("\t Number of runs per test: " + runs);
			System.out.println("\t Initial Data: Random" + "\n");
		}

		ArrayList<Double> sortingTimes = new ArrayList<Double>(); // store each average sorting time into array 
		ArrayList<Double> simplePivotSortTimes = new ArrayList<Double>();
		ArrayList<Double> medOfThreeSortTimes = new ArrayList<Double>();
		ArrayList<Double> randomPivotSortTimes = new ArrayList<Double>();
		ArrayList<Double> mergeSortTimes = new ArrayList<Double>();
		ArrayList<Double> riazSortTimes = new ArrayList<Double>();


		System.out.println("Algorithm: Simple Pivot Quicksort");
		double simplePivotBest = 0;
		double simplePivotWorst = 0;
		if (dataSorted == true) //array is intiallty sorted
		{
			//run sorting algorithms with sorted data
			fillArraySorted(); // fill array with sorted data 
			//showArray(); // use for debugging (Array is sorted)
			while (runCounter < runs) // sort data 
			{
				sorts.get(0).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); // initialize starting time of sort
				//showTime(startSortingTime); // debugging purposes 
				sorts.get(0).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				averageSortTime = (totalSortingTime / runs); // average sort time\
				sortingTimes.add(averageSortTime);
				simplePivotSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter++; // increment run counter 
			}
		} // end if 
		else // array is random 
		{
			// run sorting algorithms with random data 
			R.setSeed(123456); // set seed so all algorithms sort the same random data 
			fillArrayRandom();  // fill array with random data 
			//showArray(); // use for debugging (Array is randomized)
			while (runCounter < runs) // sort data 
			{
				//showTime(startSortingTime);
				sorts.get(0).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); 
				sorts.get(0).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				//showTime(endSortingTime);
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				//showTime(totalSortingTime);
				averageSortTime = (totalSortingTime / runs); // average sort time
				sortingTimes.add(averageSortTime); // add average sort time to average list 
				simplePivotSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter++; // increment run counter 
			}
		} // end else 
		simplePivotBest = Collections.min(simplePivotSortTimes);
		simplePivotWorst = Collections.max(simplePivotSortTimes);
		System.out.println("Simple Pivot QuickSort Best Case: " + (simplePivotBest / 1000000000) + " sec");
		System.out.println("Simple Pivot QuickSort Worst Case: " + (simplePivotWorst / 1000000000) + " sec" + "\n");
		
		
		System.out.println("Algorithm: Med of Three Quicksort");
		double medOfThreeBest = 0;
		double medOfThreeWorst = 0;
		if (dataSorted == true) //array is intiallty sorted
		{
			//run sorting algorithms with sorted data
			fillArraySorted(); // fill array with sorted data 
			//showArray(); // use for debugging (Array is sorted)
			while (runCounter1 < runs) // sort data 
			{
				sorts.get(1).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); // initialize starting time of sort
				//showTime(startSortingTime); // debugging purposes 
				sorts.get(1).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				averageSortTime = (totalSortingTime / runs); // average sort time\
				sortingTimes.add(averageSortTime);
				medOfThreeSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter1++; // increment run counter 
			}
		} // end if 
		else // array is random 
		{
			// run sorting algorithms with random data 
			R.setSeed(123456); // set seed so all algorithms sort the same random data 
			fillArrayRandom();  // fill array with random data 
			//showArray(); // use for debugging (Array is randomized)
			while (runCounter1 < runs) // sort data 
			{
				//showTime(startSortingTime);
				sorts.get(1).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); 
				sorts.get(1).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				//showTime(endSortingTime);
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				//showTime(totalSortingTime);
				averageSortTime = (totalSortingTime / runs); // average sort time
				medOfThreeSortTimes.add(averageSortTime);
				sortingTimes.add(averageSortTime); // add average sort time to average list 
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter1++; // increment run counter 
			}
		} // end else 	
		medOfThreeBest = Collections.min(medOfThreeSortTimes);
		medOfThreeWorst = Collections.max(medOfThreeSortTimes);
		System.out.println("Med of Three QuickSort Best Case: " + (medOfThreeBest/ 1000000000) + " sec");
		System.out.println("Med of Three QuickSort Worst Case: " + (medOfThreeWorst / 1000000000) + " sec" + "\n");
		
		
		System.out.println("Algorithm: Random Pivot Quicksort");
		double randomPivotBest = 0;
		double randomPivotWorst = 0;
		if (dataSorted == true) //array is intiallty sorted
		{
			//run sorting algorithms with sorted data
			fillArraySorted(); // fill array with sorted data 
			//showArray(); // use for debugging (Array is sorted)
			while (runCounter2 < runs) // sort data 
			{
				sorts.get(2).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); // initialize starting time of sort
				//showTime(startSortingTime); // debugging purposes 
				sorts.get(2).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				averageSortTime = (totalSortingTime / runs); // average sort time\
				sortingTimes.add(averageSortTime);
				randomPivotSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter2++; // increment run counter 
			}
		} // end if 
		else // array is random 
		{
			// run sorting algorithms with random data 
			R.setSeed(123456); // set seed so all algorithms sort the same random data 
			fillArrayRandom();  // fill array with random data 
			//showArray(); // use for debugging (Array is randomized)
			while (runCounter2 < runs) // sort data 
			{
				//showTime(startSortingTime);
				sorts.get(2).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); 
				sorts.get(2).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				//showTime(endSortingTime);
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				//showTime(totalSortingTime);
				averageSortTime = (totalSortingTime / runs); // average sort time
				sortingTimes.add(averageSortTime); // add average sort time to average list 
				randomPivotSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter2++; // increment run counter 
			}
		} // end else 	 
		randomPivotBest = Collections.min(randomPivotSortTimes);
		randomPivotWorst = Collections.max(randomPivotSortTimes);
		System.out.println("Random Pivot QuickSort Best Case: " + (randomPivotBest / 1000000000) + " sec");
		System.out.println("Random Pivot QuickSort Worst Case: " + (randomPivotWorst / 1000000000) + " sec" + "\n");
		
		
		System.out.println("Algorithm: Merge Sort");
		double mergeSortBest = 0;
		double mergeSortWorst = 0;
		if (dataSorted == true) //array is intiallty sorted
		{
			//run sorting algorithms with sorted data
			fillArraySorted(); // fill array with sorted data 
			//showArray(); // use for debugging (Array is sorted)
			while (runCounter3 < runs) // sort data 
			{
				sorts.get(3).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); // initialize starting time of sort
				//showTime(startSortingTime); // debugging purposes 
				sorts.get(3).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				averageSortTime = (totalSortingTime / runs); // average sort time\
				sortingTimes.add(averageSortTime);
				mergeSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter3++; // increment run counter 
			}
		} // end if 
		else // array is random 
		{
			// run sorting algorithms with random data 
			R.setSeed(123456); // set seed so all algorithms sort the same random data 
			fillArrayRandom();  // fill array with random data 
			//showArray(); // use for debugging (Array is randomized)
			while (runCounter3 < runs) // sort data 
			{
				//showTime(startSortingTime);
				sorts.get(3).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); 
				sorts.get(3).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				//showTime(endSortingTime);
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				//showTime(totalSortingTime);
				averageSortTime = (totalSortingTime / runs); // average sort time
				sortingTimes.add(averageSortTime); // add average sort time to average list 
				mergeSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter3++; // increment run counter 
			}
		} // end else 	 
		mergeSortBest = Collections.min(mergeSortTimes);
		mergeSortWorst = Collections.max(mergeSortTimes);
		System.out.println("Merge Sort Best Case: " + (mergeSortBest / 1000000000) + " sec");
		System.out.println("Merge Sort Worst Case: " + (mergeSortWorst / 1000000000) + " sec" + "\n");

		
		System.out.println("Algorithm: Riaz Sort");
		double riazSortBest = 0;
		double riazSortWorst = 0;
		if (dataSorted == true) //array is intiallty sorted
		{
			//run sorting algorithms with sorted data
			fillArraySorted(); // fill array with sorted data 
			//showArray(); // use for debugging (Array is sorted)
			while (runCounter4 < runs) // sort data 
			{
				sorts.get(4).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); // initialize starting time of sort
				//showTime(startSortingTime); // debugging purposes 
				sorts.get(4).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				averageSortTime = (totalSortingTime / runs); // average sort time\
				sortingTimes.add(averageSortTime);
				riazSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter4++; // increment run counter 
			}
		} // end if 
		else // array is random 
		{
			// run sorting algorithms with random data 
			R.setSeed(123456); // set seed so all algorithms sort the same random data 
			fillArrayRandom();  // fill array with random data 
			//showArray(); // use for debugging (Array is randomized)
			while (runCounter4 < runs) // sort data 
			{
				//showTime(startSortingTime);
				sorts.get(4).setMin(setMin); // intially, set minimum number to recurse to 3 
				startSortingTime = System.nanoTime(); 
				sorts.get(4).sort(A, A.length); // sort data based on i (different sorting algorithms as i increases)
				endSortingTime = System.nanoTime(); // end sorting time  
				//showTime(endSortingTime);
				totalSortingTime += (endSortingTime - startSortingTime); // total time it takes to sort 
				//showTime(totalSortingTime);
				averageSortTime = (totalSortingTime / runs); // average sort time
				sortingTimes.add(averageSortTime); // add average sort time to average list 
				riazSortTimes.add(averageSortTime);
				//showTime(averageSortTime);
				setMin += 5; // after sort increment setMin() by 5 
				runCounter4++; // increment run counter 
			}
		} // end else 	 
		riazSortBest = Collections.min(riazSortTimes);
		riazSortWorst = Collections.max(riazSortTimes);
		System.out.println("Riaz Sort Best Case: " + (riazSortBest / 1000000000) + " sec");
		System.out.println("Riaz Sort Worst Case: " + (riazSortWorst / 1000000000) + " sec" + "\n");




		bestCase = Collections.min(sortingTimes); // best overall sorting algo time 
		worstCase = Collections.max(sortingTimes); // worst overall sorting algo time 
		System.out.printf("Best Case Overall: " + "\n" + "Algorithm: Simple Pivot Quicksort " + "\n" + (bestCase / 1000000000) + " sec" + "\n");
		System.out.printf("\n" + "Worst Case Overall: " + "\n" + "Algorithm: Riaz Sort " + "\n" + (worstCase / 1000000000) + " sec" + "\n");
	} // end Assig4


	public static void main(String[] args)
	{
		new Assig4(args[0], args[1], args[2]);
	}
} // end class 