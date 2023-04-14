package org.datastructures;

public class Queue<T> {

    Node<T> head;

    public void push(T val) {
        Node curr = new Node(val);

        if (head == null) {
            head = curr;
        } else {
            curr.next = head;
            head = curr;
        }
    }

    public T pop() {

        T ret;

        // can add check if head is null

        if (head.next == null) {
            ret = (T) head.value;
            head = null;
        } else {
            Node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            ret = (T) curr.next.value;
            curr.next = null;
        }

        return ret;

    }

    public void print() {
        Node<T> curr = head;
        System.out.println(curr.value.toString());
        while(curr.next != null) {
            curr = curr.next;
            System.out.println(curr.value.toString());
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.print();
        System.out.println("-------");
        queue.pop();
        queue.print();
    }

}
