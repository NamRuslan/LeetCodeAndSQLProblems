package leetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 */
public class MinStack {
    Stack<Integer> stack, mins;

    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        if (mins.empty() || val <= getMin()) {
            mins.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(mins.peek())) {
            mins.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (mins.empty()) {
            return 0;
        }
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

