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


    private Node<E> first;        // stores element at the bottom of the stack

    private Node<E> last;        // stores element at the top of the stack
    private int size;

    //TODO : Complete Body with Data Fields, Methods and Classes



    //helper method similar to check index but for stack
    private void checkStack(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty");     //throws exception if stack is empty
        }
    }


    // checks if stack is empty
    public boolean isEmpty(){
        return size == 0;
    }


    private E detach(){
        E data = last.data;
        last = last.next;
        size--;
        return data;
    }


    // "peeks" at stack by returning top element without removing
    public E peek(){
        checkStack();
        return last.data;      //returns element at the top of stack
    }


    // "pops" aka removes top element and returns
    public E pop(){
        checkStack();
        E data = last.data;      // stores the element at the top of stack
        last = last.next;         // reassigns next element in stack to top
        size--;
        return data;            // returns the element at the top of the stack
    }


    // pushes an element to top of stack
    public E push(E item){
        //don't need to check stack because you are pushing an element
        Node<E> newNode = new Node<>(item, last);
        last = newNode;      //assigns the top element to newNode
        size++;
        return item;
    }


    // returns size of stack (number of elements)
    public int size(){
        return size;
    }


    public String toString(){
        if(isEmpty()){
            return "[]";
        }else{
            StringBuilder result = new StringBuilder("[");

            for (MyStack.Node<E> node = last.next; node != null; node = node.next){
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



