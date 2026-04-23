# Arrays: Memory & Complexity

## 1. Static Arrays
A contiguous block of memory. Because the memory is contiguous, access time is lightning fast. The machine calculates the exact memory address mathematically: `base_address + (index * size_of_element)`.

* **Time Complexity:**
    * **Access (Read/Write at index):** $O(1)$
    * **Search (Unsorted):** $O(N)$
    * **Insert/Delete (End):** $O(1)$ *(if space permits)*
    * **Insert/Delete (Middle):** $O(N)$ *(requires shifting elements)*

## 2. Dynamic Arrays (`ArrayList`)
Wraps a static array to allow dynamic resizing.

* **How Resizing Works (Java):** When the underlying array fills up, Java creates a new array that is **1.5x** the size of the original. It copies all elements over, which is an $O(N)$ operation.
* **Amortized Time:**
  Because resizing happens rarely, we say the "amortized" (average) time to insert at the end is $O(1)$, even though the worst-case time is $O(N)$.

## 3. Jagged Arrays vs. Matrices
In Java, a multi-dimensional array `int[][]` is an **array of references to other arrays**.
* **Memory Overhead:** Higher than a flat 1D array because you have to store object headers and references for every inner array.
* **Jagged Nature:** Inner arrays can be of varying lengths (e.g., `matrix[0] = new int[5]; matrix[1] = new int[2];`).
* **Cache Locality:** Because inner arrays are allocated separately, they may not be physically adjacent in RAM. This means traversing a 2D array in Java can result in more CPU cache misses compared to languages with true contiguous 2D matrices.
