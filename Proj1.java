

public class Proj1{

	public static void main(String[] args)
	{
		Proj1 a = new Proj1();
		a.dictTree();
	}
	
	public void dictTree(){
		
		String s = "Tests";
		Node firstNode = new Node();
		Node currentNode= firstNode;
		
		//create first/primary tree
		
		for(int i=0; i< s.length();i++)
		{
			currentNode.key = s.charAt(i);
			currentNode.nextDown = new Node();
			System.out.println(currentNode.key);
			currentNode= currentNode.nextDown;
		}
		
		int charNumber;
		//while(fileReader != eof)
			
			charNumber =0;
			while(currentNode.nextRight !=null || currentNode.key != s.charAt(letterCount))
			{
				currentNode = currentNode.nextRight;
			}
			
			if(currentNode.nextRight == null)
			{
				currentNode.nextRight = new Node();
				currentNode.nextRight.key = s.charAt(letterCount);
			} else {
				if(currentNode.nextDown != null){
					currentNode= currentNode.nextDown;
				} else {
					currentNode.nextDown = new Node();
					currentNode.nextDown.key = s.charAt(letterCount);
				}
			}
		
	}
	
	private class Node
	{
		char key;
		boolean wordEnd;
		Node nextRight;
		Node nextDown;
		
		public Node()
		{
			boolean wordEnd =false;
			Node nextRight = null;
			Node nextDown = null;
		}
	}
}