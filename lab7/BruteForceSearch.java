package lab7;

public class BruteForceSearch {

	public static void search(String txt, String pat) 
    { 
       int n = txt.length();
       int m = pat.length();
       for(int pos = 0; pos<n-m;pos++)
       {
    	   int curr;
    	   for( curr = 0; curr<m;curr++)
    	   {
    		   if(txt.charAt(pos+curr) != pat.charAt(curr))
    			   break;
    	   } 
    	   if(curr==m)
           {
        	   System.out.println("Pattern at index: "+ pos);
           }
       }
       
       
    	
        } 
  
  
    public static void main(String[] args) 
    { 

    	String txt = "ABABDABACDABABCABAB"; 
        String pat = "CABA"; 
	    
    	System.out.println("BruteForceSearch");
    	double start = System.nanoTime();
    	search(txt, pat);
    	double end = System.nanoTime();
    	System.out.println(((end-start)/1000000)+" seconds");
        
    } 

}
