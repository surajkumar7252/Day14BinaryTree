package day14binarytree.day14binarytree;

import org.apache.logging.log4j.*;



class MyNode<K extends Comparable<K>>{
	K key;
	MyNode<K> leftPart;
	MyNode<K> rightPart;
	
	public MyNode(K key) {
		this.key=key;
		leftPart=null;
		rightPart=null;
	}
}


public class MyBinarySearchTree <K extends Comparable<K>>{
	private static final Logger log = LogManager.getLogger(MyBinarySearchTree.class);
	
	public MyNode<K> myRoot=null;
	public MyBinarySearchTree() {
		myRoot=null;
	}
	public void addToTree(K key) {
		myRoot=recursiveAddition(myRoot,key);
	}
	
	public MyNode<K> recursiveAddition(MyNode<K> livePosition,K key){
		if(livePosition==null) {
			return new MyNode<K>(key);
		}
		int result=key.compareTo(livePosition.key);
		if(result==0) return livePosition;
		else if(result<0) livePosition.leftPart= recursiveAddition(livePosition.leftPart,key);
		else livePosition.rightPart= recursiveAddition(livePosition.rightPart,key);
		return livePosition;
	}
	
	public int getSize() {
		return this.getSizeByRecursion(this.myRoot);
	}
	public int getSizeByRecursion(MyNode<K> livePosition) {
		MyNode<K> ifLivePosition=livePosition;
		if(ifLivePosition==null) return 0;
		else return getSizeByRecursion(livePosition.leftPart)+getSizeByRecursion(livePosition.rightPart)+1;
	}
	
    public static void main( String[] args ){
    	MyBinarySearchTree<Integer> myValueTree=new MyBinarySearchTree<Integer>();
    	Integer firstNumber=56,secondNumber=30,thirdNumber=70,fourthNumber=40;
    	myValueTree.addToTree(firstNumber);
    	myValueTree.addToTree(secondNumber);
    	myValueTree.addToTree(thirdNumber);
    	myValueTree.addToTree(fourthNumber);
    	log.info("Binary Tree of "+myValueTree.getSize()+" values Created");
    	
        
    }
}
