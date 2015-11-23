public class IntegerTreeScript {
	public static void main(String[] args) {
		IntegerTreeNode root = new IntegerTreeNode(15);
		root.add(10);
		root.add(20);
		root.add(25);
		root.add(5);
		root.add(7);
		root.add(99);
		root.add(12);
		
		System.out.println(root.contains(99));
		System.out.println(root.contains(23));
		//System.out.println(root.getMax());
		//System.out.println(root.getMin());
	}
}