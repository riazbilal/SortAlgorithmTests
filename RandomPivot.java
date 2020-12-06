// Bilal Riaz
// CS0445 RandomPivot Class
import java.util.*;
import java.io.*;

public class RandomPivot<T extends Comparable<? super T>> implements Partitionable<T>
{
	public int partition(T[] a, int first, int last)
	{
		Random random = new Random();
		int pivotIndex = first + random.nextInt(last - first + 1); // chose a random pivot from first to last  
		swap(a, pivotIndex, last); // swap random pivot chosen to last index
		pivotIndex = last; // make pivot index equal to last 
		T pivot = a[pivotIndex];

		int indexFromLeft = first;
		int indexFromRight = last - 1; 

		boolean done = false;
		while (!done)
		{
			while (a[indexFromLeft].compareTo(pivot) < 0)
				indexFromLeft++;

			while (a[indexFromRight].compareTo(pivot) > 0 && indexFromRight > first)
				indexFromRight--;

			if (indexFromLeft < indexFromRight)
			{
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else 
				done = true;
		} // end while 

		// place pivot between Smaller and Larger subarrays
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;

		return pivotIndex; 
	} // end partition 

	private static void swap(Object [] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	} // end swap
}