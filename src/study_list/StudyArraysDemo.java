package study_list;
import java.util.Arrays; // 必须导入 Arrays 类

/**
 * 演示 java.util.Arrays 工具类的常用方法。
 */
public class StudyArraysDemo {

    /**
     * 这个方法集中学习和展示了 Arrays 类的核心功能。
     */
    public void studyArrays() {
        System.out.println("--- 开始学习 Arrays 类的常用方法 ---");

        // --- 1. Arrays.toString() - 打印数组 ---
        // 这是我们将一直用来查看数组内容的方法
        System.out.println("\n--- 1. Arrays.toString() - 打印数组 ---");
        int[] initialArray = {10, 50, 20, 40, 30};
        // 如果直接打印数组对象，得到的是内存地址，没有意义
        System.out.println("直接打印数组对象: " + initialArray);
        // 使用 Arrays.toString() 得到可读的格式
        System.out.println("使用 Arrays.toString() 打印: " + Arrays.toString(initialArray));


        // --- 2. Arrays.sort() - 数组排序 ---
        System.out.println("\n--- 2. Arrays.sort() - 数组排序 ---");
        int[] numsToSort = {9, 5, 2, 7, 1, 8, 3};
        System.out.println("排序前: " + Arrays.toString(numsToSort));
        Arrays.sort(numsToSort); // 对数组进行升序排序
        System.out.println("排序后: " + Arrays.toString(numsToSort));


        // --- 3. Arrays.equals() - 比较数组内容 ---
        System.out.println("\n--- 3. Arrays.equals() - 比较数组内容 ---");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 2, 1};
        boolean areEqual12 = Arrays.equals(arr1, arr2);
        boolean areEqual13 = Arrays.equals(arr1, arr3);
        System.out.println("arr1 和 arr2 内容是否相等? " + areEqual12); // true
        System.out.println("arr1 和 arr3 内容是否相等? " + areEqual13); // false


        // --- 4. Arrays.copyOf() - 复制数组 ---
        System.out.println("\n--- 4. Arrays.copyOf() - 复制数组 ---");
        int[] original = {1, 2, 3, 4, 5};
        System.out.println("原始数组: " + Arrays.toString(original));
        // 复制整个数组
        int[] fullCopy = Arrays.copyOf(original, original.length);
        System.out.println("完整复制: " + Arrays.toString(fullCopy));
        // 复制并截断（只取前3个元素）
        int[] truncatedCopy = Arrays.copyOf(original, 3);
        System.out.println("截断复制: " + Arrays.toString(truncatedCopy));
        // 复制并扩展（新长度为7，多出的部分用默认值0填充）
        int[] extendedCopy = Arrays.copyOf(original, 7);
        System.out.println("扩展复制: " + Arrays.toString(extendedCopy));


        // --- 5. Arrays.fill() - 填充数组 ---
        System.out.println("\n--- 5. Arrays.fill() - 填充数组 ---");
        int[] arrayToFill = new int[5];
        System.out.println("填充前: " + Arrays.toString(arrayToFill));
        Arrays.fill(arrayToFill, 88); // 用 88 填充整个数组
        System.out.println("填充后: " + Arrays.toString(arrayToFill));


        // --- 6. Arrays.binarySearch() - 二分查找 ---
        System.out.println("\n--- 6. Arrays.binarySearch() - 二分查找 ---");
        // **重要前提：使用二分查找前，数组必须是已排序的！**
        int[] sortedNums = {10, 20, 30, 40, 50, 60, 70};
        System.out.println("用于查找的有序数组: " + Arrays.toString(sortedNums));
        // 查找一个存在的元素
        int indexFound = Arrays.binarySearch(sortedNums, 40);
        System.out.println("查找元素 40 的索引位置: " + indexFound); // 应该返回 3
        // 查找一个不存在的元素
        int indexNotFound = Arrays.binarySearch(sortedNums, 45);
        System.out.println("查找元素 45 的索引位置: " + indexNotFound); // 返回负数
        System.out.println("（返回负数表示未找到。该负值可用于计算元素应插入的位置）");

        System.out.println("\n--- Arrays 类方法学习结束 ---");
    }

    /**
     * main 方法是程序的入口。
     * 它创建一个 StudyArraysDemo 的实例并调用 studyArrays() 方法来执行学习演示。
     */
    public void main1() {
        StudyArraysDemo demo = new StudyArraysDemo();
        demo.studyArrays();
    }
}
