package week_8.sapientia1007;

// 더하기와 빼기만 가능
public class PGS_타겟넘버 {
    static class Solution {
        static int answer = 0;
        public int solution(int[] numbers, int target) {
            answer = 0;
            dfs(numbers,target,0,0);
            return answer;
        }

        public void dfs(int[] numbers, int target, int idx, int sum) { // 모든 경우를 탐색하기 위한 dfs
            if (idx == numbers.length){ // numbers 배열 끝에 인덱스가 도달했으면
                if (target == sum) answer++; // 협재 합이 target과 일치하면 경우의 수 증가
                return; // 탐색 종료
            }
            dfs(numbers, target, idx+1, sum+numbers[idx]); // 현재 수 더하기
            dfs(numbers, target, idx+1, sum-numbers[idx]); // 현재 수 뺴기
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1,1,1,1,1}, 3)); // 5
        System.out.println(s.solution(new int[] {4,1,2,1}, 4)); // 2
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (17.46ms, 80.9MB)
테스트 2 〉	통과 (5.23ms, 70.9MB)
테스트 3 〉	통과 (0.23ms, 77.1MB)
테스트 4 〉	통과 (0.46ms, 81.3MB)
테스트 5 〉	통과 (0.70ms, 74.9MB)
테스트 6 〉	통과 (0.41ms, 80.1MB)
테스트 7 〉	통과 (0.17ms, 77.1MB)
테스트 8 〉	통과 (0.39ms, 79.4MB)
 */