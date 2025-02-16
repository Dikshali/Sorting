import java.util.Date;
import java.util.Random;

public class MedianQuickSort {
	public static void main(String[] args) {
		int arraySizeInput=50000;
		int[] inputArray = new int[arraySizeInput];
		Random random = new Random();
		for(int i=0;i<arraySizeInput;i++) {
			inputArray[i] = random.nextInt(100);
			System.out.print(inputArray[i]+" ");
		}
		System.out.println();
		Date d1 = new Date();
		inputArray = medianSort(inputArray,0,arraySizeInput-1);
		Date d2 = new Date();
		System.out.println("Perfromance "+ (d2.getTime()-d1.getTime())+" ms");
		for(int i=0;i<arraySizeInput;i++) {
			System.out.print(inputArray[i]+" ");
		}
		
	}
	public static int[] medianSort(int[] inputArray, int j, int k) {
		int start=j;
		int end=k;
		if((k-j+1)<=10) {
			return InsertionSort.insertionSort(inputArray);
			
		}
		int a[] = new int[3];
		a[0] = inputArray[j];
		a[1] = inputArray[k];
		a[2] = inputArray[((k-j+1)/2)+j];
		if(a[0]>a[1]) {
			int t= a[0];
			a[0]=a[1];
			a[1]=t;
		}
		if(a[0]>a[2]) {
			int t= a[0];
			a[0]=a[2];
			a[2]=t;
		}
		if(a[1]>a[2]) {
			int t= a[1];
			a[1]=a[2];
			a[2]=t;
		}
		inputArray[j] = a[0];
		inputArray[k] = a[2];
		inputArray[((k-j+1)/2)+j] = inputArray[k-1];
		inputArray[k-1] = a[1];
		
		int pivot = inputArray[k-1];
		int pivotIndex = k-1;
		k = k-2;
		j=j+1;
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
				inputArray[pivotIndex] = temp;
			}else if(inputArray[j+1]>pivot) {
				int temp = inputArray[j+1];
				inputArray[j+1] = pivot;
				inputArray[pivotIndex] = temp;
				j=j+1;
			}else if(pivotIndex==j+1) {
				j=j+1;
			}
		}
		medianSort(inputArray,start,j-1);
		medianSort(inputArray,j+1,end);
		return inputArray;
	}

}
