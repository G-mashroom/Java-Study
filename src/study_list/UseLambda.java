package study_list;
/**
 * 这是一个函数式接口，因为它只有一个抽象方法。
 * @FunctionalInterface 注解不是必需的，但它可以让编译器帮你检查
 * 这个接口是否真的只有一个抽象方法，是一种很好的编程习惯。
 */
@FunctionalInterface
interface Swim {
    // 唯一的抽象方法
//    void swimming();
    void swimming();
//    void test(); 只能有一个抽象方法
}

public class UseLambda {

    /**
     * 这是主方法，程序的入口。
     */
    public static void main1() {

        System.out.println("--- 方式一：使用匿名内部类调用 ---");
        // 这里我们创建了一个实现了 Swim 接口的匿名类的实例，并将其传入方法
        invokeSwimming(new Swim() {
            @Override
            public void swimming() {
                System.out.println("匿名内部类说：正在游泳~~~");
            }
        });

        System.out.println("\n-------------------------------------\n");

        System.out.println("--- 方式二：使用 Lambda 表达式调用 ---");
        // Lambda 表达式的代码极度简化，只保留了核心逻辑
        // () -> System.out.println(...) 完整地代表了 Swim 接口的实现
        invokeSwimming(() -> {
            System.out.println("Lambda 表达式说：正在游泳~~~");
        });

        System.out.println("\n--- Lambda 表达式的进一步简化 ---");
        // 如果 Lambda 的方法体只有一行代码，连大括号 {} 都可以省略 形参只有一个，括号也可以不写；类型可以不写
        invokeSwimming(() -> System.out.println("简化的 Lambda 说：我也在游泳!!!"));
    }

    /**
     * 定义一个静态方法，该方法接受一个 Swim 接口类型的参数。
     * 这意味着任何实现了 Swim 接口的对象都可以被传入。
     *
     * @param swimmer 一个会“游泳”的对象
     */
    public static void invokeSwimming(Swim swimmer) {
        // 调用传入对象的 swimming 方法，来执行具体的游泳行为
        swimmer.swimming();
    }
}