package csu22011_a3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  TODO
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.
	
	/** <p>Test {@link BST#put(Comparable)}.</p> */
    @Test
    public void put() {
    	BST<Integer, Integer> intBST = new BST<Integer, Integer>();
    	intBST.put(1, null);
    }
	
	/** <p>Test {@link BST#median(Comparable)}.</p> */
    @Test
    public void median() {
    	
    	BST<Integer, Integer> intBST = new BST<Integer, Integer>();
    	assertEquals("Testing median for empty tree, should return null", null, intBST.median());
    	
   	 	intBST.put(7, 7);   //        _7_
   	 	intBST.put(8, 8);   //      /     \
   	 	intBST.put(3, 3);   //    _3_      8
   	 	intBST.put(1, 1);   //  /     \
   	 	intBST.put(2, 2);   // 1       6
   	 	intBST.put(6, 6);   //  \     /
   	 	intBST.put(4, 4);   //   2   4
   	 	intBST.put(5, 5);   //        \
                      	//         5
   	 	
   	 	assertEquals("Testing median for tree of length 8 with a left and right subtree, median should be Key 4", intBST.get(4), intBST.median());
   	 	
   	 	intBST = new BST<Integer, Integer>();
   	 	intBST.put(6, 6);
   	 	intBST.put(5, 5);
   	 	intBST.put(4, 4);
   	 	intBST.put(3, 3);
   	 	intBST.put(2, 2);
   	 	
   	 	assertEquals("Testing median for skewed tree of length 5, should return Key 4", intBST.get(4), intBST.median());
    }
    
    /** <p>Test {@link BST#printKeysInOrder(Comparable)}.</p> */
    @Test
    public void printKeysInOrder() {
    	BST<Character, Character> bst = new BST<Character, Character>();
    	assertEquals("Testing for empty tree", "()", bst.printKeysInOrder());
    	
    	bst.put('S', 'S');
    	bst.put('X', 'X');
    	bst.put('E', 'E');
    	bst.put('R', 'R');
    	bst.put('H', 'H');
    	bst.put('M', 'M');
    	bst.put('A', 'A');
    	bst.put('C', 'C');
    	
    	String result = "(((()A(()C()))E((()H(()M()))R()))S(()X()))";
    	assertEquals("Testing for example given in assignment", result, bst.printKeysInOrder());
    	
    }

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     
     /** <p>Test {@link BST#height(Comparable)}.</p> */
     @Test
     public void height() {
    	 BST<Character, Character> bst = new BST<Character, Character>();
    	 int result = -1;
    	 assertEquals("Checking for height of empty tree, should return -1", result, bst.height());
    	 
    	 bst.put('B', 'B');
    	 bst.put('A', 'A');
    	 bst.put('C', 'C');
    	 
    	 bst.put('D', 'D');
    	 
    	 result = 2;
    	 assertEquals("Checking for example given in BST, height should be 2", result, bst.height());
    	 
    	 BST<Integer, Integer> intBST = new BST<Integer, Integer>();
    	 
    	 intBST.put(7, 7);   //        _7_
    	 intBST.put(8, 8);   //      /     \
    	 intBST.put(3, 3);   //    _3_      8
    	 intBST.put(1, 1);   //  /     \
    	 intBST.put(2, 2);   // 1       6
    	 intBST.put(6, 6);   //  \     /
    	 intBST.put(4, 4);   //   2   4
    	 intBST.put(5, 5);   //        \
                          	//         5
    	 result = 4;
    	 assertEquals("Checking for example tree given earlier, height should be 4", result, intBST.height());
    	 
    	 intBST = new BST<Integer, Integer>();
    	 intBST.put(6, 6);
    	 intBST.put(5, 5);
    	 intBST.put(4, 4);
    	 intBST.put(3, 3);
    	 intBST.put(2, 2);
    	 
    	 assertEquals("Checking for height of left skewed tree, height should be 4", result, intBST.height());
    	 
    	 intBST = new BST<Integer, Integer>();
    	 for (int i = 0; i < 6; i++) {
    		 intBST.put(i, i);
    	 }
    	 result = 5;
    	 assertEquals("Checking for height of right skewed tree, height should be 5", result, intBST.height());
     }
     
}

