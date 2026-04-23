package datastructures.arrays;

public class JoeArray {
    private int[] array;
    private int size = 0;

    public JoeArray() {
            this.array = new int[16];
    }

    public int size(){
        return this.size;
    }
    public int capacity(){
        return this.array.length;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public int at(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.array[index];
    }

    private void resize(int newCapacity){
        int[] newArray = new int[newCapacity];
        for(int i = 0; i < size(); i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }
    public void push(int item){
        if(this.size == capacity()){
            resize(capacity() * 2);
        }
        this.array[this.size] = item;
        this.size++;
    }

    public void insert(int index, int item){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(size() == capacity()){
            resize(capacity() * 2);
        }
        for(int i = size(); i > index; i--){
            this.array[i] = this.array[i-1];
        }
        this.array[index] = item;
        this.size++;
    }
    public void prepend(int item){
        this.insert(0, item);
    }
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot pop from an empty array");
        }
        int poppedValue = this.array[this.size - 1];
        this.remove(this.size - 1);
        return poppedValue;
    }
    // Deletes item at index, shifting trailing elements left, and shrinks if necessary
    public void delete(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size() - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.size--;

        // Shrink capacity if array is 1/4 full or less
        if (this.size > 0 && this.size <= capacity() / 4) {
            resize(capacity() / 2);
        }
    }

    // Returns first index of the item, -1 if not found
    public int find(int item) {
        for (int i = 0; i < size(); i++) {
            if (this.array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    // Looks for value and removes index holding it (even if in multiple places)
    public void remove(int item) {
        for (int i = 0; i < size(); i++) {
            if (this.array[i] == item) {
                delete(i);
                // Because elements shifted left, we must check this exact index again
                i--;
            }
        }
    }

    public static void main(String[] args) {
        JoeArray myArr = new JoeArray();
        myArr.push(5);
        myArr.push(10);
        myArr.push(15);

        System.out.println("Size: " + myArr.size() + " | Capacity: " + myArr.capacity());
        System.out.println("Popped: " + myArr.pop());
        System.out.println("Size: " + myArr.size() + " | Capacity: " + myArr.capacity());
    }



}
