### The "Delete" Concept: Primitives vs. Objects

When removing an element from a dynamic array, do you need to overwrite the old data?

**For Primitives (e.g., `int[]`): No.**
Because the array is made of primitive types, the memory space for that slot is permanently allocated as long as the underlying array exists. Setting it to `0` does not save any memory. Because your `size` variable strictly controls what the user can access via the `at(index)` method, any old "garbage" data left behind at `array[size]` is effectively invisible and harmless. Simply decreasing the `size` variable is enough!

**For Objects (e.g., `String[]`): Yes.**
If this were an array of Objects, leaving an old reference sitting at `array[size]` would prevent the Java Garbage Collector from cleaning it up, because the array is technically still pointing to it. This creates a **memory leak**. In an array of objects, you must explicitly set the removed slot to `null` (e.g., `this.array[size] = null;`) to free the memory.
