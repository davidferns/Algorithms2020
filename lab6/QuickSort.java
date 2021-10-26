package lab6;

public class QuickSort {

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
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
    
public static void main(String[] args) {
    	
	int arr[] = {64,25,1234,92,22,11,78,22637,100};
	System.out.println("QuickSort");
	double start = System.nanoTime();
	quickSort(arr,0,arr.length-1);
	double end = System.nanoTime();
	System.out.println(((end-start)/1000000)+" seconds");
    System.out.println("Sorted array");
    printArray(arr);
    System.out.println();
}
}
