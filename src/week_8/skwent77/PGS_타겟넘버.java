package week_8.skwent77;
//참고 링크: https://mungto.tistory.com/51
public class PGS_타겟넘버 {
    public int solution(int[] numbers, int target) {
        // DFS를 호출하여 탐색 시작
        return dfs(numbers, target, 0, 0);
    }
    private int dfs(int[] numbers, int target, int index, int currentSum) {
        // 모든 숫자를 다 사용한 경우
        if (index == numbers.length) {
            // 현재 합이 타겟과 같다면 1을 반환 (해당 경우 카운트)
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        // 현재 숫자를 더한 경우와 뺀 경우의 합을 계산하여 반환
        int addCase = dfs(numbers, target, index + 1, currentSum + numbers[index]);
        int subtractCase = dfs(numbers, target, index + 1, currentSum - numbers[index]);

        // 두 경우의 수를 합한 값을 반환
        return addCase + subtractCase;
    }
}
/*
정확성: 100.0
합계: 100.0 / 100.0
테스트 1 〉	통과 (4.20ms, 69.1MB)
테스트 2 〉	통과 (4.13ms, 77.9MB)
테스트 3 〉	통과 (0.17ms, 74.7MB)
테스트 4 〉	통과 (0.28ms, 71.9MB)
테스트 5 〉	통과 (0.81ms, 68.2MB)
테스트 6 〉	통과 (0.31ms, 76.4MB)
테스트 7 〉	통과 (0.17ms, 73.5MB)
테스트 8 〉	통과 (0.44ms, 75.7MB)
예시로 설명
주어진 숫자 배열 [1, 1, 1, 1, 1]과 목표 값 3이 있는 경우:

초기 호출: dfs([1, 1, 1, 1, 1], 3, 0, 0)
첫 번째 단계:
숫자 1을 더한 경우: dfs([1, 1, 1, 1, 1], 3, 1, 1)
숫자 1을 뺀 경우: dfs([1, 1, 1, 1, 1], 3, 1, -1)
이러한 방식으로 각 단계에서 숫자를 더하거나 빼는 두 가지 경우를 탐색하며, 최종적으로 목표 값 3을 만들 수 있는 경우의 수를 반환합니다.

 */

//시간 복잡도 숫자 배열의 길이에 따라 2^N의 시간 복잡도