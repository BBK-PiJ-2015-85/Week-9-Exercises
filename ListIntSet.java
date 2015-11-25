public class ListIntSet implements IntSet {
	private int value;
	private ListIntSet next;
	private ListIntSet previous;
	
	public ListIntSet(int value) {
		this.value = value;
		next = null;
		previous = null;
	}
	/**
	*adds a new int to the set; if it is there already, nothing happens.
	*/	
	public void add(int newInt) {
		if (value == newInt) {
			System.out.println("Value already in set.");
			return;
		}
		if (next == null) {
			ListIntSet newElement = new ListIntSet(newInt);
			next = newElement;
			newElement.previous = this;
		} else {
			next.add(newInt);
		}
	}
		
	/**
	* returns true if the number is in the set, false otherwise.
	*/
	public boolean contains(int num) {
		if (value == num) {
			return true;
		} else if (next != null) {
			return next.contains(num);
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
		} else if (next != null) {
			return next.containsVerbose(num);
		} 
		return false;
	}
	
	/**
	*returns a string with the values of the elements in the set separated by commas.
	*/
	public String toString() {
		String str = "";
		if (next == null) {
			return str + value;
		} else {
			return str + value + ", " + next.toString();
		}
	}	
}