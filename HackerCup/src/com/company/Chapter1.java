package com.company;
/*

import java.util.HashMap;
import java.util.Map;

public class Chapter1 {

    static class CheckMax
    {
        boolean singleMax;
        int maxCount;
        CheckMax(boolean sm,int mxc)
        {
            this.singleMax = sm;
            this.maxCount=mxc;
        }
    }

    static class CvCount
    {
        int vCount,cCount;
        CvCount(int vowelCount,int consonentCount)
        {
            this.cCount=vowelCount;
            this.vCount=consonentCount;
        }
    }
    public static void main(String[] args) {
	// write your code here


    }
    private static CvCount getcvCount(String str)
    {
        CvCount obj=new CvCount(0,0);
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='A' || str.charAt(i)=='E' ||
                    str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U')
            {
                obj.vCount++;
            }
            else {
                obj.cCount++;
            }
        }
        return obj;
    }

    private static CheckMax hasSingleMax(HashMap<Character,Integer> hm)
    {
        CheckMax obj=new CheckMax(false,0);
        int maxVal=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> me:hm.entrySet())
        {
            if(me.getValue()> obj.maxCount)
            {
                obj.maxCount = me.getValue();
            }
        }
        int mCount=0;
        for(Map.Entry<Character,Integer> me:hm.entrySet())
        {
            if(me.getValue() == obj.maxCount)
            {
               mCount++;
            }
        }
        if(mCount==1)
        {
            obj.singleMax=true;
        }

       return obj;
    }


}
*/
/*

import java.util.*;
import java.io.*;
public class Chapter1 {
    static class CheckMax
    {
        boolean singleMax;
        int maxCount;
        CheckMax(boolean sm,int mxc)
        {
            this.singleMax = sm;
            this.maxCount=mxc;
        }
    }

    static class CvCount
    {
        int vCount,cCount;
        CvCount(int vowelCount,int consonentCount)
        {
            this.cCount=vowelCount;
            this.vCount=consonentCount;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String S= br.readLine().trim();
        int T= Integer.parseInt(S);
        int k=1;
        while(k<=T)
        {
            String str=br.readLine();
            HashMap<Character,Integer> map= new HashMap<>();
            HashMap<Character,Integer> mapV= new HashMap<>();
            HashMap<Character,Integer> mapC= new HashMap<>();
            for(char c:str.toCharArray())
            {
                map.put(c,map.getOrDefault(c,0)+1);
                if(c=='A' || c=='E'|| c=='I' || c=='O' || c=='U')
                {
                    mapV.put(c,mapV.getOrDefault(c,0)+1);
                }else{
                    mapC.put(c,mapC.getOrDefault(c,0)+1);
                }
            }
            if(map.size()==1) {
                System.out.println("Case #"+k+": 0");
                //return;
                continue;
            }
            CvCount cv= getcvCount(str);
            int v= cv.vCount;
            int c= cv.cCount;
            if(v==0)
            {
                CheckMax f1= hasSingleMax(map);
                int x= f1.maxCount;
                int ans=Math.min(str.length(),(str.length()-x)*2);
                System.out.println("Case #"+k+": "+ans);
                */
/*if(f1.singleMax==true)
                {

                    int ans= (str.length()-x)*2;
                    System.out.println(ans);
                }else {
                    System.out.println(str.length());
                }*//*

            }else if(c==0)
            {
                CheckMax f1= hasSingleMax(map);
                int x= f1.maxCount;
                int ans=Math.min(str.length(),(str.length()-x)*2);
                System.out.println("Case #"+k+": "+ans);
               */
/* if(f1.singleMax==true)
                {
                    int x= f1.maxCount;
                    int ans= (str.length()-x)*2;
                    System.out.println(ans);
                }else{
                    System.out.println(str.length());
                }*//*

                //return;
            }else{
                if(c>v){
                    CheckMax f1= hasSingleMax(mapV);
                    int vow=(v-f1.maxCount)*2;
                    int ans=c+vow;
                    System.out.println("Case #"+k+": "+ans);
                }else if(v>c){
                    CheckMax f1= hasSingleMax(mapC);
                    int con=(c-f1.maxCount)*2;
                    int ans=v+con;
                    System.out.println("Case #"+k+": "+ans);

                }else{
                    CheckMax f1= hasSingleMax(map);
                    if(f1.singleMax==true)
                    {
                        int cons=str.length()/2;
                        int vow=(str.length()-f1.maxCount-cons)*2;
                        int ans=cons+vow;
                        System.out.println("Case #"+k+": "+ans);
                    }else{
                        int ans= (str.length()/2-f1.maxCount)*2+str.length()/2;
                        System.out.println("Case #"+k+": "+ans);
                    }
                }
                //return;
            }

            k++;
        }
    }
    private static CvCount getcvCount(String str)
    {
        CvCount obj=new CvCount(0,0);
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='A' || str.charAt(i)=='E' ||
                    str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U')
            {
                obj.vCount++;
            }
            else {
                obj.cCount++;
            }
        }
        return obj;
    }

    private static CheckMax hasSingleMax(HashMap<Character,Integer> hm)
    {
        CheckMax obj=new CheckMax(false,0);
        int maxVal=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> me:hm.entrySet())
        {
            if(me.getValue()> obj.maxCount)
            {
                obj.maxCount = me.getValue();
            }
        }
        int mCount=0;
        for(Map.Entry<Character,Integer> me:hm.entrySet())
        {
            if(me.getValue() == obj.maxCount)
            {
                mCount++;
            }
        }
        if(mCount==1)
        {
            obj.singleMax=true;
        }

        return obj;
    }
}
*/


