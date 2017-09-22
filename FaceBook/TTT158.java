package FaceBook;

public class TTT158 {
	private int offSet = 0;
    private int remaining = 0;
    private boolean isEndOfFile = false;
    private char[] buffer = new char[4];
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int readBytes = 0;
        while (readBytes < n && (remaining != 0 || !isEndOfFile)) {
            int readSize = 0;
            if (remaining != 0) {
                readSize = remaining;
            } else {
                offSet = 0;
                readSize = read4(buffer);
                if (readSize != 4) {
                    isEndOfFile = true;
                }
            }
            int length = Math.min(n - readBytes, readSize);
            for (int i= offSet; i<offSet + length; i++) {
                buf[readBytes++] = buffer[i];
            }
            remaining = readSize - length;
            if (remaining != 0) {
                offSet += length;
            }
        }
        return readBytes;
    }
    
    private int read4(char[] buffer){
    	return 0;
    }
}
