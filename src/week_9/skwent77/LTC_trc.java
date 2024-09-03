package week_9.skwent77;

import java.io.*;
import java.util.*;

// 참고 영상 : https://www.youtube.com/watch?v=u38ZNfsFVDM (해설강의 by 메타 개발자)
public class LTC_trc {
    public int trap(int[] height) {
        /* 변수 설명
            result 고인 물의 총량 누적하는 변수
            left : 인덱스까지 왼쪽에서 가장 높은 높이 저장하는 배열
            right; 인덱스까지 오른쪽에서 가장 높은 높이 저장하는 배열
         */
        int result = 0;
        if (height == null || height.length <= 2) {

            return result;
        } //막대가 3개 미만이면 물이 고일 수 없다.
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        //주어진 elevation지도 왼쪽부터 순회
        int max = height[0];
        left[0] = height[0];
        //현재 높이가 max보다 크거나 같으면, 최대 높이를 업데이트하고 left[i]에 현재 높이를 저장합니다.
        for (int i = 1; i < height.length; i++) {
            //height 배열을 순회하며, 각 인덱스 i에서 왼쪽 최대 높이와 오른쪽 최대 높이의 최소값에서
            // 현재 높이(height[i])를 뺍니다. 이 값이 바로 해당 위치에 고인 물의 양
            if (height[i] < max) {
                left[i] = max;
            } else {
                left[i] = height[i];
                max = height[i];
            }
        }
        // 주어질 elevation 지도 오른쪽부터 순회
        max = height[height.length - 1];
        right[height.length - 1] = height[height.length - 1];
        //right[i]에는 height[i]에서 height[height.length - 1]까지의 최대 높이가 저장됩니다.
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] < max) {
                right[i] = max;
            } else {
                //right[i]에는 height[i]에서 height[height.length - 1]까지의 최대 높이가 저장됩니다.
                right[i] = height[i];
                max = height[i];
            }
        }
        //5. 고인 물의 양 계산
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(left[i], right[i]);
            result = result + temp - height[i];
        }
        //height 배열을 왼쪽에서 오른쪽으로, 그리고 오른쪽에서 왼쪽으로 두 번 순회하여 각 위치에서의 최대 높이를 계산한 뒤
        // 각 위치에서 고일 수 있는 물의 양을 계산합
        return result;
    }
}
//Input: height = [4,2,0,3,2,5]
//Output: 9

// runtime result
//Memory
//46.04MB
// time height 배열을 세 번 순회하므로 O(n) space 복잡도 left, right int 배열 2개 사용하므로 모두 O(n)
