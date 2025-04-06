package Module_4.BowlingShopApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

import java.util.LinkedList;

// GenericQueue class
public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<>(); // LinkedList to store the queue elements
    
    // Add an item to the queue
    public void enqueue(E item) {
        list.addFirst(item); // Add the item to the front of the list
    } // End of enqueue method
    
    // Remove and return the first item in the queue
    public E dequeue() {
        return list.removeFirst(); // Remove and return the first item in the list
    } // End of dequeue method

    // Return the number of items in the queue
    public int size() {
        return list.size();
    } // End of size method
} // End of GenericQueue class