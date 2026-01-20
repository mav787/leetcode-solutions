package old.T500_699;

public class T557 {
	public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return s;
        String[] sa = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String item : sa){
            StringBuilder itemsb = new StringBuilder(item);
            sb.append(itemsb.reverse().toString()).append(" ");
        }
        
        return sb.substring(0, sb.length() - 1);
    }
}
