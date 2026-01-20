package Z2025.T10_99;
import java.util.*;


public class T99 {
    public void recoverTree(TreeNode root) {
        List<Integer> list = tree2List(root);
        int[] odds = getOdds(list);
        recover(root, odds);
    }

    private List<Integer> tree2List(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        res.addAll(tree2List(root.left));
        res.add(root.val);
        res.addAll(tree2List(root.right));

        return res;
    }

    private int[] getOdds(List<Integer> list){
        int[] res = new int[2];
        boolean seen = false;

        for(int i = 0; i < list.size() - 1; i++){
            int curr = list.get(i);
            int next = list.get(i + 1);

            if(curr >= next){
                if(!seen){
                    seen = true;
                    res[0] = curr;
                    res[1] = next;
                }
                else{
                    res[1] = next;
                }
            }
        }

        return res;
    }

    private void recover(TreeNode root, int[] odds){
        if(root == null){
            return;
        }

        if(root.val == odds[0]){
            root.val = odds[1];
        }
        else if(root.val == odds[1]){
            root.val = odds[0];
        }

        recover(root.left, odds);
        recover(root.right, odds);
    }
}
