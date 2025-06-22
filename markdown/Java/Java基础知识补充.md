# Java基础知识补充（刷题）

## Java中的For-Each遍历结构：更简洁、更安全的循环方式

在Java中，for-each循环（也称为增强型for循环）是在J2SE 5.0中引入的一种更为简洁、易读且安全的数组和集合遍历方式。它简化了迭代过程，无需显式地管理索引或迭代器，从而减少了代码量并有效避免了常见的“差一错误”（off-by-one errors）。

### 语法结构

for-each循环的语法结构非常直观：

Java

```
for (元素类型 迭代变量 : 遍历对象) {
    // 循环体代码
}
```

- **元素类型 (Type)**：必须与遍历对象中元素的类型兼容。
- **迭代变量 (variable)**：一个在每次循环中被赋值为遍历对象中当前元素的变量。
- **遍历对象 (iterable)**：需要被遍历的数组或实现了 `java.lang.Iterable` 接口的集合对象（如 `ArrayList`, `HashSet` 等）。
- **`:`** ：可以读作“in”（在...之中）。

整个循环可以解读为：“对于‘遍历对象’中的每一个‘元素’，执行循环体内的代码。”

### 工作原理

for-each循环的底层实现对于数组和集合有所不同：

- **对于数组**：编译器会将其转换为一个传统的for循环，使用一个索引变量从0遍历到数组的长度减一。
- **对于实现了 `Iterable` 接口的集合**：编译器会使用该集合的迭代器（`Iterator`）来遍历其中的元素。它会自动调用 `hasNext()` 和 `next()` 方法，将整个迭代过程封装起来。

### 使用示例

#### 1. 遍历数组

Java

```
public class ForEachArrayExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("数组中的元素：");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
```

## 获取数组长度

### 代码示例

下面通过几个例子来展示如何获取不同类型数组的长度。

#### 1. 获取基本数据类型数组的长度

Java

```
public class ArrayLengthExample {
    public static void main(String[] args) {
        // 定义一个整型数组
        int[] numbers = {10, 20, 30, 40, 50, 60};

        // 使用 .length 属性获取数组的长度
        int length = numbers.length;

        System.out.println("整型数组 numbers 的长度是: " + length); // 输出: 6
    }
}
```

#### 2. 获取对象类型数组的长度

Java

```
public class StringArrayLengthExample {
    public static void main(String[] args) {
        // 定义一个字符串数组
        String[] fruits = new String[4];
        fruits[0] = "Apple";
        fruits[1] = "Banana";
        fruits[2] = "Orange";
        // fruits[3] 是 null

        // 获取数组的长度
        int length = fruits.length;

        System.out.println("字符串数组 fruits 的长度是: " + length); // 输出: 4

        // 注意：length 属性返回的是数组的容量，而不是实际存储的元素数量。
        // 在这个例子中，即使有一个元素是 null，长度依然是 4。
    }
}
```

#### 3. 获取多维数组的长度

对于多维数组，`length` 属性返回的是第一维度的长度。

Java

```
public class MultiDimArrayLengthExample {
    public static void main(String[] args) {
        // 定义一个二维数组
        String[][] matrix = {
            {"A", "B", "C"},
            {"D", "E"},
            {"F", "G", "H", "I"}
        };

        // 获取二维数组的行数（第一维度的长度）
        int rowCount = matrix.length;
        System.out.println("二维数组的行数是: " + rowCount); // 输出: 3

        // 获取每一行的列数（第二维度的长度）
        int columnsInRow1 = matrix[0].length;
        int columnsInRow2 = matrix[1].length;
        int columnsInRow3 = matrix[2].length;

        System.out.println("第一行的列数是: " + columnsInRow1); // 输出: 3
        System.out.println("第二行的列数是: " + columnsInRow2); // 输出: 2
        System.out.println("第三行的列数是: " + columnsInRow3); // 输出: 4
    }
}
```

## 核心错误：数组 (Array) 没有 `append` 方法

