package week_6.skwent77;
//reference: https://born2bedeveloper.tistory.com/26
import java.util.Arrays;

public class PGS_조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 오른쪽으로 쭉 간 횟수
        /// 오른쪽으로 쭉 이동하는 경우의 최소 횟수 초기화

        for (int i = 0; i < name.length(); i++) {
            //문자열의 각 문자에 대해 상하 조작 횟수를 계산하고, 좌우 조작 횟수를 최적화합니다.
            int charDiffA = name.charAt(i) - 'A';
            int charDiffZ = 26 - name.charAt(i);
            answer += Math.min(charDiffA, charDiffZ); //상,하 알파벳 맞추기

            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
//                연속된 'A' 처리: 만약 다음 문자가 'A'라면, 'A'가 끝나는 지점을 찾은 후, 좌우 이동의 최적 경로를 계산합니다.
//                연속된 'A'가 있다면, 그 부분을 지나칠 수 있는 최적의 경로를 찾기 위해 두 가지 경우를 계산합니다.
                int endA = i + 1;
                while (endA < name.length() && name.charAt(endA) == 'A')
                    endA++;
                move = Math.min(move, i * 2 + (name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                move = Math.min(move, i + (name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
            }
        }
        return answer + move;
    }
}
/*
1.조이스틱의 좌, 우 조작으로 커서 위치 조정하기
2.이스틱의 상,하 조작으로 원하는 알파벳 조작하기
        // 조이스틱 위로 9번 조작하여 j 완성
		//알파벳 변환 횟수-> 조이스틱 변환 횟수 + 알파벳 마다 이동횟수 계산해 최소값을 변환 횟수에 추가
실행결과
테스트 1 〉	통과 (0.05ms, 80.4MB)
테스트 2 〉	통과 (0.05ms, 77.1MB)
테스트 3 〉	통과 (0.05ms, 73.7MB)
테스트 4 〉	통과 (0.04ms, 80.8MB)
테스트 5 〉	통과 (0.15ms, 76.6MB)
테스트 6 〉	통과 (0.05ms, 70.2MB)
테스트 7 〉	통과 (0.04ms, 76.5MB)
테스트 8 〉	통과 (0.03ms, 77.3MB)
테스트 9 〉	통과 (0.04ms, 73.4MB)
테스트 10 〉	통과 (0.04ms, 73.4MB)
테스트 11 〉	통과 (0.03ms, 72.9MB)
테스트 12 〉	통과 (0.04ms, 73.9MB)
테스트 13 〉	통과 (0.04ms, 74MB)
테스트 14 〉	통과 (0.04ms, 74.6MB)
테스트 15 〉	통과 (0.04ms, 79.1MB)
테스트 16 〉	통과 (0.26ms, 74.6MB)
테스트 17 〉	통과 (0.03ms, 74.9MB)
테스트 18 〉	통과 (0.04ms, 71.9MB)
테스트 19 〉	통과 (0.04ms, 66MB)
테스트 20 〉	통과 (0.08ms, 76.5MB)
테스트 21 〉	통과 (0.06ms, 78.1MB)
테스트 22 〉	통과 (0.05ms, 79.4MB)
테스트 23 〉	통과 (0.04ms, 77.7MB)
테스트 24 〉	통과 (0.04ms, 77.7MB)
테스트 25 〉	통과 (0.07ms, 74.9MB)
테스트 26 〉	통과 (0.06ms, 76.8MB)
테스트 27 〉	통과 (0.03ms, 71.5MB)
 */
