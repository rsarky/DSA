import java.util.*;
public class RottenOranges {
    int timeToRot(int arr[][]) {
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j] == 2) {
                    queue.addLast(arr[i][j]);
                }
            }
        }
    }
}