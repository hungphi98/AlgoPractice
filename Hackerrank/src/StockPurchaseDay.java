import java.io.*;
import java.util.*;
import java.util.Arrays.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockPurchaseDay {

    static int stockPurchaseDay(Map<Integer,Integer> map,int x) {
        if (map.containsKey(x)){
            return map.get(x)+1;
        }else return -1;

        // Complete this function

    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
            if (map.get(A[A_i])==null) map.put(A[A_i],A_i);
            else map.replace(A[A_i],A_i);
        }

        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int xi = in.nextInt();
            int result = stockPurchaseDay(map,xi);
            System.out.println(result);
        }
        in.close();
    }
}
