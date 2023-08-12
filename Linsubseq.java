import java.util.*;

class Linsubseq {
    static int lis(int arr[], int n, ArrayList<Integer> subsequence) {
        int lis[] = new int[n];
        int prev[] = new int[n];
        int maxLength = 0;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            prev[i] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
            }
            if (lis[i] > maxLength) {
                maxLength = lis[i];
                lastIndex = i;
            }
        }

        while (lastIndex != -1) {
            subsequence.add(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        return maxLength;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int arr[] = new int[size];
        for (int k = 0; k < size; k++) {
            arr[k] = sc.nextInt();
        }

        ArrayList<Integer> longestIncreasingSubsequence = new ArrayList<>();
        int n = arr.length;
        int lengthOfLIS = lis(arr, n, longestIncreasingSubsequence);

        System.out.println("Longest Increasing Subsequence: " + longestIncreasingSubsequence);
        System.out.println("Length of LIS: " + lengthOfLIS);
    }
}
