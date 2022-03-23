import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Vaccination {
    static class person
    {
        String name;
        int age;
        String category;
        int x;
        int y;
        public person(String name,int age,String category,int x,int y)
        {
            this.age=age;
            this.name=name;
            this.category=category;
            this.x=x;
            this.y=y;
        }

    }

    static class coordinates
    {
        int longitude;
        int lattitude;
        public coordinates(int l,int lat)
        {
            lattitude=l;
            longitude=lat;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        int noOfCentres = Integer.parseInt(bufferedReader.readLine());
        ArrayList<coordinates> aaaaa=new ArrayList<>();
        ArrayList<ArrayList<person>> bbbbb=new ArrayList<>();
       for(int i=0;i<noOfCentres;i++)
       {
           String[] pair = bufferedReader.readLine().split("\\s+");
           aaaaa.add(new coordinates(Integer.parseInt(pair[0]), Integer.parseInt(pair[1])));
           //bbbbb.add(new ArrayList<person>());
       }
        for(int i=0;i<noOfCentres;i++)
        {
            bbbbb.add(new ArrayList<person>());
        }


        int noOfpersons = Integer.parseInt(bufferedReader.readLine());
       for(int i=0;i<noOfpersons;i++)
       {
           String[] pair = bufferedReader.readLine().split(" ");
           person p = new person(pair[0],Integer.parseInt(pair[1]),pair[2],Integer.parseInt(pair[3]),Integer.parseInt(pair[4]));
           int index = distance(aaaaa,p.x,p.y);

           bbbbb.get(index).add(p);

       }
       /*
2
0 0
0 10
5
Atul 24 A 0 1
Sunil 24 B 0 5
Rajni 23 A 0 1
Salman 21 B 0 12
Kunal 24 A 0 2
        */
        for(int i=0;i<bbbbb.size();i++) {
            ArrayList<person> tempPerson = bbbbb.get(i);

            Collections.sort(tempPerson, (p1, p2) -> {
                if (p1.age == p2.age) {
                    if (p1.category.equals(p2.category)) {
                        return p1.name.compareTo(p2.name);
                    } else {
                        return p1.category.compareTo(p2.category);
                    }
                } else {
                    return p2.age - p1.age;
                }
            });
        }


        for(int i=0;i< bbbbb.size();i++)
        {
            if(bbbbb.get(i).size()==0)
            {
                System.out.println("Empty Centre");
                continue;
            }
            for(int j=0;j<bbbbb.get(i).size();j++)
            {
                System.out.print(bbbbb.get(i).get(j).name+" ");
            }
            System.out.println();
        }
    }

    private static int distance(ArrayList<coordinates> aaaaa, int x, int y) {
        double minimum = Double.MAX_VALUE;
//       int resx=0;
//       int resy=0;
        int result = -1;
        for (int i = 0; i < aaaaa.size(); i++) {
            coordinates c = aaaaa.get(i);
            int x1 = c.lattitude;
            int y1 = c.longitude;
            double value = Math.sqrt(((x - x1) * (x - x1))+((y - y1) *(y - y1)));
            //System.out.println(value);
            if (value < minimum) {
                minimum = value;
                result = i;
            }
        }

      return result;
    }
}
