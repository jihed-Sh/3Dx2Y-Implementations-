# Stacks & Queues: The Restrictive Structures

Stacks and Queues are abstract data types. Under the hood, they are just Arrays or Linked Lists, but they strictly restrict *where* you can add or remove data.

## 1. Stacks (LIFO)
**Last-In, First-Out.** Think of a stack of plates. You can only put a plate on top, and you can only take a plate off the top.

* **Operations:** `push` (add to top), `pop` (remove from top), `peek` (look at top).
* **Time Complexity:** All $O(1)$.
* **Use Cases:** The Call Stack (recursion), undo mechanisms in text editors, reversing a string, depth-first search (DFS).
* **Implementation:** Trivial using a Dynamic Array. Just use your array's `push()` and `pop()` methods.

## 2. Queues (FIFO)
**First-In, First-Out.** Think of a line at a coffee shop. The first person in line is the first person served.
* **Operations:** `enqueue` (add to back), `dequeue` (remove from front).
* **Use Cases:** Breadth-First Search (BFS), task scheduling, handling asynchronous requests.

### The Linked List Implementation
To get $O(1)$ operations, you must enqueue at the `tail` and dequeue at the `head`. 
* **The Washam Warning:** If you mess this up and enqueue at the head / dequeue at the tail on a Singly Linked List, your dequeue becomes **$O(N)$**. Why? Because to remove the tail, you have to traverse the entire list to find the 2nd-to-last node to make it the new tail!

### The Fixed-Size Array Implementation (Circular Buffer)
If you build a queue with a standard array, removing from the front (`dequeue`) means you have to shift every single remaining element to the left. That is $O(N)$ and terrible for performance.

* **The Solution (The Ring Buffer):** You use two pointers: a `read` index (front) and a `write` index (back). When you hit the end of the array, you wrap back around to index `0` using the modulo operator (`%`). 
* This makes both `enqueue` and `dequeue` **$O(1)$** without shifting any memory.
