package org.datastructures;

public class HashTable<K, V> {

    KVPair<K, V>[] table;

    public HashTable() {
        table = new KVPair[8];
    }

    int hash(Object o) {
        return o.hashCode() % table.length;
    }

    V get(K key) {
        for (KVPair kvPair : table) {
            if (kvPair != null && kvPair.key == key) return (V) kvPair.value;
        }
        return null;
    }

    void add(K key, V value) {

        int index = hash(key);

        while (table[index] != null) {
            index++;
        }

        table[index] = new KVPair(key, value);

    }

    void add2(K key, V value) {
        add(key, value);
        add(key, value);
    }

    @Override
    public String toString() {

        String acc = "MyKVDictionary: \n";
        for (int i = 0; i < table.length; i++) {
            KVPair<K, V> kvPair = table[i];
            if (kvPair != null) {
                acc = acc + String.format("Key: %s; Value: %s\n", kvPair.key, kvPair.value);
            } else {
                acc = acc + "Null \n";
            }
        }
        return acc;
    }
    public void print() {
        System.out.format("%s\n------------\n",this.toString());
    }

    public static void main(String[] args) {

        HashTable<Integer, String> hashTable = new HashTable<>();
        hashTable.add(1, "1");
        hashTable.add(2, "2");
        hashTable.add2(3, "3");
//        hashTable.add2(4, "4");
//        hashTable.add2(5, "5");
        hashTable.add2(6, "6");
//        hashTable.add2(7, "7");
//        hashTable.add2(8, "8");
        hashTable.print();
        System.out.println(hashTable.get(2));

    }

}
