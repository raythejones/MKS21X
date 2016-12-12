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
  private int checkSum(){
            int ans = 0;
	    for(int i=0;i<5;i++){
	  int output = Integer.parseInt(_zip.substring(i,i+1));
 	  ans += output;
  }
      return ans;

  }


    public static String toCode(String zip){
	int _checkDigit = 0;

	int ans = 0;
	    for(int i=0;i<5;i++){
	  int output = Integer.parseInt(zip.substring(i,i+1));
 	  ans += output;
  }

      _checkDigit = ans % 10;

      String tempZip = zip;
      String codedZip = "";
      	 String[] codeKey = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::",};


	 for(int i=0;i<5;i++){
	  int output = Integer.parseInt(tempZip.substring(i,i+1));
	  codedZip += codeKey[output];
	} 
	codedZip += codeKey[_checkDigit];

	
      return "|" + codedZip  + "|";		
	}

    
public static String toZip(String code){
	if(code.length() != 32) {
	    throw new IllegalArgumentException("The input barcode is not the right length.");
	}
	if(code.charAt(0) != '|' || code.charAt(31) != '|') {
	    throw new IllegalArgumentException("One or more of the guardrails is formatted improperly");
	}
	String output = "";
	try {
	    for(int x= 1; x<31; x++){
		switch(code.substring(x,x+5)) {
		case "||:::": output += "0";
		    break;
		case ":::||": output += "1";
		    break;
		case "::|:|": output += "2";
		    break;
		case "::||:": output += "3";
		    break;
		case ":|::|": output += "4";
		    break;
		case ":|:|:": output += "5";
		    break;
		case ":||::": output += "6";
		    break;
		case "|:::|": output += "7";
		    break;
		case "|::|:": output += "8";
		    break;
		case "|:|::": output += "9";
		    break;
		}
	    }
	}catch(NumberFormatException e) {
	    throw new IllegalArgumentException("");
	}
	String zipcode = output.substring(0,6);
	String check = "" + output.charAt(6);
	if(!zipcode.equals(check)) {
	    throw new IllegalArgumentException("");
	}
	return zipcode;
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


public int compareTo(Barcode other){
      int x = Integer.parseInt(_zip + _checkDigit);
      int y = Integer.parseInt(other.zip() + other.checkDigit());
      if (x < y) {
	  return -1;
      }
      if (x > y) {
	  return 1;
      }
      else {
	  return 0;
      }
}
 
      public static void main(String args[]){
	//INITIAL TESTS
	System.out.println("\nINITIAL TESTS");
	Barcode a = new Barcode("08451");
	Barcode b = new Barcode("99999");
	Barcode c = new Barcode("11111");
	System.out.println(a); //084518 |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(a.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(a.compareTo(a)); //0
	System.out.println(b.compareTo(a)); //9
	System.out.println(c.compareTo(a)); //1
		
	//more tests for second part of the lab:

	//
	//CONSTRUCTOR TESTS
	//
	
	System.out.println("\nCONSTRUCTOR TESTS");
	System.out.println(new Barcode("99999"));
	try{
	    new Barcode("024df");
	}catch(IllegalArgumentException e){
	    e.printStackTrace(); //zip contains a non digit
	}
	
	try{
	    new Barcode("010101010");
	}catch(IllegalArgumentException e){
	    e.printStackTrace(); //zip is not correct length
	}
	
	//
	//toCode TESTS
	//
	
	System.out.println("\ntoCode TESTS");
	System.out.println(Barcode.toCode("99999"));
	//Barcode b = new Barcode("99999"); //already done in init tests
	String zipOfB = (b.toString()).substring(7); // slices off begin zip part
	System.out.println(Barcode.toCode("99999").compareTo(zipOfB)); //0

	//exceptions for toCode()
	try{
	    Barcode.toCode("222222");
	}catch(IllegalArgumentException e){
	    e.printStackTrace(); //given zip is not correct length
	}
	
	try{
	    Barcode.toCode("eeeef");
	}catch(IllegalArgumentException e){
	    e.printStackTrace(); //given zip contains a non digit
	}

	//
	//toZip TESTS
	//
	System.out.println("\ntoZip TESTS");
	System.out.println(Barcode.toZip(Barcode.toCode("99999"))); //99999

	//exceptions for toZip()
	try{
	    Barcode.toZip("|:|");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//not correct length
	}

	try{
	    Barcode.toZip("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//invalid guard rails
	}

	try{
	    Barcode.toZip("|eeeeeeeeeeeeeeeeeeeeeeeeeeeeee|");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//invalid barcode characters
	}

	try{
	    Barcode.toZip("|||:::|::|::|::|:|:||||:|||::|:|");
	}catch(IllegalArgumentException e){
	    e.printStackTrace();//encoded int invalid
	}
      }
}
