package study_list;

import java.util.ArrayList;
import java.util.List;

public class StudyArraylist {
    public void main1(String args[]) {
        // 创建一个存储字符串的 ArrayList 对象
        List<String> fruitList = new ArrayList<>();
        System.out.println("程序开始，已创建一个空的 ArrayList: " + fruitList);
        System.out.println("============================================\n");

        // --- 1. 演示 add(E element) 方法 ---
        System.out.println("--- 1. 演示 add(E element) 方法 ---");
        System.out.println("向列表中添加 'Apple'...");
        boolean addAppleResult = fruitList.add("Apple");
        System.out.println("add('Apple') 的返回值: " + addAppleResult);
        System.out.println("向列表中添加 'Banana'...");
        fruitList.add("Banana");
        System.out.println("向列表中添加 'Cherry'...");
        fruitList.add("Cherry");
        System.out.println("添加元素后，列表内容: " + fruitList);
        System.out.println("============================================\n");

        // --- 2. 演示 size() 方法 ---
        System.out.println("--- 2. 演示 size() 方法 ---");
        int listSize = fruitList.size();
        System.out.println("调用 size() 方法，当前列表的长度为: " + listSize);
        System.out.println("============================================\n");

        // --- 3. 演示 get(int index) 方法 ---
        System.out.println("--- 3. 演示 get(int index) 方法 ---");
        // 索引从 0 开始，所以索引 1 指的是第二个元素 "Banana"
        String elementAtIndex1 = fruitList.get(1);
        System.out.println("调用 get(1) 方法，获取索引为 1 的元素: " + elementAtIndex1);
        System.out.println("============================================\n");

        // --- 4. 演示 set(int index, E element) 方法 ---
        System.out.println("--- 4. 演示 set(int index, E element) 方法 ---");
        System.out.println("修改前，列表内容: " + fruitList);
        System.out.println("执行 set(1, \"Blueberry\")，将索引 1 的元素替换为 'Blueberry'...");
        String replacedElement = fruitList.set(1, "Blueberry");
        System.out.println("set() 方法的返回值 (被替换掉的旧元素): " + replacedElement);
        System.out.println("修改后，列表内容: " + fruitList);
        System.out.println("============================================\n");

        // --- 5. 演示 remove(int index) 方法 ---
        System.out.println("--- 5. 演示 remove(int index) 方法 ---");
        System.out.println("删除前，列表内容: " + fruitList);
        System.out.println("执行 remove(0)，删除索引为 0 的元素...");
        String removedByIndexElement = fruitList.remove(0);
        System.out.println("remove(0) 方法的返回值 (被删除的元素): " + removedByIndexElement);
        System.out.println("删除后，列表内容: " + fruitList);
        System.out.println("删除后，列表长度: " + fruitList.size());
        System.out.println("============================================\n");

        // --- 6. 演示 remove(Object o) 方法 ---
        System.out.println("--- 6. 演示 remove(Object o) 方法 ---");
        // 先添加一个元素，让列表内容更丰富
        fruitList.add("Apple");
        System.out.println("删除前，列表内容: " + fruitList);
        System.out.println("执行 remove(\"Cherry\")，删除 'Cherry' 这个元素...");
        boolean removeObjectResult = fruitList.remove("Cherry");
        System.out.println("remove(\"Cherry\") 方法的返回值: " + removeObjectResult);
        System.out.println("删除后，列表内容: " + fruitList);

        System.out.println("\n尝试删除一个不存在的元素 'Grape'...");
        boolean removeNonExistentResult = fruitList.remove("Grape");
        System.out.println("remove(\"Grape\") 方法的返回值: " + removeNonExistentResult);
        System.out.println("删除不存在的元素后，列表内容: " + fruitList);
        System.out.println("============================================\n");


        // 添加基本数据类型 要使用包装类
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        System.out.println("添加基本数据类型: " + intList);
        System.out.println("============================================\n");
        System.out.println(intList.get(0));
        System.out.println(intList.remove(1));
        System.out.println(intList.size());
        System.out.println(intList.isEmpty());
        System.out.println(intList);
        System.out.println(intList.contains(2));



    }

}
