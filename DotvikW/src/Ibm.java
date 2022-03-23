public class Ibm {


    public void wrapLength(int n, String s)
    {
        int k=1;
        String a="";
        int i=0;
       String ans = fun100(k,a,s,i);
    }

    private String fun100(int k,String ans,String q,int i) {

        if(k<100)
        {
            ans+=q.charAt(i);
            fun100(k)
        }
        else if(k==100)
        {

        }


    }
}


