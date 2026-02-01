package Z2025.T100_999;

public class T201 {
    public int rangeBitwiseAnd(int left, int right) {
        return commonPrefix(left, right);
    }

    private int commonPrefix(int i, int j){
        int shift = 0;
        while(i != j){
            i >>= 1;
            j >>= 1;
            shift++;
        }

        return i << shift;
    }
}
