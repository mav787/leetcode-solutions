package T200_299;

public class T286DFS {
	public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0)
            return;
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0)    
                    dfs(rooms, i, j, m, n, 1, Integer.MAX_VALUE);
            }
        }
    }
    
    
    private void dfs(int[][] rooms, int i, int j, int m, int n, int distance, int inf){
        if(i - 1 >= 0 && rooms[i - 1][j] > distance){
            rooms[i - 1][j] = distance;
            dfs(rooms, i - 1, j, m, n, distance + 1, inf);
        }
        if(i + 1 < m && rooms[i + 1][j] > distance){
            rooms[i + 1][j] = distance;
            dfs(rooms, i + 1, j, m, n, distance + 1, inf);
        }
        if(j - 1 >= 0 && rooms[i][j - 1] > distance){
            rooms[i][j - 1] = distance;
            dfs(rooms, i, j - 1, m, n, distance + 1, inf);
        }
        if(j + 1 < n && rooms[i][j + 1] > distance){
            rooms[i][j + 1] = distance;
            dfs(rooms, i, j + 1, m, n, distance + 1, inf);
        }
    }
}