错误信息 `error: cannot find symbol` 指出，编译器在 `int[]` (整型数组) 类型的变量 `result` 上找不到一个叫做 `append` 的方法。

- **在Java中，数组是一种固定长度的数据结构**。一旦一个数组被创建，它的长度就不能改变。你不能像 `ArrayList` 那样动态地向其中“追加”或“附加” (append) 元素。
- `append` 这个方法名通常用在可变长度的结构中，比如 `StringBuilder` 或 `JTextArea`。对于动态数组的功能，Java提供了 `java.util.ArrayList` 类，它有一个 `add` 方法。

### 2. 逻辑错误：变量未初始化

代码中 `int[] result;` 只是声明了变量 `result`，但并没有为它分配任何内存空间（即没有初始化）。此时 `result` 的值是 `null`。

即使数组有 `append` 方法，在一个 `null` 变量上调用任何方法都会在运行时导致 `NullPointerException`（空指针异常）。

### 如何修正代码？

对于这道经典的 "Two Sum" (两数之和) 问题，你的目标是找到两个索引 `i` 和 `j`，然后返回一个包含这两个索引的数组。正确的做法是，在找到答案的那一刻，**直接创建一个新的数组并返回**。

下面是修正后的代码：

Java

```
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 外层循环遍历每个数字
        for (int i = 0; i < nums.length; i++) {
            // 内层循环遍历当前数字之后的所有数字
            for (int j = i + 1; j < nums.length; j++) {
                // 检查两个数字的和是否等于目标值
                if (nums[i] + nums[j] == target) {
                    // 找到答案，创建一个包含两个索引的新数组并返回
                    // 这是一种简洁的数组创建和初始化语法
                    return new int[]{i, j};
                }
            }
        }
        // 如果循环结束都没有找到答案，根据题目要求可以抛出异常或返回一个空数组
        // 这里我们返回一个空数组作为示例
        return new int[0]; 
    }
}
```

## `Hashtable` 的常用方法 (常用函数)

`Hashtable` 的方法和 `HashMap` 非常相似。以下是一些最常用的方法：

#### 1. `put(K key, V value)` - 添加或更新键值对

- **功能**：将指定的键（key）和值（value）存入哈希表。

- 行为

  ：

  - 如果哈希表中不存在这个键，则添加这个新的键值对，并返回 `null`。
  - 如果哈希表中已存在这个键，则用新的值覆盖旧的值，并返回**旧的值**。

- 示例

  ：

  Java

  ```
  Hashtable<String, Integer> stock = new Hashtable<>();
  stock.put("Apple", 150);
  Integer oldValue = stock.put("Apple", 155); // 更新 "Apple" 的值
  System.out.println("旧的价格是: " + oldValue); // 输出: 150
  System.out.println("现在的价格是: " + stock.get("Apple")); // 输出: 155
  ```

#### 2. `get(Object key)` - 获取值

- **功能**：根据给定的键，返回其对应的值。

- **行为**：如果找不到对应的键，则返回 `null`。

- 示例

  ：

  Java

  ```
  Integer applePrice = stock.get("Apple");
  System.out.println("苹果的价格: " + applePrice); // 输出: 155
  Integer googlePrice = stock.get("Google");
  System.out.println("谷歌的价格: " + googlePrice); // 输出: null
  ```

#### 3. `remove(Object key)` - 删除键值对

- **功能**：根据给定的键，删除整个键值对。

- **行为**：返回被删除键所对应的值。如果键不存在，则返回 `null`。

- 示例

  ：

  Java

  ```
  stock.put("Microsoft", 300);
  Integer removedValue = stock.remove("Microsoft");
  System.out.println("被删除的微软价格: " + removedValue); // 输出: 300
  System.out.println("删除后微软是否存在: " + stock.containsKey("Microsoft")); // 输出: false
  ```

#### 4. `containsKey(Object key)` - 检查是否包含指定的键

- **功能**：判断哈希表中是否存在指定的键。

