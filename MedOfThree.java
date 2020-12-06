// Bilal Riaz
// CS445 Med of Three class
import java.util.*;
import java.io.*;

public class MedOfThree<T extends Comparable<? super T>> implements Partitionable<T>
{
	public int partition(T[] a, int first, int last)
	{
	  int mid = (first + last)/2;
	  sortFirstMiddleLast(a, first, mid, last);
	  
	 
	  swap(a, mid, last - 1);
	  int pivotIndex = last - 1;
	  T pivot = a[pivotIndex];
	  
	  // determine subarrays Smaller = a[first..endSmaller]
	  // and                 Larger  = a[endSmaller+1..last-1]
	  // such that elements in Smaller are <= pivot and 
	  // elements in Larger are >= pivot; initially, these subarrays are empty

	  int indexFromLeft = first + 1; 
	  int indexFromRight = last - 2; 
	  boolean done = false;
	  while (!done)
	  {
	    // starting at beginning of array, leave elements that are < pivot;
	    // locate first element that is >= pivot; you will find one,
	    // since last element is >= pivot
	    while (a[indexFromLeft].compareTo(pivot) < 0)
	      indexFromLeft++;
	      
	    // starting at end of array, leave elements that are > pivot; 
	    // locate first element that is <= pivot; you will find one, 
	    // since first element is <= pivot
	    while (a[indexFromRight].compareTo(pivot) > 0)
	      indexFromRight--;
	      
	    assert a[indexFromLeft].compareTo(pivot) >= 0 && 
	           a[indexFromRight].compareTo(pivot) <= 0;
	           
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

	private void swap(Object [] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	} // end swap

	private void sortFirstMiddleLast(T[] a, int first, int mid, int last)
	{
	  order(a, first, mid); // make a[first] <= a[mid]
	  order(a, mid, last);  // make a[mid] <= a[last]
	  order(a, first, mid); // make a[first] <= a[mid]
	} // end sortFirstMiddleLast

	private void order(T[] a, int i, int j)
	{
	  if (a[i].compareTo(a[j]) > 0)
	    swap(a, i, j);
	} // end order

} // end MedOfThree class
