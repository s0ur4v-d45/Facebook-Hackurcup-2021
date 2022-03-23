import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week7b {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        int alphabets=0,numerals=0,specialCharacters=0;
        for(int i=0;i<string.length();i++)
        {
            char ch = string.charAt(i);
            if((ch>=65 && ch<=90) || (ch>=97 && ch<=122))
            {
                alphabets++;
            }
            else if(ch>=48 && ch<=57)
            {
                numerals++;
            }
            else
            {
                specialCharacters++;
            }
        }

        System.out.println("Alphabets:"+alphabets);
        System.out.println("Numerals:"+numerals);
        System.out.println("Special characters:"+specialCharacters);
    }
}
