package week_4.lsh981127;

import java.util.*;

public class pgs_K번째수 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // 주어진 범위에 맞춰서 temp 리스트에 분할해준 뒤, 오름차순 정렬 이후, k번째 값을 출력한다.
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


/**
 * 테스트 1 〉	통과 (0.35ms, 74.2MB)
 * 테스트 2 〉	통과 (0.34ms, 73.2MB)
 * 테스트 3 〉	통과 (0.36ms, 75.7MB)
 * 테스트 4 〉	통과 (0.51ms, 74.9MB)
 * 테스트 5 〉	통과 (0.36ms, 72MB)
 * 테스트 6 〉	통과 (0.55ms, 75MB)
 * 테스트 7 〉	통과 (0.33ms, 74.8MB)
 */