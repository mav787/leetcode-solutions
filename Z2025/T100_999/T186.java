package Z2025.T100_999;

public class T186 {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int left = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s, left, i - 1);
                left = i + 1;
            }
        }

        reverse(s, left, s.length - 1);
    }

    private void reverse(char[] s, int left, int right){
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
