package cyclicsort;
import java.util.Arrays;
/**
 * A complete, runnable example of Cycle Sort.
 */
public class CycleSortCode {

	/**
     * Sorts an array using the Cycle Sort algorithm.
     *
     * @param arr The integer array to be sorted
     */
	
	public void sort(int [] arr) {
		int n=arr.length;
		
		
		// Iterate through the array to find cycles.
		for(int cycle_start=0; cycle_start<n-1; cycle_start++) {
			// 1. Select the item for this cycle
			int item=arr[cycle_start];
			
			// 2. Find the correct position ('pos') for this item
            // by counting all elements smaller than it.
			int pos=cycle_start;
			for(int i=cycle_start+1; i<n; i++) {
				if(arr[i]<item) {
					pos++;
				}
			}
			// 3. If the item is already in its correct spot, skip.
			if(pos ==cycle_start) {
				continue;
			}
			// 4. Handle duplicates: If the item at 'pos' is the same
            // as 'item', find the next open slot.
			while(item ==arr[pos]) {
				pos++;
			}
			// 5. Place the 'item' in its correct 'pos' and
            // hold the item that was "kicked out".
			int temp=arr[pos];
			arr[pos]=item;
			item=temp;
			
			// 6. Complete the rest of the cycle until we return
            // to the 'cycle_start' position.
			while(pos !=cycle_start) {
				// Find the new correct position for the 'item' we're holding
				pos=cycle_start;
				for(int i=cycle_start+1; i<n; i++) {
					if(arr[i]<item) {
						pos++;
					}
				}
				//handle duplicates
				while(item ==arr[pos]) {
					pos++;
				}
				//place the item
				temp=arr[pos];
				arr[pos]=item;
				item=temp;
			}
		}
	}
	// --- Main Method to Test the Sort ---
	public static void main(String[] args) {
		CycleSortCode s=new CycleSortCode();
		
		//Example from our previous discussion
		int []arr= {3,5,2,1,4};
		System.out.println("Original array"+Arrays.toString(arr));
		
		//call the sort method
		s.sort(arr);
		
		System.out.println("Sorter array"+Arrays.toString(arr));
	}
}
