package week_9.heogeonho;

import java.util.Arrays;

public class PGS_입국심사 {

    /*
    시간 내에 아이디어를 떠올리지 못했던 문제
    이분탐색을 개념적으로는 이해 했으나 활용의 영역에서 부족함이 있었음
    해설을 보고 박수친 문제 (이런 아이디어가..!)

    0~가장오래걸리는 시간을 이분탐색
    중간 값을 찾고
    해당 값의 처리 가능 인원 계산
    가능 인원이 n보다 작으면 left = mid
    가능 인원이 n보다 크거나 같은면 answer=mid 업데이트 & right = mid-1
     */

    public static void main(String[] args) {
        System.out.println(solution(6, new int[] {7, 10}));
    }

    static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long)n * times[times.length-1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long comp = 0;
            for (int time : times)
                comp += mid / time;
            if (comp < n)
                left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}

/*
테스트 1 〉	통과 (1.22ms, 76.1MB)
테스트 2 〉	통과 (0.67ms, 77.4MB)
테스트 3 〉	통과 (2.77ms, 72.2MB)
테스트 4 〉	통과 (78.53ms, 87.2MB)
테스트 5 〉	통과 (79.85ms, 98.4MB)
테스트 6 〉	통과 (68.32ms, 101MB)
테스트 7 〉	통과 (90.66ms, 103MB)
테스트 8 〉	통과 (90.08ms, 101MB)
테스트 9 〉	통과 (0.54ms, 73.5MB)
 */