package netease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by co2y on 2017/8/12.
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> al = new ArrayList<Integer>(n);
        for (int i = 0; i < n; ++i) {
            al.add(scanner.nextInt());
        }

        Collections.sort(al);

        LinkedList<Integer> ll = new LinkedList<Integer>();

        int start = 0;

        int end = n - 2;
        ll.add(al.get(n - 1));
        boolean flag = true;
        while (start <= end) {
            if (flag) {
                if (ll.getFirst() >= ll.getLast()) {
                    ll.addFirst(al.get(start));
                    start++;
                    if (start <= end) {
                        if (ll.getLast() <= ll.getFirst())
                            ll.addLast(al.get(end));
                        else ll.addFirst(al.get(end));
                        end--;
                    }
                    flag = false;
                } else {
                    ll.addLast(al.get(start));
                    start++;
                    if (start <= end) {
                        if (ll.getLast() >= ll.getFirst())
                            ll.addLast(al.get(end));
                        else ll.addFirst(al.get(end));
                        end--;
                    }
                    flag = false;
                }
            } else {
                if (ll.getFirst() <= ll.getLast()) {
                    ll.addFirst(al.get(end));
                    end--;
                    if (start <= end) {
                        if (ll.getFirst() <= ll.getLast())
                            ll.addFirst(al.get(start));
                        else ll.addLast(al.get(start));
                        start++;
                    }
                    flag = true;
                } else {
                    ll.addLast(al.get(end));
                    end--;
                    if (start <= end) {
                        if (ll.getFirst() >= ll.getLast())
                            ll.addFirst(al.get(start));
                        else ll.addLast(al.get(start));
                        start++;
                    }
                    flag = true;
                }
            }
        }

        ArrayList<Integer> cls = new ArrayList<Integer>(n);
        for (int num : ll) {
            cls.add(num);
            System.out.println(num);
        }

        int ans = 0;
        int i = 0;
        int j = 1;

        while (j < cls.size()) {
            ans += Math.abs(cls.get(i) - cls.get(j));
            i++;
            j++;
        }
        System.out.println(ans);
    }
}
