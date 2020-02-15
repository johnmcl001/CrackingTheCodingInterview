package chaptertwo;

public class DNode <E> {
    private E element;
    private DNode<E> prev;
    private DNode<E> next;

    public DNode(E e, DNode<E> p, DNode<E> n){
        element = e;
        prev = p;
        next = n;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }

}
