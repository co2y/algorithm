package classic;

/**
 * Created by co2y on 05/04/2017.
 */
public class ReverseLink {
    static class Node {
        int val;
        Node next;
    }

    public static void main(String[] args) {
        Node head = new Node();
        Node c = null;
        Node b = head;
        Node a = null;

        while (b != null) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        // return a
    }
}


