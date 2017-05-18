package classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by co2y on 19/04/2017.
 */
public class LambdaPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);

        Integer[] nums = new Integer[]{1, 3, 4, 3, 5, 2, 3, 6};
        list = Arrays.asList(nums);

        Integer[] nums2 = new Integer[list.size()];
        list.toArray(nums2);

        Arrays.stream(nums2).forEach(System.out::print);

        for (int xx : nums2) System.out.print(xx);

        list.sort((a, b) -> b - a);
        list.forEach(System.out::print);

        List<String> l2 = list.stream().map(String::valueOf).collect(Collectors.toList());
        l2.forEach(System.out::print);

        String s = l2.stream().collect(Collectors.joining("|"));
        System.out.print(s);
    }
}
