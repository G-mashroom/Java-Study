package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。*/
public class t15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. 初始化结果列表
        List<List<Integer>> result = new ArrayList<>();
        // 2. 边界条件判断：如果数组长度小于3，不可能构成三元组
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 3. 对数组进行排序，这是双指针法的前提
        Arrays.sort(nums); // 例如: [-4, -1, -1, 0, 1, 2]
        // 4. 主循环：遍历数组，固定第一个数 a (nums[i])
        // 只需要遍历到倒数第三个数，因为后面需要给 left 和 right 指针留出位置
        for (int i = 0; i < nums.length - 2; i++) {
            // 优化点一：如果固定的数 a > 0，因为数组已排序，
            // 后面的数 b 和 c 也都大于0，三数之和不可能等于0，可以直接结束循环。
            if (nums[i] > 0) {
                break;
            }
            // 优化点二（去重）：防止对同一个“起始数 a”进行重复计算
            // 例如，数组是 [-1, -1, 0, 1]，当我们处理完第一个 -1 后，应跳过第二个 -1。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 5. 设置双指针：left 指向 i 的下一个位置，right 指向数组末尾
            int left = i + 1;
            int right = nums.length - 1;
            // 6. 双指针向中间收缩，寻找满足 a + b + c = 0 的 b 和 c
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到了一个满足条件的三元组！
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 优化点三（去重）：移动 left 和 right 指针，并跳过所有重复的元素
                    // 跳过所有与当前 nums[left] 重复的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 跳过所有与当前 nums[right] 重复的元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 移动指针到下一个不同的位置，继续寻找新的组合
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和小于0，说明需要更大的数，将 left 指针右移
                    left++;
                } else { // sum > 0
                    // 和大于0，说明需要更小的数，将 right 指针左移
                    right--;
                }
            }
        }
        // 7. 返回最终结果
        return result;
    }
    // 暴力枚举 比前者浪费时间
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
