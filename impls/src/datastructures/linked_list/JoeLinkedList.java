package datastructures.linked_list;


public class JoeLinkedList {

    private Node head;

    private Node tail;

    private int size;

    private class Node {
        int data;
        Node next;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int front() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return this.head.data;
    }

    public int back() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return this.tail.data;
    }

    public void push_front(int item) {

        Node newNode = new Node();
        newNode.data = item;
        newNode.next = this.head;
        if (this.isEmpty()) {
            this.tail = newNode;
        }
        this.head = newNode;
        this.size++;

    }

    public void push_back(int item) {
        Node newNode = new Node();
        newNode.data = item;
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.size++;
    }

    public int value_at(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int pop_front() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        int poppedValue = this.head.data;
        this.head = this.head.next;
        this.size--;
        if (this.size == 0) {
            this.tail = null;
        }
        return poppedValue;
    }

    public int pop_back() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (this.size == 1) {
            return pop_front();
        }
        int poppedValue = this.tail.data;
        Node current = this.head;
        while (current.next != this.tail) {
            current = current.next;
        }
        this.tail = current;
        this.tail.next = null;
        this.size--;
        return poppedValue;
    }

    public void insert(int index, int item) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            push_front(item);
            return;
        }
        if (index == size()) {
            push_back(item);
            return;
        }

        Node newNode = new Node();
        newNode.data = item;
        Node current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        this.size++;
    }

    public void erase(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            pop_front();
        } else if (index == size() - 1) {
            pop_back();
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            this.size--;
            if (this.size == 0) {
                this.tail = null;
            }

        }
    }

    public void remove_value(int value) {
        Node current = this.head;
        for (int i = 0; i < size(); i++) {
            if (current.data == value) {
                erase(i);
                return;
            }
            current = current.next;
        }
    }

    public int value_n_from_end(int n) {
        if (n < 0 || n >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.value_at(size() - n - 1);
    }

    public void reverse() {
        Node current = this.head;
        Node prev = null;
        Node next = null;
        this.tail = this.head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;


    }


    public static void main(String[] args) {
        JoeLinkedList list = new JoeLinkedList();
        list.push_back(1);
        list.push_back(2);
        list.push_back(3);

        System.out.println("Front: " + list.front() + " | Back: " + list.back());
        list.reverse();
        System.out.println("After Reverse -> Front: " + list.front() + " | Back: " + list.back());
    }
}
