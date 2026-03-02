package Z2025.T100_999;
import java.util.*;

public class T249 {
    public List<List<String>> groupStrings(String[] strings) {
        // 你的风格：逻辑清晰，变量命名语义化
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = getKey(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        // 使用 diff 记录首字符相对于 'a' 的差值
        int diff = chars[0] - 'a';

        for (char c : chars) {
            int num = c - diff;
            // 处理 26 个字母的回环情况 (比如 'a' 减去 diff 后可能落到 'z' 之后或 'a' 之前)
            if (num < 'a') {
                num += 26;
            }

            sb.append((char) num);
        }

        return sb.toString();
    }
}
