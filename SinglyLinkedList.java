package com.ds.java;

/**
 * Class : SinglyLinkedList
 * This class contains implementions for adding element to the front and back,
 * and removing element from front and back. This uses head and tail pointers
 * @param <T>
 */
public class SinglyLinkedList <T>{

    /**
     * Inner Class : Node to store information about a "Node"
     * @param e
     */
    private static class Node<T> {
        private T data;
        private Node next;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        private Node(T data) {
            this(data,null);
        }
    }

    // Node pointers
    private Node head;
    private Node tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public void print(){
        Node temp = head;
        while ( temp != null) {
            System.out.print( temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addToFront(T e) {
        // create a new node
        Node <T>newNode = new Node<>(e);
        System.out.println("Data is : " + newNode.data);
        if ( head == null && tail == null) {
            // case 1: list has no node
            head = newNode;
            tail = newNode;
            newNode = null;
        } else if ( head == tail) {
            // case 2 : list has only one node
            head = newNode;
            head.next = tail;
            newNode = null;
        } else {
            // case 3 : list has more than one node
            newNode.next = head;
            head = newNode;
            newNode = null;
        }
    }

    public void addToBack(T e) {
        // create a new node
        Node <T>newNode = new Node(e);

        if (head == null && tail == null ) {
            // case 1: head and tail point to null ( list is empty )
            head = newNode;
            tail = newNode;
            newNode = null;
        } else if ( head == tail) {
            // case 2 : head and tail point to the same node( there is only one node )
            tail = newNode;
            head.next = tail;
            newNode = null;
        } else {
            // case 3 : list has more than one node
            tail.next = newNode;
            tail = newNode;
            newNode = null;
        }

    }


    public void removeFromFront() {
        if ( head == null && tail == null) {
            return; // no node to remove
        }else if ( head == tail) { // there is only one element , remove it.
            head = null;
            tail = null;
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            temp = null;
        }
    }

    public void removeFromBack() {
        if ( head == null && tail == null) {
            return;
        } else if( head == tail) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while ( temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            temp = null;
        }
    }

    /* main method to test the program */
    public static void main(String [] args ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        // test for adding to the front
        for ( int i = 0; i < 10 ; i++ ) {
            sll.addToFront(i);
            sll.print();
        }
        // test for adding to the back
        for ( int i = 0; i < 10 ; i++) {
            sll.addToBack(i);
            sll.print();
        }

        // test for removing from front
        for (int i = 0;i < 10;i++) {
            sll.removeFromFront();
            sll.print();
        }

        // test for removing from back
        for ( int i = 0 ; i < 10 ; i++) {
            sll.removeFromBack();
            sll.print();
        }
    }

}
