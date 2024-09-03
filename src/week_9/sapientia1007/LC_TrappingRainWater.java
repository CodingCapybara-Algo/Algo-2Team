package week_9.sapientia1007;

public class LC_TrappingRainWater {
    static class Solution {
        // 물이 트랩된 양을 계산하는 메소드
        public int trap(int[] height) {
            // 입력 배열이 null이거나 길이가 0인 경우, 물이 트랩될 수 없음
            if (height == null || height.length == 0) {
                return 0;
            }

            int n = height.length; // 배열의 길이
            int left = 0; // 왼쪽 포인터
            int right = n - 1; // 오른쪽 포인터
            int leftMax = 0; // 왼쪽에서의 최대 높이
            int rightMax = 0; // 오른쪽에서의 최대 높이
            int waterTrapped = 0; // 트랩된 물의 양

            // 왼쪽 포인터가 오른쪽 포인터보다 작거나 같을 때까지 반복
            while (left <= right) {
                if (height[left] <= height[right]) { // 왼쪽 높이가 오른쪽 높이보다 작거나 같을 때
                    if (height[left] >= leftMax) { // 현재 왼쪽 높이가 왼쪽 최대 높이보다 크거나 같으면
                        leftMax = height[left]; // 왼쪽 최대 높이 업데이트
                    } else {
                        waterTrapped += leftMax - height[left]; // 트랩된 물 계산
                    }
                    left++; // 왼쪽 포인터를 오른쪽으로 이동
                } else { // 오른쪽 높이가 왼쪽 높이보다 작을 때
                    if (height[right] >= rightMax) { // 현재 오른쪽 높이가 오른쪽 최대 높이보다 크거나 같으면
                        rightMax = height[right]; // 오른쪽 최대 높이 업데이트
                    } else {
                        waterTrapped += rightMax - height[right]; // 트랩된 물 계산
                    }
                    right--; // 오른쪽 포인터를 왼쪽으로 이동
                }
            }
            return waterTrapped; // 총 트랩된 물의 양 반환
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})); // 6
        System.out.println(s.trap(new int[] {4,2,0,3,2,5})); // 9
    }
}


/*
Memory
46.54MB

Beats
19.24%
*/