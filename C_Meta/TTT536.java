package C_Meta;

public class TTT536 {
	public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) 
            return null;
        int firstParen = s.indexOf("(");
        if(firstParen == -1){
            return new TreeNode(Integer.parseInt(s));
        }
        int val = Integer.parseInt(s.substring(0, firstParen));
        TreeNode root = new TreeNode(val);
        int start = firstParen, leftParenCount = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                leftParenCount++;
            else if (s.charAt(i) == ')') 
                leftParenCount--;
            if (leftParenCount == 0 && start == firstParen) {
                root.left = str2tree(s.substring(start + 1, i)); 
                start = i+1;
            }
            else if (leftParenCount == 0) 
                root.right = str2tree(s.substring(start + 1, i));
        }
        return root;
    }
}
