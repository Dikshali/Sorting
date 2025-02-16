import java.util.Date;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		int arraySizeInput=20000;
//		int[] inputArray = {48, 55, 55, 47, 68};
		int[] inputArray = new int[arraySizeInput];
		Random random = new Random();
		for(int i=0;i<arraySizeInput;i++) {
			inputArray[i] = random.nextInt(100);
			//System.out.print(inputArray[i]+" ");
		}
		Date d5 = new Date();
		inputArray = quickSort(inputArray,0,arraySizeInput-1);
		Date d6 = new Date();
		System.out.println("Perfromance of In place Quick sort"+ (d6.getTime()-d5.getTime())+" ms");
		
	}
	public static int[] quickSort(int[] inputArray, int j, int k) {
		int start=j;
		int end=k;
		if(j>=k) {
			return inputArray;
		}
		int pivot = inputArray[k];
		k--;
		while(j<k) {
			if(inputArray[j]>pivot && inputArray[k]<=pivot) {
				int temp=inputArray[k];
				inputArray[k]=inputArray[j];
				inputArray[j]= temp;
				j++;k--;
			}else if(inputArray[j]>pivot && inputArray[k]>pivot){
				k--;
			}else if(inputArray[j]<=pivot && inputArray[k]<=pivot){
				j++;
			}else {
				j++;k--;
			}	
		}
		if(j>=k) {
			if(inputArray[j]>pivot) {
				int temp = inputArray[j];
				inputArray[j] = pivot;
				inputArray[end] = temp;
			}else if(inputArray[j+1]>pivot) {
				int temp = inputArray[j+1];
				inputArray[j+1] = pivot;
				inputArray[end] = temp;
				j=j+1;
			}else if(end==j+1) {
				j=j+1;
			}
		}
		quickSort(inputArray,start,j-1);
		quickSort(inputArray,j+1,end);
		return inputArray;
	}	
	
	/*public static int[] quickSort(int[] inputArray, int j, int k) {
		int start=j;
		int end=k;
		if(j>=k) {
			return inputArray;
		}
		int pivot = inputArray[k];
		k--;
		while(j<k) {
			if(inputArray[j]>pivot && inputArray[k]<=pivot) {
				int temp=inputArray[k];
				inputArray[k]=inputArray[j];
				inputArray[j]= temp;
				j++;k--;
			}else if(inputArray[j]>pivot && inputArray[k]>pivot){
				k--;
			}else if(inputArray[j]<=pivot && inputArray[k]<=pivot){
				j++;
			}else {
				j++;k--;
			}	
		}
		if(j>=k) {
			if(inputArray[j]>pivot) {
				int temp = inputArray[j];
				inputArray[j] = pivot;
				inputArray[end] = temp;
			}else if(inputArray[j+1]>pivot) {
				int temp = inputArray[j+1];
				inputArray[j+1] = pivot;
				inputArray[end] = temp;
				j=j+1;
			}else if(end==j+1) {
				j=j+1;
			}
		}
		quickSort(inputArray,start,j-1);
		quickSort(inputArray,j+1,end);
		return inputArray;
	}	*/
}
