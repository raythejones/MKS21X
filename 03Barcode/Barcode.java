import java.util.*;
import java.lang.Integer;

public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;
   

    
// constructors
//precondition: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      	_zip = zip;
	_checkDigit = 0;
       	    if (_zip.length() != 5){
		    throw new IllegalArgumentException ("The input zip is not the right length.");
		}
	    try {
	   Integer.parseInt(zip);
       }
	    catch (NumberFormatException e) {
	    throw new IllegalArgumentException("One or more characters in the zipcode is not a digit.");
       }
	    
	String codedZip = "";
	
	//CHECKDIGIT
	_checkDigit = checkSum() % 10;
 



	
	
  }
    
 
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
     
      String ans = _zip;

   
	      Barcode cloned = new Barcode(ans);
	      return cloned;


	      
  }

 
      public String zip() {
      return _zip;
  }
      public int checkDigit() {
      return _checkDigit;
  }
// postcondition: computes and returns the check sum for _zip
  private  int checkSum(){
            int ans = 0;
	    for(int i=0;i<5;i++){
	  int output = Integer.parseInt(_zip.substring(i,i+1));
	  ans += output;
  }
      return ans;

  }
   
    
//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String tempZip = _zip;
      String codedZip = "";
      	 String[] codeKey = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::",};


	 for(int i=0;i<5;i++){
	  int output = Integer.parseInt(tempZip.substring(i,i+1));
	  codedZip += codeKey[output];
	} 
	codedZip += codeKey[_checkDigit];

	
      return "|" + codedZip  + "|";



  }    
/*

// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){


      
  }
    */

      

public int compareTo(Barcode other){
      int z = Integer.parseInt(_zip + _checkDigit);
      int o = Integer.parseInt(other.zip() + other.checkDigit());
      if (z < o) {
	  return -1;
      }
      if (z > o) {
	  return 1;
      }
      else {
	  return 0;
      }
}

    
      public static void main(String[]args){
	Barcode a = new Barcode("08451");
	System.out.println(a.toString());

	Barcode b = new Barcode ("12345");
	System.out.println(b.toString());
	System.out.println(b.clone());

      }
}
