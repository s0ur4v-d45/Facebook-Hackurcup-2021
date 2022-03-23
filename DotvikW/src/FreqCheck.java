import  java.io.*;
import java.util.*;

public class FreqCheck {
    static class Pair {
        int freq;
        String ss;

        Pair(String s, int freq) {
            this.ss = s;
            this.freq = freq;
        }

    }


    public static void main(String[] args)throws Exception {
        System.out.println("please enter the path of the file:");
        BufferedReader bb= new BufferedReader(new InputStreamReader(System.in));
        String path=bb.readLine().trim();
        FreqCheck.freq(path);

    }

    static void freq(String path)throws Exception
    {
        BufferedReader br= new BufferedReader(new FileReader(path));
        ArrayList<String> arr= new ArrayList<>();
        ArrayList<Pair> a= new ArrayList<>();
        HashMap<String,Integer> map= new LinkedHashMap<>();
        int num=0;
        char c;
        StringBuilder b= new StringBuilder();
        while((num= br.read())!=-1)
        {
            c= (char)num;
            if(c>='A' && c<='Z' ||c>='a' && c<='z'||c>='0' && c<='9')
            {
                b.append(c);
            }else{
                if(b.length()!=0)
                    arr.add(b.toString());
                b= new StringBuilder();
            }
        }

        for(int i=0;i<arr.size();i++)
        {
            String s= arr.get(i);
            int count=0;
            for(int j=0;j<arr.size();j++)
            {
                if(arr.get(j).equals(s))
                {
                    count++;
                }
            }

            map.put(s,map.getOrDefault(s,0)+1);

        }

        System.out.println("..............................................");
        for(Map.Entry<String,Integer> e:map.entrySet())
        {
//            System.out.println(e.getKey()+"---->"+e.getValue());
            a.add(new Pair(e.getKey(),e.getValue()));
        }
        Collections.sort(a, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.freq == p2.freq) {
                    return p1.ss.compareTo(p2.ss);
                }
                return -p1.freq + p2.freq;
            }
        });

        for(Pair p:a)
        {
            System.out.println(p.ss + ":\t--"+p.freq);
        }
    }
}

