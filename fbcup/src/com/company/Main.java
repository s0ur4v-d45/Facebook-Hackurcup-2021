
package com.company;
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static class Pair
    {
        int caveNo;
        int gold;
        Pair(int cave,int gold)
        {
            this.caveNo=cave;
            this.gold=gold;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int T = Integer.parseInt(S);
        int i = 1;
        while (T-- > 0) {
            //String s= br.readLine().trim();
            int K = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");
            int n = str.length;
            int[] mGold = new int[n];
            int x = 0;
            for (String s : str) {
                mGold[x++] = Integer.parseInt(s);
            }
            HashMap<Pair, ArrayList<Pair>> map = new HashMap<>();
            HashMap<Pair, ArrayList<Pair>> mapO = new HashMap<>();
            while (K-- > 1) {
                String[] s = br.readLine().trim().split(" ");

                int start = Integer.parseInt(String.valueOf(s[0]));
                int reach = Integer.parseInt(String.valueOf(s[1]));
                Pair source =new Pair(start,mGold[start-1]);
                Pair dest= new Pair(reach,mGold[reach-1]);
                if (map.containsKey(source)) {
                    ArrayList<Pair> arr = map.get(source);
                    //arr.add(reach);
                    arr.add(dest);
                    map.replace(source, arr);
                } else {
                    ArrayList<Pair> arr = new ArrayList<>();
                    arr.add(dest);
                    map.put(source,arr);
                }
                if (mapO.containsKey(dest)) {
                    ArrayList<Pair> arr = mapO.get(dest);
                    arr.add(source);
                    mapO.replace(dest, arr);
                } else {
                    ArrayList<Pair> arr = new ArrayList<>();
                    arr.add(source);
                    mapO.put(dest,arr);
                }
            }
            ArrayList<Pair> visit1=new ArrayList<>();
            ArrayList<Pair> visit2=new ArrayList<>();
            int a=getGoldDigger(mapO,mGold,visit1,0,0);
            int b=getGoldDigger(map,mGold,visit2,0,0);
            int ans= a+b ;
            System.out.println("Case #" + i++ + ": "+ans);

        }

    }
    static int getGoldDigger(HashMap<Pair,ArrayList<Pair>> hm,int[] arr,ArrayList<Pair> visited,int cn,int cost)  throws Exception
    {
        Pair p=new Pair(cn+1,arr[cn]);
        visited.add(p);

        cost+=arr[cn];
        int fcost=Integer.MIN_VALUE;
        if(hm.containsKey(p))
        {
            for(int x=0;x<hm.get(p).size();x++)
            {
               Pair neighbour = hm.get(p).get(x);
               if(!visited.contains(neighbour))
               {
                  fcost = Math.max(cost,getGoldDigger(hm,arr,visited,neighbour.caveNo-1,cost));
               }
            }
        }

      return fcost;

    }


}
*/
import java.util.*;
import java.io.*;
public class Main {
    static class Pair {
        int caveNo;
        int gold;

        Pair(int cave, int gold) {
            this.caveNo = cave;
            this.gold = gold;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int T = Integer.parseInt(S);
        int i = 1;
        while (T-- > 0) {
            //String s= br.readLine().trim();
            int K = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");
            int n = str.length;
            int[] mGold = new int[n];
            int x = 0;
            for (String s : str) {
                mGold[x++] = Integer.parseInt(s);
            }
            HashMap<Pair, ArrayList<Pair>> map = new HashMap<>();
            HashMap<Pair, ArrayList<Pair>> mapO = new HashMap<>();
            while (K-- > 1) {
                String[] s = br.readLine().trim().split(" ");

                int start = Integer.parseInt(String.valueOf(s[0]));
                int reach = Integer.parseInt(String.valueOf(s[1]));
                Pair source = new Pair(start, mGold[start - 1]);
                Pair dest = new Pair(reach, mGold[reach - 1]);
                if (map.containsKey(source)) {
                    ArrayList<Pair> arr = map.get(source);
                    //arr.add(reach);
                    arr.add(dest);
                    map.replace(source, arr);
                } else {
                    ArrayList<Pair> arr = new ArrayList<>();
                    arr.add(dest);
                    map.put(source, arr);
                }
                if (mapO.containsKey(dest)) {
                    ArrayList<Pair> arr = mapO.get(dest);
                    arr.add(source);
                    mapO.replace(dest, arr);
                } else {
                    ArrayList<Pair> arr = new ArrayList<>();
                    arr.add(source);
                    mapO.put(dest, arr);
                }
            }
            for (Map.Entry<Pair,ArrayList<Pair>> entry : map.entrySet()){
                ArrayList<Pair> p=entry.getValue();
                for(Pair pp:p)
                {
                    System.out.println("map\t"+entry.getKey().caveNo+ "------->"+pp.caveNo+ "->"+pp.gold);
                }
            }
            System.out.println("-------------------------------------------------------------------------");
            for (Map.Entry<Pair,ArrayList<Pair>> entry : mapO.entrySet()){
                ArrayList<Pair> p=entry.getValue();
                for(Pair pp:p)
                {
                    System.out.println("mapO\t"+entry.getKey().caveNo+"------->"+pp.caveNo+"-------->"+ "->"+pp.gold);
                }
            }
            System.out.println("----------------------------END---------------------------------------------");

            ArrayList<Pair> visit1=new ArrayList<>();
            ArrayList<Pair> visit2=new ArrayList<>();
            int a=getGoldDigger(mapO,mGold,visit1,0,0);
            int b=getGoldDigger(map,mGold,visit2,0,0);
            int ans= a+b - mGold[0];
            System.out.println("Case #" + i++ + ": "+ans);

        }

    }
    static int getGoldDigger(HashMap<Pair,ArrayList<Pair>> hm,int[] arr, ArrayList<Pair> visited,int i,int cost)
    {
        Pair p=new Pair(i+1,arr[i]);
        visited.add(p);
        cost+=arr[i];
        boolean check=false;
        int finalcost=Integer.MIN_VALUE;
        if(hm.containsKey(p))
        {
            for(int x=0;x<hm.get(p).size();x++)
            {
                Pair neighbour = hm.get(p).get(x);
                if(!visited.contains(neighbour))
                {
                    check=true;
                    finalcost = Math.max(cost,getGoldDigger(hm,arr,visited,neighbour.caveNo-1,cost));
                }
            }
        }
         if(check==true)
         {
             return finalcost;
         }
       return cost;
    }


}