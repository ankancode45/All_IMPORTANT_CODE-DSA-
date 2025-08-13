/*
Title: Valid Parentheses Checker using Stack in Java

Problem Statement:
Write a Java program to check whether a given string containing parentheses is valid or not.
You must use a stack to solve the problem.
*/
import java.util.Scanner;

class Stack {
    int[] arr;
    int top;

    public Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[top];
    }
}

class NextGreaterElementArrayStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] nge = new int[n];

        // Read array
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Stack stack = new Stack(n);

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements smaller or equal to current
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            // Assign NGE
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push current element
            stack.push(nums[i]);
        }

        // Output result
        System.out.println("Next Greater Elements:");
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i] + " → " + nge[i]);
        }
        sc.close();
    }
}