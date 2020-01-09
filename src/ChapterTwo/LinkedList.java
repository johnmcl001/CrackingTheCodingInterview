package ChapterTwo;

/*
Linked List class for exercises in chapter two
 */

public class LinkedList<E> {
    // main method to test the linked list class and its methods
    public static void main(String[] args){
        LinkedList<Integer> t = new LinkedList<>();

        System.out.println(t.isEmpty());
        t.addLast(1);
        t.addFirst(2);
        t.addLast(3);
        System.out.println(t);
        t.removeFirst();
        System.out.println(t);
        System.out.println(t.isEmpty());
        System.out.println(t.getSize());
        System.out.println(t.getHead().getElement());
        System.out.println(t.getTail().getElement());
    }

    // Attributes
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // Constructors
    public LinkedList(){}

    // Getters

    /**
     * Returns the current size of the linked list
     * @return int, size of linked list
     */
    public int getSize(){
        return size;
    }

    /**
     * Checks if linked list is empty
     * @return boolean, true if empty else false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * returns head of linked list
     * @return Node, returns head if not empty, else null
     */
    public Node<E> getHead(){
        if (isEmpty()){
            return null;
        }
        return head;
    }

    /**
     * returns tail of the linked list
     * @return Node, returns tail if not empty, else null
     */
    public Node<E> getTail(){
        if (isEmpty()){
            return null;
        }
        return tail;
    }

    // Setters

    /**
     * Adds new node to beginning of the linked list which becoes the new head
     * @param e, the element to be stored in the linked list
     */
    public void addFirst(E e){
        head = new Node<>(e, head);
        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    /**
     * If empty, will call addFirst, else adds new element e to linked list as tail
     * @param e, the element to be stored at the tail of the linked list
     */
    public void addLast(E e){
        if (!isEmpty()){
            Node<E> newNode = new Node<>(e, null);
            tail.setNext(newNode);
            tail = newNode;
            size++;
        } else {
            addFirst(e);
        }
    }

    /**
     * Removes head node and returns its element, return null if empty
     * @return E, element stored in the head node, null if empty
     */
    public E removeFirst(){
        if (isEmpty()){
            return null;
        }
        E ans = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()){
            tail = null;
        }
        return ans;
    }

    /**
     * Returns a string representation of the linked list
     * @return String, elements of the linked list separated by spaces
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> walker = head;
        while (walker != null){
            sb.append(walker.getElement()).append(" ");
            walker = walker.getNext();
        }
        return sb.toString();
    }
}
