package utils;

/*****************************************************************
 * This class ArrayList implements a contiguous block of data
 * using an array.
 *
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class ArrayList <E>{

    //constants
    public static final int DEFAULT_CAPACITY = 10;

    // these are the data fields listed in the lab documentation
    E[] data;           // reference for an array of type E
    int size;           // stores the number of occupied places in the array.

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean add(E item){
        // creating a placeholder for the current size
        int oldSize = size;

        // allows the size of array to grow if size > length
        ensureCapacity(size + 1);

        // appends to back of list = first vacant spot
        data[size] = item;

        // increments size = updated number of occupied spots
        size++;

        //returns true if size updated by 1
        return size == (oldSize + 1);
    }


    @SuppressWarnings("unchecked")
    public void ensureCapacity(int targetCapacity){

        // checks if needed capacity > current array length
        if(targetCapacity > data.length){

            // select the larger of the two (double length or target size)
            int newCapacity = Math.max(targetCapacity, 2 * data.length + 1);

            //make a new array with the larger size
            E[] newArray = (E[]) new Object[newCapacity];

            //copy the values in to the new array
            for(int i = 0; i < data.length; i++){
                newArray[i] = data[i];
            }

            // re-assign underlying array reference to new array
            data = newArray;
        }
    }


    // returns true if list has no occupied items
    public boolean isEmpty(){
        return size == 0;
    }

    //prints out the values in sequence from 0 to length - 1
    public String toString(){
        if(isEmpty()){
            return "[]";

        }else {
            StringBuilder result = new StringBuilder(" [" + data[0]);

            for (int i = 1; i < size; i++) {
                result.append(", ").append(data[i]);
            }
            return result + "]";
        }
    }

}
