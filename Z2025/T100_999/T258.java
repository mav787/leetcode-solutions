package Z2025.T100_999;

public class T258 {
    public int addDigits(int num) {
        while(num >= 10){
            int res = 0;
            while(num != 0){
                res += num % 10;
                num /= 10;
            }

            num = res;
        }

        return num;
    }
}
