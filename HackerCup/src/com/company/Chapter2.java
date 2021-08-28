package com.company;
/*

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Chapter2 {

    static class Pair
    {
        char endPoints;
        int cost;
        Pair(char endPoints,int cost)
        {
            this.endPoints=endPoints;
            this.cost=cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int T = Integer.parseInt(S);
        int i=1;
        while(T-->0) {
            String str = br.readLine().trim();
            int K = Integer.parseInt(br.readLine().trim());
            HashMap<Character, ArrayList<Character>> map = new HashMap<>();
            while (K-- > 0) {
                String s = br.readLine().trim();
                char start = s.charAt(0);
                char reach = s.charAt(1);
                if (map.containsKey(start)) {
                    ArrayList<Character> arr = map.get(start);
                    arr.add(reach);
                    map.replace(start, arr);
                } else {
                    ArrayList<Character> arr = new ArrayList<>();
                    arr.add(reach);
                    map.put(start, arr);
                }
            }
            if(str.length()==1 || isAllCharSame(str)==true)
            {
                System.out.println("Case #" + i + ": 0");
                i++;
                continue;
            }
            ArrayList<ArrayList<Pair>> main = getEndPoints(str, map);
            int ans = getMinCost(main,str);
            if(ans==Integer.MAX_VALUE)
            {
                System.out.println("Case #" + i + ": "+-1);
            }else
                System.out.println("Case #" + i + ": "+ans);
            i++;
        }
    }
    static int getMinCost(ArrayList<ArrayList<Pair>> arr,String str){
        HashSet<Character> set= new HashSet<>();
        int minCost=Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++)
        {
            for(int j=0;j<arr.get(i).size();j++)
            {
                Pair p= arr.get(i).get(j);
                set.add(p.endPoints);
            }
        }
        for(char c:set)
        {
            int cost=0;
            int t=0;
            for(int i=0;i<arr.size();i++)
            {
                boolean flag=false;
                for(int j=0;j<arr.get(i).size();j++)
                {

                    Pair p= arr.get(i).get(j);
                    if(p.endPoints==c)
                    {
                        cost+=p.cost;
                        flag=true;
                        t++;
                        break;
                    }
                }
                if(flag==false)
                    break;
            }
            if(t==str.length())
                minCost=Math.min(cost,minCost);
        }
        return minCost;
    }

    private static boolean isAllCharSame(String str)
    {
        char same=str.charAt(0);
       for(int i=1;i<str.length();i++)
       {
           if(same!=str.charAt(i))
           {
               return false;
           }
       }
       return true;
    }

    private static ArrayList<ArrayList<Pair>> getEndPoints(String str, HashMap<Character, ArrayList<Character>> hm)
    {
        ArrayList<ArrayList<Pair>> list=new ArrayList<>();

        for(char c:str.toCharArray())
        {
           ArrayList<Pair> al=new ArrayList<>();
           al.add(new Pair(c,0));
           ArrayList<Character> visited = new ArrayList<>();
           dfs(al,visited,hm);
           list.add(al);
        }
        return list;
    }

    private static void dfs(ArrayList<Pair> al,ArrayList<Character> visited,HashMap<Character, ArrayList<Character>> hm)
    {
        Pair temp = al.get(al.size()-1);
       visited.add(temp.endPoints);
       if(hm.get(temp.endPoints)!=null)
       {
           for(int i=0;i<hm.get(temp.endPoints).size();i++)
           {
               char ch = hm.get(temp.endPoints).get(i);
               al.add(new Pair(ch, temp.cost+1));
               if(!visited.contains(ch))
               {
                   dfs(al,visited,hm);
               }

           }
       }

    }

}
*/


import java.util.*;
        import java.io.*;
