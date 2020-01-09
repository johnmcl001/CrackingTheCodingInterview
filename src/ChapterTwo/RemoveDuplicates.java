package ChapterTwo;

import java.util.ArrayList;

public class RemoveDuplicates {
    public static void main(String[] args){
        LinkedList<Integer> t = new LinkedList<>();

        while(t.getSize() < 20){
            t.addLast((int) (1 + Math.random()*20));
        }

        System.out.println(t);
        LinkedList<Integer> noDupes = removeDupes(t);
        System.out.println(noDupes);
    }

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
