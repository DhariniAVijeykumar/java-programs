import java.util.*;

class LPS {

    static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    static int[][] lps(String seq) {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];

        for (i = 0; i < n; i++)
            L[i][i] = 1;

        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = max(L[i][j - 1], L[i + 1][j]);
            }
        }

        return L;
    }

    static String getLPS(String seq, int[][] L, int i, int j) {
        if (i > j)
            return "";
        if (i == j)
            return String.valueOf(seq.charAt(i));

        if (seq.charAt(i) == seq.charAt(j))
            return seq.charAt(i) + getLPS(seq, L, i + 1, j - 1) + seq.charAt(j);
        else {
            if (L[i][j - 1] > L[i + 1][j])
                return getLPS(seq, L, i, j - 1);
            else
                return getLPS(seq, L, i + 1, j);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String seq = sc.next();
        int n = seq.length();
        int[][] L = lps(seq);

        System.out.println("The length of the Longest Common Palindromic Subsequence is " + L[0][n - 1]);
        System.out.println("The Longest Common Palindromic Subsequence is: " + getLPS(seq, L, 0, n - 1));
    }
}
