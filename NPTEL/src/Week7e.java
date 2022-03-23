import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week7e {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        if(string.length()==0)
        {
            System.out.println("empty string was given in input");
        }
        else
        {
            System.out.println(string.charAt(0));
        }
    }
}
