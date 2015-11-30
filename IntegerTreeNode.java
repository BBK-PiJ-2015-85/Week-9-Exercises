public class IntegerTreeNode implements IntBinTree {
	
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
	
	public String toSimpleString() {
		String str = "";
		if (left == null && right == null) {
			return str + "[" + value + "]";
		} else if (left == null) {
			return "[" + value + " " + right.toSimpleString() + "]";
		} else if (right == null) {
			return "[" + value + " " + left.toSimpleString() + "]";
		} else {
			return str + "[" + value + " " + left.toSimpleString() + " " + right.toSimpleString() + "]";
		}
	}
	
	public int depth() {
		if (right == null) {
			if (left == null) {
				return 0;
			} else {
				return 1 + left.depth();
			}		
		} else if (left == null) {
			return 1 + right.depth();
		} else {
			if (right.depth() > left.depth()) {
				return 1 + right.depth();
			} else {
				return 1 + left.depth();
			}
		}		
	}
	
	public void delete(int toDelete) {
		if (value == toDelete) {
			deleteFirstElement();
		} else {
			if (left != null && left.value == toDelete) {
				//have found the element to delete, now we need to find the element to replace it with.
				if (left.left == null && left.right == null) {
					//element to delete is a leaf so will set left to null
					left = null;
					return;
					
				} else if (left.left == null) {
					left.value = left.right.getMin();
					if (left.right.left == null && left.right.right == null) {
						left.right = null;
						return;
					} else {
						left.right.delete(left.value);
						return;
					} 					
				} else {
					left.value = left.left.getMax();
					if (left.left.left == null && left.left.right == null) {
						left.left = null;
						return;
					} else {
						left.left.delete(left.value);
						return;
					}					
				}
			} else if (right != null && right.value == toDelete) {
				//have found the element to delete, now we need to find the element to replace it with.
				if (right.left == null && right.right == null) {
					//element to delete is a leaf so will set left to null
					right = null;
					return;
					
				} else if (right.left == null) {
					right.value = right.right.getMin();
					if (right.right.left == null && right.right.right == null) {
						right.right = null;
						return;
					} else {
						right.right.delete(right.value);
						return;
					}					
				} else {
					right.value = right.left.getMax();
					if (right.left.left == null && right.left.right == null) {
						right.left = null;
						return;
					} else {
						right.left.delete(right.value);
						return;
					}					
				}
			} else if (toDelete > value && right != null) {
				right.delete(toDelete);
			} else if (toDelete < value && left != null) {
				left.delete(toDelete);
			} else {
				System.out.println("Element to delete not found");
				return;
			}
		}
	} 
		
	public void deleteFirstElement() {
		if (left != null) {
			value = left.getMax();
			if (left.left == null && left.right == null) {
				left = null;
				return;
			} else {
				left.delete(value);
			}
			
		} else if (right != null) {
			value = right.getMin();
			if (right.left == null && right.right == null) {
				right = null;
				return;
			} else {
				right.delete(value);
			}
			
		} else {
			System.out.println("You want to delete the only element in the list. Please delete list altogether.");
		}
	}
}