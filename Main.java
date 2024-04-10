public class Main {
 public static void main(String[] args) {
	 sumN sum = new sumN();
	 
	 long start = System.nanoTime();
	 long ans1 = sum.addIt(100000000);
     long duration1 = (System.nanoTime()-start)/1000000;
     System.out.println("TOTAL :" + ans1 + "  duration :" + duration1);
     
     
     System.out.println("--------------------------------------------");
     
     long start2 = System.nanoTime();
     long ans2 = sum.addConst(100000000);
     long duration2 = (System.nanoTime()-start2)/1000000;
     System.out.println("TOTAL :" + ans2 + "  duration :" + duration2);

     System.out.println("--------------------------------------------");
     
     int array[]= new int[200000];
     int target=9945;
     
     for(int i=0;i<200000;i++) {
    	 array[i]=i;
     }
     
     Binary binary = new Binary();
     int ans3 = binary.binarySearch(array, target);
     System.out.println(ans3);
 
     
     System.out.println("--------------------------------------------");
     
     long start3 = System.nanoTime();
     
     int arr[] = new int[10000000];
     for(int j = arr.length-1; j >0 ;j--) {
    	 arr[j]=j;
     }     
     Bubble bubble = new Bubble();
     bubble.BubbleSort(arr);
     long duration3 = (System.nanoTime()-start3)/1000000;
//     for(int i: arr) {
//    	 System.out.println(i);
//     }
     System.out.println("Time to sort using Bubble Sort : " + duration3);
     
     
     System.out.println("--------------------------------------------");
 }
}
