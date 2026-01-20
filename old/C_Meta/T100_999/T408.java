package old.C_Meta.T100_999;

public class T408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null && abbr == null){
            return true;
        }
        if(word == null || abbr == null){
            return false;
        }

        int i = 0, j = 0;
        while(i < word.length() && j < abbr.length()){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
            }
            else if(abbr.charAt(j) > '0' && abbr.charAt(j) <= '9'){
                int count = 0;
                while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                    count = count * 10 + abbr.charAt(j) - '0';
                    j++;
                }

                i += count;
            }
            else{
                return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
