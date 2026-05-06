# Trees: Non-Linear Hierarchy

A Tree is a collection of nodes connected by edges, representing a hierarchical relationship. Unlike Arrays or Linked Lists, Trees are **Recursive** by nature—every child of a node is itself the "root" of a smaller sub-tree.

## 1. Key Terminology
* **Root:** The top node (no parent).
* **Leaf:** A node with no children (the "end" of a branch).
* **Parent/Child:** The direct nodes above and below.
* **Ancestors:** All nodes on the path from the root to the current node.
* **Sub-tree:** A node and all of its descendants.



## 2. Binary Trees vs. Binary Search Trees (BST)
* **Binary Tree:** Each node has at most **two** children (Left and Right).
* **Binary Search Tree (BST):** A Binary Tree with a **Sorting Property**:
    * All nodes in the **Left** sub-tree are < Parent.
    * All nodes in the **Right** sub-tree are > Parent.
    * *Benefit:* This allows for $O(\log N)$ search, similar to Binary Search on an array.



## 3. The Big Three Traversals (DFS)
Traversals are ways to "visit" every node. They are defined by when you visit the **Root (Current Node)**:
1. **Pre-Order (Root, L, R):** Used for copying a tree.
2. **In-Order (L, Root, R):** Used in BSTs to get values in **Sorted Order**.
3. **Post-Order (L, R, Root):** Used for deleting a tree or calculating folder sizes (bottom-up).

## 4. Breadth-First Search (BFS / Level-Order)
Visits all nodes at the current depth before moving to the next level.
* **Implementation:** Uses a **Queue**.
* **Use Case:** Finding the "shortest path" in a tree.

## 5. Tree Traversals (The Engine)

In a general tree (not just binary), we use these two fundamental strategies:

### A. Depth-First Search (DFS)
DFS goes as deep as possible down one branch before backtracking. It is almost always implemented with **Recursion**.
* **Pseudocode:**
    ```text
    void dfs(node u, node p):
        // 1. Process node u
        for child v of u:
            if v != p: // Avoid going back to parent
                dfs(v, u)
    ```

### B. Breadth-First Search (BFS)
BFS visits the tree level-by-level. It is implemented with a **Queue**.
* **Pseudocode:**
    ```text
    void bfs(root):
        queue q
        q.push(root)
        while q is not empty:
            u = q.pop()
            // Process node u
            for child v of u:
                q.push(v)
    ```



## 6. Tree Properties: Diameter & Longest Paths
* **Diameter:** The longest path between any two nodes in a tree.
* **Algorithm (Two-DFS Trick):** 1. Start at any node $A$ and find the farthest node $B$ (using DFS).
    2. Start at $B$ and find the farthest node $C$.
    3. The distance between $B$ and $C$ is the diameter!

---

## 7. Trees and Dynamic Programming (Tree DP)
If you understand DP, Trees become much easier. In DP, we solve a big problem by combining solutions to sub-problems. In a Tree, a **sub-problem** is simply a **sub-tree**.

### Why they are related:
1.  **Optimal Substructure:** The answer for a node often depends on the answers of its children. (e.g., `Height(parent) = 1 + max(Height(children))`).
2.  **No Cycles:** Unlike general graphs, trees have no cycles. This means you never have to worry about an infinite loop in your DP state.
3.  **Post-Order Processing:** Most Tree DP is done "Bottom-Up." You solve the leaf nodes first, then use their values to solve their parents, all the way up to the root.

**Example: Maximum Independent Set**
* *Problem:* Find the maximum number of nodes you can pick such that no two nodes are connected.
* *DP State:* For each node, you calculate two values:
    1. The max nodes if I **include** this node.
    2. The max nodes if I **exclude** this node.
* *Transition:* If I include the parent, I **must** exclude the children. If I exclude the parent, I take the `max(include, exclude)` of each child.
