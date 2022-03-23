import java.util.*;
public class Infy1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.next();

        System.out.println(minRotation(s.length(),s));

    }
    static int minRotation(int N,String S)
    {
        int pointer=0;
        int rot = 0;
        for(int i=0;i<S.length();i++)
        {
            int num = Character.getNumericValue(S.charAt(i));
            rot += Math.min(Math.abs(pointer-num),pointer+(9-num)+1);
            pointer=num;
        }
        return rot;
    }

    static int minOperations(int N,int M,List<List<Integer>> A)
    {
        int ope = 0;
        if(A.get(0).size()<2)
        {
            return ope;
        }
        for(int i=0;i<A.size();i++)
        {
            for(int j=1;j<A.get(i).size();j++)
            {
                if(A.get(i).get(j-1)!=A.get(i).get(j))
                {
                    A.get(i).set(j,A.get(i).get(j)^1);
                    ope++;
                }
            }
        }
        return ope;
    }

}

