package T500_699;

public class T536 {
	public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) 
            return null;
        int first = s.indexOf("(");
        if(first == -1){
            return new TreeNode(Integer.parseInt(s));
        }
        int val = Integer.parseInt(s.substring(0, first));
        TreeNode root = new TreeNode(val);
        int start = first, open = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                open++;
            else if (s.charAt(i) == ')') 
                open--;
            if (open == 0 && start == first) {
                root.left = str2tree(s.substring(start + 1, i)); 
                start = i + 1;
            }
            else if (open == 0) {
            	root.right = str2tree(s.substring(start + 1, i));
            }
        }
        return root;
    }
}
