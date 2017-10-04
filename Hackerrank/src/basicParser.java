/**
 * Created by Phi on 9/29/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class basicParser {

    static int solve(String opr) {
        char[] str = opr.toCharArray();
        int result =0;
        if (str[1]=='+'){
            result = Integer.parseInt(String.valueOf(str[0]))+Integer.parseInt(String.valueOf(str[2]));
        }else if (str[1]=='-') result = Integer.parseInt(String.valueOf(str[2]));
        return result;

        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String opr = in.next();
        int result = solve(opr);
        System.out.println(result);
        in.close();
    }
}
