# Hash Tables: The $O(1)$ Powerhouse

A Hash Table (or Hash Map) is a data structure that maps **keys** to **values**. It provides near-instantaneous search, insertion, and deletion by using a mathematical trick to convert a key into a specific index in an array.\n

A Hash table, whatever your language calls it, associates a set of keys with a set of values. Each key/value pair is an entry in the table. Given a key, you can look up its corresponding value. You can add new key/value pairs and remove entries by key. If you add a new value for an existing key, it replaces the previous entry.
## 1. How it Works: The Hash Function
The "magic" of a hash table is the **Hash Function**. It takes a key (like a String "User123") and outputs an integer.
* **Deterministic:** The same key must always produce the same integer.
* **Uniformity:** It should distribute keys evenly across the array to avoid "clustering."
* **Fixed Range:** We use the modulo operator (`hash % array_length`) to fit the large integer into our specific array size.



## 2. The Collision Problem
No hash function is perfect. Eventually, two different keys will hash to the exact same index. This is a **Collision**. There are two primary ways to handle this:

### A. Separate Chaining (Linked Lists)
Each "bucket" in the array is actually a **Linked List**. If two keys hash to index 5, both are stored in the list at index 5.
* **Pros:** Simple to implement; the table never technically "fills up."
* **Cons:** If the lists get long, performance degrades from $O(1)$ to $O(N)$.


### B. Open Addressing (Probing)
If index 5 is taken, the hash table looks for the *next* available spot in the array.
* **Linear Probing:** Look at index 6, then 7, then 8...
* **Quadratic Probing:** Use a square function to find the next spot ($5+1^2$, $5+2^2$...) to avoid clustering.
* **Double Hashing:** Use a second hash function to determine the "step size" for the next probe.


## 3. Load Factor and Resizing
The **Load Factor ($\alpha$)** is the ratio of items to the total number of slots: `n / k`.
* If $\alpha$ gets too high (usually > 0.7), collisions become frequent and performance tanks.
* **Re-hashing:** When the load factor is exceeded, the table creates a new, larger array (usually double the size) and **re-inserts every single item**. You cannot simply copy the memory (like an ArrayList) because the modulo math (`hash % new_size`) has changed.

## 4. Complexity & Trade-offs

| Operation | Average | Worst Case |
| :--- | :--- | :--- |
| **Search** | $O(1)$ | $O(N)$ (Total collision) |
| **Insert** | $O(1)$ | $O(N)$ (During resize) |
| **Delete** | $O(1)$ | $O(N)$ |

**The Cost of Speed:** Hash tables are fast but "space-hungry." They require a lot of empty slots to maintain $O(1)$ performance, leading to higher memory overhead than a compact array or linked list.

## 5. Resources
* [Hash Tables in 4 Minutes](https://www.youtube.com/watch?v=knV86FlSXJ8)
* [Crafting Interpreters](https://craftinginterpreters.com/hash-tables.html#top)

