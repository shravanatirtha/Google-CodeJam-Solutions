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
            for (int i = 1; i < list.length; i++)
                list[i] = sc.nextInt();
            // System.out.println(Arrays.toString(list) + " " + N);
            System.out.println("Case #" + ind + ": " + reversort(list, N, 1, N, 0));

        }
        sc.close();
    }

    static int reversort(int[] list, int n, int i, int j, int cost) {
        if (i == n)
            return cost;
        else {
            j = minimumPosition(list, i, j);
            System.out.println(Arrays.toString(list));
            cost += j - i + 1;
            System.out.println("cost " + cost);
            if (i == j) {
                j = n;
                return reversort(list, n, i + 1, j, cost);
            }
            reverse(list, i, j);
            return reversort(list, n, i + 1, j, cost);
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
        int limit = j / 2;
        while (j > limit) {
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            j--;
            i++;
        }
    }
}
