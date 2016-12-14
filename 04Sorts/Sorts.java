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

public static int[] insertionSort(int[] data){
      int start = 0;
      int[] alreadySorted = {};
      while(start < data.length-1){
	  for(int x=start+1; x<data.length; x++){
	      if(data[start] < data[x]){
		  start++;
		  if(x == data.length){
		      alreadySorted = data;
		  }
	      }
	      else{
		  alreadySorted = Arrays.copyOfRange(data,0,x);
		      
	      }
	  }
      
      }
      return alreadySorted;
}
    


public static void main(String[] args) {
    int[] a = {3, 4, 5, 6, 7, 8, 1, 2, 3,};
	System.out.println(insertionSort(a));
}

}
