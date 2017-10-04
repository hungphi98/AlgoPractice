/**
 * Created by Phi on 10/4/17.
 */
import java.util.*;
public class CastleTower {
    static int castleTowers(int n, Integer[] ar) {

        //Arrays.sort(ar, Collections.reverseOrder());
        int maxi = ar[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (maxi > ar[i]) {
                maxi = ar[i];
            }
        }
        for (int i =0;i<n;i++){
            if (maxi==ar[i]) cnt++;
            else break;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] ar = new Integer[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = castleTowers(n, ar);
        System.out.println(result);
        in.close();
    }
}

