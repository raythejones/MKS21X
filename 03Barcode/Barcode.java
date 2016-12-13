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

  private static int checkSum(String zip){
            int ans = 0;
	    for(int i=0;i<zip.length();i++){
	  int output = Integer.parseInt(zip.substring(i,i+1));
 	  ans += output;
  }
      return ans;

  }
    
    public static String toCode(String zip){
	int _checkDigit = 0;
	int almostCheck = 0;
	if(zip.length() != 5){
	    throw new IllegalArgumentException("The input zip is the wrong length.");}
	if(notDigit(zip)){
	    throw new IllegalArgumentException("The input zip contains a non-integer.");}

	
	
	    for(int i=0;i<5;i++){
	  int output = Integer.parseInt(zip.substring(i,i+1));
 	  almostCheck += output;
  }
 
      _checkDigit = almostCheck % 10;

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
    

 private static boolean notDigit(String testZip){
     for (int i=0; i<5; i++) {
    		if (testZip.charAt(i) > '9' || testZip.charAt(i) < '0') {
    			return true;
    		}
    	}
    	return false;
    }
    
     private static boolean notBarcode(String testBC){
	 for (int i=0; i<testBC.length(); i++) {
    		if (testBC.charAt(i) != ':' && testBC.charAt(i) != '|') {
    			return true;
    		}
		else{}
    	}
    	return false;
    }

  private static int arraySearch(String element, String[] array){
    	for (int x=0; x<array.length; x++){
    		if (array[x].equals(element)){
    			return x;
    		}
    	}

    	return -1;
  }
    

public static String toZip(String code){
    String zip = "";
	if(code.length() != 32) {
	    throw new IllegalArgumentException("The input barcode is not the right length.");
	}
	if(code.charAt(0) != '|' || code.charAt(31) != '|') {
	    throw new IllegalArgumentException("One or both of the guardrails is formatted improperly");
	}
	if(notBarcode(code)){	    throw new IllegalArgumentException("The input barcode contains a non-barcode character.");
}
	else{
	    int i = 1;
	    while (i < code.length()-5){
		String codeNumbers = code.substring(i,i+5);
		switch(codeNumbers){
		case  ":::||": zip += 1;
		    break;
		case "::|:|": zip += 2;
		    break;
		case "::||:": zip += 3;
		    break;
		case ":|::|": zip += 4;
		    break;
		case ":|:|:": zip += 5;
		    break;
		case ":||::": zip += 6;
		    break;
		case "|:::|": zip += 7;
		    break;
		case "|::|:": zip += 8;
		    break;
		case "|:|::": zip += 9;
		    break;
		case "||:::": zip += 0;
		    break;
		default: throw new IllegalArgumentException("There may be a pattern mismatch in the zipcode.");
		    // break;
		}
        	i += 5;
	    }
	}
	if (!zip.substring(5).equals(checkSum(zip.substring(0,5)) % 10 + "")){
	    throw new IllegalArgumentException("The checkDigit for this barcode is wrong");
	}
	else{
	    return zip.substring(0,5);
	}
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
    



}
