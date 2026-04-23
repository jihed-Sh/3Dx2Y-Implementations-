package datastructures.queues;

public class JoeLinkedListQueue {
    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node next;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(int item) {

        Node newNode = new Node();

        newNode.data = item;
        newNode.next = null;
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = this.head.data;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return value;

    }
}
