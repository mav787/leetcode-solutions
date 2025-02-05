package C_Meta;

public class TTT273 {
	private String[] elements = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
    
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0)
            	sb.insert(0, " ").insert(0, thousands[i]).insert(0, dfs(num % 1000));
        	num /= 1000;
        	i++;
        }
        return sb.toString().trim();
    }
    
    private String dfs(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return elements[num] + " ";
        else if (num < 100)
            return tens[num / 10] + " " + dfs(num % 10);
        else
            return elements[num / 100] + " Hundred " + dfs(num % 100);
    }
}
