package Z2025.T100_999;

public class T158 {
    private int index = 0;
    private int count = 0;
    private char[] localBuffer = new char[4];


    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if(index == count){
                index = 0;
                count = read4(localBuffer);

                if(count == 0){
                    return i;
                }
            }

            for(index = index; index < count && i < n; index++){
                buf[i] = localBuffer[index];
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
