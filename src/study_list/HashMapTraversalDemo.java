package study_list;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
/**
 * 演示遍历 HashMap 的五种常用方法。
 */
public class HashMapTraversalDemo {

    public  void main1(String[] args) {
        // --- 准备工作：创建一个示例 Map ---
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 88);
        studentScores.put("Charlie", 92);

        System.out.println("原始 Map 内容: " + studentScores);
        System.out.println("=============================================");

        // --- 方法一：使用 EntrySet 遍历 (最高效，推荐) ---
        // 如果你需要同时访问键和值，这是最佳选择。
        System.out.println("\n--- 方法一：使用 EntrySet 遍历 ---");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("学生: " + key + ", 成绩: " + value);
        }

        // --- 方法二：使用 KeySet 遍历 ---
        // 当你主要关心键，或者需要通过键来获取值时使用。
        System.out.println("\n--- 方法二：使用 KeySet 遍历 ---");
        for (String key : studentScores.keySet()) {
            Integer value = studentScores.get(key); // 需要通过 get() 再次查找值
            System.out.println("学生: " + key + ", 成绩: " + value);
        }

        // --- 方法三：只遍历 Values ---
        // 当你只关心值，不关心键时使用。
        System.out.println("\n--- 方法三：只遍历 Values ---");
        for (Integer value : studentScores.values()) {
            System.out.println("遍历到一组成绩: " + value);
        }

        // --- 方法四：使用 Lambda 表达式 (Java 8+) - 最简洁 ---
        // 这是现代 Java 代码中最简洁、可读性最好的遍历方式。
        System.out.println("\n--- 方法四：使用 Lambda 表达式 (Java 8+) ---");
        studentScores.forEach((key, value) -> {
            System.out.println("学生: " + key + ", 成绩: " + value);
        });

        // --- 方法五：使用迭代器 (Iterator) - 可在遍历时安全删除 ---
        // 这是唯一可以在遍历过程中安全地从 Map 中删除元素的方式。
        System.out.println("\n--- 方法五：使用 Iterator (并演示安全删除) ---");

        // 为了不影响原始数据，我们创建一个副本进行删除操作
        Map<String, Integer> scoresCopy = new HashMap<>(studentScores);
        System.out.println("操作前 (副本): " + scoresCopy);

        // 获取键值对集合的迭代器
        Iterator<Map.Entry<String, Integer>> iterator = scoresCopy.entrySet().iterator();

        System.out.println("正在遍历并删除所有成绩低于 90 分的学生...");
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 90) {
                System.out.println("  -> 发现 " + entry.getKey() + " 的成绩 " + entry.getValue() + " < 90，正在删除...");
                iterator.remove(); // 使用迭代器的 remove() 方法安全地删除元素
            }
        }
        System.out.println("操作后 (副本): " + scoresCopy);
        System.out.println("=============================================");
    }
}