package week_4.heogeonho;

import java.util.Arrays;

public class PGS_K번째수 {
    /*
    기존 배열은 각 commands 마다 바뀌는 것이 아님 이것만 주의하면 틀릴일 x
     */

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer =new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int commandRange=commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[commandRange];

            int k=0;
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                temp[k++] = array[j - 1];
            }
            Arrays.sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] array=new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] commands=new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }
}

/*
테스트 1 〉	통과 (0.32ms, 71.1MB)
테스트 2 〉	통과 (0.34ms, 78.3MB)
테스트 3 〉	통과 (0.32ms, 74.1MB)
테스트 4 〉	통과 (0.33ms, 82.5MB)
테스트 5 〉	통과 (0.54ms, 83.1MB)
테스트 6 〉	통과 (0.33ms, 79.2MB)
테스트 7 〉	통과 (0.51ms, 81.9MB)
 */