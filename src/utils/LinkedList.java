package utils;

import java.util.NoSuchElementException;

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
    Node<E> first;          //reference to first node in list
    Node<E> last;           //reference to last node in list
    int size;               //counter of index in list


    public LinkedList(){
        // initializes variables
        first   = null;
        last    = null;
        size    = 0;
    }



    @Override
    public boolean add(E item) {
        int oldSize = size;
        append(item);       //add to end of list
        size++;             // update counter with added node

        return size == (oldSize + 1);
    }


    @Override
    public void add(int index, E item) {
        // check support for front, mid, back
        if (index == size) {
            append(item);       // appends if the index prompted is same as list size
        } else{
            checkIndex(index);
            insertBefore(index, item);
        }
        size++;
    }

    private void append(E item){
        Node<E> newNode = new Node<>(last, item, null);     // declares Node newNode
        if (isEmpty()) {
            first = last = newNode;        // if list is empty both pointers will point to the appended node
        } else {
            last.next = newNode;        // if not empty item is appended after the current last element
        }
        last = newNode;              // last pointer is now on the newNode
    }



    // private helper method to check if index is valid
    private void checkIndex(int index) {
        String message = "Invalid Index";

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(message);
        }
    }


    @Override
    public void clear() {
        first = null;
        last  = null;
        size  = 0;
    }


    @Override
    public boolean contains(E item) {
        return indexOf(item) >= 0;      // returns true if item is found
    }


    private E detach(int index){
        Node<E> target;

        if(index == 0){
            target = first;             //stores the first nodes address (only for universal readability)
            first = first.next;         //reassigns first node in list

        } else{

            Node<E> nodeBefore  = node(index - 1);   //returning address of node before
            target              = nodeBefore.next;           //current target node comes after the node before
            nodeBefore.next     = target.next;      //this reassignment updates order of the list
            target.next         = null;                 //detaches the node from the list
        }

        return target.data;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).data;        // returns the item at the given index
    }


    // returns the index of the first occurrence of the value specified
    @Override
    public int indexOf(E item) {
        // loops through list
        int index = 0;

        for (Node<E> node = first; node != null; node = node.next) {
            // if the value specified is found
            if (item.equals(node.data)) {
                return index;   //returns the index of the item
            }
            index++;
        }
        return -1;
    }


    private void insertBefore(int index, E item) {
        if (index == 0) {       //if inserting before first item (index 0)
            first = new Node<>(null, item, first);        // item's prev pointer goes to null

        } else {
            Node<E> nodeBefore      = node(index - 1);
            Node<E> target          = nodeBefore.next;
            nodeBefore.next         = new Node<>(nodeBefore, item, target);
        }
    }



    public boolean isEmpty(){

        return size == 0;       // if the size is 0 returns true
    }

    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    // private helper class counter for finding the node address at
    // the index location in DLL
    private Node<E> node(int index){
        Node<E> current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    @Override
    public E remove(int index) {
        checkIndex(index);      // checks index to see if its valid
        E oldItem = detach(index);   // removes index from list
        size--;

        return oldItem;     // returns removed item
    }


    @Override
    public boolean remove(E item) {
        // loops through list searching for item
        for (Node<E> node = first; node != null; node = node.next) {
            if (item.equals(node.data)) {
                detach(indexOf(item));      // if node data is equal to item it is removed
                size--;
                return true;        // returns true if found and removed
            }
        }
        return false;       //NOT FOUND
    }


    @Override
    public E set(int index, E item) {
        checkIndex(index);
        Node<E> target = node(index);           // find and store address of target node
        E oldItem      = target.data;           // store old item from node
        target.data    = item;                  // update item in node
        return oldItem;
    }


    @Override
    public int size() {
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

    //**********************************************************************************
    private class LinkedIterator implements Iterator<E> {

        int position;               // stores current index position in the list
        Node<E> current;            // stores the node at the current counter index
        boolean isAbleToRemove;     // stores if value can be removed

        public LinkedIterator() {
            position       = 0;
            current        = first;
            isAbleToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next value!");
            }
            E currentItem = current.data;
            current       = current.next;

            position++;
            isAbleToRemove = true;
            return currentItem;
        }

        @Override
        public void remove() {
            if(!isAbleToRemove){
                throw new IllegalStateException("Not Able To Remove.");
            }
            LinkedList.this.remove(position - 1);
            isAbleToRemove = false;
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