package com.flifi.tot.commons.collection;

public interface WeakConcurrentHashMapListener<K,V> {
    public void notifyOnAdd(K key, V value);
    public void notifyOnRemoval(K key, V value);
}
