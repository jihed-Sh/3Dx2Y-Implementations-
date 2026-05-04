# Binary Search: Optimization & Edge Cases

Binary Search is the foundation of $O(\log N)$ efficiency. If you see a problem with a **sorted input** or a **monotonic search space**, Binary Search is likely the answer.

## 1. The Implementation "Pro" Profile
* **The Midpoint Overflow:** Standard: `mid = (low + high) / 2` (Risks integer overflow in Java/C++).
  Professional: `mid = low + ((high - low) >> 1);` (Using unsigned shift is even faster).
* **Search Space:** It doesn't have to be an array. It can be a **range of values** (e.g., "Find the smallest integer $x$ such that $f(x)$ is true").

## 2. Decision Logic: The Three Variations
1. **Basic:** Find the exact target.
2. **Left-most (Lower Bound):** Find the first occurrence of a target in a list with duplicates.
    * Logic: When `arr[mid] == target`, don't stop. Set `high = mid - 1` to keep looking left.
3. **Right-most (Upper Bound):** Find the last occurrence.
    * Logic: When `arr[mid] == target`, set `low = mid + 1`.

## 3. Complexity
* **Time:** $O(\log N)$
* **Space:** $O(1)$ Iterative / $O(\log N)$ Recursive (stack depth).

# The Concept of Monotonicity

In mathematics and Computer Science, a function or sequence is **Monotonic** if it moves in **only one direction**. It never reverses its trend.

## 1. Types of Monotonicity
* **Monotonic Increasing:** As $x$ increases, $y$ never decreases ($f(x_1) \leq f(x_2)$).
    * *Example:* `[1, 2, 2, 5, 8, 10]`
* **Monotonic Decreasing:** As $x$ increases, $y$ never increases ($f(x_1) \geq f(x_2)$).
    * *Example:* `[20, 15, 10, 10, 5, 2]`



## 2. Why it matters for Binary Search
Binary Search is traditionally taught as a way to search a "sorted array." However, a sorted array is simply a **Monotonic Search Space**.

As long as a search space is monotonic, we can use the **Binary Search on Answer** pattern:
1.  If a condition is **True** for $x$, and the space is monotonic increasing, the condition must also be **True** for all values $> x$.
2.  This allows us to discard half of the remaining possibilities in $O(1)$ time.

## 3. Real-World Example: Square Roots
To find $\sqrt{100}$ without a math library:
* Search the range $[1, 100]$.
* Check the midpoint $50$: $50^2 = 2500$ (Too high).
* Since $f(n) = n^2$ is **Monotonic Increasing**, every number *greater* than 50 is also guaranteed to be too high.
* We just eliminated $51$ through $100$ in a single step.

## 4. Non-Monotonic (Binary Search Fails)
If a sequence "zig-zags" (e.g., `[1, 5, 2, 8, 3]`), it is **not monotonic**. When you check a midpoint, you have no logical guarantee about which direction to move next. You are forced to use Linear Search $O(N)$.
