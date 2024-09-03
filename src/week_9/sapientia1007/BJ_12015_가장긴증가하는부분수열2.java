package week_9.sapientia1007;

import java.util.*;
import java.io.*;
public class BJ_12015_가장긴증가하는부분수열2 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N]; // 숫자 배열 저장 
            List<Integer> list = new ArrayList<>(); // 증가 수열 저장 리스트
            list.add(0);

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i=0; i<N; i++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i] = val;

                if (val > list.get(list.size() - 1)) { // 수열 마지막 값보다 현재 val이 크면 증가 수열에 저장
                    list.add(val);
                } else { // 증가 수열 담은 list 내 이분탐색
                    int left = 0; int right = list.size()-1;
                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (list.get(mid) >= val) { // 중간값이 현재 값보다 크면
                            right = mid ;
                        } else {
                            left = mid + 1;
                        }
                    }
                    list.set(right,val); // right index에 위치한 값을 val로 변경
                }
            }
            System.out.println(list.size() - 1);
            br.close();
        }
    }

/*
메모리 : 122284 KB
시간 : 660 ms
 */