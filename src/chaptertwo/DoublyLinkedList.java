package chaptertwo;

public class DoublyLinkedList <E> {
    private DNode<E> head;
    private DNode<E> tail;
    private int size = 0;

    // Contstructors
    public DoublyLinkedList(){
        head = new DNode<>(null, null, null);
        tail = new DNode<>(null, head, null);
        head.setNext(tail);
    }

    // Getters
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public DNode<E> getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.getNext();
    }

    public DNode<E> getLast(){
        return tail.getPrev();
    }

    // Setters
    public void insertFirst(E e){
        insertBetween(e, head, head.getNext());
    }

    public void insertLast(E e){
        if (isEmpty()){
            insertFirst(e);
        } else {
            insertBetween(e, tail.getPrev(), tail);
        }
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }
        DNode<E> oldHead = getFirst();
        head.setNext(oldHead.getNext());
        E ans = oldHead.getElement();
        oldHead.setPrev(null);
        oldHead.setNext(null);
        oldHead.setElement(null);
        size--;
        return ans;
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        DNode<E> oldTail = getLast();
        tail.setPrev(oldTail.getPrev());
        E ans = oldTail.getElement();
        oldTail.setPrev(null);
        oldTail.setNext(null);
        oldTail.setElement(null);
        size--;
        return ans;

    }

    // For Question Setup

    public void intersect(DNode<E> n){
        DNode<E> pred = getLast();
        pred.setNext(n);
        tail.setPrev(n);
        size++;
    }

    // Utilities
    private void insertBetween(E e, DNode<E> pred, DNode<E> succ){
        DNode<E> newNode = new DNode<>(e, pred, succ);
        pred.setNext(newNode);
        succ.setPrev(newNode);
        size++;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        DNode<E> walker = getFirst();

        while (walker.getNext() != null){
            sb.append(walker.getElement());
            if (walker.getNext() != tail){
                sb.append(" <-> ");
            }
            walker = walker.getNext();
        }

        return sb.toString();
    }

    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        DNode<E> walker = getFirst();

        while(walker.getNext() != null){
            if (e == walker.getElement()){
                return true;
            }
            walker = walker.getNext();
        }

        return false;
    }
}
