import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] solution = solution(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.print(solution[i] + " ");
        }
    }

    private static int[] solution(int n, int[] arr) {
        int[] ans = new int[n];
        List<Integer> list = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int rank = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && list.get(i - 1).equals(list.get(i))) {
                    rank--;
                    break;
                }
                if (list.get(i) == arr[j]) {
                    ans[j] = rank;
                }
            }
            rank++;
        }
        return ans;
    }
}