- **行为**：返回 `true` 或 `false`。这是一个非常高效的 O(1) 操作。

- 示例

  ：

  Java

  ```
  boolean hasApple = stock.containsKey("Apple"); // true
  boolean hasGoogle = stock.containsKey("Google"); // false
  ```

#### 5. `containsValue(Object value)` - 检查是否包含指定的值

- **功能**：判断哈希表中是否存在一个或多个键映射到指定的值。

- **行为**：返回 `true` 或 `false`。**注意**：这个操作效率较低，因为它需要遍历哈希表中的所有值。

- 示例

  ：

  Java

  ```
  boolean hasPrice155 = stock.containsValue(155); // true
  boolean hasPrice200 = stock.containsValue(200); // false
  ```

#### 6. `size()` - 获取大小

- **功能**：返回哈希表中键值对的数量。

- 示例

  ：

  Java

  ```
  int count = stock.size();
  System.out.println("库存中有 " + count + " 种股票");
  ```

#### 7. `isEmpty()` - 检查是否为空

- **功能**：判断哈希表是否不包含任何键值对。
- **行为**：`size()` 为 0 时返回 `true`，否则返回 `false`。

#### 8. `keys()` 和 `elements()` - 获取所有键或所有值

- **功能**：这两个是 `Hashtable` 从 `Dictionary` 继承来的“老”方法，它们返回一个 `Enumeration` 对象，用于遍历所有的键或值。

- **现代用法**：在现代代码中，更推荐使用 `keySet()` 和 `values()`，它们返回 `Set` 和 `Collection`，可以更方便地与 Java 集合框架的其他部分（如 for-each 循环）集成。

  Java

  ```
  // 老式遍历 (使用 Enumeration)
  Enumeration<String> stockKeys = stock.keys();
  while(stockKeys.hasMoreElements()) {
      String key = stockKeys.nextElement();
      System.out.println("键: " + key);
  }
  
  // 推荐的现代遍历 (使用 for-each)
  for (String key : stock.keySet()) {
      System.out.println("键: " + key + ", 值: " + stock.get(key));
  }
  ```

## 核心思想

这个方法使用的是一种非常聪明且高效的 **“哈希集合（HashSet）与智能遍历”** 的策略来寻找最长连续序列。它比先排序再遍历的方法在时间复杂度上更优。该算法的核心思想是：

1. **用空间换时间**：首先将所有数字放入一个哈希集合 `HashSet` 中。这样做有两个巨大的好处：
   - **自动去重**：`HashSet` 中不会有重复元素。
   - **快速查找**：检查一个数字是否存在（`contains` 操作）的时间复杂度是 O(1)，也就是瞬间完成。这是整个算法高效的关键。
2. **避免重复计算**：我们只对一个序列的**起始数字**（比如序列 `[3, 4, 5]` 中的 `3`）进行长度计算。如果一个数字 `x` 的前一个数字 `x-1` 存在于集合中，那么 `x` 就不可能是一个序列的起点，我们就可以直接跳过它，从而避免了大量的重复劳动。

------

### 程序分步详解

我们用一个例子 `nums = [100, 4, 200, 1, 3, 2]` 来一步步走完整个程序。

#### 第 1 步：准备工作 - 将所有数字存入 HashSet

Java

```
Set<Integer> num_set = new HashSet<Integer>();
for (int num : nums) {
    num_set.add(num);
}
// 执行后，num_set 的内容是 {1, 2, 3, 4, 100, 200}
// 注意：顺序无关紧要，并且重复的数字会被自动忽略。

int longestStreak = 0; // 初始化最长序列长度为 0
```

这一步很简单，就是把数组转换成一个方便快速查找的集合。

#### 第 2 步：遍历集合，智能寻找序列起点

这是算法最精妙的部分。

Java

```
for (int num : num_set) {
    // 这行代码是精髓！
    if (!num_set.contains(num - 1)) {
        // ... 如果条件成立，说明 num 是一个序列的起点，开始计算长度
    }
}
```

