import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tranducer {

    static int forward(int num_tranducer,int[] x,int current,int count,int coverage){
        if (count>=x[x.length-1]){
            return num_tranducer;
        }else{
            count = x[current]+ 2*coverage;
            for (int i=current;i<x.length;i++){
                if (x[i]>=count){
                    current = i;
                    break;
                }
            }
            num_tranducer++;
            return forward(num_tranducer,x,current,count,coverage);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
            int current = x_i;
            if (current>0){
                while (current>0 && x[current]<x[current-1]){
                    int temp = x[current];
                    x[current]=x[current-1];
                    x[current-1]=temp;
                    current--;
                }
            }
        }
//        for (int i=0;i<x.length;i++) {
//            System.out.println(x[i]);
//        }
        System.out.println(forward(0,x,0,0,k));
    }
}
