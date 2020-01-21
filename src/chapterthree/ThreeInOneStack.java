package chapterthree;

import java.util.Arrays;

public class ThreeInOneStack {
    public static void main(String[] args) {
        ThreeInOneStack stacks = new ThreeInOneStack(30);


        for (int i = 1; i < 20; i++){
            stacks.push(1, i);
        }

        System.out.println(stacks.pop(1));
        System.out.println(stacks);
        for (int i = 39; i < 50; i++){
            stacks.push(2, i);
        }
        System.out.println(stacks);

        System.out.println(stacks.getSize(1));
        System.out.println(stacks.getSize(2));
    }

    // Attributes

    private int[] arr;
    private int stackSize;
    private int size1 = 0;
    private int size2 = 0;
    private int size3 = 0;

    // Contructor

    public ThreeInOneStack(int n) {
        arr = new int[n];
        stackSize = n / 3;
    }

    // Getters

    /**
     * returns the size of the specified stack
     * @param n, int denoting the desired stack
     * @return int, size of the specified stack
     */
    public int getSize(int n) {
        if (n < 1 || n > 3) {
            return -1;
        }
        switch (n) {
            case 1:
                return size1;
            case 2:
                return size2;
            default:
                return size3;
        }
    }

    /**
     * checks if the specified stack is empty
     * @param n, int denoting the desired stack
     * @return boolean, true if stack empty else false
     */
    public boolean isEmpty(int n) {
        if (n < 1 || n > 3) {
            return false;
        }
        switch (n) {
            case 1:
                return size1 == 0;
            case 2:
                return size2 == 0;
            default:
                return size3 == 0;
        }
    }

    /**
     * returns top most element of the specified stack without removing it
     * @param n, int denoting the desired stack
     * @return int, top most element of the specified stack
     */
    public int top(int n) {
        if (n < 1 || n > 3) {
            return -1;
        }
        if (isEmpty(n)) {
            return -1;
        }

        switch (n) {
            case 1:
                return arr[size1 - 1];
            case 2:
                return arr[stackSize + size2 - 1];
            default:
                return arr[stackSize * 2 + size3 - 1];
        }
    }

    // Setters

    /**
     * pushes new element onto specified stack if not full
     * @param n, int denoting desired stack
     * @param i, int to be inserted onto specified stack
     */
    public void push(int n, int i) {
        if (n < 1 || n > 3) {
            return;
        }
        if (getSize(n) == stackSize) {
            return;
        }

        switch (n) {
            case 1:
                arr[size1++] = i;
                break;
            case 2:
                arr[stackSize + size2++] = i;
                break;
            default:
                arr[stackSize * 2 + size3++] = i;
        }
    }

    /**
     * removes and returns the topmost element of the specified stack
     * @param n, int denoting the specified stack
     * @return int, top most element of the stack
     */
    public int pop(int n) {
        if (n < 1 || n > 3) {
            return -1;
        }
        if (isEmpty(n)) {
            return -1;
        }

        int ans;

        switch (n) {
            case 1:
                ans = arr[size1 - 1];
                arr[size1 - 1] = 0;
                size1--;
                return ans;
            case 2:
                ans = arr[size2 - 1];
                arr[size2 - 1] = 0;
                size2--;
                return ans;
            default:
                ans = arr[size3 - 1];
                arr[size3 - 1] = 0;
                size3--;
                return ans;
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}
