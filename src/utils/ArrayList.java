package utils;

import java.util.Array
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

public class ArrayList <E> {

    //constants
    public static final int DEFAULT_CAPACITY = 10;

    // these are the data fields listed in the lab documentation
    private E[] data;           // reference for an array of type E
    private int size;           // stores the number of occupied places in the array.

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

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


    //inserts a given value at the index specified, shifting subsequent values to the right
    public boolean add(int index, E item) {
        int oldSize = size;
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
        return size == (oldSize + 1);
    }


    //appends another list to current list
    public boolean addAll(ArrayList<E> other) {
        if (other == null) {
            return false;
        }
        int oldSize = size;
        ensureCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add((E) other.data[i]);
        }
        return size == (oldSize + other.size);
    }


    //checks if current index is valid
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
    }


    //clears elements in the list
    public void clear() {
        size = 0;
    }


    //returns true if value is in the list and false if it isn't
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return true;        //FOUND
            }
        }
        return false;           //NOT FOUND
    }

    @SuppressWarnings("unchecked")
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


    //returns the value of item at the specified index
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }


    //returns the index of the first occurrence of the value specified
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i] == item) {
                return i;
            }
        }
        return -1;      //NOT FOUND
    }


    //constructs an iterator that iterates over current list


    //removes the value at the specified index
    public E remove(int index) {
        checkIndex(index);
        E removedItem = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removedItem;
    }


    // returns true if list has no occupied items
    public boolean isEmpty(){
        return size == 0;
    }


    //replaces value at index with the given value
    public E set(int index, E item){
        checkIndex(index);
        data[index] = item;
        return item;
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
