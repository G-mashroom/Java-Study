package Hot100;
/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。*/
public class t11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = right*(Math.min(height[left],height[right]));
        while(left!=right){
            //寻找最小边，移动可能获得大一点的最短边
            //（移动指针，宽度是一定会增加的）
            if(height[left]>=height[right])
                right--;
            else
                left++;
            maxArea = Math.max(maxArea,((right-left)*Math.min(height[left],height[right])));
        }
        return maxArea;
    }
}
