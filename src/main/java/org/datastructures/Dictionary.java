package org.datastructures;

import java.util.ArrayList;

public class Dictionary<K, V> {

    ArrayList<KVPair> kvPairs;

    public Dictionary() {
        kvPairs = new ArrayList<KVPair>();
    }

    public void add(K key, V value) throws DuplicateKeyException {

        for (KVPair kvPair : kvPairs) {
            if (kvPair.key.equals(key))
                throw new DuplicateKeyException();
        }

        KVPair<K, V> kvPair = new KVPair<K, V>(key, value);
        kvPairs.add(kvPair);

    }

    // keys method - returns an ArrayList of all the kvPair keys
    // get method - returns T

    public static void main(String[] args) throws DuplicateKeyException {
        Dictionary<String, String> dict = new Dictionary<String, String>();
        dict.add("hello", "world");
        try {
            dict.add("hello", "friends");
        } catch (DuplicateKeyException e) {
            System.out.println(e);
        }
    }

}
