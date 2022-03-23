import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week7a {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int count=0;
        for(int i=0;i<string.length();i++)
        {
           if(string.charAt(i)!=' ')
           {
               count++;
           }
        }
        System.out.println(count);
    }
}
