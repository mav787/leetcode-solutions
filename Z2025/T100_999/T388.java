package Z2025.T100_999;

import java.util.*;

public class T388 {
    class Solution {
        public int lengthLongestPath(String input) {
            String[] lines = input.split("\n");

            // map[depth] = 当前深度节点的父目录路径长度（包含末尾的 '/'）
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0); // 根目录没有父路径

            int res = 0;

            for(String line : lines){
                // 通过前面的 '\t' 数量确定当前节点的深度
                int depth = 0;
                while(depth < line.length() && line.charAt(depth) == '\t'){
                    depth++;
                }

                // 去掉缩进，得到当前文件或目录名
                String name = line.substring(depth);

                // 父目录路径长度 + 当前名称长度
                int length = map.get(depth) + name.length();

                if(name.contains(".")){
                    // 文件：更新最长绝对路径
                    res = Math.max(res, length);
                }
                else{
                    // 目录：加上 '/'，供下一层子节点使用
                    // 同一深度的新目录会覆盖旧目录，因为旧分支已经结束
                    map.put(depth + 1, length + 1);
                }
            }

            return res;
        }
    }

}
