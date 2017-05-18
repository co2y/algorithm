package classic;

/**
 * Created by co2y on 05/04/2017.
 */
public class ConstructOrder {
    public static void main(String[] args) {
        Father s = new Son();
        System.out.print(s.i);
    }
}


class Father {
    static int i;

    static {
        i = 10;
        System.out.println("in father static");
    }

    {
        System.out.print("in father instance");
    }

    Father() {
        System.out.println("in father construct");
    }
}


class Son extends Father {
    static int i;

    static {
        i = 5;
        System.out.println("in son static");
    }

    {
        System.out.print("in son instance");
    }

    Son() {
        System.out.print("in son construct");
    }
}