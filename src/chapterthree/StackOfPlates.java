package chapterthree;

import java.util.Vector;

public class StackOfPlates<E> {
    public static void main(String[] args){
        StackOfPlates<Integer> stacks = new StackOfPlates<>(10);

        for (int i = 0; i < 35; i++){
            stacks.push(i);
        }

        System.out.println(stacks.numberOfStacks());

        System.out.println(stacks);
        System.out.println();
        System.out.println(stacks.popAt(2));

        System.out.println(stacks);

        for (int i = 0; i < 10; i++){
            stacks.popAt(0);
        }

        System.out.println();
        System.out.println(stacks);

        System.out.println(stacks.currentStack);

        while(stacks.numberOfStacks() == 3){
            stacks.popAt(2);
        }

        System.out.println();
        System.out.println(stacks.currentStack);

        System.out.println(stacks.popAt(10));
    }

    // Attributes
    Vector<Stack<E>> stacks = new Vector<>();
    Stack<E> currentStack;
    private final int CAPACITY;

    // Constructor
    public StackOfPlates(int c){
        currentStack = new Stack<>();
        stacks.add(currentStack);
        CAPACITY = c;
    }

    // Getters

    /**
     * return number of stacks present
     * @return int, number of stacks in stacks of platesj
     */
    public int numberOfStacks(){
        return stacks.size();
    }

    /**
     * checks if the stack of stacks is empty
     * @return true if empty else false
     */
    public boolean isEmpty(){
        return stacks.isEmpty();
    }

    /**
     * returns top most element of topmost stack without removing it
     * @return E, topmost element of topmost stack
     */
    public E top(){
        if (isEmpty()){
            return null;
        }
        return currentStack.top();
    }

    // Setters

    /**
     * pushes new element onto topmost stack, updates current stack if capacity reached
     * @param e, new element
     */
    public void push(E e){
        currentStack.push(e);

        if (currentStack.getSize() == CAPACITY){
            currentStack = new Stack<>();
            stacks.add(currentStack);
        }
    }

    /**
     * removes and returns top of topmost stack, removes stack if empty
     * @return E, topmost element of topmost stack
     */
    public E pop(){
        if (isEmpty()){
            return null;
        }
        E ans = currentStack.pop();
        if (currentStack.getSize() == 0){
            stacks.remove(currentStack);
        }
        currentStack = stacks.lastElement();

        return ans;
    }

    /**
     * returns topmost element of a specific stack, updates stacks if this is emptied
     * @param i, determines stack to pop from
     * @return E, topmost element of specified stack
     */
    public E popAt(int i) throws IllegalArgumentException {
        if (isEmpty()) {
            return null;
        }
        if (i >= stacks.size() || i < 0) {
            throw new IllegalArgumentException("Stack doesn't exist");
        }
        Stack<E> stack = stacks.get(i);

        E ans = stack.pop();

        if (stack.isEmpty()){
            stacks.remove(stack);
            if (stack == currentStack) {
                currentStack = stacks.lastElement();
            }

        }

        return ans;
    }

    // Utilities

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (Stack<E> stack: stacks){
            sb.append(stack.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
