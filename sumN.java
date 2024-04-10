
public class sumN {
	public long addIt(long N){
        long sum=0;
        for(int i=0;i<=N;i++){
            sum+=i;
        }
        return sum;
    }
    
    public long addConst(long N){
        return N * (N+1)/2;
    }
}
