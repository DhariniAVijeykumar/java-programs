import java.util.*;
import java.lang.*;
import java.io.*;

class binStr
{
	public static void print(char str[], int index)
	{
		if (index == str.length)
		{
			System.out.println(str);
			return;
		}

		if (str[index] == '?')
		{
			// replace '?' by '0' and recurse
			str[index] = '0';
			print(str, index + 1);
			
			// replace '?' by '1' and recurse
			str[index] = '1';
			print(str, index + 1);
			
			// NOTE: Need to backtrack as string
			// is passed by reference to the
			// function
			str[index] = '?';
		}
		else
			print(str, index + 1);
	}

	// driver code
	public static void main (String[] args)
	{
		Scanner n = new Scanner(System.in);
            System.out.println("Enter a string with wildcard characters:");
            String input = n.next();
		char[] str = input.toCharArray();
		print(str, 0);
	}
}


