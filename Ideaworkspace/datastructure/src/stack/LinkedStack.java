package stack;

/**
 * 链式栈实现
 * @author yangyong
 * @create 2020-10-06-15:00
 */
public class LinkedStack<E> {
    //私有内部类
    private class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data,Node<T> node){
            this.data = data;
            next = node;
        }
    }
    //栈顶元素
    private Node<E> top;
    //栈的大小
    private int size;

    //栈是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //入栈
    public void push(E data){
        //创建新结点
        Node<E> node = new Node<E>(data,top);
        top = node;
        size++;
    }
    //出栈
    public Node<E> pop(){
        //判空
        if(isEmpty()){
            throw new RuntimeException("栈为空!");
        }
        Node<E> node = top;
        top = top.next;
        node.next = null;//释放内存;
        size--;
        return node;
    }

    //打印栈
    public void print(){
        //从栈顶开始遍历
        Node<E> index = top;
        while(index != null){
            System.out.print(index.data + " ");
            index = index.next;
        }
        System.out.println();
    }
    //测试
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Rico");
        stack.push("TJU");
        stack.push("Livia");
        stack.push("NEU");
        stack.print();

        stack.pop();

        stack.print();

        System.out.println("栈中元素个数为:"+stack.size);
    }

}
