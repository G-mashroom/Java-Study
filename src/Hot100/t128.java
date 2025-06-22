package Hot100;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

 示例 1：

 输入：nums = [100,4,200,1,3,2]
 输出：4
 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 示例 2：

 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 输出：9
 示例 3：

 输入：nums = [1,0,1,2]
 输出：3
 */
public class t128 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                int count = map.get(num - 1) + 1;
                map.put(num, count);
            }else if (!map.containsKey(num)) {
                map.put(num, 1);
            }
        }
        int max = 0;
        for (int num : map.keySet()) {
            max = Math.max(max, map.get(num));
        }
        return max;

    }
    public int longestConsecutive1(int[] nums) {
        /**
         * 使用哈希集合（HashSet）查找最长连续序列。
         * 这种方法的时间复杂度为 O(N)，空间复杂度也为 O(N)。
         *
         * @param nums 整数数组，可能包含重复数字。
         * @return 数组中最长连续序列的长度。
         */
        // 健壮性检查：如果输入数组为 null 或为空，不存在任何序列，直接返回 0。
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // --- 步骤 1: 准备工作 ---
        // 使用 HashSet 来存储数组中的所有数字。
        // HashSet 的两大优势:
        // 1. 自动去重：[1, 2, 2, 3] 会被存为 {1, 2, 3}。
        // 2. 快速查找：contains() 操作的平均时间复杂度为 O(1)，非常高效。
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        // 用于记录并更新全局的最长连续序列长度。
        int longestStreak = 0;

        // --- 步骤 2: 核心逻辑 ---
        // 遍历 HashSet 中的每一个去重后的数字。
        for (int num : num_set) {
            // 这是整个算法最核心、最聪明的优化点！
            // 我们只对一个序列的“起点”进行计算。
            // 如果一个数字 num 的前一个数字 (num - 1) 不在集合中，
            // 那么 num 就是一个潜在的连续序列的起点。
            // 这样可以避免对一个已经计算过的序列（例如 {2, 3, 4}）进行重复的、无意义的计算。
            // 例如，对于序列 {1, 2, 3, 4}，我们只会从 1 开始计算，而会直接跳过 2, 3, 4。
            if (!num_set.contains(num - 1)) {

                // --- 步骤 3: 从起点开始计算当前序列长度 ---
                int currentNum = num;      // 初始化当前数字为序列起点
                int currentStreak = 1;     // 初始化当前序列长度为 1（起点本身）

                // “顺藤摸瓜”，检查下一个连续数字是否存在。
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;     // 移动到下一个数字
                    currentStreak += 1;  // 增加当前序列的长度
                }

                // --- 步骤 4: 更新全局最长记录 ---
                // 当一个从 num 开始的连续序列查找结束后（即 while 循环结束），
                // 我们用它当前的长度 currentStreak 和已知的最长长度 longestStreak 比较，
                // 并将较大值赋给 longestStreak。
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        // 遍历完所有数字后，longestStreak 中存储的就是最终答案。
        return longestStreak;
    }
}
