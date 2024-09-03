package week_9.heogeonho;

import java.io.*;
import java.util.*;

public class BOJ_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st=new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        List<Integer> lis = new ArrayList<>();

        // 전체 순회 하면서 각각에 숫자에 대해 부분수열 가능 여부 조회
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int position =  binarySearch(lis, num); // 이분탐색으로 적절한 자리 탐색

            // 메인 idea를 구현한 부분
            // 적절한 위치가 맨 끝자리라면 값을 추가
            // 아니면 해당 위치의 값 교체
            if (position == lis.size()) {
                lis.add(num);
            } else {
                lis.set(position, num);
            }

        }

    }

    // 이분 탐색 메서드 (target이 들어갈 위치를 찾음)
    // 크기 비교를 통해 위치 처리
    static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}




/*
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 수열의 크기
        int[] arr = new int[n]; // 수열을 저장할 배열

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); // 수열의 값을 입력받음
        }

        List<Integer> lis = new ArrayList<>(); // LIS를 저장할 리스트

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            // 이분 탐색을 이용해 num이 들어갈 위치를 찾음
            int pos = binarySearch(lis, num);

            // 찾은 위치가 LIS 리스트의 끝이라면 추가
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                // 그렇지 않으면 해당 위치의 값을 현재 num으로 교체
                lis.set(pos, num);
            }
        }

        // LIS 리스트의 크기가 가장 긴 증가하는 부분 수열의 길이
        System.out.println(lis.size());
    }

    // 이분 탐색 메서드 (target이 들어갈 위치를 찾음)
    private static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
 */