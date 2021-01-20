package com.ds.java;

import java.util.Arrays;

public class ArrayList<T> {

    public static final int INITIAL_CAPACITY = 10;
    private T[] arraylist;
    private int size = 0;
    /**
     * constructor to intialize array with
     * INITIAL_CAPACITY
     * @param args
     */
    public ArrayList() {
        arraylist = (T[]) new Object[INITIAL_CAPACITY];
    }
    public T[] doubleArraySize(T[] arraylist) {
        // create a new array with size two times bigger than the original arraylist
        T[] doubled_arraylist = (T[])new Object[arraylist.length*2];
        // copy elements from arraylist to doubled_arraylist
        for (int i = 0; i < arraylist.length; i++ ) {
            doubled_arraylist[i] = arraylist[i];
        }
        return doubled_arraylist;
    }

    public void shilfRight(T[] arraylist, int fromIndex) {
        while ( fromIndex > 0 ) {
            arraylist[fromIndex] = arraylist[fromIndex-1];
            fromIndex--;
        }
    }

    public void shilfLeft(T[] arraylist, int fromIndex) {
        while ( fromIndex+1 < arraylist.length && arraylist[fromIndex+1] != null) {
            arraylist[fromIndex] = arraylist[fromIndex+1];
            fromIndex++;
        }
        arraylist[fromIndex] = null;
    }

    public void printArray(){
        System.out.println(Arrays.toString(arraylist));
    }

    /**
     * Method: AddToFront
     * Purpose : adds element e to the front of the array
     * @param args
     */
    public void addToFront(T e) {
        // if size == array length, double the size of arraylist
        if ( size == arraylist.length) {
            arraylist = doubleArraySize(arraylist);
        }

        // shift all element to the right
        shilfRight(arraylist, size);
        // insert the element at index 0
        arraylist[0] = e;
        // increment the size
        size++;

    }

    /**
     * Method : addToBack
     * Purpose: add element e to the back of the array.
     * @param e
     */
    public void addToBack(T e) {
        // if size == arraylist.length, double the size
        if ( size == arraylist.length) {
            arraylist = doubleArraySize(arraylist);
        }
        // add the element at index = size
        arraylist[size] = e;
        // increment the size
        size++;
    }

    public void removeFromFront() {
        shilfLeft(arraylist, 0);
        // set the size index to null
        arraylist[size-1] = null;
        size--;
    }

    public void removeFromBack() {
        // set the size index to null
        arraylist[size-1] = null;
        size--;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for ( int i = 0; i < 20 ;i++) {
            if ( i % 2 == 0 ) {
                arrayList.addToFront(i);
            } else {
                arrayList.addToBack(i);
            }
            arrayList.printArray();
        }
        for ( int i = 0; i < 20 ;i++) {
            if ( i % 2 == 0 ) {
                arrayList.removeFromFront();
            } else {
                arrayList.removeFromBack();
            }
            arrayList.printArray();
        }

    }


}
