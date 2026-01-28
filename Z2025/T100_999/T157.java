package Z2025.T100_999;

public class T157 {
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int i = 0;

        while(i < n){
            int count = read4(buf4);
            if(count == 0){
                return i;
            }

            for(int j = 0; j < count && i < n; j++){
                buf[i] = buf4[j];
                i++;
            }
        }

        return i;
    }

    // cheat on the compiler
    private int read4(char[] buf4) {
        return 0;
    }
}
