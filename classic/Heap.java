package classic;

import java.util.PriorityQueue;

/**
 * Created by co2y on 31/03/2017.
 */
public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(4);
        System.out.print(pq.poll());
        System.out.print(pq.poll());
    }
}
