// Bilal Riaz
// CS445 Simple Pivot Class
import java.util.*;
import java.io.*;

public class SimplePivot<T extends Comparable<? super T>> implements Partitionable<T>
{
	@Override
	public int partition(T[] a, int first, int last)
	{
		int pivotIndex = last;  // simply pick pivot as rightmost element
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
	}

	private static void swap(Object [] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	} // end swap
}