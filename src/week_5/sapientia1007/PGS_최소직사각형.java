package week_5.sapientia1007;

public class PGS_최소직사각형 {
    static class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;

            int MaxWidth = 0; int MaxHeight = 0;

            for (int[] size : sizes){
                int maxVal = Math.max(size[0],size[1]); // 큰값끼리 비교하기 위함
                int minVal = Math.min(size[0], size[1]); // 작은값끼리 비교하기 위함
                MaxWidth = Math.max(maxVal, MaxWidth);
                MaxHeight = Math.max(minVal, MaxHeight);
            }
            answer = MaxWidth*MaxHeight;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}})); // 4000
        System.out.println(s.solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120
        System.out.println(s.solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})); // 133
    }
}

/*
정확성 테스트
테스트 1 〉	통과 (0.03ms, 78MB)
테스트 2 〉	통과 (0.03ms, 76.7MB)
테스트 3 〉	통과 (0.05ms, 74.4MB)
테스트 4 〉	통과 (0.07ms, 75MB)
테스트 5 〉	통과 (0.03ms, 78MB)
테스트 6 〉	통과 (0.04ms, 76.2MB)
테스트 7 〉	통과 (0.03ms, 74.9MB)
테스트 8 〉	통과 (0.09ms, 69.6MB)
테스트 9 〉	통과 (0.03ms, 75.2MB)
테스트 10 〉	통과 (0.03ms, 73.2MB)
테스트 11 〉	통과 (0.06ms, 78.9MB)
테스트 12 〉	통과 (0.06ms, 69.5MB)
테스트 13 〉	통과 (0.23ms, 76.8MB)
테스트 14 〉	통과 (0.35ms, 76.8MB)
테스트 15 〉	통과 (0.42ms, 79.5MB)
테스트 16 〉	통과 (0.69ms, 80.2MB)
테스트 17 〉	통과 (0.96ms, 94.3MB)
테스트 18 〉	통과 (1.11ms, 79.7MB)
테스트 19 〉	통과 (1.30ms, 89.5MB)
테스트 20 〉	통과 (1.44ms, 99.7MB)
 */