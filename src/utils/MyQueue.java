package utils;


import java.util.EmptyStackException;
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

    Node<E> first;
    Node<E> last;

    private int size;

    public MyQueue(){
        first = null;
        last = null;
        size = 0;
    }
    //TODO : Complete Body with Data Fields, Methods and Classes

    public boolean add(E item){
        append(item);
        return true;
    }


    private void append(E item){
        Node<E> newNode = new Node<>(item, null);
        if(last == null){
            first = last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }


    private E detach(){
        E item = first.data;
        first = first.next;
        size--;
        return item;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    public E peek(){
        if(isEmpty()){
            return null;
        }
        return first.data;
    }


    public E remove(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return detach();
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

