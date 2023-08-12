import java.util.*;
class LCsbsq
{
public static String lcsq(String s1, String s2, int m, int n)
{
int[][] l = new int[m + 1][n + 1];
{
for (int i = 0; i <= m; i++)
{
for (int j = 0; j <= n; j++)
{
if (i == 0 || j == 0)
l[i][j] = 0;
else if (s1.charAt(i - 1) == s2.charAt(j - 1))
l[i][j] = l[i - 1][j - 1] + 1;
else
l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
}
}
int index = l[m][n];
int temp = index;
char[] lc = new char[index + 1];
lc[index] = '\0';
int i = m, j = n;
String lcs ="";
while (i > 0 && j > 0)
{
if (s1.charAt(i - 1) == s2.charAt(j - 1))
{
lc[index - 1] = s1.charAt(i - 1);
i--;
j--;
index--;
}
else if (l[i - 1][j] > l[i][j - 1])
i--;
else
j--;
}
for (int k = 0; k <= temp; k++)
lcs = lcs + lc[k];
return lcs;
}
}
public static void main(String[] args)
{
String s1, s2, LCS;
Scanner sc= new Scanner(System.in);
System.out.print("Enter first sequence: ");
s1 = sc.nextLine();
System.out.print("Enter second sequence: ");
s2 = sc.nextLine();
int m = s1.length();
int n = s2.length();
LCS = lcsq(s1, s2, m, n);
System.out.print("Sequence1: " + s1 + "\nSequence2: " + s2);
System.out.println("\nLCS: "+LCS);
}
}
