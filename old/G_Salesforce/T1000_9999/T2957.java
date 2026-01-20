package old.G_Salesforce.T1000_9999;

public class T2957 {
    public int removeAlmostEqualCharacters(String word) {
        // Iterate from i = 1 to the string end.
        // For each i check if its prev char is almost equal alphabet or not
        // => where abs diff of current char and prev char is less than equal to 1.

        // If almost equal found then we have to change the curr index char to a char diff
        // from prev as well as diff from the next. So we increment the change count.
        // We don't have to care about what the new char will be.

        // Also if we change the char to a new one that means we are sure that
        // the next char should not be checked so iterate one more
        // to skip check for the immediate next char.
        int res = 0;
        for(int i = 1; i < word.length(); i++){
            if(Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 1) {
                res++;
                i++;
            }
        }
        return res;
    }
}
