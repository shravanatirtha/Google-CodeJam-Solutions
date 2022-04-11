import java.util.*;

/* 
Sample input

3
4
4 2 1 3
2
1 2
7
7 6 5 4 3 2 1

Sample output

Case #1: 6
Case #2: 1
Case #3: 12
*/
public class Reversort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int ind = 1; ind <= T; ind++) {
            int N = sc.nextInt();
            int[] list = new int[N + 1];
            list[0] = 0;
            for (int i = 1; i < N+1; i++)
                list[i] = sc.nextInt();
            // System.out.println(Arrays.toString(list) + " " + N);
            System.out.println("Case #" + ind + ": " + reversort(list, 1, N));

        }
        sc.close();
    }

    static int reversort(int[] list,int i, int n) {
        if (i == n)
            return 0;
        else {
            int j = minimumPosition(list, i, n);
            // System.out.println(Arrays.toString(list));
            int cost = j - i + 1;
            // System.out.println("cost " + cost);
            reverse(list, i, j);
            return reversort(list, i + 1, n) + cost;

        }

    }

    static int minimumPosition(int[] list, int i, int j) {
        int min = Integer.MAX_VALUE;
        int pos = 0;
        while (i <= j) {
            if (list[i] < min) {
                min = list[i];
                pos = i;
            }
            i++;
        }
        return pos;
    }

    static void reverse(int[] list, int i, int j) {
        while (i < j) {
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            j--;
            i++;
        }
    }
}
