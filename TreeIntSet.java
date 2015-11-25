public class TreeIntSet implements IntSet {
	
	private int value;
	private TreeIntSet right;
	private TreeIntSet left;
	
	public TreeIntSet(int value) {
		this.value = value;
		right = null;
		left = null;
	}
	
	/**
	*adds a new int to the set; if it is there already, nothing happens.
	*/	
	public void add(int newInt) {
		if (contains(newInt) == true) {
			System.out.println("Value already in set.");
			return;
		}
		if (newInt > value) {
			if (right == null) {
				right = new TreeIntSet(newInt);
			} else {
				right.add(newInt);
			}
		} else {
			if (left == null) {
				left = new TreeIntSet(newInt);
			} else {
				left.add(newInt);
			}
		}
	}
		
	/**
	* returns true if the number is in the set, false otherwise.
	*/
	public boolean contains(int num){
		if (value == num) {
			return true;
		} else if (num > value && right != null) {
			return right.contains(num);
		} else if (num < value && left != null) {
			return left.contains(num);
		} 
		return false;
	}
	
	/**
	*returns the same values as the former method, 
	*but for every element that is checked prints its value on screen.
	*/
	public boolean containsVerbose(int num) {
		System.out.println("Checking element: " + value);
		if (value == num) {
			return true;
		} else if (num > value && right != null) {
			return right.containsVerbose(num);
		} else if (num < value && left != null) {
			return left.containsVerbose(num);
		} 
		return false;
	}
	
	
	/**
	*returns a string with the values of the elements in the set separated by commas.
	*/
	public String toString() {
		String str = "";
		if (left == null && right == null) {
			return str + value;
		} else if (left == null) {
			return str + value + ", " + right.toString();
		} else if (right == null) {
			return str + value + ", " + left.toString();
		} else {
			return str +value +  ", " + left.toString() + ", " + right.toString();
		}
	}
}