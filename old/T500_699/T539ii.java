package old.T500_699;
import java.util.*;

public class T539ii {
	public int findMinDifference(List<String> timePoints) {

	    boolean[] timeSeen = new boolean[1440];
	    for (String s : timePoints) {
	        int mins = Integer.parseInt(s.split(":")[0])*60 + Integer.parseInt(s.split(":")[1]);
	        if (timeSeen[mins]) return 0;
	        timeSeen[mins] = true;
	    }
	    
	    Integer firstTimeSeen = null, prevTimeSeen = null, minDiff = Integer.MAX_VALUE;
	    for (int i=0;i<1440;i++) {
	        if (!timeSeen[i]) continue;
	        if (firstTimeSeen == null) {firstTimeSeen = i; prevTimeSeen = i;}
	        else {
	          minDiff = Math.min(minDiff, Math.min(i - prevTimeSeen, 1440 - i + prevTimeSeen));
	          prevTimeSeen = i;
	        }
	    }
	    
	    minDiff = Math.min(minDiff, Math.min(prevTimeSeen - firstTimeSeen, 1440 - prevTimeSeen + firstTimeSeen));
	    return minDiff;
	}
}
