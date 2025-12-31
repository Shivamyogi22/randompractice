import java.util.*;


public class SelectionSort
{
	public static void main(String[] args) {
	    //Selection Sort
	   int[] arr = {20, 90, 60, 100, 80, 4, 12, 56};
	    for(int i = 0; i < arr.length-1; i++){
	        for(int j = i+1; j < arr.length; j++){
	            if(arr[i] > arr[j]){
	                int temp =  arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
				
	            }
	        }
	    }
		for (int x : arr) {
            System.out.print(x + " ");
        }
	}
}