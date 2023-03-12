package utils;

public class SinglyLinkedList<T> {

    Node<T> first;  //reference to first item in list
    int     size;   //counter

    public SinglyLinkedList(){
        first = null;
        size  = 0;
    }

    public boolean add(T item){
        append(item);    // operation to append to back
        size++;          // update counter with added node

        return true;
    }


    // add items to the back of the SLL
    private void  append(T item){
        Node<T> currentLast = node(size - 1);   // find the last location
        Node<T> newNode     = new Node<>(item);       // made new node with item to append

        if(isEmpty())
            first = newNode;                            // assign first reference to new node
        else
            currentLast.next    = newNode;              // attach new node to the back
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
    public class Node<E>{
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