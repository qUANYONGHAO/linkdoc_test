package test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> result = new ArrayList<Integer>();
        int carry = 0;
        int digit = 1;
        int temp = 1;
        int i,j;
        result.add(1);
        for(i = 2;i<=n;i++){
            for(j = 0,carry = 0;j<digit;j++){
                temp = result.get(j)*i+carry;
                result.set(j, temp%10000);
                carry  = temp/10000;
            }
            
            while(carry != 0){
                result.add(digit++, carry%10000);
                carry/=10000;
            }
        }
        int count = 1;
        System.out.print(result.get(digit-1));
        for(i = digit-1;i>=1;i--){
            count++;
            if(result.get(i-1)<10){
                System.out.print("000");
            }else if(result.get(i-1)<100){
                System.out.print("00");
            }else if(result.get(i-1)<1000){
                System.out.print("0");
            }
            System.out.print(result.get(i-1));
            
        }
    }
}