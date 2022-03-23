import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week7c {
    public static void main(String[] args) throws IOException {
        System.out.println("enter a string:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        System.out.println("enter a character on the basis you want to split the string:");
        String character = br.readLine();

        String[] result=string.split(character);

        for(String str:result)
        {
            System.out.println(str);
        }
    }
}
