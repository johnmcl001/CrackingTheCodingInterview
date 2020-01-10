package ChapterTwo;

public class DeleteMiddleNode {
    public static void main(String[] args){
        LinkedList<Character> t = new LinkedList<>();

        t.addLast('a');
        t.addLast('b');
        t.addLast('c');
        t.addLast('d');
        t.addLast('e');
        t.addLast('f');

        System.out.println(t);
        removeMiddle(t, 'c');
        System.out.println(t);
    }

    /**
     * Remove node from list so long as it's not head or tail
     * @param ll, linked list which may contain c
     * @param c, element to be removed from ll
     * @param <E>, Type for c
     */
    public static <E> void removeMiddle(LinkedList<E> ll, char c){
        if (ll.getHead().getElement().equals(c) || ll.getTail().getElement().equals(c)){
            return;
        }

        Node<E> walker = ll.getHead();

        while (!walker.getNext().getElement().equals(c)){
            walker = walker.getNext();
        }

        walker.setNext(walker.getNext().getNext());
    }
}
