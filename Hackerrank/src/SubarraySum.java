/**
 * Created by Phi on 10/5/17.
 */
import java.util.Scanner;
public class SubarraySum {
    static int[] result = new int[2];
    public static int[] subarray(int sum, int diff, int[] arr, int i, int start, int end)
    {
        if (i==arr.length) return new int[]{-1};
        else if (diff==0)
        {
            end =i-1;
            return new int[]{start+1, end+1};
        }
        else if (diff<0)
        {
            start++;
            return subarray(sum,sum,arr,start,start,end);
        }
        else
        {
            diff-=arr[i];
            i++;
            return subarray(sum,diff,arr,i,start,end);
        }
    }
    public static void main(String[] arg)
    {
        Scanner userInput = new Scanner(System.in);
        int n = userInput.nextInt();
        int j = 0;
        while (j<n){
            int k = userInput.nextInt();
            int[] arr = new int[k];
            int sum = userInput.nextInt();
            for (int i=0;i<k;i++)
            {
                arr[i]=userInput.nextInt();
            }
            result = subarray(sum,sum,arr,0,0,arr.length-1);
            System.out.println(result[0] + " "+ result[1]);
            j++;
        }

    }
}


