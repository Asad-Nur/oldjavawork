package utils;
import java.util.ArrayList;
import java.util.EmptyStackException;

/*****************************************************************
 * This class MyStack implements a LIFO data structure using a
 * Singly Linked List (SLL).
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class MyStack <E> {


    private Node<E> first;        // stores element at the top of the stack
    private int size;            // stores stack size


    //TODO : Complete Body with Data Fields, Methods and Classes

    // constructor to initialize data fields
    public MyStack(){
        first = null;
        size = 0;
    }

    //helper method similar to check stack
    private void checkStack(){
        if (isEmpty()){
            throw new EmptyStackException();     //throws exception if stack is empty
        }
    }


    // checks if stack is empty
    public boolean isEmpty(){

        return first == null && size == 0;       // returns true if stack has 0 elements
    }                           // false if not


    // helper method for removing item in "pop"
    private E detach(){
        E item = first.data;        // E stores data from top of stack
        first = first.next;         // element at top of stack is switched to the item next up
        size--;                     // reduce stack size by one since we are removing an element
        return item;                // return the element at the top of the stack
    }


    // "peeks" at stack by returning top element without removing
    public E peek(){
        checkStack();
        return first.data;      // returns element at the top of stack
    }


    // "pops" aka removes top element and returns
    public E pop(){
        checkStack();
        return detach();            // returns the element at the top of the stack
    }


    // pushes an element to top of stack
    public E push(E item){
        //don't need to check stack because you are pushing an element
        first = new Node<>(item, first);      // assigns the top element to newNode
        size++;
        return item;
    }


    // checks the amount of elements int the stack
    public int size(){
        return size;            // returns size of stack (number of elements)

    }



    public String toString(){
        if(isEmpty()){
            return "[]";        //returns empty string if stack is empty
        } else {
            StringBuilder result = new StringBuilder("[");
            ArrayList<E> elements = new ArrayList<E>();     // Stores element from bottom to top using an Arraylist

            for (Node<E> node = first; node != null; node = node.next){
                elements.add(node.data);        // loops through stack and adds the node data to ArrayList
            }

            for (int i = elements.size() - 1; i >= 0; i--){         // loops through list in reverse
                result.append(elements.get(i));                     //  appends to stringBuilder
                if (i != 0) {
                    result.append(", ");    // adds comma and space after all except last
                }
            }

            result.append("]");
            return result.toString();       // returns the string representation
        }
    }


    // This is an inner class that is decoupled from outer class.
    // The purpose is primarily for storage of data and next reference
    // sequence.
    private static class Node<E>{
        E data;             // data storage

        Node<E> next;       // self-reference

        public Node(E data){

            this(data, null);
        }

        private Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

    }
}



