package csu22011_a2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Luke Sullivan
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testGet() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        
    	Integer expectedResult = 4;
        assertEquals("Checking get for a list, looking for data of the first element - expect 4", expectedResult, testDLL.get(0));
        expectedResult = 3;
        assertEquals("Checking get for a list, looking for data of last element - expect 3", expectedResult, testDLL.get(3));
        expectedResult = null;
        assertEquals("Checking get for a list, with a negative index passed in - expect null", expectedResult, testDLL.get(-1));
        assertEquals("Checking get for a list, with a index greater than the actual size of the list - expect null", expectedResult, testDLL.get(700));
        

    }
    
    @Test
    public void testDelete() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        
        assertEquals("Checking delete for a list, pos is too big, should return false", false, testDLL.deleteAt(700));
        
        testDLL.deleteAt(0);
        assertEquals("Checking delete for a list, deleting the first element", "1,2,3", testDLL.toString());
        testDLL.deleteAt(1);
        assertEquals("Checking delete for a list, deleting next element", "1,3", testDLL.toString());
        testDLL.deleteAt(1);
        assertEquals("Checking delete for a list, deleting last element", "1", testDLL.toString());
        testDLL.deleteAt(0);
        assertEquals("Checking delete for a list, deleting last element", "", testDLL.toString());
        
        assertEquals("Checking delete for a list, pos is negative, should return false", false, testDLL.deleteAt(-1));
        
        DoublyLinkedList<Integer> testDLLTwo = new DoublyLinkedList<Integer>();
        
        assertEquals("Checking delete for a list, pos is zero, length of list is zero, should return false", false, testDLLTwo.deleteAt(0));
    }
    
    @Test
    public void testReverse() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        
        testDLL.reverse();
        assertEquals("Checking reverse, expect 3,2,1,4", "3,2,1,4", testDLL.toString());
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0, 1);
        testDLL.reverse();
        assertEquals("Checking reverse for list with only one element", "1", testDLL.toString());
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.reverse();
        assertEquals("Checking reverse for list with no elements", "", testDLL.toString());
    	
    }
    
    @Test
    public void testUnique() {
  
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(0,4);
        testDLL.insertBefore(2,4);
        testDLL.insertBefore(2,3);
        
        testDLL.makeUnique();
        assertEquals("Checking unique - expect 4,1,3,2", "4,1,3,2", testDLL.toString());
        
        testDLL = new DoublyLinkedList<Integer>();
        
        testDLL.insertBefore(0, 8);
        testDLL.insertBefore(1, 4);
        testDLL.insertBefore(2, 4);
        testDLL.insertBefore(3, 6);
        testDLL.insertBefore(4, 4);
        testDLL.insertBefore(5, 8);
        testDLL.insertBefore(6, 4);
        testDLL.insertBefore(7, 10);
        testDLL.insertBefore(8, 12);
        testDLL.insertBefore(9, 12);
        testDLL.makeUnique();
        assertEquals("Check unique for list of 10 elements - expect 8,4,6,10,12", "8,4,6,10,12", testDLL.toString());
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.makeUnique();
        assertEquals("Check unique for empty list - expect ''", "", testDLL.toString());
        
        testDLL.insertBefore(0, 1);
        testDLL.makeUnique();
        assertEquals("Check unique for list with one element - expect 1", "1", testDLL.toString());
    }
    
    @Test
    public void testPush() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.push(1);
    	assertEquals("Check push on an empty list - expect 1", "1", testDLL.toString());
    	testDLL.push(2);
    	testDLL.push(3);
    	testDLL.push(4);
    	
    	assertEquals("Check push on a list with one element - expect 1,2,3,4", "1,2,3,4", testDLL.toString());
    	
    }
    
    @Test
    public void testPop() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	assertEquals("Check pop on empty list - expect null", null, testDLL.pop());
    	for (int i = 1; i <= 4; i++) {
    		testDLL.push(i);
    	}
    	Integer expectedResult = 4;
    	assertEquals("Check pop on list of four nodes - expect 4", expectedResult, testDLL.pop());
    	expectedResult--;
    	assertEquals("Check pop on list of four nodes - expect 3", expectedResult, testDLL.pop());
    	expectedResult--;
    	assertEquals("Check pop on list of four nodes - expect 2", expectedResult, testDLL.pop());
    	expectedResult--;
    	assertEquals("Check pop on list of four nodes - expect 1", expectedResult, testDLL.pop());
    	
    }
    
    @Test
    public void testEnqueue() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.enqueue(1);
    	assertEquals("Checking enqueue on empty list - expect 1", "1", testDLL.toString());
    	testDLL.enqueue(2);
    	testDLL.enqueue(3);
    	testDLL.enqueue(4);
    	assertEquals("Checking enqueue for four elements - expect 4,3,2,1", "4,3,2,1", testDLL.toString());
    	
    	
    }
    
    @Test
    public void testDequeue() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	assertEquals("Checking dequeue on empty list - expect null", null, testDLL.dequeue());
    	for (int i = 1; i <= 4; i++) {
    		testDLL.enqueue(i);
    	}
    	Integer expectedResult = 1;
    	assertEquals("Checking dequeue on list of four nodes - expect 1", expectedResult, testDLL.dequeue());
    	expectedResult++;
    	assertEquals("Checking dequeue on list of four nodes - expect 2", expectedResult, testDLL.dequeue());
    	expectedResult++;
    	assertEquals("Checking dequeue on list of four nodes - expect 3", expectedResult, testDLL.dequeue());
    	expectedResult++;
    	assertEquals("Checking dequeue on list of four nodes - expect 4", expectedResult, testDLL.dequeue());
    	
    
    	
    }
}

