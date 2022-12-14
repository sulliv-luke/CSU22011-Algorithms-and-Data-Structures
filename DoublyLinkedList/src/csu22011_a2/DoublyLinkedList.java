package csu22011_a2;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Luke Sullivan
 *  @version 11/10/22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: TODO O(1);
     *
     * Justification:
     * This function consists of an if statement
     * The conditions of the if statement both have a cost O(1)
     * O(1) + O(1) = O(1)
     * Hence the worst case asymptotic running time cost = O(1)
     *  TODO
     */
    public boolean isEmpty()
    {
      if (head == null || tail == null) {
    	  return true;
      }
      return false;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: TODO O(N)
     *
     * Justification:
     * This function consists of an if statement, where the condition is the previous isEmpty() function. Cost = O(1).
     *
     * 
     * There is also a for loop on line 136 which in the worst case will iterate to the very end of the list.
     * Hence the cost is O(N)
     * 
     * Ignoring the constant costs, O(N) is the worst case time complexity
     * 
     *  TODO
     */
    public void insertBefore( int pos, T data ) 
    {
    	// If list is empty, create node first
    	DLLNode newNode = new DLLNode(data, null, null);
    	if(isEmpty()) {
    		head = newNode;
    		tail = newNode;
    	} else {
    		if (pos <= 0) {
    			newNode.next = head;
    			head.prev = newNode;
    			head = newNode;
    		} else {
    			DLLNode refNode = head;
    			boolean alreadyInserted = false;
    			for (int i = 0; i < pos; i++) {
    				if (refNode.next == null) {
    					tail.next = newNode;
    	    			newNode.prev = tail;
    	    			tail = newNode;
    					i = pos;
    					alreadyInserted = true;
    				} else {
    					refNode = refNode.next;
    				}
    			}
    			if (!alreadyInserted) {
    				newNode.next = refNode;
        			refNode.prev.next = newNode;
        			newNode.prev = refNode.prev;
        			refNode.prev = newNode;
    			}
    		}
    	}
    	// 
    	
      //TODO
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     * This function (in order) consists of;
     * 	- an if statement [Cost: O(1)]
     * 	- two variable declarations [Cost: O(1) each]
     * 	- a while loop, which iterates through the entire list [Cost: O(N)]
     * 	- another if statement [Cost: O(1)]
     *  - another variable (node) declaration [Cost: O(1)]
     *  - a for loop which, in the worst case, will iterate through the entire list [Cost: O(1)]
     *  
     *  Therefore, the total cost for the worst case asymptotic running time is;
     *  O(N)
     * 
     * 
     *  TODO
     *
     */
    public T get(int pos) 
    {
    	if (pos < 0 || isEmpty()) {
    		return null;
    	}
    	DLLNode ref = head;
		for (int i = 0; i < pos; i++) {
			if (ref.next == null) {
				return null;
			} else {
				ref = ref.next;
			}
		}
      return ref.data;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: TODO O(N)
     *
     * Justification:
     *
     * There is then a for loop on line 227 to get the correct reference node
     * Hence the cost for that is O(N) in the worst case
     * 
     * Ignoring all the constant costs, O(N) is the worst case runtime
     *  TODO
     */
    public boolean deleteAt(int pos) 
    {
      //TODO
    	if (pos < 0 || isEmpty()) {
    		return false;
    	}
		DLLNode ref = head;
		for (int i = 0; i < pos; i++) {
			if (ref.next == null) {
				return false;
			} else {
				ref = ref.next;
			}
		}
		if (head == ref) {
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = ref.next;
				ref.next.prev = null;
			}
		} else if (tail == ref) {
			tail = ref.prev;
			ref.prev.next = null;
		} else {
			ref.next.prev = ref.prev;
			ref.prev.next = ref.next;
		}
      return true;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: O(N)TODO
     *
     * Justification:
     * 
     * On line 267 we have a while loop which is used to iterate through the list, swapping the previous and next pointers of each node
     * In the worst case this will run at a time complexity of O(N), ignoring all constant costs      *  TODO
     */
    public void reverse()
    {
      //TODO
    	if (!isEmpty()) {
    		DLLNode tempNode = null;
    		DLLNode currentNode = head;
    		
    		while (currentNode != null) {
    			tempNode = currentNode.prev;
    			currentNode.prev = currentNode.next;
    			currentNode.next = tempNode;
    			currentNode = currentNode.prev;
    		}
    		
    		if (tempNode != null) {
    			head = tempNode.prev;
    		}
    		
    	}
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: O(N^2) TODO
     *
     * Justification:
     * 
     * On line 301 there is a for loop which will iterate through each node in the list in the worst case: O(N)
     * Inside this for loop, we iterate though every other node in the list in order to compare the first node (ref1) with every other node in the list: O(N)
     * As this while loop is nested inside the for loop, the worst case time complexity is O(N^2), ignoring all constant costs.
     *  TODO
     */
     public void makeUnique()
    {
      //TODO
    	if (!isEmpty()) {
    		// only executes when there's more than one node
    		DLLNode ref1;
    		DLLNode ref2;
    		int ref1Pos = 0;
    		for (ref1 = head; ref1 != null; ref1 = ref1.next) {
    			ref2 = ref1.next;
    			int ref2Pos = ref1Pos + 1;
    			ref1Pos++;
    			while (ref2 != null) {
    				if (ref1.data == ref2.data) {
    					DLLNode temp = ref2.next;
    					deleteAt(ref2Pos);
    					ref2 = temp;
    				} else {
    					ref2 = ref2.next;
    					ref2Pos++;
    				}
    			} 
    		}
    		
    	}
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: O(1) TODO
     *
     * Justification:
     * 
     * All the instructions in this function have a constant cost of O(1)
     * Hence the worst case run time is O(1)
     *  TODO
     */
    public void push(T item) 
    {
      //TODO
    	DLLNode newNode = new DLLNode(item, null, null);
    	if (isEmpty()) {
    		head = newNode;
    		tail = newNode;
    	} else {
    		tail.next = newNode;
    		newNode.prev = tail;
    		tail = newNode;
    	}
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(1) TODO
     *
     * Justification:
     * All the instructions in this function have a constant cost of O(1)
     * Hence the worst case run time is O(1)
     *  TODO
     */
    public T pop() 
    {
      //TODO
    	if (isEmpty()) {
    		return null;
    	} else if (head == tail){
    		DLLNode temp = head;
    		head = null;
    		tail = null;
    		return temp.data;
    	} else {
    		DLLNode temp = tail;
    		tail.prev.next = null;
    		tail = tail.prev;
    		return temp.data;
    	}
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: O(1) TODO
     *
     * Justification:
     * 
     * All instructions have a constant cost of O(1)
     * 
     *  TODO
     */
    public void enqueue(T item) 
    {
      //TODO
    	DLLNode newNode = new DLLNode(item, null, null);
    	if (isEmpty()) {
    		head = newNode;
    		tail = newNode;
    	} else {
    		// inserts at head
    		newNode.next = head;
			head.prev = newNode;
			head = newNode;
    	}
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(1)TODO
     *
     * Justification:
     * All instructions have a constant cost of O(1)
     *  TODO
     */
    public T dequeue() 
    {
      //TODO
    	if (isEmpty()) {
    		return null;
    	} else if (head == tail){
    		DLLNode temp = tail;
    		head = null;
    		tail = null;
    		return temp.data;
    	} else {
    		DLLNode temp = tail;
    		tail.prev.next = null;
    		tail = tail.prev;
    		return temp.data;
    	}
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  The code consists of the lines before the for-loop, the for-loop itself and the lines after the for-loop.
     *
     *  The lines before the for loop involve 
     *  - the creation of a StringBuilder object which does not depend on the length of the list. Therefore it takes Theta(1) time.
     *  - the allocation and assignment of two variables which are constant time operations.
     *  Thus the code before the for-loop will take Theta(1) time to run.
     *
     *  The lines after the for-loop involve a single return instruction and thus take Theta(1) time.
     *
     *  The for-loop itself will iterate over all elements of the DLL. Thus it will perform Theta(N) iterations.
     *  Each iteration will involve:
     *   * The if-conditional will run:
     *       - the if-then-else conditions and branching, which are constant time operations. Thus these cost Theta(1) time.
     *       - The then-branch of the conditional calls StringBuilder's append() method, which (from the Java documentation) we know it runs in Theta(1) time.
     *       - the else-branch of the conditional involves a single assignment, thus runs in Theta(1) time.
     *     Therefore the if-then-else conditions will cost Theta(1) in the worst case.
     *   * The final call to StringBuilder's append will cost again Theta(1)
     *   * the nested call to toString() will cost time proportional to the length of the strings (but not the length of the list). 
     *     Assuming strings are relatively small compared to the size of the list, this cost will be Theta(1).
     *  Therefore each iteration of the loop will cost Theta(1).
     *  Thus the lines involving the for-loop will run in Theta(N)*Theta(1) = Theta(N).
     *
     * Therefore this method will run in Theta(1) + Theta(1) + Theta(N) = Theta(N) time in the worst case.
     *
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



