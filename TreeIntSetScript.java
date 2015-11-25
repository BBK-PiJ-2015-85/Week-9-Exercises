public class TreeIntSetScript {
	public static void main(String[] args) {
		TreeIntSet mySet = new TreeIntSet(10);
		mySet.add(5);
		mySet.add(3);
		mySet.add(7);
		mySet.add(16);
		mySet.add(13);
		mySet.add(15);				
		System.out.println(mySet.toString());		
		mySet.add(13);
		mySet.add(15);
		System.out.println(mySet.toString());
		System.out.println(mySet.containsVerbose(15));
	}
}