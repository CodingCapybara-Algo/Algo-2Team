package week_8.sapientia1007;

public class PGS_단어변환 {
    static class Solution {
        static boolean[] v;
        static int answer = 0;
        public int solution(String begin, String target, String[] words) {
            v = new boolean[words.length];

            dfs(begin, target, words, 0); // words 배열 내에서 탐색
            return answer;
        }

        static void dfs(String now, String target, String[] words, int cnt) {
            if (now.equals(target)) { // 원하는 단어와 같아지면 탐색 종료
                answer = cnt;
                return;
            }

            for (int i=0; i<words.length; i++) {
                if (v[i] == true) continue; // 이미 방문한 단어면 pass

                String word = words[i]; int notEqual = 0;
                for (int j=0; j<now.length(); j++) {
                    if (now.charAt(j) != words[i].charAt(j)) notEqual++; // 단어 별 다른 알파벳 개수
                }
                // 1개만 다르면 탐색
                if (notEqual == 1){
                    v[i] = true;
                    dfs(word, target, words, cnt+1);
                    v[i] = false; // 방문 초기화
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"})); // 4
        System.out.println(s.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"})); // 0
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 74.6MB)
테스트 2 〉	통과 (0.05ms, 84.4MB)
테스트 3 〉	통과 (0.37ms, 75.5MB)
테스트 4 〉	통과 (0.03ms, 73.6MB)
테스트 5 〉	통과 (0.03ms, 70MB)
*/