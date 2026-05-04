package datastructures.hashtable;

public class JoeHashTable {

    private static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // This is our "Tombstone" marker
    private final Entry DELETED = new Entry(null, -1);

    private Entry[] table;
    private int size;
    private int capacity;

    public JoeHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void add(String key, int value) {
        // 1. Check for resize here later (e.g., if size >= capacity * 0.7)

        int index = hash(key);
        int firstDeletedIndex = -1;

        // Probing loop
        while (table[index] != null) {
            if (table[index] == DELETED) {
                // Keep track of the first tombstone we find to reuse it later
                if (firstDeletedIndex == -1) firstDeletedIndex = index;
            } else if (table[index].key.equals(key)) {
                // Key already exists? Just update value and stop.
                table[index].value = value;
                return;
            }

            index = (index + 1) % capacity;

            // Safety check to prevent infinite loop if table is full
            // (Though resizing should prevent this)
        }

        // If we are here, the key wasn't found.
        // We can reuse a deleted slot if we found one, otherwise use the null slot.
        int insertionIndex = (firstDeletedIndex != -1) ? firstDeletedIndex : index;
        table[insertionIndex] = new Entry(key, value);
        size++;
    }

    public boolean exists(String key) {
        int index = hash(key);
        while (table[index] != null) {
            // Only check the key if this isn't a deleted slot!
            if (table[index] != DELETED && table[index].key.equals(key)) {
                return true;
            }
            index = (index + 1) % capacity;
        }
        return false;
    }

    public Integer get(String key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % capacity;
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = DELETED;
                size--;
                return;
            }
            index = (index + 1) % capacity;
        }
    }

    private void resize(int newCapacity) {
        Entry[] oldTable = this.table;
        this.capacity = newCapacity; // Update capacity FIRST so hash() works for the new size
        this.table = new Entry[newCapacity];
        this.size = 0; // Reset size and re-increment during re-insertion

        for (Entry entry : oldTable) {
            // Only move active entries (skip nulls and tombstones)
            if (entry != null && entry != DELETED) {
                reInsert(entry);
            }
        }
    }

    // Helper for resize so we don't have to deal with complex logic inside the loop
    private void reInsert(Entry entry) {
        int index = Math.abs(entry.key.hashCode()) % capacity;
        while (table[index] != null) {
            index = (index + 1) % capacity;
        }
        table[index] = entry;
        size++;
    }

    public static void main(String[] args) {

    }

}
