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
	public void addingArray(K[] arrayKey) {
		for(K key:  arrayKey) {
			this.addToTree(key);
		}
	}
	public boolean searchValue(K key) {
		return this.searchUsingRecursion(this.myRoot,key);
	}
	
	private boolean searchUsingRecursion(MyNode<K> livePosition, K key) {
		if(livePosition==null) {
			return false;
		}else if(livePosition.key==key) {
			return true;
		}else if(key.compareTo(livePosition.key)<0) {
			return searchUsingRecursion(livePosition.leftPart, key);
		}else {
			return searchUsingRecursion(livePosition.rightPart, key);
		}
	}
	
    public static void main( String[] args ){
    	MyBinarySearchTree<Integer> myValueTree=new MyBinarySearchTree<Integer>();
    	Integer[] arrayKey=new Integer[] {56,30,70,22,40,60,95,11,65,3,63,67};
    	Integer searchElement=63;
		myValueTree.addingArray(arrayKey);
		
    	log.info("Binary Tree of "+myValueTree.getSize()+" values Created");
    	if(myValueTree.searchValue(searchElement))
    			log.info(" 63 is there in the tree");
    	else log.info(" 63 is NOT there in the tree");
    	
    	
        
    }
}
