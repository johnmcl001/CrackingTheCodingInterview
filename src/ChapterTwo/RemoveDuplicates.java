package ChapterTwo;

import java.util.ArrayList;

public class RemoveDuplicates {
    public static void main(String[] args){
        LinkedList<Integer> t = new LinkedList<>();

        while(t.getSize() < 20){
            t.addLast((int) (1 + Math.random()*20));
        }

        System.out.println(t);
        System.out.println(removeDupes(t));
        removeDupesInPlace(t);
        System.out.println(t);
    }

    /**
     * Remove duplicate elements in place
     * @param ll, Linked list with duplicated
     */
    public static void removeDupesInPlace(LinkedList<Integer> ll){
        ArrayList<Integer> present = new ArrayList<>();
        Node<Integer> walker = ll.getHead();

        while (walker != null){
            // add current to present if not already present
            if (!present.contains(walker.getElement())){
                present.add(walker.getElement());
            }

            // skip over already present until null or new element encountered
            while(walker.getNext() != null
                    && present.contains(walker.getNext().getElement())){
                walker.setNext(walker.getNext().getNext());
            }

            // Advance walker
            walker = walker.getNext();
        }
    }

    /**
     * Remove duplicate elements using a temporary buffer
     * @param ll, Linked List with duplicates
     * @return Linked list without duplicates
     */
    public static LinkedList<Integer> removeDupes(LinkedList<Integer> ll){
        LinkedList<Integer> buffer = new LinkedList<>();

        Node<Integer> walker = ll.getHead();

        while (walker != null){
            if (!contains(buffer, walker.getElement())){
                buffer.addLast(walker.getElement());
            }
            walker = walker.getNext();
        }
        return buffer;
    }

    /**
     * Check if element is present in linked list
     * @param ll, Linked list which may contain element
     * @param i, element which may be in linked list
     * @return boolean, true if i in ll, else false
     */
    public static boolean contains(LinkedList<Integer> ll, int i){
        Node<Integer> walker = ll.getHead();

        while (walker != null){
            if (i == walker.getElement()){
                return true;
            }
            walker = walker.getNext();
        }
        return false;
    }
}
