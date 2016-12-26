import java.util.*;
public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "09.Jones.AugustRay"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */

 public static void selectionSort(int[] data){
 	if(data.length == 0 || data.length == 1){
return;
        	}
      int start = 0;
      while(start < data.length-1){
	  int min = start;
	  for(int x=start; x<data.length; x++){
	      if(data[x] < data[min]){
		  min = x;
	      }
	  }
	  int temp = data[start];
	  
	  data[start] = data[min];
	  data[min] = temp;
	  start += 1;
      }
 }


        public static void insertionSort(int[] data){
        	if(data.length == 0 || data.length == 1){
return;
        	
        	}
	int temp;
	for(int x=0; x<data.length - x; x++){
	    if(!(data[x] <= data[x + 1])){
		temp = data[x + 1];
		for(int y = 0; y <= x; y++){
		    if(temp <= data[y]){
			for(int z = x + 1; z > y; z = z - 1){
			    data[z] = data[z - 1];
			}
			data[y] = temp;
			return;
		    }
		}
	    }
	}
	}

    public static void swap(int[] data, int x, int y){
      int t = data[x];
      data[x] = data[y];
      data[y] = t;
    }
    
    public static void bubbleSort(int[] data){
    	if(data.length == 0 || data.length == 1){
return;
        	}
			int place = data.length;

			for(int x1=0;x1<data.length;x1++){
	    
	    for(int x2=0;x2<place - 1;x2++){
		if(data[x2] > data[x2+1]){
		    swap(data, x2, x2+1);
		}
		
	    }
	    place--;
	}
	    
    }


    public static void print(int[] data){
	String output = "[";
	for(int x=0; x<data.length; x++){
	    output += data[x];
	    output += ",";
	}
	output += "]";
	System.out.println(output);
	}
    
    
public static void main(final String[] args) {
	// int[] a = {1, 2, 3, 4, 5,};
	// selectionSort(a);
	// print(a);
	// insertionSort(a);
	// print(a);
	// bubbleSort(a);
	// print(a);

	// int[] a = {1, 2, 3, 4, 5,};
	// selectionSort(a);
	// print(a);
	// insertionSort(a);
	// print(a);
	// bubbleSort(a);
	// print(a);

	// 	int[] a = {5,2,34,1,23,41,515,6,233,411,2,231};
	// selectionSort(a);
	// print(a);
	// insertionSort(a);
	// print(a);
	// bubbleSort(a);
	// print(a);

		int[] a = {1,};
	selectionSort(a);
	print(a);
	insertionSort(a);
	print(a);
	bubbleSort(a);
	print(a);

		int[] b = {};
	selectionSort(b);
	print(b);
	insertionSort(b);
	print(b);
	bubbleSort(b);
	print(b);

		int[] c = {10,9,8,7,6,5,4,3,2,1,};
	selectionSort(c);
	print(c);
	insertionSort(c);
	print(c);
	bubbleSort(c);
	print(c);

		int[] d = {300, 22};
	selectionSort(d);
	print(d);
	insertionSort(d);
	print(d);
	bubbleSort(d);
	print(d);

		int[] e = {12, 211, 3111, 4, 532,};
	selectionSort(e);
	print(e);
	insertionSort(e);
	print(e);
	bubbleSort(e);
	print(e);

		int[] f = {12, 22, 31, 14, 3335, 123, 123, 1231, 1231,1232, 123,41234,1, 644, 666,756,};
	selectionSort(f);
	print(f);
	insertionSort(f);
	print(f);
	bubbleSort(f);
	print(f);
}



}
