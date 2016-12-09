import java.util.Math;

public class Barcode implements Comparable<Barcode>{
// instance variables
   private String _zip;
   private int _checkDigit;


    /*
To make it easier on myself:

1  :::||   
2  ::|:|
3  ::||: 
 :|::|
 :|:|:
 :||::
 |:::|
 |::|:
 |:|::
 ||:::   

    */
    
// constructors
//precondition: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      	_zip = zip;
	_checkDigit = 0;
	if (zip.length() != 5){
	    throw new IllegalArgumentException ("The input is not the right length.");
	}
	String codedZip = "";
	String[] codeKey = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::",};
      for(int x=0;x<5;x++){
	  
	  _checkDigit += parseInt(zip.charAt(x));

      }
      _checkDigit = _checkDigit % 10;

      for(int x=0;x<5;x++){
		  codedZip += (codeKey[parseInt(zip.charAt(x))]);
      }

      _zip = codedZip;
  }

// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      String codedCopy = _zip;	  }

    /*
// postcondition: computes and returns the check sum for _zip
  private int checkSum(){


  }
    */

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
	return "|" + _zip + _checkDigit + "|";



  }    /*


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
}
