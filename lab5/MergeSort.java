package lab5;

public class MergeSort {

    private static final int CUTOFF = 15;
    
    public static void merge(int[] a, int[] l, int[] r, int left, int right){
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j])
            {
                a[k++] = l[i++];
            }
            
            else
            	
            	{
            	a[k++] = r[j++];
            	}
        }
        while (i < left)
        {
            a[k++] = l[i++];
        }
        while (j < right) 
        {
        	a[k++] = r[j++];	
        }
        	
    }

    public static void mergeSort(int[] a, int n){
        if (n < 2)
            return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

   

    public static void mergeSortEnhanced(int[] a, int n) {

        int lo = 0;
        int hi = n-1;
        if (lo + CUTOFF > hi) {
            insertion_sort(a);
        } else {

            if (n < 2)
            {
                return;
            }
            int mid = n / 2;
            int[] l = new int[mid];
            int[] r = new int[n - mid];
            for (int i = 0; i < mid; i++) {
                l[i] = a[i];
            }
            for (int i = mid; i < n; i++) {
                r[i - mid] = a[i];
            }
            mergeSortEnhanced(l, mid);
            mergeSortEnhanced(r, n - mid);

            if(a[mid] <= a[mid+1]) {
                merge(a, l, r, mid, n - mid);
            }
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

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
    	
    	int arr[] = {64,25,1234,92,22,11,78,22637,100};
    	System.out.println("MergeSort");
    	double start = System.nanoTime();
    	mergeSort(arr,arr.length);
    	double end = System.nanoTime();
    	System.out.println(((end-start)/1000000)+" seconds");
        System.out.println("Sorted array");
        printArray(arr);
        System.out.println();
        
    	int arr2[] = {64,25,1234,92,22,11,78,22637,100};
    	System.out.println("Enhanced MergeSort");
    	double start1 = System.nanoTime();
    	mergeSortEnhanced(arr2,arr2.length);
    	double end1 = System.nanoTime();
    	System.out.println(((end1-start1)/1000000)+" seconds");
        System.out.println("Sorted array");
        printArray(arr2);
        System.out.println();
    	
    	
    
    }
}
