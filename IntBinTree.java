/**
*Creates a binary tree of integers
*/

public interface IntBinTree {
	/**
	* adds a node (with an integer value) to the tree
	*/
	void add(int newInt);
	
	/**
	*returns true if the tree contains a specified umber, false otherwise
	*/
	boolean contains(int num);
	
	/**
	*returns the higest number in the treee
	*/
	int getMax();
	
	/**
	*returns the lowest number in the tree
	*/
	int getMin();
}