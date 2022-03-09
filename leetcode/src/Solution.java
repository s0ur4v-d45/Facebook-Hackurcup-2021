
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
       int n =  nums.length;
       int[] big=new int[n*2];
       for(int i=0;i<big.length;i++)
       {
           big[i]=nums[i%n];
       }

       int[] res=new int[n];
       st.push(big[big.length-1]);
       for(int i= big.length-1;i>=0;i--)
        {
           while(!st.isEmpty())
           {
               if(st.peek()<=big[i])
               {
                   st.pop();
               }
               else
               {
                   if(i<n)
                   {
                       res[i] = st.peek();
                   }

                   break;
               }
           }
           if(st.isEmpty())
           {
               if(i<n)
               {
                   res[i] = -1;
               }
           }
           st.push(big[i]);
        }
       return res;
    }
}
