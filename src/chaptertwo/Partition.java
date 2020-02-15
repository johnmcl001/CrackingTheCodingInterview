package chaptertwo;

public class Partition {
    public static void main(String[] args){
        LinkedList<Integer> t = new LinkedList<>();

        t.addLast(3);
        t.addLast(5);
        t.addLast(8);
        t.addLast(5);
        t.addLast(10);
        t.addLast(2);
        t.addLast(1);
        System.out.println(t);
        System.out.println(partitionList(t, 5));
    }

    public static LinkedList<Integer> partitionList(LinkedList<Integer> ll,
                                                    int partition){
        LinkedList<Integer> buffer = new LinkedList<>();

        Node<Integer> walker = ll.getHead();

        while(walker != null){
            if (walker.getElement() < partition){
                buffer.addFirst(walker.getElement());
            } else {
                buffer.addLast(walker.getElement());
            }

            walker = walker.getNext();
        }

        return buffer;
    }
}
