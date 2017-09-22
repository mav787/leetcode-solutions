package FaceBook;

public class TTT157 {
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int curr = 0;
        
        while (curr < n && !endOfFile) {
            int readBytes = read4(buffer);
            if (readBytes != 4) {
                endOfFile = true;
            }
            int length = Math.min(n - curr, readBytes);
            for (int i = 0; i < length; i++) {
                buf[curr + i] = buffer[i];
            }
            curr += length;
        }
        
        return curr;
    }
    
    int read4(char[] buf){
    	return 0;
    }
}
