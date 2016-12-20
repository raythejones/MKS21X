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
    
    
    public static void main(String [] args) {


}

}
