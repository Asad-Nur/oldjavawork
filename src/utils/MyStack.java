package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class MyStack implements a LIFO data structure using a
 * Singly Linked List (SLL).
 *
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

    public MyStack(){
        first = null;
        size = 0;
    }

    //helper method similar to check index but for stack
    private void checkStack(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty");     //throws exception if stack is empty
        }
    }


    // checks if stack is empty
    public boolean isEmpty(){

        return size == 0;       // returns true if stack has 0 elements
    }                           // false if not


    private E detach(){
        E data = first.data;
        first = first.next;
        size--;
        return data;
    }


    // "peeks" at stack by returning top element without removing
    public E peek(){
        checkStack();
        return first.data;      //returns element at the top of stack
    }


    // "pops" aka removes top element and returns
    public E pop(){
        checkStack();
        E data = first.data;      // stores the element at the top of stack
        first = first.next;         // reassigns next element in stack to top
        size--;
        return data;            // returns the element at the top of the stack
    }


    // pushes an element to top of stack
    public E push(E item){
        //don't need to check stack because you are pushing an element
        Node<E> newNode = new Node<>(item, first);
        first = newNode;      //assigns the top element to newNode
        size++;
        return item;
    }


    // checks the amount of elements int the stack
    public int size(){

        return size;        // returns size of stack (number of elements)
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



