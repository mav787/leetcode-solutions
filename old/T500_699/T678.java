package old.T500_699;

public class T678 {
	public boolean checkValidString(String s) {
        if(s == null) return true;
        return backtrack(s, 0, 0);
    }
    
    private boolean backtrack(String s, int pos, int count){
        if(count < 0) return false;
        if(pos == s.length()){
            return count == 0;
        }
        char c = s.charAt(pos);
        if(c == '('){
            return backtrack(s, pos + 1, count + 1);
        }
        else if(c == ')'){
            return backtrack(s, pos + 1, count - 1);
        }
        else{
            // c == '*'
            if(backtrack(s, pos + 1, count + 1)) return true;		// '('
            else if(backtrack(s, pos + 1, count - 1)) return true;	// ')'
            else if(backtrack(s, pos + 1, count)) return true;		// blank
            else return false;
        }
    }
}
