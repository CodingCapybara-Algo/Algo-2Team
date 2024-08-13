package week_6.sapientia1007;

import java.util.*;


public class PGS_단속카메라 {
    static class Solution {
        public int solution(int[][] routes) {
            // 경로의 끝 지점을 기준으로 오름차순 정렬
            Arrays.sort(routes, (r1, r2) -> Integer.compare(r1[1], r2[1]));

            int answer = 0;
            int camera = Integer.MIN_VALUE; // 현재 설치된 카메라의 위치를 초기화

            for (int[] route : routes) {
                // 현재 설치된 카메라가 커버하지 못하는 경우
                if (camera < route[0]) {
                    camera = route[1]; // 새로운 카메라 설치
                    answer++; // 카메라 설치 횟수 증가
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}})); // 2
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.77ms, 71.7MB)
테스트 2 〉	통과 (0.88ms, 83.1MB)
테스트 3 〉	통과 (0.61ms, 73.3MB)
테스트 4 〉	통과 (0.66ms, 77.4MB)
테스트 5 〉	통과 (0.77ms, 75.3MB)
효율성  테스트
테스트 1 〉	통과 (6.35ms, 52.8MB)
테스트 2 〉	통과 (3.23ms, 53.1MB)
테스트 3 〉	통과 (5.57ms, 53.3MB)
테스트 4 〉	통과 (1.04ms, 51.8MB)
테스트 5 〉	통과 (8.71ms, 53.5MB)
 */