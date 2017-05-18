package classic;

import java.util.BitSet;

/**
 * Created by co2y on 15/04/2017.
 */
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bs = new BitSet();
        bs.set(1);
        bs.set(3);
        bs.set(100);
        bs.get(200);
        System.out.print(bs.size());
    }
}
