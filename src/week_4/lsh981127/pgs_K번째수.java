package week_4.lsh981127;

import java.util.*;

public class pgs_K번째수 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int y = 0; y < commands.length; y++) {
            int[] arr = commands[y];
            int i = arr[0]-1, j = arr[1]-1, k = arr[2]-1;  // 몇 번째 ~ 몇 번째라서 index 기준으로 하려면 -1 해줘야헤
            int[] temp = new int[j-i+1];
            for(int x = 0; x < j-i + 1; x++) {
                temp[x] = array[i+x];
            }
            Arrays.sort(temp);
            answer[y] = temp[k];
        }

        return answer;
    }
}
