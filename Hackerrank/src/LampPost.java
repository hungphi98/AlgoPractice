import java.math.BigInteger;
import java.util.*;

public class LampPost {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        BigInteger row = new BigInteger(String.valueOf(userInput.nextInt()));
        BigInteger col = new BigInteger(String.valueOf(userInput.nextInt()));
        int num_racks = userInput.nextInt();
        BigInteger sum =new BigInteger(String.valueOf(0));
        for (int i = 0; i < num_racks; i++){
            int rack_row = userInput.nextInt();
            int start = userInput.nextInt();
            int end = userInput.nextInt();
            sum = sum.add(BigInteger.valueOf(end-start+1)) ;
        }
        BigInteger result = row.multiply(col).subtract(sum);
        System.out.println(result);

    }
}