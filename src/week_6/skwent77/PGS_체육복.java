package week_6.skwent77;
import java.util.Arrays;
public class PGS_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        // int answer = 0;
        int answer = n - lost.length; // 체육복이 없는 학생 수

        // 1. 선택 절차
        // 중복 제거 쉽게
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 2. 적절성 검사
        // 체육복을 잃어버린 학생 중 여벌이 있는 학생에게 빌려줄 수 있는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++; //중복되는 학생은 체육복을
                    lost[i]=-1;
                    reserve[j] = -1; // 빌려준 학생은 더 이상 빌려줄 수 없도록 표시
                    break;
                }
            }
        }
        // 3. 해답 검사
        // 체육복을 잃어버린 학생 중 여벌이 없는 학생에게 빌려줄 수 있는 경우
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) continue; // 이미 처리된 학생은 건너뜀
            for (int j = 0; j < reserve.length; j++) {

                if (reserve[j] == -1) continue;     //이미 처리된 학생은 건너뜀
                if (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
/*
이후 두 배열을 순회하면서 중복된 요소를 처리하기 쉽게 만들어줍니다. 하지만 실제로 중복을 제거하는 작업은 정렬 후에 직접 작성된 코드에서 이루어집니다.


테스트 1 〉	통과 (0.51ms, 85.4MB)
테스트 2 〉	통과 (0.41ms, 67.5MB)
테스트 3 〉	통과 (0.36ms, 76.5MB)
테스트 4 〉	통과 (0.53ms, 73MB)
테스트 5 〉	통과 (0.48ms, 76.7MB)
테스트 6 〉	통과 (0.49ms, 76MB)
테스트 7 〉	통과 (0.53ms, 64.5MB)
테스트 8 〉	통과 (0.33ms, 70MB)
테스트 9 〉	통과 (0.36ms, 69.8MB)
테스트 10 〉	통과 (0.40ms, 76.5MB)
테스트 11 〉	통과 (0.37ms, 76.2MB)
테스트 12 〉	통과 (0.52ms, 77.1MB)
테스트 13 〉	통과 (0.44ms, 79.3MB)
테스트 14 〉	통과 (0.41ms, 72.3MB)
테스트 15 〉	통과 (0.44ms, 74.4MB)
테스트 16 〉	통과 (0.35ms, 71.9MB)
테스트 17 〉	통과 (0.34ms, 77.6MB)
테스트 18 〉	통과 (0.34ms, 77.5MB)
테스트 19 〉	통과 (0.46ms, 75.1MB)
테스트 20 〉	통과 (0.35ms, 72.8MB)
테스트 21 〉	통과 (0.39ms, 77.9MB)
테스트 22 〉	통과 (0.32ms, 72.9MB)
테스트 23 〉	통과 (0.35ms, 80.5MB)
테스트 24 〉	통과 (0.40ms, 87.6MB)
테스트 25 〉	통과 (0.30ms, 72.3MB)
테스트 26 〉	통과 (0.31ms, 82.4MB)
테스트 27 〉	통과 (0.34ms, 70.7MB)
테스트 28 〉	통과 (0.36ms, 80.5MB)
테스트 29 〉	통과 (0.39ms, 69.5MB)
테스트 30 〉	통과 (0.52ms, 81.2MB)
 */