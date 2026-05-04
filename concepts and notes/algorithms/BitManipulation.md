# Bit Manipulation: Hardware-Level Logic

For a senior dev, bit manipulation is about **Space Optimization** (packing 32 booleans into one `int`) and **Performance** (avoiding branching and division).

## 1. Core Logic Table
| Op | Name | Identity | Trick |
| :--- | :--- | :--- | :--- |
| `&` | **AND** | `x & 0 = 0` | **Masking:** `n & (n-1)` removes the lowest set bit. |
| `\|` | **OR** | `x \| 0 = x` | **Setting:** `n \| (1 << k)` turns bit $k$ on. |
| `^` | **XOR** | `x ^ x = 0` | **Toggling:** `x ^ y ^ x = y` (Finds the non-paired element). |
| `~` | **NOT** | `~x = -x - 1` | **Inverting:** Used for creating masks. |
| `<<` | **L-Shift** | `x << 1 = x*2` | **Growth:** Creating bit-flags. |
| `>>` | **R-Shift** | `x >> 1 = x/2` | **Shrink:** Signed shift (keeps the sign bit). |
| `>>>` | **U-Shift** | `x >>> 1` | **Java Specific:** Logical shift (fills 0 regardless of sign). |

## 2. Advanced "Bit Hacks" for Interviews
* **Power of Two Check:** `return (n > 0) && ((n & (n - 1)) == 0);`
* **Count Set Bits (Kernighan’s):** ```java
  while (n > 0) { n &= (n - 1); count++; }


## 4. Professional Bit-Hacks & Patterns

### A. The "XOR" Property Masterclass
XOR (`^`) is essentially "Addition without carrying."
* **Self-Inverse:** `x ^ x = 0`.
* **The Single Number Problem:** Given an array where every element appears twice except for one, XORing the entire array results in the unique element.
* **Zero-Temp Swap:** `x ^= y; y ^= x; x ^= y;` (Note: Only use this for "cool factor" in interviews; in production, `temp` is safer and often optimized better by compilers).

### B. Two's Complement Wizardry
* **Extract Lowest Set Bit:** `x & -x`
    * *Why?* If $x = 12$ (`1100`), then $-x$ (two's complement) is `0100`. `1100 & 0100 = 0100` (4).
    * This is the backbone of **Binary Indexed Trees (Fenwick Trees)**.
* **Absolute Value (Branchless):**
    ```java
    int mask = x >> 31; // Fills with 1s if negative, 0s if positive
    int abs = (x + mask) ^ mask;
    ```
    * This avoids a CPU "branch" (an `if` statement), which can be faster in tight loops.

### C. The "Kernighan" Bit Counter
Standard counting loops take 32 iterations (for an `int`). Kernighan’s algorithm only takes as many iterations as there are **set bits**.
```java
while (n != 0) {
    n &= (n - 1); // Clears the least significant set bit
    count++;
}
