package lab6;

import java.util.Arrays;

public class EnhancedQuickSort {
	
	  private static final int CUTOFF = 10;



	    static void quickSort(int[] arr, int low, int high)
	    {
	        if( low + CUTOFF >= high ) {
	            insertion_sort(arr);
	        }
	        else if(low < high) {
	            int pi = medianOf3(arr, low, high);
	            quickSort(arr, low, pi - 1);
	            quickSort(arr, pi + 1, high);
	        }
	    }
	    public static void insertion_sort(int[] arr){


	        for (int i = 1; i < arr.length; ++i) {
	            int key = arr[i];
	            int j = i -1;

	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j--;
	            }
	            arr[j+1] = key;
	        }

	    }
	    
	    static void printArray(int[] arr)
	    {
	        for(int i = 0; i < arr.length; i++)
	        {
	            System.out.print(arr[i] + " ");
	        }

	        System.out.println();
	    }


	    public static int medianOf3(int arr[], int low, int high) {

	        int mid = (high) / 2;

	        int[] sortingArr = { arr[low], arr[mid], arr[high] };

	        Arrays.sort(sortingArr);

	        int midValue = sortingArr[1];

	        int tmp = arr[high];
	        arr[high] = midValue;
	        if (midValue == arr[low]) {
	            arr[low] = tmp;
	        } else if (midValue == arr[mid]) {
	            arr[mid] = tmp;
	        }

	        return partition(arr, low, high);
	        

	    }
	    
		   
	    static int partition(int[] arr, int low, int high)
	    {

	        int pivot = arr[high];

	        int i = (low - 1);

	        for(int j = low; j <= high - 1; j++)
	        {
	            if (arr[j] < pivot)
	            {
	                i++;
	                swap(arr, i, j);
	            }
	        }
	        swap(arr, i + 1, high);
	        return (i + 1);
	    }
	    
	    static void swap(int[] arr, int i, int j)
	    {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	int arr[] = {64,25,1234,92,22,11,78,22637,100};
	    	System.out.println("Enhanced QuickSort");
	    	double start = System.nanoTime();
	    	quickSort(arr,0,arr.length-1);
	    	double end = System.nanoTime();
	    	System.out.println(((end-start)/1000000)+" seconds");
	        System.out.println("Sorted array");
	        printArray(arr);
	        System.out.println();
	}

}
