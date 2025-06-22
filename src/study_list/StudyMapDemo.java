package study_list;
import java.util.HashMap;
import java.util.Map;
/**
 * Map<String, String> map: 这是**“父类型引用”**。
 * 我们声明了一个变量 map，它的类型是 Map 接口。
 * 这相当于一个承诺：我这个 map 变量可以引用任何一个实现了 Map 接口的类的对象。它是一个更通用、更抽象的身份。
 * new HashMap<>(): 这是**“子类对象”**。
 * 我们在内存中实际创建（new）了一个对象，这个对象的具体类型是 HashMap。
 * HashMap 是 Map 接口的一个具体实现类。
 * 一个生动的比喻：
 * Map 接口就像是**“交通工具”**这个概念。
 * HashMap, TreeMap, LinkedHashMap 分别是**“小汽车”、“高铁”、“大巴车”**这些具体的交通工具。
 * 代码 Map map = new HashMap(); 就好比说：
 * “交通工具（Map map），具体给你的是一辆小汽车（= new HashMap()）。”
 * 因为“小汽车” 是 “交通工具”的一种，所以这个赋值是完全成立的。这就是多态。
 * 2. 为什么推荐用 Map map = new HashMap()？
 * 这是“面向接口编程”的核心思想，这样做有巨大的好处，主要是为了灵活性和可维护性。
 * 当你把变量声明为接口类型 Map 时，你的代码其他部分就不再关心它具体是 HashMap 还是 TreeMap 了。你的代码只会调用 Map 接口中定义的方法，比如 put(), get(), remove() 等。
 * 这样做的好处是：可以轻松地更换实现！
 * */
public class StudyMapDemo {

    public void main1() {
        // 创建一个 Map 集合，键是国家(String)，值是首都(String)
        Map<String, String> capitalCities = new HashMap<>();
        System.out.println("程序开始，已创建一个空的 Map: " + capitalCities);
        System.out.println("============================================\n");


        // --- 1. V put(K key, V value) - 添加或更新元素 ---
        System.out.println("--- 1. put(K key, V value) - 添加或更新元素 ---");
        // 当键是新的，put 返回 null
        String r1 = capitalCities.put("中国", "北京");
        capitalCities.put("法国", "巴黎");
        System.out.println("put(\"中国\", \"北京\") 的返回值: " + r1);
        System.out.println("添加新元素后: " + capitalCities);

        // 当键已存在，put 会用新值覆盖旧值，并返回那个被覆盖的“旧值”
        String oldValue = capitalCities.put("法国", "新巴黎");
        System.out.println("put(\"法国\", \"新巴黎\") 的返回值 (旧值): " + oldValue);
        System.out.println("更新元素后: " + capitalCities);
        System.out.println("============================================\n");


        // --- 2. int size() - 获取键值对的个数 ---
        System.out.println("--- 2. size() - 获取键值对的个数 ---");
        int mapSize = capitalCities.size();
        System.out.println("当前 Map 中的键值对数量为: " + mapSize);
        System.out.println("============================================\n");


        // --- 3. boolean containsKey(Object key) - 判断是否包含指定的键 ---
        System.out.println("--- 3. containsKey(Object key) - 判断是否包含指定的键 ---");
        boolean hasChinaKey = capitalCities.containsKey("中国");
        boolean hasUsaKey = capitalCities.containsKey("美国");
        System.out.println("Map 是否包含键 '中国'? " + hasChinaKey);
        System.out.println("Map 是否包含键 '美国'? " + hasUsaKey);
        System.out.println("============================================\n");


        // --- 4. boolean containsValue(Object value) - 判断是否包含指定的值 ---
        System.out.println("--- 4. containsValue(Object value) - 判断是否包含指定的值 ---");
        boolean hasBeijingValue = capitalCities.containsValue("北京");
        boolean hasLondonValue = capitalCities.containsValue("伦敦");
        System.out.println("Map 是否包含值 '北京'? " + hasBeijingValue);
        System.out.println("Map 是否包含值 '伦敦'? " + hasLondonValue);
        System.out.println("============================================\n");


        // --- 5. V remove(Object key) - 根据键删除键值对 ---
        System.out.println("--- 5. remove(Object key) - 根据键删除键值对 ---");
        System.out.println("删除前: " + capitalCities);
        // 删除一个存在的键，会返回它对应的值
        String removedValue = capitalCities.remove("法国");
        System.out.println("remove(\"法国\") 的返回值 (被删除的值): " + removedValue);
        System.out.println("删除后: " + capitalCities);
        System.out.println("============================================\n");


        // --- 6. boolean isEmpty() - 判断是否为空 ---
        System.out.println("--- 6. isEmpty() - 判断是否为空 ---");
        boolean isEmptyNow = capitalCities.isEmpty();
        System.out.println("当前 Map 是否为空? " + isEmptyNow);
        System.out.println("============================================\n");


        // --- 7. void clear() - 移除所有键值对 ---
        System.out.println("--- 7. clear() - 移除所有键值对 ---");
        System.out.println("清空前，Map 的大小为: " + capitalCities.size());
        capitalCities.clear(); // 执行清空操作
        System.out.println("调用 clear() 之后，Map 的内容为: " + capitalCities);
        System.out.println("清空后，Map 的大小为: " + capitalCities.size());
        System.out.println("清空后，Map 是否为空? " + capitalCities.isEmpty());
        System.out.println("============================================\n");
    }
}