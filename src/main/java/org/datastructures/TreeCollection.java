package org.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class TreeCollection implements Iterable {

    Node root;

    public class Node {
        Node left;
        Node right;
        int value;
        public Node(int s) {
            this.value = s;
        }
    }
    public class TCIterator implements Iterator {
        Node root;
        ArrayList<Node> order;
        int index;

        public TCIterator(Node root) throws NullRootException {
            if (root == null) {
                throw new NullRootException();
            }
            this.root = root;
            this.order = DFSOrder();
            this.index = 0;
        }

        public ArrayList<Node> DFSOrder() {
            ArrayList<Node> order = new ArrayList<Node>();

            if (root == null) return order;

            Stack<Node> stack = new Stack<Node>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node curr = stack.pop();
                order.add(curr);
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
            return order;
        }

        @Override
        public boolean hasNext() {
            return index < order.size();
        }

        @Override
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Node temp = order.get(index);
            index++;
            return temp.value;
        }

    }

    public void insert(int i) {
        Node temp = new Node(i);

        if (root == null) {
            root = temp;
            return;
        }

        Node current = root;
        while (current != null) {
            if (current.left == null && temp.value <= current.value) {
                current.left = temp;
                return;
            } else if (current.right == null && temp.value > current.value) {
                current.right = temp;
                return;
            } else if (temp.value <= current.value) {
                current = current.left;
            } else if (temp.value > current.value) {
                current = current.right;
            }
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        try {
            return new TCIterator(root);
        } catch (NullRootException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TreeCollection tc = new TreeCollection();
        tc.insert(5);
        tc.insert(4);
        tc.insert(6);
        tc.insert(2);
        tc.insert(3);
        tc.insert(1);

    }

}
