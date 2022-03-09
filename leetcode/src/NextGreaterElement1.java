import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        int[] arr=new int[nums2.length];
        arr[nums2.length-1]=-1;
        hm.put(nums2[nums2.length-1],-1);
        st.push(nums2[nums2.length-1]);
        for(int i= nums2.length-2;i>=0;i--)
        {
            while(!st.isEmpty())
            {
                if(st.peek()<=nums2[i])
                {
                    st.pop();
                }
                else
                {
                    arr[i]=st.peek();
                    break;
                }
            }
            if(st.isEmpty())
            {
                arr[i]=-1;
            }
            st.push(nums2[i]);
            hm.put(nums2[i],arr[i]);
        }

        for(int i=0;i<nums1.length;i++)
        {
            nums1[i]=hm.get(nums1[i]);
        }
        return nums1;
    }
}
