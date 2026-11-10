package Z2025.T100_999;

import java.util.*;

public class T353 {
    class SnakeGame {
        Deque<int[]> snake;
        int width;
        int height;

        Queue<int[]> foods;
        int[] nextFood;
        Set<Integer> set;


        public SnakeGame(int width, int height, int[][] food) {
            snake = new LinkedList<>();
            this.width = width;
            this.height = height;
            snake.offerFirst(new int[]{0, 0});

            this.foods = new LinkedList<>();
            for(int[] f : food){
                foods.offer(f);
            }

            nextFood = foods.poll();

            set = new HashSet<>();
            set.add(getKey(new int[]{0, 0}));
        }

        public int move(String direction) {
            int[] currHead = snake.peekFirst();
            int[] nextHead = getNextHead(currHead, direction);
            if(nextHead[0] == -1 || nextHead[1] == -1){
                return -1;
            }

            if(nextFood != null && nextHead[0] == nextFood[0] && nextHead[1] == nextFood[1]){
                nextFood = foods.poll();
            }
            else{
                int[] tail = snake.pollLast();
                set.remove(getKey(tail));
            }

            if(set.contains(getKey(nextHead))){
                return -1;
            }

            set.add(getKey(nextHead));
            snake.offerFirst(nextHead);

            return snake.size() - 1;
        }

        private int getKey(int[] point){
            return point[0] * width + point[1];
        }


        private int[] getNextHead(int[] currHead, String direction){
            int x = currHead[0], y = currHead[1];
            int newx = -1, newy = -1;
            if(direction.equals("U")){
                newx = x - 1;
                newy = y;
            }
            else if(direction.equals("D")){
                newx = x + 1;
                newy = y;
            }
            else if(direction.equals("L")){
                newx = x;
                newy = y - 1;
            }
            else if(direction.equals("R")){
                newx = x;
                newy = y + 1;
            }

            if(newx < 0 || newx >= height){
                newx = -1;
            }
            if(newy < 0 || newy >= width){
                newy = -1;
            }

            return new int[]{newx, newy};
        }
    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

}
