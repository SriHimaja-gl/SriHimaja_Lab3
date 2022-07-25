package Question2;

import java.util.*;


public class MaxSum 
{
	static class Node
	{
		int nodeData;
		Node leftNode,rightNode;
	}
	static Node newNode (int nodeData)
	{
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;		
		
		return temp;
	}
	public Node insert(Node root,int key)
	{
		if(root == null)
			return newNode(key);
		if(key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode , key);
		
		return root;
	}
	public boolean findSum(Node root, int sum, HashSet<Integer> set)
	{
		if(root == null)
			return false;
		
		if(findSum(root.leftNode, sum, set))
			return true;
		
		if(set.contains(sum - root.nodeData))
		{
			System.out.println("Pair is found ("+(sum-root.nodeData)+"," + root.nodeData+")");
			return true;
			
		}
		else
			set.add(root.nodeData);
		return findSum(root.rightNode, sum, set);
	}
	public void findPairWithGivenSum(Node root, int sum)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		if(!findSum(root,sum,set))
		{
			System.out.println("Pair doesnt exist");
		}
	}
	public static void main(String[] args)
	{
		Node root =null;
		MaxSum ms = new MaxSum();
		root = ms.insert(root, 40);
		root = ms.insert(root, 20);
		root = ms.insert(root, 60);
		root = ms.insert(root, 10);
		root = ms.insert(root, 30);
		root = ms.insert(root, 50);
		root = ms.insert(root, 70);
		
		System.out.println("Enter the sum you want to find");
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		
		ms.findPairWithGivenSum(root, sum);
		
		sc.close();
	}
}
