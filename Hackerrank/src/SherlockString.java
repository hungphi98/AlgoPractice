import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockString {
    static Map<String,Integer> map = new HashMap<>();
    static ArrayList<Integer> arr = new ArrayList<>();


    static String isValid(String s){
        for (int i =0;i<s.length();i++){
            if (map.get(String.valueOf(s.charAt(i)))== null) map.put(String.valueOf(s.charAt(i)),1);
            else map.put(String.valueOf(s.charAt(i)),map.get(String.valueOf(s.charAt(i)))+1);
        }
        printMap();

        int sum=0;
        for (int e:arr){
            sum+=e;
        }

        if (sum%arr.size()==1 || sum%arr.size()==0 || sum%(arr.size()-1)==1){
            return "YES";
        }
        else return "NO";

        // Complete this function
    }

    static void printMap(){
        for (Map.Entry entry : map.entrySet()){
            arr.add((Integer) entry.getValue());
            //System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