`if (!num_set.contains(num - 1))` 这行代码像一个“司令官”，它在说：“**只有当你是一个序列的‘排头兵’时，我才开始从你这里数数。**”

- 如果 `num - 1` **不存在**于集合中，说明 `num` 就是一个连续序列的起点。
- 如果 `num - 1` **存在**于集合中，说明 `num` 只是序列中的一员，而不是起点（比如数字 `4`，它的前面有 `3`），那么我们现在就没必要从 `4` 开始数了，因为之后遍历到 `3`、`2`、`1` 的时候，自然会从真正的起点 `1` 开始数，从而一次性把 `[1, 2, 3, 4]` 这个序列数完。

#### 第 3 步：从起点开始，计算当前序列的长度

一旦 `if` 条件成立，说明我们找到了一个起点，就开始执行内部的 `while` 循环。

Java

```
// 假设我们找到了一个起点 num
int currentNum = num;
int currentStreak = 1; // 当前序列长度，从 1 开始（起点本身）

// 顺藤摸瓜，看看下一个数字在不在
while (num_set.contains(currentNum + 1)) {
    currentNum += 1;     // 数字加一
    currentStreak += 1;  // 长度加一
}
// 当循环结束时，currentStreak 就是从 num 开始的这个连续序列的总长度
```

这个 `while` 循环非常直观，它就像在说：“好的，我们从 `currentNum` 开始，看看 `currentNum + 1` 在不在？在。好，长度加一。再看看 `currentNum + 2` 在不在？在。好，长度再加一...” 直到找不到下一个连续的数字为止。

#### 第 4 步：更新全局最长长度

计算完一个序列的长度后，我们需要和已经记录的全局最长长度 `longestStreak` 进行比较，并保留那个更大的值。

Java

```
longestStreak = Math.max(longestStreak, currentStreak);
```

好的，我们来详细讲解一下 Java 中的 `HashSet`，它是在日常开发中非常常用的一个集合类。

`HashSet` 是 `java.util.Set` 接口的一个实现类，它基于哈希表（实际上内部是使用一个 `HashMap` 实例）来存储元素。它提供了高效的元素查找、添加和删除操作。

------

### `HashSet` 的核心特性

`HashSet` 最主要的特性可以概括为以下三点：

#### 1. 不允许重复元素 (Uniqueness)

这是 `Set` 接口所有实现类的共同特点。当你尝试向 `HashSet` 中添加一个已经存在的元素时，添加操作会失败，并返回 `false`，但不会抛出异常。这使得 `HashSet` 成为一个实现数据去重的天然工具。

- 如何判断重复

  ：

  ```
  HashSet
  ```

   通过调用元素的 

  ```
  hashCode()
  ```

   和 

  ```
  equals()
  ```

   方法来判断是否重复。

  1. 首先计算元素的 `hashCode()` 值，确定它在哈希表中的存储位置。
  2. 如果该位置上已经有其他元素，再调用 `equals()` 方法进行精确比较。
  3. 只有当 `hashCode()` 相同且 `equals()` 返回 `true` 时，才认为两个元素是重复的。

  - **重要提示**：如果你想在 `HashSet` 中存储自定义对象，**强烈建议同时重写该对象的 `hashCode()` 和 `equals()` 方法**，以确保其行为符合预期。

#### 2. 无序性 (Unordered)

`HashSet` 不保证元素的存储和迭代顺序。你添加元素的顺序和遍历（比如使用 for-each 循环）时取出的顺序很可能是不同的。这个顺序取决于元素的哈希码，并且在哈希表扩容等操作后可能会发生改变。

- **对比 `LinkedHashSet`**：如果你需要一个既能去重又能保持插入顺序的集合，应该使用 `LinkedHashSet`。
- **对比 `TreeSet`**：如果你需要一个能自动对元素进行排序的去重集合，应该使用 `TreeSet`。

#### 3. 允许一个 `null` 元素

