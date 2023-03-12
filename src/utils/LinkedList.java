package utils;

/*****************************************************************
 * This class LinkedList implements linked data structures using
 * a Doubly Linked List (DLL).
 *
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class LinkedList<E>{

    //TODO : Complete Body with Data Fields, Methods and Classes
    Node<E> first; //reference to first node in list
    Node<E> last; //reference to last node in list
    int size; //counter of index in list
    public LinkedList(){
        first   = null;
        last    = null;
        size    = 0;
    }


    // This is an inner class that is decoupled from outer class.
    // The purpose is primarily for storage of data, prev and next
    // reference in linked sequence.
    private static class Node<E>{
        E data;             // data storage
        Node<E> next;       // self-reference after current node
        Node<E> prev;       // self-reference before current node

        private Node(Node<E> prev, E data){
            this(prev, data, null);
        }

        private Node(Node<E> prev, E data, Node<E> next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }

}