package utils;

/*****************************************************************
 * This class LinkedList implements linked data structures using
 * a Doubly Linked List (DLL).

 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class LinkedList<E> implements List<E> {

    //TODO : Complete Body with Data Fields, Methods and Classes
    Node<E> first; //reference to first node in list
    Node<E> last; //reference to last node in list
    int size; //counter of index in list
    public LinkedList(){
        first   = null;
        last    = null;
        size    = 0;
    }



    @Override
    public boolean add(E item) {
        int oldSize = size;
        append(item);
        size++;

        return size == (oldSize + 1);
    }


    @Override
    public void add(int index, E item) {

    }

    private void append(E item){
        Node<E> currentLast = last;
        Node<E> newNode     = new Node<>(last,item);
        last                = newNode;

        if (isEmpty()) {
            first = newNode;
        }else{
            currentLast.next = newNode;
        }
    }


    private void checkIndex(int index) {
        String message = "Invalid Index";

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(message);
        }
    }


    @Override
    public void clear() {

    }


    @Override
    public boolean contains(E element) {
        return false;
    }


    @Override
    public E get(int index) {
        return null;
    }


    @Override
    public int indexOf(E element) {
        return 0;
    }


    public boolean isEmpty(){

        return first == null && last == null && size == 0;
    }


    @Override
    public E remove(int index) {
        return null;
    }


    @Override
    public boolean remove(E element) {
        return false;
    }


    @Override
    public E set(int index, E element) {
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    //**********************************************************************************
    public class LinkedIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {

        }
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