import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Mla {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int time1 = Integer.parseInt(br.readLine());
        int time2 = Integer.parseInt(br.readLine());
        int n=Integer.parseInt(br.readLine());

        String[] villages=br.readLine().split(" ");
        int[] gaon=new int[villages.length];
        for(int i=0;i< villages.length;i++)
        {
            gaon[i] = Integer.parseInt(villages[i]);
        }
        int sum1=0,sum2=0,i=0,j=villages.length;

        System.out.println(fun(time1,time2,gaon,gaon.length));
    }

    private static int fun(int time1, int time2, int[] arr, int length) {
        int end=0,start=0;

        for(int i=0;i<length;i++)
        {
            end+=arr[i];
        }

        int ans=end;

        int jm=fun2(arr,length);
        while(start<=end)
        {
            int mid=(start+end)/2;

            if(mid>=jm && isP(mid,time1,arr,length))
            {
                ans=Math.min(ans,mid);
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return ans*time2;

    }

    private static boolean isP(int mid, int time1, int[] arr, int length) {
        int c=1;
        int ct=0;
        for(int i=0;i<length;) {
            if(ct+ arr[i]>mid)
            {
                ct=0;
                c++;
            }
            else{
                ct+=arr[i++];
            }
        }
            return c<=time1;



    }

    private static int fun2(int[] arr, int length) {
        int res=arr[0];
        for(int i=1;i<length;i++)
        {
            if(arr[i]>res)
            {
                res=arr[i];
            }
        }
        return res;
    }
}
