/**
 * Created by Phi on 10/5/17.
 */

import org.apache.commons.lang3.*;

import java.util.Scanner;
public class Parenthesis{
    static int parent(String arr,int left,int right)
    {

        if (left==right) return 0;
        else{
            if (StringUtils.countMatches(arr.substring(left,right+1),"(") != StringUtils.countMatches(arr.substring(left,right+1),")")){
                if (moveRight(arr,left,right)) return right-left;
                else if (moveLeft(arr,left,right)) return right - left;
                else{
                    while (arr.charAt(left)!='(') left++ ;
                    while (arr.charAt(right)!= ')') right--;
                    return parent(arr,left,right);
                }
            }else{
                return right-left;
            }
        }
    }
    static boolean moveRight(String str,int left,int right){
        while (str.charAt(left)!='(') left++;
        if (StringUtils.countMatches(str.substring(left,right+1),"(") != StringUtils.countMatches(str.substring(left,right+1),")")) return false;
        else return true;
    }
    static boolean moveLeft(String str,int left,int right){
        while (str.charAt(right)!='(') right--;
        if (StringUtils.countMatches(str.substring(left,right+1),"(") != StringUtils.countMatches(str.substring(left,right+1),")")) return false;
        else return true;
    }

    public static void main(String[] arg)
    {

        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int j = 0;
        while (j<k)
        {
            String str = in.next();
            int result = parent(str,0,str.length()-1);
            System.out.println(result);
            j++;
        }
    }

}


