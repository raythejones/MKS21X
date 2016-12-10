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
	 String[] codeKey = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::",};
	//	    if (_zip.length() != 5){
	//	    throw new IllegalArgumentException ("The input zip is not the right length.");
	//	}
	String codedZip = "";


	//CHECKDIGIT
	
	for(int x=0;x<5;x++){
	      char current = _zip.charAt(x); 
	      int toBeAdded = current - '0';
	      _checkDigit += toBeAdded;

	}
      _checkDigit = _checkDigit % 10;
 

      /*
      for(int x=0;x<5;x++){
	  char q = zip.charAt(x);
	  String r = str(q);
	  codedZip += codeKey[r.parseInt];
      }

      _zip = codedZip;*/
  }
 /*
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      String codedCopy = _zip;	  }

 */
      public String zip() {
      return _zip;
  }
      public int checkDigit() {
      return _checkDigit;
  }
// postcondition: computes and returns the check sum for _zip
  private  int checkSum(){
      int output = Integer.parseInt(_zip);
      int sum = 0;
      int i = 1;
      while (i < 5) {
	  sum += (output % 10 ^ i);
	  i++;
      }
      return sum % 10;

  }
   
    /*
//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
	return "|" + _zip + _checkDigit + "|";



  }    


// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){


      
  }
    */

        public static void main(String[]args){
	Barcode a = new Barcode("08451");
	System.out.println(a.toString());
	Barcode b = new Barcode ("12345");
	System.out.println(b.toString());
	}

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
}
