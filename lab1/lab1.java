package lab1;

public class lab1 {
	
	static int russianPeasant(int a, int b)
    {
        // initialize result
        int result = 0; 
        while (b > 0)
        {

             if ((b % 2) != 0) 
             {
                 result = result + a;
             }
  
            a = 2*a;
            b = b/2;
        }
        return result;
        
    }

	public static void main(String[] args) {
		
		double start = System.nanoTime();
		System.out.println(russianPeasant(1000, 1200));
		double end = System.nanoTime();
		System.out.println(((end-start)/1000000)+" seconds");
		
		double start1 = System.nanoTime();
		System.out.println(russianPeasant(90, 12));
		double end1 = System.nanoTime();
		System.out.println(((end1-start1)/1000000)+" seconds");
		
		double start2 = System.nanoTime();
		System.out.println(russianPeasant(350, 1290));
		double end2 = System.nanoTime();
		System.out.println(((end2-start2)/1000000)+" seconds");
		

	}

}
