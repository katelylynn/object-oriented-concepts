package org.datastructures;

public class HashMap<K, V> {

    KVLinkedList<K, V>[] table;

    HashMap() {
        this.table = new KVLinkedList[8];
    }

    void add(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new KVLinkedList<>();
        }

        table[index].add(key, value);
    }

    V get(K key) {
        int index = hash(key);
        return table[index].get(key);
    }

    int hash(K key) {
        return Math.abs( key.hashCode() % table.length );
    }

    void rehash() {

        KVLinkedList<K, V>[] temp = table;
        table = new KVLinkedList[table.length*2];

        for (KVLinkedList kvll : temp) {

            if (kvll == null) continue;

            while (kvll.head != null) {
                KVPair head = (KVPair) kvll.head.value;
                add( (K) head.key, (V) head.value );

                kvll.head = kvll.head.next;
            }

        }

    }

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        // Add some key-value pairs
        map.add("apple", 1);
        map.add("banana", 2);
        map.add("cherry", 3);

        // Print the values associated with the keys
        System.out.println("apple: " + map.get("apple"));
        System.out.println("banana: " + map.get("banana"));
        System.out.println("cherry: " + map.get("cherry"));

        // Test the rehash method
        map.rehash();
        System.out.println("After rehashing:");
        System.out.println("apple: " + map.get("apple"));
        System.out.println("banana: " + map.get("banana"));
        System.out.println("cherry: " + map.get("cherry"));

        System.out.println(map.table.length);
    }

}
