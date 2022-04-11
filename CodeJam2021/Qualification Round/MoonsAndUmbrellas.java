import java.util.*;

public class MoonsAndUmbrellas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int ind = 1; ind <= T; ind++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.nextLine();
            int n = s.length();
            if (n == 1)
                System.out.println("Case #" + ind + ": 0");
            else
                System.out.println("Case #" + ind + ": " + totalCost(s, 1, 0, n, x, y));
        }
        sc.close();
    }

    static int totalCost(String s, int current, int prev, int n, int x, int y) {
        String t = "";
        char p = s.charAt(prev);
        char c = s.charAt(current);
        t += p;
        t += c;
        if (current == n - 1) {
            if (t.equals("CJ"))
                return x;
            else if (t.equals("JC"))
                return y;
            else
                return 0;
        } else if (c != '?' && p != '?') {
            int cost = 0;
            if (t.equals("CJ"))
                cost = x;
            else if (t.equals("JC"))
                cost = y;
            return totalCost(s, current + 1, current, n, x, y) + cost;
        } else if (c != '?' || p != '?') {
            if (p == '?')
                return totalCost(s, current + 1, current, n, x, y);
            if (c == '?')
                return totalCost(s, current + 1, prev, n, x, y);
        }
        return 0;
    }
}
