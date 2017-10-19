import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CostBalancing {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i =1;i<m+1;i++){
            map.put(i,0);
        }
        int sum=0;
        for(int a0 = 0; a0 < n; a0++){
            int id_number = in.nextInt();
            int amount = in.nextInt();
            sum+=amount;
           map.replace(id_number,map.get(id_number)+amount);

        }
        in.close();
        int average = Math.round(sum/m);
        int comp= sum-average*m;
        map.replace(1,map.get(1)-comp);
        for (int i=1;i<m+1;i++){
            map.replace(i,map.get(i)-average);
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

    }
}
