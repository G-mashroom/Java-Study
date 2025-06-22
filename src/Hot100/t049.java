package Hot100;

import java.util.*;

/**给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 示例 1:
 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 解释：
 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 示例 2:
 输入: strs = [""]
 输出: [[""]]
 示例 3:
 输入: strs = ["a"]
 输出: [["a"]]*/

public class t049 {
    // 字符排序
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 ) return new ArrayList();
        Map<String,List> map = new HashMap<String,List>();
        for(String str : strs){
            char[] as = str.toCharArray();
            Arrays.sort(as);
            String key = new String(as);
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }

    // 字母计数
    public List<List<String>> groupAnagram(String[] strs) {
        if(strs.length == 0 ) return new ArrayList();
        Map<String,List> map = new HashMap<String,List>();
        for(String str : strs){
            int[] counter = new int[26];
            for(char c : str.toCharArray())
                counter[c - 'a']++;
            String key = Arrays.toString(counter);
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