`HashSet` 最多可以存储一个 `null` 元素。当你尝试添加多个 `null` 时，只有第一个会成功。

- **对比 `Hashtable` 和 `TreeSet`**：`Hashtable` 完全不允许 `null` 键和值。`TreeSet` 也不允许 `null` 元素（除非你提供一个能处理 `null` 的特殊比较器）。

#### 4. 高性能（非线程安全）

`HashSet` 内部由 `HashMap` 支持，因此其基本操作（`add`, `remove`, `contains`, `size`）具有非常高的性能，平均时间复杂度为 **O(1)**。

- **线程不安全**：与 `HashMap` 一样，`HashSet` 是非线程安全的。如果在多线程环境下共享一个 `HashSet` 实例并且有线程会修改它，必须手动进行同步，或者使用 `Collections.synchronizedSet(new HashSet<>())` 来包装它，或者使用 `java.util.concurrent` 包下的 `CopyOnWriteArraySet`。

------

## `HashSet` 的常用方法 (常用函数)

以下是 `HashSet` 最常用的一些方法，非常直观易用。

#### 1. `add(E element)` - 添加元素

- **功能**：向集合中添加指定的元素。

- 行为

  ：

  - 如果元素不存在，则成功添加，方法返回 `true`。
  - 如果元素已存在，则添加失败，方法返回 `false`。

- 示例

  ：

  Java

  ```
  Set<String> languages = new HashSet<>();
  boolean r1 = languages.add("Java");   // true
  boolean r2 = languages.add("Python"); // true
  boolean r3 = languages.add("Java");   // false, 因为 "Java" 已存在
  System.out.println(languages); // 输出 (顺序不定): [Java, Python]
  ```

#### 2. `remove(Object o)` - 删除元素

- **功能**：从集合中删除指定的元素。

- 行为

  ：

  - 如果元素存在并被成功删除，返回 `true`。
  - 如果元素不存在，不做任何操作，返回 `false`。

- 示例

  ：

  Java

  ```
  languages.add("C++");
  boolean r4 = languages.remove("C++"); // true
  boolean r5 = languages.remove("Go");  // false, 因为 "Go" 不存在
  System.out.println(languages); // 输出 (顺序不定): [Java, Python]
  ```

#### 3. `contains(Object o)` - 检查是否包含元素

- **功能**：判断集合中是否存在指定的元素。

- **行为**：如果存在，返回 `true`；否则，返回 `false`。这是 `HashSet` 最高效、最常用的操作之一。

- 示例

  ：

  Java

  ```
  boolean hasJava = languages.contains("Java");     // true
  boolean hasRuby = languages.contains("Ruby");     // false
  ```

#### 4. `size()` - 获取集合大小

- **功能**：返回集合中元素的数量。

- 示例

  ：

  Java

  ```
  int count = languages.size();
  System.out.println("集合中有 " + count + " 种语言。"); // 输出: 2
  ```

#### 5. `isEmpty()` - 检查集合是否为空

- **功能**：判断集合中是否不包含任何元素。

- **行为**：如果 `size()` 为 0，则返回 `true`；否则，返回 `false`。

- 示例

  ：

  Java

  ```
  System.out.println("集合是空的吗? " + languages.isEmpty()); // false
  ```

#### 6. `clear()` - 清空集合

- **功能**：移除集合中的所有元素。

- 示例

  ：

  Java

  ```
  languages.clear();
  System.out.println("清空后的大小: " + languages.size()); // 输出: 0
  System.out.println("清空后是空的吗? " + languages.isEmpty()); // true
  ```

#### 7. 遍历 `HashSet`

遍历 `HashSet` 最常见的方式是使用 for-each 循环，也可以使用迭代器（Iterator）。

**示例：**

Java

