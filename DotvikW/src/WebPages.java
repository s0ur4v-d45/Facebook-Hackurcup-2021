import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WebPages {
    public static void main(String[] args) throws IOException {
        BufferedReader souravReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> souravList = new ArrayList<>();

        int N = Integer.parseInt(souravReader.readLine());

        for(int i=0;i<=N;i++)
        {
            souravList.add(new ArrayList<>());
        }
        for(int i=1;i<=N;i++)
        {
            String[] souravEdges = souravReader.readLine().trim().split("\\s+");
            for(int j=0;j< souravEdges.length;j++)
            {
                souravList.get(i).add(Integer.parseInt(souravEdges[j]));
            }
        }
        boolean[] souravBool=new boolean[souravList.size()-1];

        String[] souravPath = souravReader.readLine().trim().split("\\s+");
        int souravSource = Integer.parseInt(souravPath[0]);
        int souravDest = Integer.parseInt(souravPath[1]);


        Queue<Integer> souravQueue=new LinkedList<>();
        souravQueue.add(souravSource);
        souravBool[souravSource-1] = true;

        int souravClicks = 0;
        boolean souravReached=false;
        outer :while(!souravQueue.isEmpty())
        {
            int t= souravQueue.size();
            int k=0;
            while(k<t)
            {
                int temp= souravQueue.remove();
                if(temp==souravDest)
                {
                    souravReached=true;
                    break outer;
                }
                for(int i:souravList.get(temp))
                {
                    if(souravBool[i-1]==false)
                    {
                        souravQueue.add(i);
                        souravBool[i-1]=true;
                    }
                }
                k++;
            }
            souravClicks++;
        }
        if(souravReached)
        {
            System.out.println(souravClicks);
            return;
        }
        System.out.println(-1);

    }
}
