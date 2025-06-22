package study_list.practice;

import java.util.Arrays;

public class StringMethodsDemo {

    public  void main1() {
        System.out.println("--- String 常用方法演示 ---\n");
        demonstrateInfoMethods();
        demonstrateComparisonMethods();
        demonstrateSubstringAndSplitMethods();
        demonstrateTransformMethods();
        demonstrateTypeConversionMethods();
    }

    public static void demonstrateInfoMethods() {
        System.out.println("--- 1. 获取信息类方法 ---");
        String text = "Hello World, Hello Java!";
        System.out.println("原始字符串: \"" + text + "\"");

        System.out.println("length(): " + text.length()); // 24
        System.out.println("charAt(1): '" + text.charAt(1) + "'"); // 'e'
        System.out.println("isEmpty(): " + text.isEmpty()); // false
        System.out.println("indexOf('Hello'): " + text.indexOf("Hello")); // 0
        System.out.println("lastIndexOf('Hello'): " + text.lastIndexOf("Hello")); // 14
        System.out.println("contains('World'): " + text.contains("World")); // true
        System.out.println("startsWith('He'): " + text.startsWith("He")); // true
        System.out.println("endsWith('!'): " + text.endsWith("!")); // true
        System.out.println("--------------------------------\n");
    }

    public static void demonstrateComparisonMethods() {
        System.out.println("--- 2. 比较类方法 ---");
        String s1 = "java";
        String s2 = "Java";
        String s3 = "java";

        System.out.println("s1 = \"" + s1 + "\", s2 = \"" + s2 + "\", s3 = \"" + s3 + "\"");
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // false
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true
        System.out.println("s1.equalsIgnoreCase(s2): " + s1.equalsIgnoreCase(s2)); // true
        System.out.println("--------------------------------\n");
    }

    public static void demonstrateSubstringAndSplitMethods() {
        System.out.println("--- 3. 截取与拆分类方法 ---");
        String url = "www.example.com";
        System.out.println("原始字符串: \"" + url + "\"");

        System.out.println("substring(4): " + url.substring(4)); // "example.com"
        System.out.println("substring(4, 11): " + url.substring(4, 11)); // "example"

        String data = "one,two,three,four";
        String[] parts = data.split(",");
        System.out.println("split(\",\") 的结果: " + Arrays.toString(parts)); // [one, two, three, four]
        System.out.println("--------------------------------\n");
    }

    public static void demonstrateTransformMethods() {
        System.out.println("--- 4. 转换与修改类方法 ---");
        String rawText = "  Hello Java  ";
        System.out.println("原始字符串: \"" + rawText + "\"");

        System.out.println("toUpperCase(): \"" + rawText.toUpperCase() + "\"");
        System.out.println("toLowerCase(): \"" + rawText.toLowerCase() + "\"");
        System.out.println("trim(): \"" + rawText.trim() + "\"");
        System.out.println("replace('a', 'o'): \"" + rawText.replace('a', 'o') + "\"");

        char[] chars = "abc".toCharArray();
        System.out.println("toCharArray(): " + Arrays.toString(chars)); // [a, b, c]
        System.out.println("--------------------------------\n");
    }

    public static void demonstrateTypeConversionMethods() {
        System.out.println("--- 5. 类型转换类方法 ---");
        int number = 123;
        double price = 99.9;
        boolean flag = true;

        String strNum = String.valueOf(number);
        String strPrice = String.valueOf(price);
        String strFlag = String.valueOf(flag);

        System.out.println("String.valueOf(123): \"" + strNum + "\"");
        System.out.println("String.valueOf(99.9): \"" + strPrice + "\"");
        System.out.println("String.valueOf(true): \"" + strFlag + "\"");
        System.out.println("--------------------------------\n");
    }
}