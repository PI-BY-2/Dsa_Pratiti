
public class FrogJump {
	
	public static void main(String[] args) {
		int[] A= {1, 0, 0, 1, 0, 1, 1, 1, 0};
		System.out.println(frogjumpByFibonacciJumps(A));
	}
	
	static int fibo(int n) {
		if(n==0 || n==1) {
			return n;
		}
		else return fibo(n-1)+ fibo(n-2);
	}

	
//	static int frogjumpByFibonacciJumps(int[] A){
//        int[] dp = new int[A.length];
//        dp[0] = 0;
//        for(int i = 1; i < A.length; i++){
//            dp[i] = Integer.MAX_VALUE;
//            for(int j = 0; j < i; j++){
//                if(A[j] == 1 && i-j <= fibo(2)){
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp[A.length-1];
//    }
	
	static int minFrogJump(int[] A) {
		
		return -1;
	}
	
}
