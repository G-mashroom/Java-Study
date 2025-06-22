package study_list;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 演示 java.util.Arrays 工具类的常用 API 方法。
 */
public class StudyArraysApiDemo {
    public static void  BinarySearchDemo(int[] sortedNums) {
        System.out.println("--- 深入解析 Arrays.binarySearch() 的返回值 ---\n");


        System.out.println("用于查找的有序数组: " + Arrays.toString(sortedNums));
        System.out.println("-----------------------------------------");

        // --- Case 1: 查找成功 ---
        int key1 = 5;
        int index1 = Arrays.binarySearch(sortedNums, key1);
        System.out.println("查找存在的元素 " + key1 + ":");
        System.out.println("  -> 返回值: " + index1 + " (>= 0，表示查找成功，返回值即为索引)");
        System.out.println("-----------------------------------------");


        // --- Case 2: 查找失败 (插入点在中间) ---
        int key2 = 6;
        int index2 = Arrays.binarySearch(sortedNums, key2);
        int insertionPoint2 = -index2 - 1; // 解码公式: 插入点 = -返回值 - 1
        System.out.println("查找不存在的元素 " + key2 + ":");
        System.out.println("  -> 返回值: " + index2 + " (< 0，表示查找失败)");
        System.out.println("  -> 根据公式 -(返回值) - 1 计算出插入点为: " + insertionPoint2);
        System.out.println("     (意味着 " + key2 + " 应该插入到索引 " + insertionPoint2 + " 的位置)");
        System.out.println("-----------------------------------------");


        // --- Case 3: 查找失败 (演示为什么需要 -1 的关键场景) ---
        int key3 = 0; // 这个元素如果存在，应该在索引 0 的位置
        int index3 = Arrays.binarySearch(sortedNums, key3);
        int insertionPoint3 = -index3 - 1;
        System.out.println("查找不存在的元素 " + key3 + " (该元素本应在索引0):");
        System.out.println("  -> 返回值: " + index3);
        System.out.println("     (如果没有-1，这里会返回-0，即0，与“找到”的情况混淆)");
        System.out.println("  -> 根据公式 -(返回值) - 1 计算出插入点为: " + insertionPoint3);
        System.out.println("-----------------------------------------");


        // --- Case 4: 查找失败 (插入点在末尾) ---
        int key4 = 20; // 这个元素如果存在，应该在数组末尾之后
        int index4 = Arrays.binarySearch(sortedNums, key4);
        int insertionPoint4 = -index4 - 1;
        System.out.println("查找不存在的元素 " + key4 + " (该元素应插入在末尾):");
        System.out.println("  -> 返回值: " + index4);
        System.out.println("  -> 根据公式 -(返回值) - 1 计算出插入点为: " + insertionPoint4);
        System.out.println("     (意味着 " + key4 + " 应该插入到索引 " + insertionPoint4 + " 的位置，即数组长度)");
    }
    public void main1(String[] args) {
        // 准备一个用于演示的原始数组
        int[] originalNums = {3, 1, 9, 5, 7, 4};
        System.out.println("--- 演示开始，使用的原始数组为: " + Arrays.toString(originalNums) + " ---\n");


        // --- 1. public static String toString(数组) ---
        // 功能：将数组的内容拼接成一个易于阅读的字符串。这是调试和打印数组最常用的方法。
        System.out.println("--- 1. toString(数组) ---");
        String arrayString = Arrays.toString(originalNums);
        System.out.println("调用 toString() 的结果: " + arrayString);
        System.out.println("============================================\n");


        // --- 2. public static void sort(数组) ---
        // 功能：按照默认方式（对数字来说是升序）对数组进行排序。这是一个原地排序，会直接修改原数组。
        System.out.println("--- 2. sort(数组) - 默认升序排序 ---");
        // 为了不破坏原始数组，我们先复制一份再排序
        int[] numsToSort = Arrays.copyOf(originalNums, originalNums.length);
        System.out.println("排序前: " + Arrays.toString(numsToSort));
        Arrays.sort(numsToSort);
        BinarySearchDemo(numsToSort);
        System.out.println("排序后: " + Arrays.toString(numsToSort));
        System.out.println("============================================\n");


        // --- 3. public static int binarySearch(数组, 查找的元素) ---
        // 功能：使用二分查找法在一个 *已排序* 的数组中查找元素。
        // 重要前提：数组必须已经排好序，否则结果不可预测！
        System.out.println("--- 3. binarySearch(数组, 查找的元素) ---");
        System.out.println("在已排序的数组 " + Arrays.toString(numsToSort) + " 中进行查找...");
        // 查找一个存在的元素
        int indexFound = Arrays.binarySearch(numsToSort, 7);
        System.out.println("查找元素 7 的索引: " + indexFound); // 7 在排序后数组的索引为 4
        // 查找一个不存在的元素
        int indexNotFound = Arrays.binarySearch(numsToSort, 6);
        System.out.println("查找元素 6 的索引: " + indexNotFound); // 返回负数，表示未找到
        System.out.println("============================================\n");


        // --- 4. public static void sort(数组, 排序规则) ---
        // 功能：按照我们自己指定的规则进行排序。
        // 注意：自定义排序规则通常用于对象数组，这里我们用 Integer 包装类数组来演示。
        System.out.println("--- 4. sort(数组, 排序规则) - 自定义降序排序 ---");
        Integer[] numsForCustomSort = {3, 1, 9, 5, 7, 4};
        System.out.println("排序前: " + Arrays.toString(numsForCustomSort));
        // 使用 Lambda 表达式提供一个降序排序的规则 (b - a)
        Arrays.sort(numsForCustomSort, (a, b) -> b - a);
        System.out.println("按降序规则排序后: " + Arrays.toString(numsForCustomSort));
        System.out.println("============================================\n");


        // --- 5. public static int[] copyOf(原数组, 新数组长度) ---
        // 功能：复制数组，生成一个指定长度的新数组。
        System.out.println("--- 5. copyOf(原数组, 新数组长度) ---");
        System.out.println("原始数组: " + Arrays.toString(originalNums));
        // 复制并截断（只取前3个元素）
        int[] truncatedCopy = Arrays.copyOf(originalNums, 3);
        System.out.println("截断复制 (长度为3): " + Arrays.toString(truncatedCopy));
        // 复制并扩展（新长度为8，多出的部分用默认值0填充）
        int[] extendedCopy = Arrays.copyOf(originalNums, 8);
        System.out.println("扩展复制 (长度为8): " + Arrays.toString(extendedCopy));
        System.out.println("============================================\n");


        // --- 6. public static int[] copyOfRange(原数组, 起始索引, 结束索引) ---
        // 功能：复制指定范围的数组元素，生成一个新数组。范围是“包前不包后”。
        System.out.println("--- 6. copyOfRange(原数组, 起始索引, 结束索引) ---");
        System.out.println("原始数组: " + Arrays.toString(originalNums));
        // 复制索引从 1 到 4 的元素 (即第2、3、4个元素)
        int[] rangeCopy = Arrays.copyOfRange(originalNums, 1, 4);
        System.out.println("复制索引范围 [1, 4) 的结果: " + Arrays.toString(rangeCopy));
        System.out.println("============================================\n");


        // --- 7. public static void fill(数组, 元素) ---
        // 功能：用一个指定的值填充数组的所有位置。
        System.out.println("--- 7. fill(数组, 元素) ---");
        int[] arrayToFill = new int[5];
        System.out.println("填充前: " + Arrays.toString(arrayToFill));
        Arrays.fill(arrayToFill, 88); // 用 88 填充整个数组
        System.out.println("用 88 填充后: " + Arrays.toString(arrayToFill));
        System.out.println("============================================\n");
    }
}