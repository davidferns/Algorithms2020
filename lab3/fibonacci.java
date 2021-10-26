package lab3;

public class fibonacci {

	static int fibonacciIterative(int n){
		  if (n<=1)
		      return 1 ;

		  int fib = 1;
		  int prevFib =  1;

		  for (int i = 2; i < n; i++) {
		   int temp = fib;
		   fib = fib + prevFib;
		   prevFib = temp;
		  }
		  return fib;
		  
		 }
	
	static int fibonacciRecursive(int number) {
		
		if(number<=1)
		{
			return number;
		}
		else
		{
			return(fibonacciRecursive(number-1)+fibonacciRecursive(number-2));
		}

		
	}
	

	public static void main (String args[])
	{ 
	    int n = 20; 
	    System.out.println("Fibonacci Recursive");
	    double start = System.nanoTime();
	    System.out.println(fibonacciRecursive(n));
	    double end = System.nanoTime();
	    System.out.println(((end-start)/1000000)+" seconds");
	    System.out.println();
	    System.out.println("Fibonacci Iterative");
	    double start2 = System.nanoTime();
	    System.out.println(fibonacciIterative(n));
	    double end2 = System.nanoTime();
	    System.out.println(((end2-start2)/1000000)+" seconds");
    } 
}
