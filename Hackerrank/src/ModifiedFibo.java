/**
 * Created by Phi on 9/27/17.
 */
import java.math.BigInteger;
import java.util.*;
public class ModifiedFibo {
    public static BigInteger fibonacci(BigInteger first, BigInteger second, int num, int count){
        if (count==num) return second;
        else{
            BigInteger num1 = new BigInteger(String.valueOf(first));
            BigInteger num2 = new BigInteger(String.valueOf(second));
            BigInteger num3 = num1.add(num2.multiply(num2));

            num1=num2;
            num2=num3;
            count++;
            return fibonacci(num1,num2,num,count);
        }
    }
    public static void main(String[] arg){
        Scanner userInput = new Scanner(System.in);
        int num1 = userInput.nextInt();
        int num2 = userInput.nextInt();
        int num = userInput.nextInt();
        BigInteger first = new BigInteger(String.valueOf(num1));
        BigInteger second = new BigInteger(String.valueOf(num2));
        System.out.println(fibonacci(first,second,num,2));
    }
}
