import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bracket {
    static char[] open = {'{','[','('};
    static char[] close = {'}',']',')'};
    public static boolean isBalanced(String e) {
        Stack<Character> s = new Stack<>();
        char[] br = e.toCharArray();
        if (br.length%2==1) return false;
        else{
            for (char c: br){
                if (c=='{') s.push('}');
                else if (c=='[') s.push(']');
                else if (c=='(') s.push(')');
                else{
                    if (s.empty() || c != s.peek()) return false;
                    s.pop();
                }
            }
            return s.empty();
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
