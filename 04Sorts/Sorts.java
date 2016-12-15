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
	int temp;
	for(int x=0; x<data.length - x1; x++){
	    if(!(data[x] <= data[x + 1])){
		temp = data[x + 1];
		for(int y = 0; y <= i; y++){
		    if(temp <= data[y]){
			for(int z = x + 1; z > y; z = z - 1){
			    data[z] = data[z - 1];
			}
			data[y] = temp;
			break;
		    }
		}
	    }
	}
	}

    public static void bubbleSort(int[] data){
	int len = data.length;
	for(int n=len-1;n>1;n--){
	    for(int x=0;x<n+1;x++){
		
	    }
	}
	    
    }


    public static void print(int[] data){
	String output = "[";
	for(int x=0; x<data.length; x++){
	    output += data[x];
	    output += ",";
	    
	}
	output += "]";
	}
    
    
    public static void main(String [] args) {
}

}
