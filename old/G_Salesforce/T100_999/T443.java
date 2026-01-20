package old.G_Salesforce.T100_999;

public class T443 {
    public int compress(char[] chars) {
        int i = 0, index = 0;
        while (i < chars.length) {
            int count = 1;
            while (i + count < chars.length && chars[i + count] == chars[i]) {
                count++;
            }

            chars[index++] = chars[i];
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }

            i += count;
        }
        return index;
    }
}
