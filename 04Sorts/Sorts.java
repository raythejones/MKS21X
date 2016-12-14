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

    
    public static void main(String[]args){
    }
}
