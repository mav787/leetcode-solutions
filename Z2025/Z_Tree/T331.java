package Z2025.Z_Tree;

public class T331 {
    class Solution {
        int index = 0;
        public boolean isValidSerialization(String preorder) {
            if(preorder == null || preorder.length() == 0){
                return true;
            }

            String[] sa = preorder.split(",");
            return helper(sa) && index == sa.length;
        }

        private boolean helper(String[] sa){
            if(index >= sa.length){
                return false;
            }

            String s = sa[index];
            index++;

            if(s.equals("#")){
                return true;
            }

            return helper(sa) && helper(sa);
        }
    }

}
