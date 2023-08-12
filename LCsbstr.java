import java.util.*;
public class LCsbstr
{
public static String LC(String s1, String s2)
{
int[][] l = new int[s1.length() + 1][s2.length() + 1];
int maxLength = 0;
int endIndex = 0;
for (int i = 1; i <= s1.length(); i++)
{
for (int j = 1; j <= s2.length(); j++)
{
if (s1.charAt(i - 1) == s2.charAt(j - 1))
{
l[i][j] = l[i - 1][j - 1] + 1;
if (l[i][j] > maxLength)
{
maxLength = l[i][j];
endIndex = i;
}
}
else
{
l[i][j] = 0;
}
}
}
return s1.substring(endIndex - maxLength, endIndex);
}
public static void main(String[] args)
{
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the first string: ");
String s1 = scanner.nextLine();
System.out.print("Enter the second string: ");
String s2 = scanner.nextLine();
String lc = LC(s1, s2);
System.out.println("The longest common substring is: " + lc);
}
}

