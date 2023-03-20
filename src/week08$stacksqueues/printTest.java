package week08$stacksqueues;
import org.junit.Assert;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class printTest {
    public static void StackToQueue(Stack<Integer> stack) {
        Queue <Integer> queue = new LinkedList<>();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        System.out.println(queue);
    }

    public static void QueueToStack(Queue<Integer> queue) {
        Stack <Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
           stack.add(queue.remove());
        }
        System.out.println(stack);
    }
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(0);

        StackToQueue(stack);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(4);
        queue.add(5);
        queue.add(7);
        queue.add(9);
        queue.add(0);
        QueueToStack(queue);

    }
}


