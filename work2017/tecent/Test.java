package tecent;

/**
 * Created by co2y on 22/03/2017.
 */
public class Test {
    public int bsearch(int iKey, int[] base, int nmemb) {
        int left = 0;
        int right = nmemb - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (base[mid] == iKey) return mid;
            else if (base[mid] > iKey) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
