import java.util.Collections;
import java.util.Stack;

/**
 * Created by Administrator on 2016/7/19.
 * 题目描述

 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class TwoStackWorksAsQueue {
    public static void main(String[] args){

    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);

    }

    public int pop() {
        int value=-1;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        value=stack2.pop();
        return value;
    }

}