```
Set<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Orange");

// 方式一：使用 for-each 循环 (推荐，最简洁)
System.out.println("--- 使用 for-each 循环遍历 ---");
for (String fruit : fruits) {
    System.out.println(fruit);
}

// 方式二：使用迭代器 Iterator (可以在遍历时安全地删除元素)
System.out.println("\n--- 使用 Iterator 遍历 ---");
Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    String fruit = iterator.next();
    System.out.println(fruit);
    // 例如，可以在这里安全地删除元素
    // if ("Banana".equals(fruit)) {
    //     iterator.remove();
    // }
}
```

## Java集合

### 单列集合-Arrayslist

### 双列集合 Map

## Lambda表达式

好的，我们来系统地总结一下 Java 8 引入的这个重量级新特性——**Lambda 表达式**。它彻底改变了 Java 的编程风格，使其更简洁、更具表现力。

### 1. 核心思想：什么是 Lambda 表达式？

**Lambda 表达式**，简单来说，就是一个**可以传递的匿名函数**。

它的核心思想是：**允许你像传递一个普通变量（如整数、字符串）一样，来传递一段代码（一个函数）**。

在 Lambda 出现之前，如果你想传递一段代码（比如一个排序规则），你必须把它包裹在一个对象里（比如一个匿名内部类）。Lambda 则让你省去这些繁琐的“包装盒”，直接传递代码本身。

### 2. 为什么使用 Lambda？—— 代码的演进

Lambda 最直观的好处就是**极大地简化了代码**。我们用之前排序的例子来看一下演进过程，你就能体会到它的威力。

**场景：对一个字符串列表按长度进行排序。**

**Java 8 之前：使用匿名内部类（冗长、模板代码多）**

Java

```
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
});
```

**Java 8 之后：使用 Lambda 表达式（简洁、直观）**

Java

```
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Collections.sort(names, (s1, s2) -> s1.length() - s2.length());
```

可以看到，Lambda 表达式省去了所有的方法名、返回类型、`new` 关键字等模板代码，只保留了最核心的**参数**和**方法体**。

### 3. Lambda 表达式的语法

Lambda 表达式有一个非常标志性的结构，由三部分组成：

```
(parameters) -> { body }
```

1. **参数列表 `(parameters)`**：

   - `()`：方法没有参数。例如：`() -> System.out.println("Hello");`
   - `(p1)` 或 `p1`：方法只有一个参数。括号是可选的。例如：`name -> System.out.println(name);`
   - `(p1, p2)`：方法有多个参数。括号是必须的。例如：`(a, b) -> a + b;`
   - **类型推断**：大多数情况下，你不需要显式声明参数的类型，编译器可以根据上下文自动推断。`(String s1, String s2)` 可以简写为 `(s1, s2)`。

2. **箭头 `->`**：

   - 这是 Lambda 表达式的核心，将参数列表和方法体分开。可以读作“goes to”或“产生”。

3. **方法体 `{ body }`**：

   - 单行表达式

     ：如果方法体只有一行代码，并且是 

     ```
     return
     ```

      语句，那么可以省略大括号 

     ```
     {}
     ```

      和 

     ```
     return
     ```

      关键字。

     - `(a, b) -> a + b;`  等价于 `{ return a + b; }`

   - 代码块

     ：如果方法体包含多行语句，则必须使用大括号 

     ```
     {}
     ```

      包裹，并且如果需要返回值，必须显式地使用 

     ```
     return
     ```

      语句。

     Java

     ```
     (s1, s2) -> {
         System.out.println("正在比较...");
         return s1.length() - s2.length();
     };
     ```

### 4. 在哪里使用 Lambda？—— 函数式接口 (Functional Interface)

这是使用 Lambda 的**唯一前提**。Lambda 表达式只能被用在需要**“函数式接口”**的地方。

**什么是函数式接口？**

> **一个只包含【一个】抽象方法的接口**，就是函数式接口。

例如 `Comparator` 接口，它只有一个抽象方法 `compare()`。`Runnable` 接口，只有一个抽象方法 `run()`。

Lambda 表达式的参数列表和方法体，实际上就是在为这个**唯一的抽象方法**提供具体实现。

