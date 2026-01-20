package old.T100_199;

public class T134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, res = 0, total = 0;
        for(int i = 0; i < gas.length; ++i){
            sum += gas[i] - cost[i];
            if(sum < 0){
                total += sum;
                sum = 0;
                res = i + 1;
            }
        }
        total += sum;
        return total < 0 ? -1 : res;
    }
}
