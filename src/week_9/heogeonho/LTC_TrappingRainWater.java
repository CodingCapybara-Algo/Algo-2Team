package week_9.heogeonho;

public class LTC_TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;  // 왼쪽 포인터
        int right = height.length - 1;  // 오른쪽 포인터
        int leftMax = 0;  // 왼쪽에서 가장 높은 벽
        int rightMax = 0;  // 오른쪽에서 가장 높은 벽
        int trappedWater = 0;  // 물의 총량

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // 왼쪽에서 가장 높은 벽 갱신
                } else {
                    trappedWater += leftMax - height[left];  // 현재 높이와 왼쪽 최고 높이의 차이만큼 물을 가둠
                }
                left++;  // 왼쪽 포인터 이동
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // 오른쪽에서 가장 높은 벽 갱신
                } else {
                    trappedWater += rightMax - height[right];  // 현재 높이와 오른쪽 최고 높이의 차이만큼 물을 가둠
                }
                right--;  // 오른쪽 포인터 이동
            }
        }

        return trappedWater;  // 총 가둘 수 있는 물의 양 반환
    }
}
