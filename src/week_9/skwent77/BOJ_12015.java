package week_9.skwent77;
//참고 링크
/*

         문제 유형: LIS를 구하는 문제
         - LIS(최장 증가 부분 수열)를 구하는 방식으로, 배열을 순차적으로 탐색하며
           LIS를 업데이트합니다.
         - 이진 탐색을 활용하여 LIS를 효율적으로 관리합니다.
        문제 해결 전략
         - 이진 탐색을 통해 LIS 배열에서 해당 원소가 들어갈 위치를 찾아 그 위치의 원소를 현재 원소로 교체합니다. 이 과정에서 LIS의 길이는 변하지 않지만, 잠재적으로 더 좋은 LIS를 만들 수 있는 기회를 확보하게 됩
 */

import java.io.*;
//BufferedReader , InputStreamReader
import java.util.StringTokenizer;

public class BOJ_12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n]; /// LIS(Longest Increasing Subsequence)를 저장할 배열
        answer[0] = nums[0];
        int answerLength = 1;
        //첫 번째 원소는 이미 answer[0]에 추가되었으므로, 반복문을 i = 1부터 비교 시작
        for (int i = 1; i < n; i++) {
            if (answer[answerLength - 1] < nums[i]) {
                // 정답 배열의 마지막 원소보다 새로운 원소가 큰 경우
                // / 새로 들어오는 원소가 현재 LIS의 마지막 원소보다 크다면
                // LIS의 길이를 늘리고 새로운 원소를 추가합니다.
                answer[answerLength++] = nums[i];
            } else {
                // 정답 배열의 마지막 원소보다 새로운 원소가 작거나 같은 경우 즉 위 case에 해당 안 되면 이진 탐색을 통해 새로 들어오는 원소가
                // LIS에서 어디에 들어갈지를 결정합니다.
                int idx = binarySearch(answer, 0, answerLength - 1, nums[i]);
                answer[idx] = nums[i];
            }
        }
        System.out.println(answerLength);
        br.close();
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        int idx = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return idx;
    }
}
//	메모리 96212KB	시간472ms