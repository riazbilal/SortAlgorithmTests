// Bilal Riaz
// CS0445 MergeSort Class
import java.util.*;
import java.io.*;

public class MergeSort<T extends Comparable<? super T>> implements Sorter<T>
{
	 private int MIN_SIZE; // min size to recurse, use InsertionSort for smaller sizes to complete sort

     public MergeSort()
     {
          MIN_SIZE = 3;
     }
     public void sort(T[] a, int size)
     {
     	sort(a, 0, size - 1);
     }
     public void sort(T[] a, int first, int last)
     {
     	T[] tempArray = (T[])new Comparable<?>[a.length];
     	sort(a, tempArray, first, last);
     }
     public void sort(T[] a, T[] tempArray, int first, int last)
     {
     	if (first < last)
	    {  // sort each half
	      int mid = (first + last)/2;// index of midpoint
	      sort(a, tempArray, first, mid);  // sort left half array[first..mid]
	      sort(a, tempArray, mid + 1, last); // sort right half array[mid+1..last]

			if (a[mid].compareTo(a[mid + 1]) > 0)      
	     	 	merge(a, tempArray, first, mid, last); // merge the two halves
	    //	else skip merge step
	    }  // end if
     }

     private void merge(T[] a, T[] tempArray, int first, int mid, int last)
	{
		// Two adjacent subarrays are a[beginHalf1..endHalf1] and a[beginHalf2..endHalf2].
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// while both subarrays are not empty, copy the
	   // smaller item into the temporary array
		int index = beginHalf1; // next available location in
								            // tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
	   {  // Invariant: tempArray[beginHalf1..index-1] is in order
	   
	      if (a[beginHalf1].compareTo(a[beginHalf2]) <= 0)
	      {  
	      	tempArray[index] = a[beginHalf1];
	        beginHalf1++;
	      }
	      else
	      {  
	      	tempArray[index] = a[beginHalf2];
	        beginHalf2++;
	      }  // end if
	   }  // end for

	   // finish off the nonempty subarray

	   // finish off the first subarray, if necessary
	   for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
	      // Invariant: tempArray[beginHalf1..index-1] is in order
	      tempArray[index] = a[beginHalf1];

	   // finish off the second subarray, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
	      // Invariant: tempa[beginHalf1..index-1] is in order
	      tempArray[index] = a[beginHalf2];
		
	   // copy the result back into the original array
	   for (index = first; index <= last; index++)
	      a[index] = tempArray[index];
	}  // end merge

	public void setMin(int minSize)
	{
		MIN_SIZE = minSize; 
	}

} // end class 