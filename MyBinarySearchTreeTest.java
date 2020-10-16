package day14binarytree.day14binarytree;


import org.junit.Assert;
import org.junit.Test;

public class MyBinarySearchTreeTest 
{
   
    @Test
  
    	public void givenThreeNumbersWhenAddedToBInaryTreeShouldHaveSizeThree() {
    		MyBinarySearchTree<Integer> myValueTree=new MyBinarySearchTree<Integer>();
    		Integer firstNumber=56,secondNumber=30,thirdNumber=70,fourthNumber=40;
        	myValueTree.addToTree(firstNumber);
        	myValueTree.addToTree(secondNumber);
        	myValueTree.addToTree(thirdNumber);
        	myValueTree.addToTree(fourthNumber);
        	
    		int size=myValueTree.getSize();
    		Assert.assertEquals(4, size);
    	
    	
    	
    }
}
