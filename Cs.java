package cyclicsort;
import java.util.Arrays;

/**
 * This class demonstrates the Cycle Sort algorithm in Java.
 */
public class Cs {
	/**
     * The main method to test the cycle sort.
     */
	public static void main(String[] args) {
		//the array we want to sort
		int[]arr= {4,1,5,2,3};
		
		System.out.println("Original Array"+Arrays.toString(arr));
		
		//call the sorting method
		cyclesort(arr);
		System.out.println("Sorted array"+Arrays.toString(arr));
	}
	/**
     * Sorts an array using the Cycle Sort algorithm.
     * @param arr The array to be sorted in-place.
     */
 public static void cyclesort(int[] arr) {

	 	int n=arr.length;
	 	
	 // Iterate through the array to find cycles to rotate
	 	for(int cycleStart=0; cycleStart<n-1; cycleStart++) {
	 		//the item we want to place  correctly
	 		int item=arr[cycleStart];
	 		
	 	// Find the correct position for the item
            // by counting all smaller elements
	 		int pos=cycleStart;
	 		for(int i=cycleStart+1; i<n; i++) {
	 			if(arr[i]<item) {
	 				pos++;
	 				
	 			}
	 		}
	 		//if the item is already in its correctly position ,skip
	 		if (pos==cycleStart) {
	 			continue;
	 		}
	 	// Handle duplicates: if the item at the correct position
            // is the same, increment the position
	 		while(item==arr[pos]) {
	 			pos++;
	 		}
	 		//place the item at its correct position
	 		if(pos !=cycleStart) {
	 			//Swap 'item' with the element at 'pos'
	 			int temp=item;
	 			item=arr[pos];
	 			arr[pos]=temp;
	 		}
	 	// Continue rotating the rest of the cycle
	 		while(pos !=cycleStart) {
	 			pos=cycleStart;
	 			
	 		// Find the new correct position for the 'item' (which was displaced)
                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    
                    }
 	}
                //handle duplicate
                	while(item==arr[pos]) {
                		pos++;
                		
                	}
                	//place the item
                	if(item !=arr[pos]) {
                		int temp=item;
                		item=arr[pos];
                		arr[pos]=temp;
                	}
	}
	
}
}}
