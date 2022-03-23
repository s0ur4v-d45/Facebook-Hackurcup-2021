import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Week1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String num1 = br.readLine();
        String num2 = br.readLine();

        int i=0;
        while(i<num1.length() && num1.charAt(i)=='0')
        {
            i++;
        }
        num1 = (i==num1.length()) ? "":num1.substring(i);


        i=0;
        while(i<num2.length() && num2.charAt(i)=='0')
        {
            i++;
        }
        num2 =( i==num2.length()) ? "":num2.substring(i);



        System.out.println("added: " + addition(num1,num2));
        System.out.println("sustracted: " + substraction(num1,num2));
        System.out.println("multiplied:" + multiplication(num1,num2));
        System.out.println("divided:" + division(num1,num2));
    }

    private static String division(String num1, String num2) {
//        if(isSmaller(num1,num2))
//        {
//            return "quotient:0, remainder:"+num1;
//        }
//        if(num2.equals(""))
//        {
//            return "cannot divide by zero";
//        }
//        String dividend="";
//        int i=0;
//        String quotient="";
//        while(i<num1.length())
//        {
//            dividend += num1.charAt(i);
//            if(isSmaller(num2,num1))
//            {
//
//            }
//            quotient+="0";
//            i++;
//
//        }
//       return "0";

        int divisor = Integer.parseInt(num2);
        StringBuilder result=new StringBuilder();

        char[] dividend = num1.toCharArray();
        int carry=0;

        for(int i=0;i<dividend.length;i++)
        {
            int x= carry*10 + Character.getNumericValue(dividend[i]);
            result.append(x/divisor);
            carry = x % divisor;
        }

        for(int i=0;i<result.length();i++)
        {
            if(result.charAt(i) != '0')
            {
                return result.substring(i);
            }
        }
        return "";
    }

    private static String multiplication(String num1, String num2) {

        String t="";
        String value = multiplyHelper(num1,num2.charAt(num2.length()-1));
        for(int i=num2.length()-2;i>=0;i--)
        {
            String temp = multiplyHelper(num1,num2.charAt(i));
            t +="0";
            temp=temp+t;
            value = addition(value,temp);


        }
        return value;
    }

    private static String multiplyHelper(String num1, char charAt) {
        int carry=0;
        int m = Character.getNumericValue(charAt);
        int i=num1.length()-1;
        String result = "";
        int value=0;
        while(i>-1)
        {
            int digit = Character.getNumericValue(num1.charAt(i));
            value = (digit*m) + carry;
            result= "" + value%10 + ""+ result;
            value /=10;
            if(value>0)
            {
                carry=value;
            }
            else
            {
                carry=0;
            }
            i--;
        }
        if(carry!=0)
        {
            result = "" + carry + result;
        }

    return result;
    }

    private static String substraction(String num1, String num2) {
        if(num1=="") return num2;
        if(num2=="") return num1;

        String result="";

        if(isSmaller(num1,num2))
        {
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        int i=num1.length()-1,j=num2.length()-1;
        boolean flag=false;
        while(j>-1)
        {
            int digit1 = Character.getNumericValue(num1.charAt(i));
            int digit2 = Character.getNumericValue(num2.charAt(j));
            int value=0;

            if(flag==true)
            {
                digit1-=1;
            }

            if(digit1<digit2)
            {
                flag=true;
                value = (digit1+10) - digit2;
            }
            else
            {
                flag=false;
                value = digit1 - digit2;
            }
            result = "" + value +""+ result;

          i--;j--;
        }
        while(i>-1)
        {
            int digit1 = Character.getNumericValue(num1.charAt(i));
            if(flag==true) {
                digit1 -= 1;
            }
            result = "" + digit1 +""+ result;
            flag=false;
            i--;
        }
        return result;

    }

    private static boolean isSmaller(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 < n2)
            return true;
        if (n2 < n1)
            return false;
        for (int i = 0; i < n1; i++) {
            if (s1.charAt(i) < s2.charAt(i))
                return true;
            else if (s1.charAt(i) > s2.charAt(i))
                return false;

        }
        return false;
    }

    private static String addition(String num1, String num2) {
        if(num1=="") return num2;

        if(num2=="") return num1;

        String result="";
        int i=num1.length()-1,j=num2.length()-1;
        int carry=0;
        while(i>-1 && j>-1)
        {
            int digit1 = Character.getNumericValue(num1.charAt(i));
            int digit2 = Character.getNumericValue(num2.charAt(j));

            int value = digit1 + digit2 + carry;
            result = "" + value%10 + "" +  result;
            value/=10;
            if(value>0)
            {
                carry = value;
            }
            else
            {
                carry=0;
            }
            i--;j--;
        }
        while(i>-1)
        {
            int digit1 = Character.getNumericValue(num1.charAt(i));
            int value = digit1 + carry;
            result = "" + value%10 +""+ result;
            value/=10;
            if(value>0)
            {
                carry = value;
            }
            else
            {
                carry=0;
            }
            i--;

        }
        while(j>-1)
        {
            int digit1 = Character.getNumericValue(num1.charAt(j));
            int value = digit1 + carry;
            result = "" + value%10 + "" +result;
            value/=10;
            if(value>0)
            {
                carry = value;
            }
            else
            {
                carry=0;
            }
            j--;

        }
        if(carry!=0)
        {
            result="" + carry +""+result;
        }
        return result;
    }

}
