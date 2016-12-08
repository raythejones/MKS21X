import java.util.Math

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
      String[] array codeKey = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|":, "|:|::"};
	  String output;
	  int unitPlace = 0;
      for(x=0;x<5;x++){
	  
	  _checkDigit += parseInt(zip.charAt(x));

      }
      _checkDigit = _checkDigit % 10;

      for(x=0;x<5;x++){
	  for(x=4;x>-1;x--){
	      int unitPlace = Math.pow(10,x);
		  output += (codeKey[parseInt(zip.charAt(x))] * unitPlace);
	  }}

      
  }
    
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      int outputCopy;
      int unitPlace = 0
      for(x=0;x<5;x++){
	  for(x=4;x>-1;x--){
	      unitPlace = Math.pow(10,x);
		  output += (codeKey[parseInt(zip.charAt(x))] * unitPlace);
	  }}

  }

    /*
// postcondition: computes and returns the check sum for _zip
  private int checkSum(){


  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){



  }

// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){


      
  }
    */
}
