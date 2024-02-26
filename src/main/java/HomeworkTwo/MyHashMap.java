package HomeworkTwo;

public class MyHashMap<K, V> {

    private static final int DEFAULT_SIZE = 8;
    private Entry<K, V>[] entries = new Entry[DEFAULT_SIZE];
    private int size;

    public void put(K key, V value) {
        int index = getBucket(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (entries[index] == null) {
            entries[index] = newEntry;
            size++;
        } else {
            Entry<K, V> current = entries[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newEntry;
                size++;
            }
        }
    }

    public V get(K key) {
        int index = getBucket(key);
        Entry<K, V> current = entries[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = getBucket(key);
        Entry<K, V> current = entries[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    entries[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        for (int i = 0; i < entries.length; i++) {
            entries[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private int getBucket(K key) {
        return Math.abs(key.hashCode() % entries.length);
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}