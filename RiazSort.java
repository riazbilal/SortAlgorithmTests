// Bilal Riaz 
// Extra Credit Sort Class
// Sorts by find min element and placing it at beginning of array 
import java.util.*;
import java.io.*;
import java.lang.*;

public class RiazSort<T extends Comparable<? super T>> implements Sorter<T>
{
	private int MIN_SIZE;
	private static Integer A[];
	private static ArrayList<Sorter<Integer>> sorts;
	private static Random R = new Random();

	public RiazSort()
	{
		MIN_SIZE = 3; 
	}

	public void sort(T[] a, int size)
    {
     	sort(a, 0, size - 1);
    }
    public void sort(T[] a, int first, int last)
    {
    	int n = a.length;
    	int indexSwap; 

    	for (int i = 0; i < n-1; i++)
    	{
    		indexSwap = i; 
    		for (int j = i + 1; j < n; j++)
    		{
    			if (a[j].compareTo(a[indexSwap]) < 0)
    			{
    				indexSwap = j;
    			}
    		}
    			T temp = a[indexSwap];
    			a[indexSwap] = a[i];
    			a[i] = temp;
    	}

    } // end sort



    private void swap(Object [] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	} // end swap

	public static void showArray() // method creating for debugging 
	{
		for (int i = 0; i < A.length; i++)
		{
			System.out.print(A[i] + " ");
		}
		System.out.println("\n");
	}
	public void setMin(int minSize)
    {
     	MIN_SIZE = minSize; 
    }
    public static void fillArrayRandom()
	{
		for (int i = 0; i < A.length; i++)
		{
			A[i] = new Integer(R.nextInt(100)); // fill array with random numbers
		}
	}
	/*public static void main(String[] args)
	{
		sorts = new ArrayList<Sorter<Integer>>();
		sorts.add(new RiazSort<Integer>());
		int size = 10;
		A = new Integer[size];
		fillArrayRandom();
        sorts.get(0).setMin(3);
        sorts.get(0).sort(A, A.length); 
        System.out.println("Sorted array"); 
        showArray(); 
	}*/


} // end class 