public class Chapter2 {
    static class Pair
    {
        char endPoints;
        int cost;
        Pair(char endPoints,int cost)
        {
            this.endPoints=endPoints;
            this.cost=cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int T = Integer.parseInt(S);
        int i=1;
        while(T-->0) {
            String str = br.readLine().trim();
            int K = Integer.parseInt(br.readLine().trim());
            HashMap<Character, ArrayList<Character>> map = new HashMap<>();
            while (K-- > 0) {
                String s = br.readLine().trim();
                char start = s.charAt(0);
                char reach = s.charAt(1);
                if (map.containsKey(start)) {
                    ArrayList<Character> arr = map.get(start);
                    arr.add(reach);
                    map.replace(start, arr);
                } else {
                    ArrayList<Character> arr = new ArrayList<>();
                    arr.add(reach);
                    map.put(start, arr);
                }
            }
            if(str.length()==1 || isAllCharSame(str)==true)
            {
                System.out.println("Case #" + i + ": 0");
                i++;
                continue;
            }
            ArrayList<ArrayList<Pair>> main = getEndPoints(str, map);
            int ans = getMinCost(main,str);
            if(ans==Integer.MAX_VALUE)
            {
                System.out.println("Case #" + i + ": "+-1);
            }else
                System.out.println("Case #" + i + ": "+ans);
            i++;
        }
    }
    static int getMinCost(ArrayList<ArrayList<Pair>> arr,String str){
        HashSet<Character> set= new HashSet<>();

        for(int i=0;i<arr.size();i++)
        {
            for(int j=0;j<arr.get(i).size();j++)
            {
                Pair p= arr.get(i).get(j);
                set.add(p.endPoints);
            }
        }
        /*for(char c:set)
        {
            int cost=0;
            int t=0;
            for(int i=0;i<arr.size();i++)
            {
                boolean flag=false;
                for(int j=0;j<arr.get(i).size();j++)
                {

                    Pair p= arr.get(i).get(j);
                    if(p.endPoints==c)
                    {
                        cost+=p.cost;
                        flag=true;
                        t++;
                        break;
                    }
                }
                if(flag==false)
                    break;
            }
            if(t==str.length())
                minCost=Math.min(cost,minCost);
        }
        return minCost;*/

        int minCost=Integer.MAX_VALUE;
        int outerLoopCount=0,minCostUpdate=0;
        int j=0,i=0;
        for(char c:set)
        {
            outerLoopCount++;
            int cost=0;
            for(i=0;i<arr.size();i++)
            {
//                boolean flag=false;
                for(j=0;j<arr.get(i).size();j++)
                {
                    Pair p=arr.get(i).get(j);
                    if(p.endPoints==c)
                    {
                        cost+=p.cost;
//                        flag=true;
                        break;
                    }
                }
                if(j==arr.get(i).size())
                {
                    break;
                }

            }
            if(i==arr.size())
            {
                minCostUpdate++;
               minCost = Math.min(minCost,cost);
            }


        }
        if(minCostUpdate==0)
        {
            minCost=-1;
        }

        return minCost;

    }
    private static ArrayList<ArrayList<Pair>> getEndPoints(String str, HashMap<Character, ArrayList<Character>> hm)
    {
        ArrayList<ArrayList<Pair>> list=new ArrayList<>();

        for(char c:str.toCharArray())
        {
            ArrayList<Pair> al=new ArrayList<>();
            Pair p=new Pair(c,0);
            al.add(p);
            ArrayList<Character> visited = new ArrayList<>();
            Queue<Pair> q=new LinkedList<>();
            q.add(p);
            visited.add(p.endPoints);
            bfs(q,al,visited,hm);
            list.add(al);
        }
        return list;
    }

    private static void bfs(Queue<Pair> q,ArrayList<Pair> al,ArrayList<Character> visited,HashMap<Character, ArrayList<Character>> hm)
    {
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
//        visited.add(temp.endPoints);
            if(hm.get(temp.endPoints)!=null)
            {
                for(int i=0;i<hm.get(temp.endPoints).size();i++)
                {
                    if(!visited.contains(hm.get(temp.endPoints).get(i)))
                    {
                        visited.add(hm.get(temp.endPoints).get(i));
                        Pair p=new Pair(hm.get(temp.endPoints).get(i), temp.cost+1);
                        al.add(p);
                        q.add(p);
                    }
                }
            }
        }

    }
    private static boolean isAllCharSame(String str)
    {
        char same=str.charAt(0);
        for(int i=1;i<str.length();i++)
        {
            if(same!=str.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
}
