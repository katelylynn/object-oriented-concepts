package org.datastructures;

public class KVLinkedList<K, V> {

    Node head;

    void add(K key, V value) {
        Node temp = new Node(new KVPair<K, V>(key, value));
        if (head == null) {
            head = temp;
        } else {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
    }

    V get(K key) {

        // the kv pair stored inside the node
        KVPair kv;

        if (head == null) {
            return null;
        } else {
            Node curr = head;
            while (curr.next != null) {

                kv = (KVPair) curr.value;

                if (kv.key == key) {
                    return (V) kv.value;
                }

                curr = curr.next;

            }
        }
        kv = (KVPair) head.value;
        return (V) kv.value;
    }

}
