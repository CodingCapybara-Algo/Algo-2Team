package week_5.skwent77;

public class PGS_피로도 {
    static int maxDun = 0;

    // 주어진 피로도(k)와 던전 배열(dungeons)을 바탕으로 최대 탐험 가능한 던전 수를 반환하는 함수
    public static int solution(int k, int[][] dungeons) {
        maxDun = 0;  // 최대 탐험 가능한 던전 수를 저장할 변수 초기화
        boolean[] visited = new boolean[dungeons.length];  // 던전 방문 여부를 추적하기 위한 배열
        permute(dungeons, visited, k, 0);  // 재귀적으로 모든 가능한 던전 탐험 순서 시도
        return maxDun;  // 최대 탐험 가능한 던전 수 반환
    }

    // 재귀적으로 던전 탐험 순서를 생성하고 최대 탐험 가능한 던전 수를 갱신하는 함수
    private static void permute(int[][] dungeons, boolean[] visited, int k, int count) {
        // 현재까지 탐험한 던전 수(count)를 maxDun과 비교하여 최대값 갱신
        maxDun = Math.max(maxDun, count);

        // 각 던전을 순회하며 방문하지 않았고, 현재 피로도(k)로 탐험 가능한 던전을 찾음
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {  // 던전을 탐험할 수 있는지 확인
                visited[i] = true;  // 현재 던전을 방문함으로 표시
                permute(dungeons, visited, k - dungeons[i][1], count + 1);  // 남은 피로도(k)와 탐험한 던전 수(count) 갱신하여 재귀 호출
                visited[i] = false;  // 재귀 호출 후 원래 상태로 복구 (백트래킹)
            }
        }
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));  // 출력: 3
    }
}
/*
/*
위의 코드는 주어진 피로도와 던전 정보를 바탕으로 최대 탐험 가능한 던전 수를 계산하는 방법을 사용합니다. 주석을 통해 각 단계가 어떤 역할을 하는지 설명했습니다.

예제 설명:
1. 초기 피로도는 80이며, 첫 번째 던전을 돌기위한 최소 필요 피로도는 80입니다. 첫 번째 던전을 탐험하면 남은 피로도는 60이 됩니다.
2. 두 번째 던전을 탐험하기 위해 필요한 최소 피로도는 50이며, 소모 피로도는 40입니다. 남은 피로도 60으로 두 번째 던전을 탐험할 수 있으며, 탐험 후 남은 피로도는 20이 됩니다.
3. 세 번째 던전을 탐험하기 위해 필요한 최소 피로도는 30이지만, 현재 남은 피로도는 20이므로 탐험할 수 없습니다.

따라서 첫 번째 → 두 번째 → 세 번째 던전 순서로 탐험할 수 있으며, 최대 탐험 가능한 던전 수는 3개입니다.

permute 메서드:

현재까지 탐험한 던전 수 count를 maxDun과 비교하여 최대값을 갱신합니다.
각 던전을 순회하며, 방문하지 않았고 현재 피로도 k로 탐험 가능한 던전을 찾음.
현재 던전을 탐험할 수 있으면 visited[i]를 true로 설정하여 방문함을 표시하고, 재귀적으로 다음 던전을 탐험합니다.
재귀 호출이 끝나면 visited[i]를 false로 설정하여 원래 상태로 복구 (백트래킹).
테스트 1 〉	통과 (0.03ms, 75.2MB)
테스트 2 〉	통과 (0.06ms, 80.2MB)
테스트 3 〉	통과 (0.11ms, 78.3MB)
테스트 4 〉	통과 (0.15ms, 87.2MB)
테스트 5 〉	통과 (0.49ms, 71.5MB)
테스트 6 〉	통과 (0.72ms, 74.4MB)
테스트 7 〉	통과 (1.50ms, 73.5MB)
테스트 8 〉	통과 (4.00ms, 74.8MB)
테스트 9 〉	통과 (0.04ms, 71.3MB)
테스트 10 〉	통과 (0.29ms, 72.7MB)
테스트 11 〉	통과 (0.03ms, 77.1MB)
테스트 12 〉	통과 (0.47ms, 70.7MB)
테스트 13 〉	통과 (0.17ms, 78.6MB)
테스트 14 〉	통과 (0.05ms, 82.2MB)
테스트 15 〉	통과 (0.03ms, 75.9MB)
테스트 16 〉	통과 (0.04ms, 73MB)
테스트 17 〉	통과 (0.05ms, 82.8MB)
테스트 18 〉	통과 (0.04ms, 76.2MB)
테스트 19 〉	통과 (0.06ms, 65.6MB)
*/
