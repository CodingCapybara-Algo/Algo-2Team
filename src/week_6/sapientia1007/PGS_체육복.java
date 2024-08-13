package week_6.sapientia1007;

import java.io.*;
import java.util.*;

public class PGS_체육복 {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] clothes = new int[n+1];
            Arrays.fill(clothes, 1); // 모든학생이 하나의 체육복씩 가지고 있다 가정
            clothes[0]=0; // idx로 학생 구별하기 위해 0번째는 0으로 초기화
            for (int idx : reserve) clothes[idx] += 1; // 여유분 가진 학생이라면 +1
            for (int idx : lost) clothes[idx] -=1; // 잃어버린 학생이라면 -1

            // 잃어버린 학생을 기준으로 앞/뒤에 여유분에 체육복이 있는 학생이라면 빌리기
            for (int i=1; i<=n; i++) {
                if (clothes[i] == 0) {
                    if (i-1 >= 1 && clothes[i-1] == 2){
                        clothes[i-1]-=1;
                        clothes[i]+=1;
                    } else if (i+1 <=n && clothes[i+1] == 2){
                        clothes[i+1]-=1;
                        clothes[i]+=1;
                    }
                }
            }
            // 전체 결과
            for (int i=1; i<=n; i++){
                if (clothes[i] > 0) answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[] {2,4}, new int[] {1,3,5})); //5
        System.out.println(s.solution(5, new int[] {2,4}, new int[] {3})); //4
        System.out.println(s.solution(3, new int[] {3}, new int[] {1})); //2
    }
}

/*
테스트 1 〉	통과 (0.03ms, 88.3MB)
테스트 2 〉	통과 (0.03ms, 73.3MB)
테스트 3 〉	통과 (0.02ms, 73.8MB)
테스트 4 〉	통과 (0.03ms, 73MB)
테스트 5 〉	통과 (0.03ms, 72.9MB)
테스트 6 〉	통과 (0.04ms, 70.7MB)
테스트 7 〉	통과 (0.03ms, 73.1MB)
테스트 8 〉	통과 (0.03ms, 74.6MB)
테스트 9 〉	통과 (0.03ms, 73.9MB)
테스트 10 〉	통과 (0.03ms, 80MB)
테스트 11 〉	통과 (0.04ms, 74.9MB)
테스트 12 〉	통과 (0.02ms, 77MB)
테스트 13 〉	통과 (0.03ms, 75MB)
테스트 14 〉	통과 (0.02ms, 77MB)
테스트 15 〉	통과 (0.02ms, 75.3MB)
테스트 16 〉	통과 (0.02ms, 75.4MB)
테스트 17 〉	통과 (0.03ms, 75.6MB)
테스트 18 〉	통과 (0.04ms, 83.5MB)
테스트 19 〉	통과 (0.03ms, 79.5MB)
테스트 20 〉	통과 (0.02ms, 69.3MB)
테스트 21 〉	통과 (0.02ms, 74.2MB)
테스트 22 〉	통과 (0.02ms, 73.4MB)
테스트 23 〉	통과 (0.02ms, 76.8MB)
테스트 24 〉	통과 (0.02ms, 77.7MB)
테스트 25 〉	통과 (0.02ms, 76.4MB)
테스트 26 〉	통과 (0.02ms, 73.5MB)
테스트 27 〉	통과 (0.02ms, 69.5MB)
테스트 28 〉	통과 (0.02ms, 70.7MB)
테스트 29 〉	통과 (0.02ms, 79.9MB)
테스트 30 〉	통과 (0.02ms, 77.9MB)
 */