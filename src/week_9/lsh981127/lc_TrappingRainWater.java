package week_9.lsh981127;
import java.util.*;
public class lc_TrappingRainWater {
    public int trap(int[] height) {
        int left =0, right = height.length-1;

        int lmax =0, rmax = 0;
        int result = 0;
        while(left < right) {

            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);

            if(lmax <= rmax) {
                result += lmax - height[left];
                left++;
            } else {
                result += rmax - height[right];
                right--;
            }
        }
        return result;
    }
}
