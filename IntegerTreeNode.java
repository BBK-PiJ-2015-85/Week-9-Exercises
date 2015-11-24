public class IntegerTreeNode {
	
	private int value;
	private IntegerTreeNode right;
	private IntegerTreeNode left;
	
	public IntegerTreeNode(int value) {
		this.value = value;
		this.right = null;
		this.left = null;
	}
	
	public void add(int newInt) {
		if (newInt > value) {
			if (right == null) {
				right = new IntegerTreeNode(newInt);
			} else {
				right.add(newInt);
			}
		} else {
			if (left == null) {
				left = new IntegerTreeNode(newInt);
			} else {
				left.add(newInt);
			}
		}
	}
	
	public boolean contains(int num) {
		if (value == num) {
			return true;
		} else if (num > value && right != null) {
			return right.contains(num);
		} else if (num < value && left != null) {
			return left.contains(num);
		} 
		return false;
	}
	
	public int getMax() {
		if (right == null) {
			return value;
		} else {
			return right.getMax();
		}
	}
	
	public int getMin() {
		if (left == null) {
			return value;
		} else {
			return left.getMin();
		}
	}
	
	public String toString() {
		String str = "";
		if (left == null && right == null) {
			return str + "[" + value + " L[] R[]]";
		} else if (left == null) {
			return "[" + value + " L[] R" + right.toString() + "]";
		} else if (right == null) {
			return "[" + value + " L" + left.toString() + " R[]]";
		} else {
			return str + "[" + value + " L" + left.toString() + " R" + right.toString() + "]";
		}
	}
}