为了确保一个接口是函数式接口，Java 提供了 `@FunctionalInterface` 注解。虽然不是必需的，但加上它可以让编译器帮你检查，防止你意外地在接口中添加第二个抽象方法。

**JDK 中常见的函数式接口：**

- `Runnable`: `run()` - 无参数，无返回值。
- `Comparator<T>`: `compare(T o1, T o2)` - 比较两个对象。
- `Consumer<T>`: `accept(T t)` - 消费一个数据。
- `Predicate<T>`: `test(T t)` - 判断真假。
- `Function<T, R>`: `apply(T t)` - 输入 T，返回 R。

------

### 5. 常见使用场景与实例代码

#### a) 遍历集合

Java

```
List<String> list = Arrays.asList("a", "b", "c");
// forEach 方法需要一个 Consumer<T> 类型的参数
list.forEach(item -> System.out.println(item));
```

#### b) 排序

Java

```
List<String> names = Arrays.asList("Peter", "Anna", "Mike");
// sort 方法需要一个 Comparator<T> 类型的参数
names.sort((s1, s2) -> s1.compareTo(s2)); // 按字母升序排序
System.out.println(names); // [Anna, Mike, Peter]
```

#### c) 启动线程

Java

```
// Thread 的构造函数需要一个 Runnable 类型的参数
Thread t = new Thread(() -> System.out.println("新线程正在运行..."));
t.start();
```

#### d) 集合过滤（结合 Stream API）

Java

```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
// filter 方法需要一个 Predicate<T> 类型的参数
numbers.stream()
       .filter(n -> n % 2 == 0) // 只保留偶数
       .forEach(System.out::println); // 打印: 2, 4, 6
```

**总结：** Lambda 表达式是 Java 函数式编程的基石，它让代码变得更加简洁、灵活和强大。掌握它，尤其是结合 Stream API 使用，是现代 Java 开发的必备技能。

## 匿名内部类

### 什么是匿名内部类 (Anonymous Inner Class)？

**匿名内部类**，顾名思义，就是一个**没有名字的内部类**。

它的核心用途是：**“即用即弃”**。当你需要创建一个类的实例，而这个类的逻辑非常简单，并且**只会在当前这个地方使用一次**时，你就可以使用匿名内部类，从而省去专门为它创建一个独立的 `.java` 文件的麻烦。

#### 语法和解读

我们来看你截图中的例子，这是匿名内部类的经典用法：

Java

```
Arrays.sort(arr, new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; // 这是一个降序排序的例子
    }
});
```

我们来分解 `new Comparator<Integer>() { ... }` 这部分语法：

1. **`new Comparator<Integer>()`**
   - `Comparator` 是一个接口，接口是不能直接 `new` 实例的。
   - 所以，当 Java 看到 `new 接口名()` 或者 `new 类名()` 后面紧跟着 `{}` 时，它就知道这不是一个普通的实例化操作。
   - 这段语法的真正意思是：“**我要创建一个实现了 `Comparator<Integer>` 接口的、匿名的、新的类的对象。**”
2. **`{ ... }`**
   - 这个大括号里的内容，就是那个“没有名字的类”的**类体**。
   - 因为你实现了 `Comparator` 接口，所以你必须在这个类体中，提供接口所要求的所有方法的具体实现（在这里就是 `compare` 方法）。
3. **`;`**
   - 注意最后的分号。这个分号不是匿名内部类的一部分，而是结束 `Arrays.sort(...)` 这整个方法调用的语句。

**总结匿名内部类：**

1. **本质**：一个没有名字的类。
2. **作用**：方便地创建只使用一次的子类或接口实现类的实例。
3. **优点**：代码更紧凑，逻辑都写在了一起，避免了创建过多简单的类文件。
4. **缺点**：语法稍显复杂，如果类体逻辑过多，会降低代码可读性。 

## String特性

### String 的核心特性：不可变性 (Immutability)

在学习具体方法前，必须先理解 `String` 最最重要的一个特性：**不可变性**。

