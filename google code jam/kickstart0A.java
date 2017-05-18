import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by co2y on 19/02/2017.
 */
public class kickstart0A {

    private static HashSet<Character> lhs = new HashSet<>();
    private static String leader;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            lhs.clear();
            int N = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < N; ++j) {
                String name = sc.nextLine();
                getLeader(name);
            }
            System.out.println("Case #" + i + ": " + leader);
        }
    }

    private static void getLeader(String name) {
        HashSet<Character> hs = new HashSet<>();
        for (char ch : name.toCharArray()) {
            if (ch == ' ') continue;
            if (hs.contains(ch)) continue;
            hs.add(ch);
        }

        if (hs.size() > lhs.size()) {
            leader = name;
            lhs = hs;
        }

        if (hs.size() == lhs.size() && name.compareTo(leader) < 0) {
            leader = name;
            lhs = hs;
        }
    }
}
