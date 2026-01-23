package Z2025.T100_999;

public class T134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0){
            return -1;
        }

        int tank = 0;
        int res = 0;
        int min = gas[0] - cost[0];

        for(int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
            if(tank < min){
                min = tank;
                res = i;
            }
        }

        if(tank < 0){
            return -1;
        }

        return (res + 1) % gas.length;
    }
}
