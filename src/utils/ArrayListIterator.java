package utils;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListIterator {

    private ArrayList list;             //list to iterate over
    private int position;               // current list position
    private boolean isAbleToRemove;     // stores if value can be removed


    //constructs iterator object for given list
    public ArrayListIterator(ArrayList currentList){
        list = currentList;
        position = 0;
        isAbleToRemove = false;
    }



    //returns true if there are more elements in the list to iterate over
    public boolean hasNext(){
        return position < list.size();
    }

    //returns the value at the current position before advancing
    // to next position on the list
    public int next(){
        if(!hasNext()){
            throw new NoSuchElementException("No next value");
        }
        int currentItem = (int) list.get(position);
        position++;
        isAbleToRemove = true;
        return currentItem;
    }


    //removes last value returned
    public void remove(){
        if(!isAbleToRemove){
            throw new IllegalStateException("Not Able To Remove.");
        }
        list.remove(position - 1);
        position--;
        isAbleToRemove = false;
    }
}
