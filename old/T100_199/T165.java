package old.T100_199;

public class T165 {
	public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null)
            return 0;
        String[] sa1 = version1.split("\\."), sa2 = version2.split("\\.");
        for(int i = 0; i < Math.max(sa1.length, sa2.length); i++){
            int d1 = i < sa1.length? Integer.parseInt(sa1[i]) : 0;
            int d2 = i < sa2.length? Integer.parseInt(sa2[i]) : 0;
            if(d1 < d2)
                return -1;
            else if(d1 > d2)
                return 1;
        }
        return 0;
    }
}
