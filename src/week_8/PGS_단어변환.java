package week_8;
//사고 과정: 초기 상태(시작 단어) 부터 목표 단계(목표 단어)까지 "최단 경로"-> BFS
import java.util.LinkedList;
import java.util.Queue;
/* 목차
1단계  line 13
2단계  line 41
3단계  line 46
4단계  line 50
 */
public class PGS_단어변환 {

    //1. 상태 정의  상태를 나타내는 클래스
    private static class State {
        public final String word;
        public final int step;

        private State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    // 두 단어가 변환 가능한지 확인하는 메소드
    private boolean isConvertible(String src, String dst) {
        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();

        int diff = 0;

        // 단어의 각 문자가 얼마나 다른지 계산
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] != dstArr[i]) diff++;
        }

        // 한 문자만 다를 때 변환 가능
        return diff == 1;
    }

    public int solution(String begin, String target, String[] words) {
        //2단계 방문 검사 배열
        int numCnt = words.length;
        boolean[] isVisited = new boolean[numCnt];
        Queue<State> queue = new LinkedList<>(); //BFS에서 사용하는 큐 선언하고 아래 라인에서 초기 상태 넣어줌
        queue.add(new State(begin, 0));
        // 큐에 들어간 begin이 나오기 전에 이미 begin에서전이되는 상태들을 받ㅇ문하기 때문에 정답 찾는데 영향 x 위 코드 생략 가능
        // 탐색 공간에 있는 상태 순회하며 검사 3. 탐색 진행
        while (!queue.isEmpty()) {
            State state = queue.poll();

            // 목표 단어에 도달했을 때 ==> 4. 현재 상태 처리
            if (state.word.equals(target)) {
                return state.step;
            }

            // 단어 리스트를 순회하며 변환 가능한 단어를 찾음
            for (int i = 0; i < numCnt; i++) {
                String next = words[i];

                // 변환이 불가능하거나 이미 방문한 단어는 건너뜀
                if (!isConvertible(state.word, next) || isVisited[i]) {
                    continue;
                }
// 단계마다 변환 가능한 단어를 찾아가면서 목표 단어에 도달하면 해당 단계를 반환
                // 다음 상태를 큐에 추가하고 방문 처리
                isVisited[i] = true;
                queue.add(new State(next, state.step + 1));
            }
        }

        // 목표 단어로 변환할 수 없는 경우 즉 정답 상태를 방문하지 못한 경우 0 반환
        return 0;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.28ms, 73.8MB)
테스트 2 〉	통과 (0.51ms, 86.4MB)
테스트 3 〉	통과 (1.30ms, 73MB)
테스트 4 〉	통과 (0.29ms, 73MB)
테스트 5 〉	통과 (0.28ms, 77.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

 */