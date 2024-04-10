
public class FIbonacci {
	public static void main(String[] args) {
		System.out.println(fibo(6));
		System.out.println(fib(46));
		int[] A = new int[] {0, 0, 0, 1, 1, 0, 1};
		System.out.println(frogjumpByFibonacciJumps(A));
 		
	}
	
	
	//recursion
	
	static int fibo(int n) {
		if(n==0 || n==1) {
			return n;
		}
		else return fibo(n-1)+ fibo(n-2);
	}
	
	
	//matrix approach
	
	    static int fib(int n)
	    {
	        int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
	        if (n == 0)
	            return 0;
	        power(F, n - 1);
	 
	        return F[0][0];
	    }
	 
	    static void multiply(int F[][], int M[][])
	    {
	        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
	        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
	        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
	        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];
	 
	        F[0][0] = x;
	        F[0][1] = y;
	        F[1][0] = z;
	        F[1][1] = w;
	    }
	 
	    static void power(int F[][], int n)
	    {
	        if (n == 0 || n == 1)
	            return;
	        int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };
	 
	        power(F, n / 2);
	        multiply(F, F);
	 
	        if (n % 2 != 0)
	            multiply(F, M);
	    }
	    
	    
	    
	    
	    //frog jump
	    
	    
	    static int frogjumpByFibonacciJumps(int[] A){
	        int[] dp = new int[A.length];
	        dp[0] = 0;
	        for(int i = 1; i < A.length; i++){
	            dp[i] = Integer.MAX_VALUE;
	            for(int j = 0; j < i; j++){
	                if(A[j] == 1 && i-j <= fibo(2)){
	                    dp[i] = Math.min(dp[i], dp[j] + 1);
	                }
	            }
	        }
	        return dp[A.length-1];
	    }
}
