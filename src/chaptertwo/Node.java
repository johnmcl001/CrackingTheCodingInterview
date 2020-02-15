package chaptertwo;

// Node class for chapter two

public class Node <E>{
    private E element;
    private Node<E> next;

    // Constructors
    public Node(E e, Node<E> n){
        element = e;
        next = n;
    }

    // Getters
    public E getElement(){
        return element;
    }

    public Node<E> getNext(){
        return next;
    }

    // Setters
    public void setElement(E e){
        element = e;
    }

    public void setNext(Node<E> n){
        next = n;
    }
}