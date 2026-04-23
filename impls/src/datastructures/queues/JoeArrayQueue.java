package datastructures.queues;

public class JoeArrayQueue {
    private int[] array;
    private int size = 0;
    private int capacity;
    private int head= 0;
    private int tail = 0;

    public JoeArrayQueue(int capacity) {
        this.capacity = capacity;
        this.array =new int[capacity];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
    public boolean isFull(){
        return this.size == this.capacity;
    }
    public void enqueue(int item){
        if(isFull()){
            throw new IllegalStateException("Queue is full");
        }
        this.array[this.tail] = item;
        this.tail = (this.tail + 1) % this.capacity;
        this.size++;
    }
    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        int item = this.array[this.head];
        this.head = (this.head + 1) % this.capacity;
        this.size--;
        return item;
    }

    public static void main(String[] args) {
        JoeArrayQueue q = new JoeArrayQueue(3);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue()); // Removes 10
        q.enqueue(40); // This wraps around to index 0!

        System.out.println("Next to Dequeue: " + q.dequeue()); // Removes 20
    }

}
