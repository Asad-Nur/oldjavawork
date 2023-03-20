package utils;



import java.util.NoSuchElementException;

/*****************************************************************
 * This class MyQueue implements a FIFO data structure using a
 * Singly Linked List (SLL).
 *
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class MyQueue<E> {

    Node<E> first;          //stores first element
    Node<E> last;           // stores last element

    private int size;       // stores stack size

    public MyQueue(){
        first = null;
        last  = null;
        size  = 0;
    }
    //TODO : Complete Body with Data Fields, Methods and Classes

    public boolean add(E item){
        append(item);       //calls on append method to add to end of queue
        return true;
    }


    private void append(E item){
        Node<E> newNode = new Node<>(item, null);   // declares Node newNode
        if(last == null){
            first = last = newNode;     // if list is empty both pointers will point to the appended node
        }else{
            last.next = newNode;        // if not empty item is appended after the current last element
            last      = newNode;             // last pointer is now on the newNode
        }
        size++;         // increase queue size
    }


    private E detach(){
        Node<E> nodeToDetach = last;                        // E stores data from top of stack
        E detachedNode       = nodeToDetach.data;           // element at top of stack is switched to the item next up
        last                 = last.next;                   // reduce stack size by one since we are removing an element

        return detachedNode;                                // return the element at the top of the stack
    }


    public boolean isEmpty(){
        return size == 0;
        // returns false if it isn't empty and true if it is
    }


    public E peek(){
        if(isEmpty()){
            return null;
        }
        return first.data;      // returns front item if queue isn't empty
    }


    public E remove(){
        if(isEmpty()){
            throw new NoSuchElementException();         // throws exception if queue is empty
        }
        return detach();        // calls on helper method detach to remove item from front of queue
    }


    public int size(){
        return size;
    }


    public String toString(){
        if(isEmpty()){
            return "[]";
        }else{
            StringBuilder result = new StringBuilder("[" + first.data);

            for (Node<E> node = first.next; node != null; node = node.next){
                result.append(", ").append(node.data);
            }

            return result + "]";
        }

    }

    private static class Node<E>{
        E data;             // data storage
        Node<E> next;       // self-reference

        public Node(E data){
            this(data, null);
        }

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

    }


}

