package MiroSoftTest;

import java.util.Stack;

/**
 * @author lenovo
 * 最小栈，用一个辅助栈维护最小值
 */
public class P14 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack; //辅助栈

        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }

        public void pop() {
            if (stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }
}
