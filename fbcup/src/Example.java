
import java.util.*;


class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0, Q = 0;
        N = sc.nextInt();
        Q = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        while (Q-- > 0) {
            int target = sc.nextInt();
            if (targetSum(arr, target)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static boolean targetSum(int[] arr, int target) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (isprime(i)) {
                al.add(arr[i]);
            }
        }
        for (int i = 0; i < al.size(); i++) {
            if (al.contains(target - al.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isprime(int i) {
        if (i == 0 || i == 1) return false;

        for (int k = 2; k < i ; k++) {
            if (i % k == 0) {
                return false;
            }
        }
        return true;
    }
}

