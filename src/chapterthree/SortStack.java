package chapterthree;

import java.util.Arrays;

public class SortStack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (1 + Math.random()*20);
        }

        for (int i: arr){
            stack.push(i);
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        sort(stack);

        int[] stackArr = new int[10];
        int i = 0;
        while (!stack.isEmpty()){
            stackArr[i++] = stack.pop();
        }
        System.out.println(Arrays.toString(stackArr));
        System.out.println(Arrays.equals(arr, stackArr));
    }

    private static void sort(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int min;
        Stack<Integer> fullStack;
        Stack<Integer> emptyStack;
        boolean test;
        while (!stack.isEmpty() || !stack1.isEmpty()){
            test = stack.isEmpty();

            fullStack = test ? stack1 : stack;
            emptyStack = test ? stack : stack1;
            min = fullStack.pop();

            while (!fullStack.isEmpty()){
                if (min > fullStack.top()){
                    emptyStack.push(min);
                    min = fullStack.pop();
                } else {
                    emptyStack.push(fullStack.pop());
                }
            }

            stack2.push(min);
        }

        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }



    }
}
