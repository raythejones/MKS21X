import java.util.Iterator;
import java.util.NoSuchElementException;
public class SuperArrayIterator implements Iterator{
    private int counter = 0;
    private SuperArray iterateThrough;

    public SuperArrayIterator(SuperArray l){
        iterateThrough = l;
    }

    public boolean hasNext(){
        return counter < iterateThrough.size();
    }

    public String next(){
        if(hasNext()){
            return iterateThrough.get(ctr++);
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }
}