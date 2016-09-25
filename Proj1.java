import java.util.*;
import java.io.*;

public class Proj1
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Proj1 a = new Proj1();
		Node dictionaryTree = a.dictTree();
	}
	
	public void PasswordGeneration()
	{
		
	}
	
	public Node dictTree() throws FileNotFoundException
	{
		File dictText = new File("dictionary.txt");
		Scanner fileIn = new Scanner(dictText);
		
		String s = fileIn.nextLine();
		Node firstNode = new Node();
		Node currentNode= firstNode;
		
		//create first/primary tree
		
		for(int i=0; i< s.length();i++)
		{
			currentNode.key = s.charAt(i);
			if(i != s.length()-1)
			{
			currentNode.nextDown = new Node();
			currentNode= currentNode.nextDown;
			} else
			{
				currentNode.wordEnd = true;
			}
		}
		
		// fill in rest of tree with words <= 5 characters in length
		do{
			String t= fileIn.nextLine();
			currentNode = firstNode;
			if(t.length()<=5)// if we should just generate the tree with all dict words remove this
			{
				for(int i=0; i<t.length(); i++)
				{
					if(currentNode == null)
					{
						currentNode = new Node();
						currentNode.key = toLowerCase(t.charAt(i));
						if(i == t.length()-1)
						{
							currentNode.wordEnd = true;
						}
						currentNode= currentNode.nextDown;
					} else 
					{
						if(currentNode.key == t.charAt(i))
						{
							currentNode = currentNode.nextDown;
						} else {
							currentNode = currentNode.nextRight;
						}
					}
				}
			}
		}while(fileIn.hasNextLine());
		
		return firstNode;
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
