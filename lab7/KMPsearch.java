package lab7;

public class KMPsearch {

    static void KMPSearch(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[M]; 
        int patternIndex = 0; // index for pat[] 
  
        // Preprocess the pattern (calculate lps[] 
        // array) 
        computeLPSArray(pat, M, lps); 
  
       //insert your code here
        int strIndex = 0;
        while(strIndex<N)
        {
        	if(pat.charAt(patternIndex)==txt.charAt(strIndex))
        	{
        		patternIndex++;
        		strIndex++;
        	}
        	
        	if(patternIndex == M)
        	{
        		System.out.println("Pattern starting at index: " + (strIndex-patternIndex));
        		patternIndex = lps[patternIndex-1];
        	}
        	
        	else if((strIndex<N)&&(pat.charAt(patternIndex) != txt.charAt(strIndex)))
        	{
        		if(patternIndex != 0)
        		{
        			patternIndex = lps[patternIndex-1];
        		}
        		else
        		{
        			strIndex++;
        		}
        	}
        			
        }
        
    } 
  
    static void computeLPSArray(String pat, int M, int lps[]) 
    { 
        // length of the previous longest prefix suffix 
        int len = 0; 
        int i = 1; 
        lps[0] = 0; // lps[0] is always 0 
  
        // the loop calculates lps[i] for i = 1 to M-1 
        while (i < M) { 
            if (pat.charAt(i) == pat.charAt(len)) { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else // (pat[i] != pat[len]) 
            { 
                // This is tricky. Consider the example. 
                // AAACAAAA and i = 7. The idea is similar 
                // to search step. 
                if (len != 0) { 
                    len = lps[len - 1]; 
  
                    // Also, note that we do not increment 
                    // i here 
                } 
                else // if (len == 0) 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    } 
  
    // Driver program to test above function 
    public static void main(String args[]) 
    { 
    	String txt = "ABABDABACDABABCABAB"; 
        String pat = "CABA";  
        
    	System.out.println("KMPSearch");
    	double start = System.nanoTime();
    	KMPSearch(pat,txt);
    	double end = System.nanoTime();
    	System.out.println(((end-start)/1000000)+" seconds");
        
    } 
} 
