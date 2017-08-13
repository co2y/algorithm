package netease;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by co2y on 2017/8/12.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for (int i = 1; i <= n; ++i) {
            if ((i & 1) == 1) ll.addFirst(scanner.nextInt());
            else ll.addLast(scanner.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        for (int num : ll) {
            sb.append(num);
            sb.append(" ");
        }
        String ans;
        if ((n & 1) == 1) ans = sb.toString();
        else
            ans = sb.reverse().toString();

        System.out.println(ans.trim());

    }
}
