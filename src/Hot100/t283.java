package Hot100;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 * */

public class t283 {
    public void moveZeroes(int[] nums) {
       int b = 0;
       for(int a=0;a<nums.length;a++){
           if(nums[a]!=0){
               nums[b++] = nums[a];
           }
       }
       for(int i =b;i<nums.length;i++) nums[i] = 0;
       System.out.println(Arrays.toString(nums));
    }
}
