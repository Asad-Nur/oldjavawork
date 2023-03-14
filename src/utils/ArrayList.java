package utils;

/*****************************************************************
 * This class ArrayList implements a contiguous block of data
 * using an array.
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class ArrayList <E> {

    //constants
    public static final int DEFAULT_CAPACITY = 10;

    // these are the data fields listed in the lab documentation
    E[] data;           // reference for an array of type E
    int size;           // stores the number of occupied places in the array.

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean add(E item) {
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


    // inserts a given value at the index specified, shifting subsequent values to the right
    public void add(int index, E item) {
        if(index < 0 || index > size){      //checks to see if index is in bound
            throw new IndexOutOfBoundsException("Invalid index");   //breaks if index is out of bounds
        }

        ensureCapacity(size + 1);
        shiftRight(index);

        data[index] = item;
        size++;
    }


    // appends another list to current list
    public boolean addAll(ArrayList<E> other) {
        if (other == null) {
            return false;
        }
        int oldSize = size;
        ensureCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add(other.data[i]);
        }
        return size == (oldSize + other.size);
    }


    // checks if current index is valid
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {       // checks to see if in bound/exists
            throw new IndexOutOfBoundsException("Invalid Index");
        }
    }


    // clears elements in the list
    public void clear() {
        for(int i = 0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }


    // returns true if value is in the list and false if it isn't
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return true;        // FOUND
            }
        }
        return false;           // NOT FOUND
    }


    public void ensureCapacity(int targetCapacity) {

        // checks if needed capacity > current array length
        if (targetCapacity > data.length) {

            // select the larger of the two (double length or target size)
            int newCapacity = Math.max(targetCapacity, 2 * data.length + 1);

            //make a new array with the larger size
            E[] newArray = (E[]) new Object[newCapacity];

            //copy the values in to the new array
            for (int i = 0; i < data.length; i++) {
                newArray[i] = data[i];
            }

            // re-assign underlying array reference to new array
            data = newArray;
        }
    }


    // returns the value of item at the specified index
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }


    // returns the index of the first occurrence of the value specified
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;      //NOT FOUND
    }


    // returns true if list has no occupied items
    public boolean isEmpty(){

        return size == 0;
    }


    //removes the value at the specified index
    public E remove(int index) {
        checkIndex(index);              // checks index to make sure it is valid
        E oldItem = data[index];
        shiftLeft(index);               // shifts item down by 1
        data[size - 1] = null;
        size--;
        return oldItem;
    }


    //searches for specified item in list
    public boolean remove(E item){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                remove(i);          // removes first occurrence
                return true;        // returns true if found and removed
            }
        }
        return false;       //NOT FOUND
    }


    //replaces value at index with the given value
    public E set(int index, E item){
        checkIndex(index);          // check to make sure index is valid
        E oldItem = data[index];    //store current item at location in temp
        data[index] = item;         //update index location with new item
        return oldItem;             //return the replaced item
    }


    // private helper method to shift down by 1
    private void shiftLeft(int index){
        for (int i = index; i < size - 1; i++) {
           data[i] = data[i + 1];
        }
    }


    private void shiftRight(int index){
        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
    }



    //returns the current number of elements in the list
    public int size(){

        return size;
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
