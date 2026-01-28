package Z2025.T100_999;

public class T165 {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null){
            return -2;
        }

        String[] sa1 = version1.split("\\.");
        String[] sa2 = version2.split("\\.");

        if(sa1.length > sa2.length){
            return -compareVersion(version2, version1);
        }

        for(int i = 0; i < sa2.length; i++){
            int v1 = i < sa1.length ? Integer.valueOf(sa1[i]) : 0;
            int v2 = Integer.valueOf(sa2[i]);

            if(v1 < v2){
                return -1;
            }
            else if(v1 == v2){
                continue;
            }
            else{
                return 1;
            }
        }

        return 0;
    }
}
