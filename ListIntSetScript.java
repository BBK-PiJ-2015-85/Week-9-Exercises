public class ListIntSetScript {
	public static void main(String[] args) {
		ListIntSet head = new ListIntSet(1);
		
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(5);
		head.add(5);
		head.add(6);
		head.add(7);
		head.add(8);
		head.add(9);
		System.out.println(head.contains(5));
		System.out.println(head.containsVerbose(9));
		System.out.println(head.toString());
		
		
	}	
}