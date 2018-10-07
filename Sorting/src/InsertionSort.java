

import java.util.Date;

public class InsertionSort {

	static int[] arr = new int[100000];
	static int[] sortedArr = new int[100000];
	

	static int[] insertionSort ( int arr[]){
		int n = arr.length;
		for(int i=1 ; i<n ; i++ ){
			int key = arr[i];
			int j= i-1;
			while( j>=0  && arr[j] >key ){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key ;
		}
		return arr;
	}
	public static void main(String[] args) {
		System.out.println("Perfromance");
		arr[0]=1;
		for(int count = 1 ; count <100000; count++){
			//arr[count] = (int) (Math.random() * 100);
			arr[count] = arr[count-1]+1;
			//System.out.print(arr[count]+" ");
		}
		Date d1 = new Date();	
		sortedArr = insertionSort(arr);
		Date d2 = new Date();
		System.out.println("Perfromance "+ (d2.getTime()-d1.getTime())+" ms");
	}
}
