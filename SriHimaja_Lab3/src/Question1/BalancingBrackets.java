package Question1;

import java.util.Stack;
import java.util.Scanner;

public class BalancingBrackets 
{
	static boolean isBracketsBalanced(String brackets)
	{
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i < brackets.length(); i++)
		{
			char character = brackets.charAt(i);
			
			if(character == '(' || character == '[' || character == '{')
			{
				stack.push(character);
				continue;
			}
			if(stack.isEmpty())
				return false;
			
			char c;
			
			switch(character)
			{
				case '}' : c = stack.pop();
						   if(c == ')' || c == ']')
						   {
							   return false;
						   }
						   break;
				case ')' : c = stack.pop();
				   		   if(c == '}' || c == ']')
				   		   {
				   			return false;
				   		   }
				   		   break;
				case ']' : c = stack.pop();
							if(c == '}' || c == ')')
							{
								return false;
							}
						break;	
			}	
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args)
	{
		System.out.println("Enter any string with brackets");
		Scanner sc = new Scanner(System.in);
		
		String brackets = sc.next();
		Boolean result;
		
		result = isBracketsBalanced(brackets);
		if(result)
			System.out.println("The entered string has balanced brackets");
		else
			System.out.println("The entered string doesnt have balanced brackets");
		
		sc.close();
		
	}
}
