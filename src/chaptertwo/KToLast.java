package chaptertwo;

public class KToLast {
    public static void main(String[] args){
        LinkedList<Integer> t = new LinkedList<>();

        while(t.getSize() < 20){
            t.addLast((int) (1 + Math.random()*20));
        }

        System.out.println(t);
        System.out.println(kToLast(t, 15));
    }

    /**
     * Returns from k to end of linked list ll
     * @param ll, Linked list
     * @param k, position from which to return
     * @return subset linked list of ll
     */
    public static Integer kToLast(LinkedList<Integer> ll, int k){
        LinkedList<Integer> buffer = new LinkedList<>();
        Node<Integer> walker = ll.getHead();
        k = ll.getSize() - k;
        int i = 0;

        while (walker != null && i != k){
            walker = walker.getNext();
            i++;
        }

        return walker.getElement();
    }
}
