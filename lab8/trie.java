package lab8;

public class trie {

	// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26; 


	// class for Trie node 
	static class TrieNode { 
	TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
	// isEndOfWord is true if the node represents end of a word i.e. leaf node
	boolean isEndOfWord; 

	TrieNode(){ 
	isEndOfWord = false; 

	for (int i = 0; i < ALPHABET_SIZE; i++) 
	children[i] = null; 
	} 
	}

	static TrieNode root;
	// If not key present, inserts into trie 
	// If the key is prefix of Trie node,  
	//  marks leaf node
	static void insert(String key){
		
		int level;
        int length = key.length();
        int index;
       
        TrieNode pCrawl = root;
       
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
       
            pCrawl = pCrawl.children[index];
        }
       
        // mark last node as leaf
        pCrawl.isEndOfWord = true;

		

	} 

	// Returns true if key presents in trie, else false 
	static boolean search(String key) { 
		

        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
       
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
       
            if (pCrawl.children[index] == null)
                return false;
       
            pCrawl = pCrawl.children[index];
        }
       
        return (pCrawl != null && pCrawl.isEndOfWord);

		
	} 


	// Driver 
	public static void main(String args[]) { 

	// Input keys (use only 'a' through 'z' and lower case) 
	String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


	String output[] = {"Not present in trie", "Present in trie"}; 

	root = new TrieNode(); 

	// Construct trie 
	int i; 
	for (i = 0; i < keys.length ; i++) {
	insert(keys[i]); 
	}

	// Search for different keys
	
	if(search("bank") == true)
        System.out.println( output[1]);
    else 
    	System.out.println(output[0]);
      
    if(search("book") == true)
        System.out.println(output[1]);
    else 
    	System.out.println(output[0]);
    if(search("bar") == true)
        System.out.println(output[1]);
    else 
    	System.out.println(output[0]);
      
    if(search("bring") == true)
        System.out.println(output[1]);
    else 
    	System.out.println(output[0]);


	} 

	//end of class


}
