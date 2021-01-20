package com.ds.java;

/**
 * Class QueueImpl
 * This class contains implementations for Queue using arrays
 */

public class QueueImpl<T> {

    public static final int INITIAL_CAPACITY = 5;
    private T[] queue;
    private int size = 0;
    private int front = 0;

    /**
     * Constructor initialize the queue
     * with INITIAL_CAPACITY
     */
    public QueueImpl() {
        // initialize the queue with initial capacity.
        queue = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * resize() methods resizes the queue with all
     * elements copied over to the resized queue.
     * front index is reset to 0
     */
    public void resize() {
        T[] temp = (T[]) new Object[queue.length*2];
        int length = queue.length;
        for ( int i = 0; i < size; i++) {
            temp[i] = queue[front%length];
            front++;
        }
        // reset the front to zero
        front = 0;
        queue = temp;

    }

    /**
     * print() method prints the content
     * of queue for debugging purposes.
     */
    public void print() {
        int length = queue.length;
        int temp = front;
        for( int i = 0 ; i < size ;i++) {
            System.out.print(queue[temp%length] + " ");
            temp++;
        }
        System.out.println();
    }

    /**
     * enqueue() method add a new element e
     * to the end of the queue.
     * @param e
     */
    public void enqueue(T e) {
        int length = queue.length;
        // check if the array is full
        if ( (front + size) % length == 0 ) {
            // resize the array and reset front
            resize();
        }
        queue[front + size ] = e;
        size++;
    }

    /**
     * dequeue(e) removes an element from the
     * front of the queue and returns it.
     * @return
     */
    public T dequeue() {
            T e = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            size--;
            return e;
    }

    /* Main method to test enqueue and dequeu */
    public static void main(String[] args) {
        QueueImpl<Integer> queue = new QueueImpl<>();

        // enqueue 10 items
        for ( int i = 0 ; i < 10 ; i++) {
            queue.enqueue(i);
            queue.print();
        }

        // dequeue 10 items
        for ( int i = 0 ; i < 10 ;i++) {
            queue.dequeue();
            queue.print();
        }
    }

}