import java.util.*;
import java.io.*;

public class Chapter1 {
    static class CheckMax
    {
        boolean singleMax;
        int maxCount;
        CheckMax(boolean sm,int mxc)
        {
            this.singleMax = sm;
            this.maxCount=mxc;
        }
    }

    static class CvCount
    {
        int vCount,cCount;
        CvCount(int vowelCount,int consonentCount)
        {
            this.cCount=vowelCount;
            this.vCount=consonentCount;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String S= br.readLine().trim();
        int T= Integer.parseInt(S);
        int k=1;
        while(k<=T)
        {
            String str=br.readLine();
            HashMap<Character,Integer> map= new HashMap<>();
            HashMap<Character,Integer> mapV= new HashMap<>();
            HashMap<Character,Integer> mapC= new HashMap<>();
            for(char c:str.toCharArray())
            {
                map.put(c,map.getOrDefault(c,0)+1);
                if(c=='A' || c=='E'|| c=='I' || c=='O' || c=='U')
                {
                    mapV.put(c,mapV.getOrDefault(c,0)+1);
                }else{
                    mapC.put(c,mapC.getOrDefault(c,0)+1);
                }
            }
            if(map.size()==1) {
                System.out.println("Case #"+k+": 0");
                //return;
                k++;
                continue;
            }
            CvCount cv= getcvCount(str);
            int v= cv.vCount;
            int c= cv.cCount;
            if(v==0)
            {
                CheckMax f1= hasSingleMax(map);
                int x= f1.maxCount;
                int ans=Math.min(str.length(),(str.length()-x)*2);
                System.out.println("Case #"+k+": "+ans);
                /*if(f1.singleMax==true)
                {

                    int ans= (str.length()-x)*2;
                    System.out.println(ans);
                }else {
                    System.out.println(str.length());
                }*/
            }else if(c==0)
            {
                CheckMax f1= hasSingleMax(map);
                int x= f1.maxCount;
                int ans=Math.min(str.length(),(str.length()-x)*2);
                System.out.println("Case #"+k+": "+ans);
               /* if(f1.singleMax==true)
                {
                    int x= f1.maxCount;
                    int ans= (str.length()-x)*2;
                    System.out.println(ans);
                }else{
                    System.out.println(str.length());
                }*/
                //return;
            }else{
                if(c>v){
                    CheckMax f1= hasSingleMax(mapV);
                    int vow=(v-f1.maxCount)*2;
                    int ans=c+vow;
                    System.out.println("Case #"+k+": "+ans);
                }else if(v>c){
                    CheckMax f1= hasSingleMax(mapC);
                    int con=(c-f1.maxCount)*2;
                    int ans=v+con;
                    System.out.println("Case #"+k+": "+ans);

                }else{
                    CheckMax f1= hasSingleMax(map);
                    if(f1.singleMax==true)
                    {
                        int cons=str.length()/2;
                        int vow=(str.length()-f1.maxCount-cons)*2;
                        int ans=cons+vow;
                        System.out.println("Case #"+k+": "+ans);
                    }else{
                        int ans= (str.length()/2-f1.maxCount)*2+str.length()/2;
                        System.out.println("Case #"+k+": "+ans);
                    }
                }
                //return;
            }

            k++;
        }
    }
    private static CvCount getcvCount(String str)
    {
        CvCount obj=new CvCount(0,0);
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='A' || str.charAt(i)=='E' ||
                    str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U')
            {
                obj.vCount++;
            }
            else {
                obj.cCount++;
            }
        }
        return obj;
    }

    private static CheckMax hasSingleMax(HashMap<Character,Integer> hm)
    {
        CheckMax obj=new CheckMax(false,0);
        int maxVal=Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> me:hm.entrySet())
        {
            if(me.getValue()> obj.maxCount)
            {
                obj.maxCount = me.getValue();
            }
        }
        int mCount=0;
        for(Map.Entry<Character,Integer> me:hm.entrySet())
        {
            if(me.getValue() == obj.maxCount)
            {
                mCount++;
            }
        }
        if(mCount==1)
        {
            obj.singleMax=true;
        }

        return obj;
    }
}
