package cyclicsort;

import java.util.Arrays;

//java.util.Arrays;//
public class CycleSort {

	/* Sorts an array using the Cycle Sort algorithm.
    * This algorithm is optimized for the minimum number of memory writes.
    * @param arr The array to be sorted
    */
	
	public void sort(int [] arr) {
		int n=arr.length;
		// 1. Iterate through the array to find cycles.
        // We only need to go up to n-2 because the last element
        // will be in place if all others are.
		
		for(int cycle_start =0; cycle_start<=n-2; cycle_start++) {
			
			//get the item we want to place correctly
			int item=arr[cycle_start];
			
			// 2. Find the correct position 'pos' where this 'item' should go.
            // We do this by counting how many elements are smaller than it.
			int pos=cycle_start;
			for(int i=cycle_start +1; i<n; i++) {
				if(arr[i]<item) {
					pos++;
				}
			}
			// 3. If the item is already in its correct position, skip this cycle.
			if(pos ==cycle_start) {
				continue;
			}
			// 4. Handle duplicates:
            // If the element at 'pos' is the same as 'item',
            // find the next available position.
			while(item ==arr[pos]) {
				pos++;
			}
			// 5. Place the item in its correct position ('pos').
            // We "kick out" the element that was there and now hold it in 'item'.
			
			int temp=arr[pos];
			arr[pos]=item;
			item=temp;
			// 6. Complete the rest of the cycle.
            // We continue placing the "kicked out" item ('item') in its
            // correct spot until we eventually place an item back
            // into the 'cycle_start' position.
			
			while(pos !=cycle_start) {
				// Find the new correct position for the 'item' we are holding
				pos=cycle_start;
				for(int i=cycle_start+1; i<n; i++) {
					if(arr[i]<item) {
						pos++;
					}
				}
				//handle duplicates again
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
//	---main method to test the sort---
	public static void main(String[] args) {
		CycleSort cs=new CycleSort();
		
		// Example 1: Simple case
		int[] arr1 = {2, 5, 1, 4, 3};
		System.out.println("Original array"+Arrays.toString(arr1));
		cs.sort(arr1);
		System.out.println("sortd array"+Arrays.toString(arr1));
		
		System.out.println("---");
		
		//Example 2 :with duplicates 
		int[] arr2= {4,5,6,1,5,2,4};
		System.out.println("Original array(with dublicates)"+Arrays.toString(arr2));
		cs.sort(arr2);
		System.out.println("sorted array"+Arrays.toString(arr2));
		
	}
}
