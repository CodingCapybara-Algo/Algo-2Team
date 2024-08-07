package week_5.sapientia1007;

public class PGS_카펫 {
    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            // 전체 사각형 타일 개수
            int sum = brown+yellow;

            for (int i=3; i<=Math.sqrt(sum); i++) {
                if (sum % i == 0) { // 현재 i가 전체 사각형 개수의 약수인 경우
                    int x = i; // 가로
                    int y = sum / i; // 세로
                    if ((x - 2) * (y - 2) == yellow) { // 노란색 타일의 개수 = 내부 타일 = (가로 길이 - 2) * (세로 길이 - 2)로 계산
                        answer[0] = Math.max(x,y); answer[1] = Math.min(x,y);
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10,2)); // [4,3]
        System.out.println(s.solution(8,1)); // [3,3]
        System.out.println(s.solution(24,24)); // [8,6]
    }
}

/*
테스트 1 〉	통과 (0.03ms, 76.3MB)
테스트 2 〉	통과 (0.04ms, 76.3MB)
테스트 3 〉	통과 (0.12ms, 65.6MB)
테스트 4 〉	통과 (0.04ms, 76.3MB)
테스트 5 〉	통과 (0.02ms, 71.4MB)
테스트 6 〉	통과 (0.04ms, 74.3MB)
테스트 7 〉	통과 (0.05ms, 77.5MB)
테스트 8 〉	통과 (0.05ms, 75.7MB)
테스트 9 〉	통과 (0.09ms, 75.3MB)
테스트 10 〉	통과 (0.09ms, 76.8MB)
테스트 11 〉	통과 (0.02ms, 72.3MB)
테스트 12 〉	통과 (0.04ms, 77.7MB)
테스트 13 〉	통과 (0.04ms, 76.8MB)
*/