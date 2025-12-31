import java.util.*;


public class InsertionSort
{
	public static void main(String[] args) {
	    //Insertion Sort
		 int[] arr = {20, 90, 60, 100, 80, 4, 12, 56};
	    for(int i = 1; i < arr.length; i++){
	        int key = arr[i];
	        int j = i-1;
	        
	        while(j>=0 && arr[j] > key){
	            arr[j+1] = arr[j];
	            j--;
	        }
            
	        arr[j+1] = key;
	    }
	    
		for (int x : arr) {
            System.out.print(x + " ");
        }


	    
	}
}