**一个 `String` 对象一旦被创建，它的内容就永远不能被改变。**

你可能会感到困惑：“可是 `replace()`, `toUpperCase()` 这些方法不是修改了字符串吗？” 答案是：**没有**。这些方法**不会修改原始的字符串**，而是会**返回一个全新的、修改后的 `String` 对象**。原始的字符串对象在内存中保持原样。

Java

```
String s1 = "hello";
String s2 = s1.toUpperCase(); // s1.toUpperCase() 返回了一个新的字符串 "HELLO"

System.out.println(s1); // 输出 "hello"，s1 本身没有变
System.out.println(s2); // 输出 "HELLO"，s2 是一个全新的字符串
```

理解了这一点，你就能更好地理解下面所有“修改类”方法的行为了。

------

### String 常用方法分类详解

下面的代码演示将封装在一个类中，通过不同的方法来展示各类 API 的功能。

#### 1. 获取信息类方法

这类方法用于检查字符串的特征或获取其部分信息，它们不会以任何方式改变字符串。

| 方法签名                            | 说明                                              |
| ----------------------------------- | ------------------------------------------------- |
| `int length()`                      | 返回字符串的长度（字符的数量）。                  |
| `char charAt(int index)`            | 返回指定索引位置的字符。                          |
| `boolean isEmpty()`                 | 判断字符串是否为空字符串（长度为0）。             |
| `int indexOf(String str)`           | 查找子字符串第一次出现的索引，未找到则返回 -1。   |
| `int lastIndexOf(String str)`       | 查找子字符串最后一次出现的索引，未找到则返回 -1。 |
| `boolean contains(CharSequence s)`  | 判断字符串是否包含指定的子字符串。                |
| `boolean startsWith(String prefix)` | 判断字符串是否以指定的前缀开始。                  |
| `boolean endsWith(String suffix)`   | 判断字符串是否以指定的后缀结束。                  |

#### 2. 比较类方法

| 方法签名                               | 说明                                                       |
| -------------------------------------- | ---------------------------------------------------------- |
| `boolean equals(Object obj)`           | **内容比较**，严格区分大小写。这是最常用的字符串比较方法。 |
| `boolean equalsIgnoreCase(String str)` | 内容比较，**忽略大小写**。                                 |

#### 3. 截取与拆分类方法

这类方法会从原字符串中提取一部分，并返回一个新的字符串。

| 方法签名                                         | 说明                                                         |
| ------------------------------------------------ | ------------------------------------------------------------ |
| `String substring(int beginIndex)`               | 从指定索引截取到字符串末尾。                                 |
| `String substring(int beginIndex, int endIndex)` | 截取 `[beginIndex, endIndex)` 范围的子字符串，**包前不包后**。 |
| `String[] split(String regex)`                   | 根据指定的**正则表达式**来拆分字符串，返回一个字符串数组。   |

#### 4. 转换与修改类方法

这类方法会基于原字符串创建一个新的、经过修改的字符串并返回。

| 方法签名                                                   | 说明                                                  |
| ---------------------------------------------------------- | ----------------------------------------------------- |
| `String toUpperCase()`                                     | 将字符串所有字符转换为大写。                          |
| `String toLowerCase()`                                     | 将字符串所有字符转换为小写。                          |
| `String trim()`                                            | 去除字符串**首尾**的空白字符（空格、Tab、换行符等）。 |
| `String replace(CharSequence oldStr, CharSequence newStr)` | 将字符串中所有出现的老子字符串替换为新的子字符串。    |
| `char[] toCharArray()`                                     | 将字符串转换为一个字符数组。                          |

#### 5. 类型转换类方法

| 方法签名                     | 说明                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| `static String valueOf(...)` | **静态方法**，用于将其他数据类型（如 `int`, `double`, `boolean`, 对象等）转换为字符串。 |

------

### 完整演示代码

Java

```
import java.util.Arrays;

public class StringMethodsDemo {

    public static void main(String[] args) {
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
```