package T500_699;

public class T606 {
	public String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if(left.equals("") && right.equals("")) return sb.toString();
        sb.append("(").append(left).append(")");
        
        if(!right.equals("")){
            sb.append("(").append(right).append(")");    
        }
        return sb.toString();
    }
}
