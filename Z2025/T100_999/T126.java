package Z2025.T100_999;
import java.util.*;

public class T126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }
        if (beginWord.equals(endWord)) {
            res.add(List.of(beginWord));
            return res;
        }

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> curr = new HashSet<>();
        curr.add(beginWord);
        dict.remove(beginWord);
        boolean found = false;

        while (!curr.isEmpty() && !found) {
            Set<String> next = new HashSet<>();
            for (String parent : curr) {
                char[] s = parent.toCharArray();
                for (int i = 0; i < s.length; i++) {
                    char old = s[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) {
                            continue;
                        }
                        s[i] = c;
                        String child = new String(s);
                        if (!dict.contains(child)) {
                            continue;
                        }

                        parents.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
                        if (child.equals(endWord)) {
                            found = true;
                        }
                        next.add(child);
                    }
                    s[i] = old;
                }
            }
            dict.removeAll(next);
            curr = next;
        }

        if (!found) {
            return res;
        }

        List<String> path = new LinkedList<>();
        path.add(endWord);
        dfs(endWord, beginWord, parents, path, res);
        return res;
    }

    private void dfs(String curr, String target, Map<String, List<String>> parents,
                     List<String> path, List<List<String>> res) {
        if (curr.equals(target)) {
            res.add(new ArrayList<>(path));
            return;
        }
        List<String> ps = parents.get(curr);
        if (ps == null) {
            return;
        }
        for (String p : ps) {
            path.add(0, p);
            dfs(p, target, parents, path, res);
            path.remove(0);
        }
    }
}
