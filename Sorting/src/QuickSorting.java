import java.util.Date;

public class QuickSorting
{
	public static void main(String[] args)
	{
		// This is unsorted array
		Integer[] array = new Integer[10000000] ;


		for(int count = 0 ; count <10000000; count++)
		{

			array[count] = (int) (Math.random() * 10000);
		}


		Date d1 = new Date ();
		// Let's sort using quick sort
		quickSort( array, 0, array.length - 1 );
		Date d2 = new Date ();
		System.out.println("Ran in " + (d2.getTime()-d1.getTime()));

		// Verify sorted array
		//System.out.println(Arrays.toString(array));
	}

	public static void quickSort(Integer[] arr, int low, int high)
	{
		//check for empty or null array
		if (arr == null || arr.length == 0){
			return;
		}

		if (low >= high){
			return;
		}

		//Get the pivot element from the middle of the list
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j)
		{
			//Check until all values on left side array are lower than pivot
			while (arr[i] < pivot)
			{
				i++;
			}
			//Check until all values on left side array are greater than pivot
			while (arr[j] > pivot)
			{
				j--;
			}
			//Now compare values from both side of lists to see if they need swapping
			//After swapping move the iterator on both lists
			if (i <= j)
			{
				swap (arr, i, j);
				i++;
				j--;
			}
		}
		//Do same operation as above recursively to sort two sub arrays
		if (low < j){
			quickSort(arr, low, j);
		}
		if (high > i){
			quickSort(arr, i, high);
		}
	}

	public static void swap (Integer array[], int x, int y)
	{
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}