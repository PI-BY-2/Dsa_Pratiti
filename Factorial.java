
public class Factorial {
	
	public static long factorial(long n) {
		if(n<=1) return 1;
		else return n*factorial(n-1);
	}
	
	public static void main(String[] args) {
		long duration = System.nanoTime();
		System.out.println(factorial(20));
		System.out.println("Time taken:" +  (System.nanoTime() - duration)/1000000);
	}
}

