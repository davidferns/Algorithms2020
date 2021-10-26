package lab4;

public class ElementarySorting {
	
	 static void SelectionSort(int arr[])
    {
        int n = arr.length;
        int small;
  
        for (int i = 0; i < n; i++)
        {
            // The minimum element in unsorted array
            small=i;
            for (int j = i+1; j < n; j++)
            {
                if (arr[j] < arr[small])
                {
                    small = j;
                }
            }
            int temp = arr[small];
            arr[small] = arr[i];
            arr[i] = temp;
        }
    }
	 
	 static void InsertionSort(int arr[])
	 {
	        int n = arr.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = arr[i];
	            int j = i-1;

	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j--;
	            }
	            arr[j+1] = key;
	        }

	 }
	 
	 
	 static void BogoSort(int arr[])
	 {
		int temp;
		for(int i = arr.length-1;i>0;i--)
		{
			int n = (int) (Math.random() * (i + 1));
			temp = arr[i];
			arr[i]=arr[n];
			arr[n]= temp;
			
		}
		
	 }
	
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

	public static void main(String[] args) {
		
        int arr[] = {64,43,76,80,1000,3239,4324,1242,100};
        System.out.println("SelectionSort");
        double start = System.nanoTime();
        SelectionSort(arr);
        double end = System.nanoTime();
		System.out.println(((end-start)/1000000)+" seconds");
        System.out.println("Sorted array");
        printArray(arr);
        System.out.println();
        
        int arr2[] = {64,43,76,80,1000,3239,4324,1242,100};
        System.out.println("InsertionSort");
        double start2 = System.nanoTime();
        InsertionSort(arr2);
        double end2 = System.nanoTime();
		System.out.println(((end2-start2)/1000000)+" seconds");
        System.out.println("Sorted array");
        printArray(arr2);
        System.out.println();
        
        int arr3[] = {64,43,76,80,1000,3239,4324,1242,100};
        System.out.println("BogoSort");
        double start3 = System.nanoTime();
        BogoSort(arr3);
        double end3 = System.nanoTime();
		System.out.println(((end3-start3)/1000000)+" seconds");
        System.out.println("Sorted array");
        printArray(arr3);

		

	}

}