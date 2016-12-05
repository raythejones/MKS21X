public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }
    
    public SuperArray(int initialCapacity){
    if(initialCapacity<0){throw new IllegalArgumentException();}
    else{
    data = new String[initialCapacity];
    size = 0;
    }
    }


    public int size(){
	return size;
    }

    public boolean add(String n){
	if (size < data.length){
	    data[size] = n;
	}
	else{
	    grow();
	    data[size] = n;
	}
	size += 1;
	return true;
  }

    public void add(int index, String element){	
		if((index < 0 || index > size())){throw new IndexOutOfBoundsException(""+index);}
		else{
		
	if (size == data.length){
		    grow();
}
	for(int x=data.length - 1; x>index; x--){
	    data[x] = data[x-1];
	}	
	data[index] = element;	
	size++;
    }
    }

    public String remove(int index){
	if(index < 0 || index >= size()){throw new IndexOutOfBoundsException(""+index);}
	else{
	String returnvalue = data[index];
	for(int x=index; x<size() - 1; x++){
	    data[x] = data[x+1];
	}
	size--;
	return returnvalue;
		}}
    

    public void grow(){
        String[] temparray = new String[size + 5];
	for (int count = 0; count < data.length; count= count + 1){
	    temparray[count] = data[count];
	}
	data = temparray;
    }

    public String get(int index){
	if((index < 0 || index >= size())){throw new IndexOutOfBoundsException();}
	else{
	return data[index];
	}}

    
    public void clear(){
	SuperArray x = new SuperArray();
	data = x.data;
       	size = 0;
    }
    
    public String set(int index, String element){
		if((index < 0 || index >= size())){throw new IndexOutOfBoundsException();}
		else{
        String x = data[index];
	data[index] = element;
	return x;
		}}
    
    public boolean isEmpty(){
    	if (size == 0){
    		return true;
    	}
    	else { return false;
    	}
    	}
    
    
    public String toString(){
	String stringary = "[" + data[0];
	for (int x=1; x<size; x++){
	    stringary += ", " + data[x];
	}
	stringary += "]";
	return stringary;
    }

    public String toStringDebug(){
	String a;
	  a  = "[" + data[0];
	for (int b = 1; b < data.length; b++){
	    a = a + ", ";
	    if (b < size){
		a += data[b];
	    }
	    else{
		a += "_";
	    }
	}
	a = a + "]";
	return a;
    }



public void resize(int newCapac){

if (newCapac >= size()){
	String[] newData = new String[newCapac];
for (int i=0; i<size(); i++){
newData[i] = data[i];
}
data = newData;
}}


    public int indexOf(String i){
	int value = 0;
	for(int x=size; x>=0; x--){
	    if(data[x].compareTo(i) == 0){
		value = x;

	    }
	    else{}
	    
	}
	if(value == 0 && i.compareTo(data[0]) != 0){value = -1;}
	return value;

    }
    
    public int lastIndexOf(String i){
	int value = 0;
	for(int x=0; x<size; x++){
	    if(i.compareTo(data[x]) == 0){
		value = x;

	    }
	    else{}
	    
	}
	if(value == 0 && i.compareTo(data[0]) != 0){value = -1;}
	return value;

    }
    public String[] toArray(){
	String[]toarray = new String[size];
	for (int i=0; i<size; i++){
	    toarray[i]=data[i];
	}
	return toarray;}
public void trimToSize(){
	String[] temp = new String[size];
	for (int i = 0; i<size; i++){
	    temp[i]=data[i];}
	data=temp;
    }
    
        public static void main(String[]args){

}


    
}
