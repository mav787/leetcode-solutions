package old.T500_699;

public class T657 {
	public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0 || moves.length() % 2 != 0) return false;
        int x = 0, y = 0;
        for(int i = 0; i < moves.length(); i++){
            switch(moves.charAt(i)){
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
