package org.datastructures;

public class Stack<T> {

    Node<T> head;

    public void push(T val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node curr = new Node(val);
            curr.next = head;
            head = curr;
        }
    }

    public T pop() {

        T ret = null;
        // can add check for null head

        if (head.next == null) {
            ret = head.value;
            head = null;
        } else {
            ret = head.value;
            head = head.next;
        }

        return ret;

    }

    public void print() {
        if (head == null) return;
        Node<T> curr = head;
        System.out.println(curr.value.toString());
        while(curr.next != null) {
            curr = curr.next;
            System.out.println(curr.value.toString());
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.print();
        System.out.println("-------");
        stack.pop();
        stack.print();
    }

}
