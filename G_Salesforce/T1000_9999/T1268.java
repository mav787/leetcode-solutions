package G_Salesforce.T1000_9999;
import java.util.*;

public class T1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();

        List<List<String>> res = new ArrayList<>();
        for(String product : products){
            constructTrie(root, product);
        }


        for(int i = 0; i < searchWord.length(); i++){
            char c = searchWord.charAt(i);
            int index = c - 'a';
            TrieNode curr = root.next[index];
            if(curr == null){
                while(i < searchWord.length()){
                    res.add(new ArrayList<>());
                    i++;
                }
                return res;
            }
            else{
                res.add(curr.words);
                root = curr;
            }
        }

        return res;
    }

    private void constructTrie(TrieNode root, String product){
        TrieNode curr = root;
        for(char c : product.toCharArray()){
            int index = c - 'a';
            if(curr.next[index] == null){
                curr.next[index] = new TrieNode();
            }

            curr = curr.next[index];
            curr.words.add(product);

            List<String> list = new ArrayList<>();
            Collections.sort(curr.words);
            for(int i = 0; i < Math.min(curr.words.size(), 3); i++){
                list.add(curr.words.get(i));
            }
            curr.words = list;
        }
    }

    class TrieNode{
        TrieNode[] next;
        List<String> words;

        public TrieNode(){
            this.next = new TrieNode[26];
            this.words = new ArrayList<>();
        }
    }
}
