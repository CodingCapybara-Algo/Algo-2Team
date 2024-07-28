package week_4.skwent77;
import java.util.*;
public class PGS_K번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> li = new ArrayList<>();

        for (int[] command : commands) {
            int start = command[0] - 1;  // 시작 인덱스
            int end = command[1];        // 끝 인덱스 (end는 포함되지 않으므로 1을 빼지 않음)
            int k = command[2] - 1;      // k번째 인덱스 (0부터 시작하기 때문에 1을 뺌)

            // 부분 배열 추출 및 정렬
            int[] subArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArray);

            // k번째 수를 결과에 추가
            li.add(subArray[k]);
        }

        // List<Integer>를 int[]로 변환하여 반환
        answer= li.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = solution(array, commands);
        System.out.println(Arrays.toString(result));
    }
}
/*테스트 1 〉	통과 (3.45ms, 81.6MB)
테스트 2 〉	통과 (2.55ms, 82.8MB)
테스트 3 〉	통과 (3.73ms, 73.9MB)
테스트 4 〉	통과 (2.59ms, 72MB)
테스트 5 〉	통과 (2.38ms, 72.6MB)
테스트 6 〉	통과 (3.31ms, 76.5MB)
테스트 7 〉	통과 (2.33ms, 76.2MB)
*/
 */