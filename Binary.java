
public class Binary {
      public int binarySearch(int arr[], int target) {
    	int high=arr.length-1;
    	int low=0;
    	while(low<=high) {
    		int middle = low + (high - low)/2;
    		int value = arr[middle];
    		if(value < target) {
    			low=middle+1;
    			
    		}
    		else if(value>target) {
    			high = middle - 1;
    		}
    			return middle;
    		
    	}   
    	return -1;

      }
}
