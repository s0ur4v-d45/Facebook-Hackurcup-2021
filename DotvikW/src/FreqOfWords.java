import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FreqOfWords {

    static class pair {
        int freq;
        String string;

        pair(String s, int freq) {
            this.string = s;
            this.freq = freq;
        }
    }

        public static void main(String[] args) throws Exception {


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String path = br.readLine();
            br = new BufferedReader(new FileReader(path));
            int num = 0;
            char ch;
            StringBuilder str = new StringBuilder();
            ArrayList<String> al = new ArrayList<>();
            ArrayList<Integer> count = new ArrayList<>();
            ArrayList<String> ul = new ArrayList<>();


            while ((num = br.read()) != -1) {
                ch = (char) num;
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                    str.append(ch);
                } else {
                    if (str.length() != 0) {
                        al.add(str.toString());
                    }

                    str = new StringBuilder();
                }
            }

            for (int i = 0; i < al.size(); i++) {
                if (!ul.contains(al.get(i))) {
                    int counting = 0;
                    for (int j = 0; j < al.size(); j++) {
                        if (al.get(i).equals(al.get(j))) counting++;
                    }
                    ul.add(al.get(i));
                    count.add(counting);
                    System.out.println(al.get(i) + "--->" + counting);
                }
            }

            ArrayList<pair> sorted = new ArrayList<>();
            for (int i = 0; i < ul.size(); i++) {
                sorted.add(new pair(ul.get(i), count.get(i)));
            }
            Collections.sort(sorted, (o1, o2) -> {
                if (o1.freq == o2.freq) {
                    return o1.string.compareTo(o2.string);
                }
                return o2.freq - o1.freq;
            });
            System.out.println("--------------------------------------------");
            for (pair p : sorted) {
                System.out.println(p.string + "---->" + p.freq);
            }

        }

}


