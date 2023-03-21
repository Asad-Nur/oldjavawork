package week08$stacksqueues;

import utils.MyQueue;

import java.util.LinkedList;

import utils.MyStack;

public class MyPrintTest {
    public static void StackToQueue(MyStack<Integer> stack) {
        MyQueue<Integer> queue = new MyQueue<>();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        System.out.println(queue);
    }

    public static void QueueToStack(MyQueue<Integer> queue) {
        MyStack <Integer> stack = new MyStack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        System.out.println(stack);
    }
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(0);
        System.out.println("Original Stack " + stack);
        System.out.print("Stack to Queue ");  StackToQueue(stack);

        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(2);
        queue.add(4);
        queue.add(5);
        queue.add(7);
        queue.add(9);
        queue.add(0);
        System.out.println(queue);
        QueueToStack(queue);

    }
}
