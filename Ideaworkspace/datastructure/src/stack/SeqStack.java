package stack;

import java.util.Arrays;

/**顺序栈实现
 * 使用数组作为底层实现
 * @author yangyong
 * @create 2020-10-06-15:08
 */
public class SeqStack<E> {
    //底层支撑数组
    private Object[] stack;
    //栈顶指针
    private int top;
    //栈的最大容量
    private  int maxSize;

    public SeqStack(){
        this(10);
    }

    public SeqStack(int maxSize){
        this.stack = new Object[maxSize];
        this.top = -1;
        this.maxSize = maxSize;
    }
    //栈是否为空
    public  boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(E e){
        if(top == maxSize - 1){
            throw new RuntimeException("栈已满!");
        }
        stack[++top] = e;
    }
    //出栈
    public E pop(){
        if(top == -1){
            throw new RuntimeException("栈为空!");
        }
        E element = (E)stack[top];
        stack[top--] = null;
        return element;
    }
    // 打印栈
    @Override
    public String toString() {
        return Arrays.toString(stack);
    }

    public static void main(String[] args) {
        SeqStack<String> stack = new SeqStack<>();
        stack.push("Richo");
        stack.push("hha");
        stack.push("ss");
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }

}
