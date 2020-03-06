package chapterfour;

import chapterthree.Queue;

import java.util.*;

public class Graph <E> {
    public static void main(String[] args) {
        Graph<Character> testGraph = new Graph<>();

        testGraph.insertNode('a');
        testGraph.insertNode('b');
        testGraph.insertNode('c');
        testGraph.insertNode('d');
        testGraph.insertNode('e');
        testGraph.insertNode('f');
        testGraph.insertNode('g');
        testGraph.insertNode('h');
        testGraph.insertEdge('a', 'b');
        testGraph.insertEdge('a', 'c');
        testGraph.insertEdge('a', 'd');
        testGraph.insertEdge('b', 'g');
        testGraph.insertEdge('g', 'f');
        testGraph.insertEdge('c', 'f');

        List<Character> result;

        result = testGraph.depthFirstSearch('a');

        for (Character c: result) {
            System.out.println(c);
        }
        System.out.println();

        result = testGraph.breadthFirstSearch('a');

        for (Character c: result) {
            System.out.println(c);
        }
    }

    private Map<E, Node<E>> nodes = new HashMap<>();

    public Graph(){}

    public Node<E> getNode(E e) {
        if (!nodes.containsKey(e)){
            return null;
        }
        return nodes.get(e);
    }

    public void insertNode(E e) {
        if (!nodes.containsKey(e)){
            nodes.put(e, new Node<>(e));
        }
    }

    public void insertEdge(E e1, E e2) {
        if (nodes.containsKey(e1) && nodes.containsKey(e2)) {
            nodes.get(e1).addNeighbour(nodes.get(e2));
        }
    }

    public List<Node<E>> getNeighbours(E e) {
        if (!nodes.containsKey(e)){
            return null;
        }
        return nodes.get(e).getNeighbours();
    }

    public List<E> depthFirstSearch(E e) {
        List<E> visited = new ArrayList<>();
        Queue<Node<E>> queue = new Queue<>();

        queue.enqueue(getNode(e));
        Node<E> current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();

            for (Node<E> neighbour: getNeighbours(current.getElement())){
                if (!visited.contains(neighbour.getElement()) &&
                    !queue.contains(neighbour)) {
                    queue.enqueue(neighbour);
                }
            }

            visited.add(current.getElement());
        }

        return visited;
    }

    public List<E> breadthFirstSearch(E e) {

        List<E> visited = new ArrayList<>();
        Stack<Node<E>> stack = new Stack<>();

        stack.push(getNode(e));
        Node<E> current;
        while (!stack.isEmpty()) {
            current = stack.pop();

            for (Node<E> neighbour: getNeighbours(current.getElement())){
                if (!visited.contains(neighbour.getElement()) &&
                        !stack.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }

            visited.add(current.getElement());
        }

        return visited;
    }

    private static class Node<E>{
        private E element;
        private List<Node<E>> neighbours = new ArrayList<>();

        public Node(E e){
            element = e;
        }

        public E getElement(){
            return element;
        }

        public List<Node<E>> getNeighbours(){
            return neighbours;
        }

        public void setElement(E e) {
            element = e;
        }

        public void addNeighbour(Node<E> e) {
            neighbours.add(e);
        }
    }
}
