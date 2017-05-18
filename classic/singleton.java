package classic;

/**
 * Created by co2y on 02/03/2017.
 */
public enum singleton {
    INSTANCE(1);

    private int id;
    singleton (int num) {
        id = num;
    }

    public void say() {
        System.out.print(123);
    }

    public static void main(String args[]) {
        singleton s = singleton.INSTANCE;
        s.say();
        System.out.print(singleton.INSTANCE.equals(s));
    }
}



