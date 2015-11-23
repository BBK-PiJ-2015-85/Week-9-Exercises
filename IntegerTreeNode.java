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
		if (this.value == num) {
			return true;
		} else if (num > this.value && this.right != null) {
			return this.right.contains(num);
		} else if (num < this.value && this.left != null) {
			return this.left.contains(num);
		} else {
			return false;
		}
	}
	
}