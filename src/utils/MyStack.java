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

    private Node<E> first;       // stores element at teh bottom of the stack
    private Node<E> last;        // stores element at the top of the stack
    private int size;            // stores stack size


    //TODO : Complete Body with Data Fields, Methods and Classes

    // constructor to initialize data fields
    public MyStack(){
        first = null;
        last  = null;
        size  = 0;
    }

    //helper method similar to check stack
    private void checkStack(){
        if (isEmpty()){
            throw new EmptyStackException();     //throws exception if stack is empty
        }
    }


    // checks if stack is empty
    public boolean isEmpty(){

        return last == null && size == 0;       // returns true if stack has 0 elements
    }                           // false if not


    // helper method for removing item in "pop"
    private E detach(){
       Node<E> nodeToDetach = last;                             // sets the top node as node to detach
       E detachedNode       = nodeToDetach.data;                // stores the top node data in detachedNode
       last                 = last.next;                        // top pointer updated to next item in stack

       return detachedNode;                                     // returns the data of the nodeToDetach
    }


    // "peeks" at stack by returning top element without removing
    public E peek(){
        checkStack();
        return last.data;      // returns element at the top of stack
    }


    // "pops" aka removes top element and returns
    public E pop() {
        checkStack();
        E item = detach();      // detaches node from top of list
        size--;                 // reduces size by 1
        return item;            // returns and pops the item
    }


    // pushes an element to top of stack
    public E push(E item){
        Node<E> newNode = new Node<>(item, last);      // assigns the top element to newNode
        last = newNode;                                // newNode is last item in stack

        if(isEmpty()){
            first = last = newNode;       // if empty newNode is first item in stack (also still last)
        }
        size++;
        return last.data;
    }


    // checks the amount of elements int the stack
    public int size(){
        return size;            // returns size of stack (number of elements)

    }



    public String toString(){
        if(isEmpty()){
            return "[]";        //returns empty string if stack is empty
        } else {
            ArrayList<E> list = new ArrayList<E>();

            for (Node<E> node = last; node != null; node = node.next){
                list.add(0,node.data);        // loops through stack and adds the node data to ArrayList
            }

            return list.toString();       // returns the string representation
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



