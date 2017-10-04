import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
import java.io.*;

/*ID: miles.d1
  LANG: JAVA
  TASK: ride
*/

public class ride {
    static HashMap map = new HashMap();
    public static void main(String arg[]) throws IOException {
        int count=0;
        int product1 =1;
        int product2=1;
        for (char ch = 'A';ch <= 'Z';++ch){
            count++;
            map.put(ch,count);
        }

       // printMap(map);

        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster

        // Get line, break into tokens
        String i1 = f.readLine();
        for (char c : i1.toCharArray()){
            product1 *=(int) map.get(c);
        }// first integer
        String i2 = f.readLine();
        for (char c : i2.toCharArray()){
            product2 *=(int) map.get(c);
        }// second integer
        if (product1 %47==product2%47){
            out.println("GO");
        }else{
            out.println("STAY");
        }
                                  // output result
        out.close();
        System.exit(0);// close the output file
        //System.out.println(product);

    }
    public static void printMap(Map<Character, Integer> map)
    {
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + ": "+ entry.getValue());
        }
    }
}
