package utils;

public class SinglyLinkedList<T> {

    Node<T> first;  //reference to first item in list
    int     size;   //counter

    public SinglyLinkedList(){
        first = null;
        size  = 0;
    }

    public boolean add(T item){
        int oldSize = size;
        append(item);    // operation to append to back
        size++;          // update counter with added node

        return size == (oldSize + 1);
    }

    public void add(int index, T item) {
        // check support for front, mid, back
        if (index == size) {
            append(item);       //appends if the index prompted is same as list size
        } else{
            checkIndex(index);
            insertBefore(index, item);
        }
        size++;
    }

    // add items to the back of the SLL
    private void append(T item){
        Node<T> currentLast = node(size - 1);   // find the last location
        Node<T> newNode     = new Node<>(item);       // made new node with item to append

        if(isEmpty())
            first = newNode;                            // assign first reference to new node
        else
            currentLast.next    = newNode;              // attach new node to the back
    }

    private void checkIndex(int index){
        String message = "Invalid Index";

        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(message);
        }
    }
    private T detach(int index){
        Node<T> target;

        if(index == 0){
            target = first;             //stores the first nodes address (only for universal readability)
            first = first.next;         //reassigns first node in list

        } else{

            Node<T> nodeBefore  = node(index - 1);   //returning address of node before
            target              = nodeBefore.next;           //current target node comes after the node before
            nodeBefore.next     = target.next;      //this reassignment updates order of the list
            target.next         = null;                 //detaches the node from the list
        }

        return target.data;
    }


    public T get(int index){
        checkIndex(index);
        Node <T> target = node(index);
        return target.data;
    }

    private void insertBefore(int index, T item){
        if(index == 0){
            first = new Node<>(item, first);
        }else {
            Node<T> nodeBefore = node(index - 1);
            Node<T> target     = nodeBefore.next;
            nodeBefore.next    = new Node<>(item, target);
        }
    }


    public boolean isEmpty(){

        return first == null && size == 0;
    }

    // private helper class counter for finding the node address at
    // the index location in SLL
    private Node<T> node(int index){
        Node<T> current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T remove(int index){
        checkIndex(index);
        T oldItem = detach(index);
        size--;     //reduces size by one after detaching

        return oldItem;
    }

    public T set(int index, T item){
        checkIndex(index);
        Node<T> target  = node(index);              // find and store address of target node
        T oldItem       = target.data;              // store old item from node
        target.data     = item;                     // update item in node
        return oldItem;
    }
    public int size(){

        return size;
    }

    public String toString(){
        if(isEmpty()){
            return "[]";
        }else{
            StringBuilder result = new StringBuilder("[" + first.data);

            for (Node<T> node = first.next; node != null; node = node.next){
                result.append(", ").append(node.data);
            }

            return result + "]";
        }

    }


    // This is an inner class that is decoupled from outer class.
    // The purpose is primarily for storage of data and next reference in linked
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