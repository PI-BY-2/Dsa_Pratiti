

public class Solution {
   
	int[] binary = new int[35];
    static int id = 0;
    
	    public void decimalToBinary(int num)
	    {       
	        while (num > 0) {
	            binary[id++] = num % 2;
	            num = num / 2;
	        }
	    }
	      
	    public int solution(int N) {
	    	
	    	
	    	
	    	  	
			return N;
	    	
	    }
   
}
